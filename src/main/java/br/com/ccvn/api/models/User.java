package br.com.ccvn.api.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vn_users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 60)
    private String name;

    @Email(message = "O endereço de email esta fora dos padrões")
    @Column(unique = true, length = 60)
    private String email;

    @Column(length = 60)
    private String password;

    private Boolean status;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "vn_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "user_id", "role_id"
                })
            })
    private List<Role> roles = new ArrayList<>();

    public User(Long id, String name, String email, String password, Boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        createdAt = atual;
        updatedAt = atual;
    }
}


