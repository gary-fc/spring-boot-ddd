package com.garyfrancodev.IdentityServer.domain.events;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class UserCreatedEvent {

    @TargetAggregateIdentifier
    private String userId;
    private String firstName;
    private String lastName;
    private String age;
}
