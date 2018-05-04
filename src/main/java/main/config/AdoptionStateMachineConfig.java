package main.config;

import main.config.enums.Events;
import main.config.enums.States;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/*
+----------------------------------------------------------+
|                   Adoption machine state                 |
+----------------------------------------------------------+
|                   Event                  Event           |
|               Start Machine       DISAPPROVED_ADOPTION   |
|                  +-------+            +--------+         |
|                  |WAITING+------------>REJECTED|         |
|                  +----+--+            +--------+         |
|                       |                                  |
|                       |                 Event            |
|                       |                GIVE_UP           |
|        Event     +----v--------+       +---------+       |
| APPROVED_ADOPTION|WAITING_VISIT+------->DESISTING|       |
|                  +-----+-------+       +---------+       |
|                        |                                 |
|                        |                                 |
|               Event +--v----+       +--------+   Event   |
|               ADOPT |ADOPTED+------->RETURNED| GIVE_BACK |
|                     +---+---+       +--------+           |
|                         |                                |
|                         |                                |
|                     +---v---+                            |
|                     |REVOKED|                            |
|                     +-------+                            |
|                      Event                               |
|                 REVOKED_ADOPTION                         |
+----------------------------------------------------------+
*/

@Configuration
@EnableStateMachineFactory
public class AdoptionStateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {
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
                .source(States.WAITING).target(States.REJECTED)
                .event(Events.DISAPPROVED_ADOPTION)
                .and()
                .withExternal()
                .source(States.WAITING).target(States.WAITING_VISIT)
                .event(Events.APPROVED_ADOPTION)
                .and()
                .withExternal()
                .source(States.WAITING_VISIT).target(States.DESISTING)
                .event(Events.GIVE_UP)
                .and()
                .withExternal()
                .source(States.WAITING_VISIT).target(States.ADOPTED)
                .event(Events.ADOPT)
                .and()
                .withExternal()
                .source(States.ADOPTED).target(States.RETURNED)
                .event(Events.GIVE_BACK)
                .and()
                .withExternal()
                .source(States.ADOPTED).target(States.REVOKED)
                .event(Events.REVOKED_ADOPTION);
    }

}
