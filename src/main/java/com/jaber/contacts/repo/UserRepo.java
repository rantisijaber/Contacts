package com.jaber.contacts.repo;

import ch.qos.logback.core.net.SMTPAppenderBase;
import com.jaber.contacts.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    public User findByUsername(String username);
}
