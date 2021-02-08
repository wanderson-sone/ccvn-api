package br.com.ccvn.api.models.dto;

import br.com.ccvn.api.models.Role;
import br.com.ccvn.api.models.User;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String name;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
    private String email;

    private String password;

    private Boolean status;

    private Long roles;

    private Date createdAt;
}
