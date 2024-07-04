package com.oauth.server.persistence.model;

import com.oauth.server.util.BooleanToSmallintConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 15)
    private Long id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(length = 60)
    private String password;

    @Column(columnDefinition = "smallint", nullable = false)
    @Convert(converter = BooleanToSmallintConverter.class)
    private boolean enabled = false;

}
