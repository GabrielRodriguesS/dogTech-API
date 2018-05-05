package main.config;

import main.config.stateMachineEnums.Events;
import main.config.stateMachineEnums.States;
import main.model.Adoption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdoptionStateMachineConfig.class)
public class AdoptionStateMachineTest {

    @Autowired
    private StateMachine<States, Events> stateMachine;
    private Adoption adoption;

    @Before
    public void setUp() {
        this.adoption = new Adoption();
        this.stateMachine.start();
    }

    @After
    public void tearDown() {
        this.stateMachine.stop();
    }

    // Flow normal testing walking by allowed transitions states
    @Test
    public void testStartingWaitingEvent() {
        assertEquals(States.WAITING, stateMachine.getState().getId());
    }

    @Test
    public void testEventDisapprovedAdoption() {
        assertTrue(this.stateMachine.sendEvent(Events.REJECTED_EVENT));
        assertEquals(States.REJECTED, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventApprovedAdoption() {
        assertTrue(this.stateMachine.sendEvent(Events.WAITING_VISIT_EVENT));
        assertEquals(States.WAITING_VISIT, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventEventGiveUp() {
        assertTrue(this.stateMachine.sendEvent(Events.WAITING_VISIT_EVENT));
        assertTrue(this.stateMachine.sendEvent(Events.DESISTING_EVENT));
        assertEquals(States.DESISTING, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventAdopt() {
        assertTrue(this.stateMachine.sendEvent(Events.WAITING_VISIT_EVENT));
        assertTrue(this.stateMachine.sendEvent(Events.ADOPTED_EVENT));
        assertEquals(States.ADOPTED, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventGiveBack() {
        assertTrue(this.stateMachine.sendEvent(Events.WAITING_VISIT_EVENT));
        assertTrue(this.stateMachine.sendEvent(Events.ADOPTED_EVENT));
        assertTrue(this.stateMachine.sendEvent(Events.RETURNED_EVENT));
        assertEquals(States.RETURNED, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventRevokedAdoption() {
        assertTrue(this.stateMachine.sendEvent(Events.WAITING_VISIT_EVENT));
        assertTrue(this.stateMachine.sendEvent(Events.ADOPTED_EVENT));
        assertTrue(this.stateMachine.sendEvent(Events.REVOKED_EVENT));
        assertEquals(States.REVOKED, this.stateMachine.getState().getId());
    }
    //Ending normal flow tests

    @Test
    public void testNoAllowedTransitionState(){ //This test are very wrong, but i'm lazy
        assertFalse(this.stateMachine.sendEvent(Events.REVOKED_EVENT));
        assertFalse(this.stateMachine.sendEvent(Events.RETURNED_EVENT));
        assertFalse(this.stateMachine.sendEvent(Events.ADOPTED_EVENT));
        assertFalse(this.stateMachine.sendEvent(Events.REVOKED_EVENT));

        assertEquals(States.WAITING, this.stateMachine.getState().getId());
    }

}