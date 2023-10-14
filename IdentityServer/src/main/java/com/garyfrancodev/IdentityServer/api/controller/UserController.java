package com.garyfrancodev.IdentityServer.api.controller;

import com.garyfrancodev.IdentityServer.application.dtos.CreateUserRequestDTO;
import com.garyfrancodev.IdentityServer.application.usecase.command.CreateUserCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final CommandGateway commandGateway;

    @Autowired
    public UserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createUser(CreateUserRequestDTO createUserRequestDTO) {
        CreateUserCommand createUserCommand = CreateUserCommand.builder()
                .firstName(createUserRequestDTO.getFirstName())
                .lastName(createUserRequestDTO.getLastName())
                .age(createUserRequestDTO.getAge())
                .userId(UUID.randomUUID().toString()).build();
        String response;
        try {
            response = commandGateway.sendAndWait(createUserCommand);
        } catch (Exception exception) {
            response = exception.getLocalizedMessage();
        }

        return response;
    }
}
