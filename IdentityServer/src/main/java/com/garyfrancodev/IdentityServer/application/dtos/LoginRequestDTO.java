package com.garyfrancodev.IdentityServer.application.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @Schema(description = "email")
    private String email;

    @Schema(description = "password")
    private String password;
}
