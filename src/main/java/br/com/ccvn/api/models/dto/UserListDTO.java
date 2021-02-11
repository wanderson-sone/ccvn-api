package br.com.ccvn.api.models.dto;

import br.com.ccvn.api.models.Role;
import br.com.ccvn.api.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserListDTO {

    private Long id;

    private String name;

    private String email;

    private Boolean status;

    private Date createdAt;

    private List<Role> roles;

    public UserListDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        status = obj.getStatus();
        createdAt = obj.getCreatedAt();
        roles = obj.getRoles();
    }
}
