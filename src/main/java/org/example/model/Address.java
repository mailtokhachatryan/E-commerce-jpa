package org.example.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

}
