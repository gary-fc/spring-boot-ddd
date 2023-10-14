package com.garyfrancodev.IdentityServer.api.controller;

import com.garyfrancodev.IdentityServer.application.dtos.LoginRequestDTO;
import com.garyfrancodev.IdentityServer.application.dtos.LoginResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ApiResponse(description = "Operaciones relacionadas con la autenticación de usuarios")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private Environment env;

    @Operation(
            summary = "Iniciar",
            description = "test",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LoginResponseDTO.class))
                    )
            }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return null;
    }

    @GetMapping("/login")
    public String test() {
        return "Test" + env.getProperty("local.server.port");
    }
}
