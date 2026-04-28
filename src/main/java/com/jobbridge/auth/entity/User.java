package com.jobbridge.auth.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private String phone;
    private String location;
    private String skills;
    private Integer experienceYears;
    @Column(length = 1000)
    private String bio;
}