package com.garyfrancodev.IdentityServer.application.dtos;

import lombok.Data;

@Data
public class CreateUserRequestDTO {
    private String firstName;
    private String lastName;
    private String age;
}
