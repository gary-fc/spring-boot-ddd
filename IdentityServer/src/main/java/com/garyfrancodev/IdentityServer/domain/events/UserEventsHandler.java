package com.garyfrancodev.IdentityServer.domain.events;

import com.garyfrancodev.IdentityServer.infrastructure.persistence.UserEntity;
import com.garyfrancodev.IdentityServer.infrastructure.repository.UserRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserEventsHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventHandler
    public void on(UserCreatedEvent userCreatedEvent) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userCreatedEvent, userEntity);
        userRepository.save(userEntity);
    }
}
