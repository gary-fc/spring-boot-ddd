package com.garyfrancodev.IdentityServer.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String age;
}
