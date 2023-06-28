package org.example.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@Entity
@ToString
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
