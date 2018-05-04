package main.service;

import main.config.enums.States;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StateMachineService.class)
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
        this.stateMachine = null;
    }

    //Todo refatorar as classes handler para converter ou algo assim
    @Test
    public void testStateMachineReturnWaitingState() { // TODO autowired das classes handlerEnum nao funcionam.
        this.stateMachine = this.stateMachineService.getConfiguredStateMachine(States.WAITING);
        assertEquals(States.WAITING, this.stateMachine.getState().getId());
    }
}