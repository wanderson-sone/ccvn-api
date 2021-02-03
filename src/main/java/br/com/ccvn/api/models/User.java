package br.com.ccvn.api.models;

import lombok.*;

import javax.persistence.*;
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
    private String nome;

    @Column(length = 60)
    private String email;

    @Column(length = 8)
    private String password;

    private Boolean status;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "vn_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "user_id", "role_id"
                })
            })
    private List<Role> roles;

    @PrePersist
    public void prePersist(){
        createdAt = new Date();
    }
}


