package com.garyfrancodev.IdentityServer.domain.model;

import com.garyfrancodev.IdentityServer.application.usecase.command.CreateUserCommand;
import com.garyfrancodev.IdentityServer.domain.events.UserCreatedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Data
@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String userId;
    private String firstName;
    private String lastName;
    private String age;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand) {
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(createUserCommand, userCreatedEvent);
        AggregateLifecycle.apply(userCreatedEvent);
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent userCreatedEvent) {
        this.userId = userCreatedEvent.getUserId();
        this.firstName = userCreatedEvent.getFirstName();
        this.lastName = userCreatedEvent.getLastName();
        this.age = userCreatedEvent.getAge();
    }
}
