package ru.yandex.practicum.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class User {

    @Id
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "registration_date")
    private Instant registrationDate = Instant.now();

    @Enumerated(EnumType.STRING)
    private UserState state;
}