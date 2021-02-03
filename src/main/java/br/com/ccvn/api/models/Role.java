package br.com.ccvn.api.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vn_roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
