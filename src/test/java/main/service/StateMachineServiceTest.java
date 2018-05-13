package main.service;

import main.DogTechApiApplication;
import main.utils.stateMachine.stateMachineEnums.Events;
import main.utils.stateMachine.stateMachineEnums.States;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = StateMachineService.class)
@SpringBootTest(classes = DogTechApiApplication.class)
public class StateMachineServiceTest {

    @Autowired
    private StateMachineService stateMachineService;
    private StateMachine stateMachine;

    @Before
    public void setUp() {
        this.stateMachine = null;
    }

    @After
    public void tearDown() {
        this.stateMachine.stop();
    }

    @Test
    public void testStateMachineReturnWaitingState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.WAITING);
        assertEquals(States.WAITING, this.stateMachine.getState().getId());
    }

    @Test
    public void testStateMachineReturnWaitingVisitState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.WAITING_VISIT);
        assertEquals(States.WAITING_VISIT, this.stateMachine.getState().getId());
    }

    @Test
    public void testStateMachineReturnRejectState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.REJECTED);
        assertEquals(States.REJECTED, this.stateMachine.getState().getId());
    }

    @Test
    public void testStateMachineReturnDesistingState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.DESISTING);
        assertEquals(States.DESISTING, this.stateMachine.getState().getId());
    }

    @Test
    public void testStateMachineReturnAdoptedState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.ADOPTED);
        assertEquals(States.ADOPTED, this.stateMachine.getState().getId());
    }

    @Test
    public void testStateMachineReturnReturnedState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.RETURNED);
        assertEquals(States.RETURNED, this.stateMachine.getState().getId());
    }

    @Test
    public void testStateMachineReturnRevokedState() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.REVOKED);
        assertEquals(States.REVOKED, this.stateMachine.getState().getId());
    }

    @Test
    public void stateMachineHasErros() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.WAITING);
    }

    @Test
    public void startStateMachine() {
        this.stateMachine = this.stateMachineService.configureStateMachine(States.WAITING);
        this.stateMachine.sendEvent(Events.REVOKED_EVENT);
        assertTrue(this.stateMachine.hasStateMachineError());
    }

}