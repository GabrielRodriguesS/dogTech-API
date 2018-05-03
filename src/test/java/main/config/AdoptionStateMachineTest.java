package main.config;

import main.config.enums.Events;
import main.config.enums.States;
import main.model.Adoption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdoptionStateMachineConfig.class)
public class AdoptionStateMachineTest {

    @Autowired
    private StateMachine<States, Events> stateMachine;
    private Adoption adoption;

    @Before
    public void setUp() throws Exception {
        this.adoption = new Adoption();
        this.stateMachine.start();
    }

    @After
    public void tearDown() {
        stateMachine.stop();
    }

    // Flow normal testing walking by allowed transitions states
    @Test
    public void testStartingWaitingEvent() {
        assertEquals(States.WAITING, stateMachine.getState().getId());
    }

    @Test
    public void testEventDisaprovedAdoption() {
        assertTrue(this.stateMachine.sendEvent(Events.DISAPPROVED_ADOPTION));
        assertEquals(States.REJECTED, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventApprovedAdoption() {
        assertTrue(this.stateMachine.sendEvent(Events.APPROVED_ADOPTION));
        assertEquals(States.WAITING_VISIT, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventEventGiveUp() {
        assertTrue(this.stateMachine.sendEvent(Events.APPROVED_ADOPTION));
        assertTrue(this.stateMachine.sendEvent(Events.GIVE_UP));
        assertEquals(States.DESISTING, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventAdopt() {
        assertTrue(this.stateMachine.sendEvent(Events.APPROVED_ADOPTION));
        assertTrue(this.stateMachine.sendEvent(Events.ADOPT));
        assertEquals(States.ADOPTED, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventGiveBack() {
        assertTrue(this.stateMachine.sendEvent(Events.APPROVED_ADOPTION));
        assertTrue(this.stateMachine.sendEvent(Events.ADOPT));
        assertTrue(this.stateMachine.sendEvent(Events.GIVE_BACK));
        assertEquals(States.RETURNED, this.stateMachine.getState().getId());
    }

    @Test
    public void testEventRevokedAdoption() {
        assertTrue(this.stateMachine.sendEvent(Events.APPROVED_ADOPTION));
        assertTrue(this.stateMachine.sendEvent(Events.ADOPT));
        assertTrue(this.stateMachine.sendEvent(Events.REVOKED_ADOPTION));
        assertEquals(States.REVOKED, this.stateMachine.getState().getId());
    }
    //Ending normal flow tests


}