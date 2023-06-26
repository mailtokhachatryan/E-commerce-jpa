package org.example.model;

import jakarta.validation.constraints.*;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull // null
    @NotEmpty // null, ""
    @NotBlank // null, "", "        "
    private String name;

    @Min(5)
    @Max(4)
    private String lastname;

    @Positive
    private double balance;

    @Size(min = 8)
    private String password;
    private int age;
    private Boolean active;

}