package main.config;

import main.config.stateMachineEnums.Events;
import main.config.stateMachineEnums.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/*
+----------------------------------------------------------+
|                   Adoption machine state                 |
+----------------------------------------------------------+
|                   Event                   Event          |
|      Start Machine or WAITING_EVENT  REJECTED_EVENT      |
|                  +-------+            +--------+         |
|                  |WAITING+------------>REJECTED|         |
|                  +----+--+            +--------+         |
|                       |                                  |
|            Event      |                  Event           |
|    WAITING_VISIT_EVENT|             DESISTING_EVENT      |
|                  +----v--------+       +---------+       |
|                  |WAITING_VISIT+------->DESISTING|       |
|                  +-----+-------+       +---------+       |
|                        |                                 |
|                        |                                 |
|           Event     +--v----+       +--------+           |
|       ADOPTED_EVENT |ADOPTED+------->RETURNED|           |
|                     +---+---+       +--------+           |
|                         |              Event             |
|                         |         RETURNED_EVENT         |
|                     +---v---+                            |
|                     |REVOKED|                            |
|                     +-------+                            |
|                      Event                               |
|                  REVOKED_EVENT                           |
+----------------------------------------------------------+
*/

@Configuration
@EnableStateMachine
public class AdoptionStateMachineConfig extends StateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states
                .withStates()
                .initial(States.WAITING)
                .end(States.REJECTED)
                .end(States.DESISTING)
                .end(States.RETURNED)
                .end(States.REVOKED)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                .source(States.WAITING).target(States.WAITING)
                .event(Events.WAITING_EVENT)
                .and()
                .withExternal()
                .source(States.WAITING).target(States.REJECTED)
                .event(Events.REJECTED_EVENT)
                .and()
                .withExternal()
                .source(States.WAITING).target(States.WAITING_VISIT)
                .event(Events.WAITING_VISIT_EVENT)
                .and()
                .withExternal()
                .source(States.WAITING_VISIT).target(States.DESISTING)
                .event(Events.DESISTING_EVENT)
                .and()
                .withExternal()
                .source(States.WAITING_VISIT).target(States.ADOPTED)
                .event(Events.ADOPTED_EVENT)
                .and()
                .withExternal()
                .source(States.ADOPTED).target(States.RETURNED)
                .event(Events.RETURNED_EVENT)
                .and()
                .withExternal()
                .source(States.ADOPTED).target(States.REVOKED)
                .event(Events.REVOKED_EVENT);
    }


}
