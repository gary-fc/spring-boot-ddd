package com.garyfrancodev.IdentityServer.application.usecase.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateUserCommand {

    @TargetAggregateIdentifier
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String age;
}
