package com.garyfrancodev.IdentityServer.application.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginResponseDTO {
    @Schema(description = "Mensaje de éxito", example = "Inicio de sesión exitoso")
    private String successMessage;

    @Schema(description = "Token de acceso", example = "eyJhbGciOiJIUzI1NiIsIn...")
    private String accessToken;
}
