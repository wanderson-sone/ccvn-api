package br.com.ccvn.api.services;

import br.com.ccvn.api.models.User;
import br.com.ccvn.api.models.dto.UserDTO;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public User create(User user);

    public User update(User user);

    public void delete(Long id);

    public User fromUserDTO(UserDTO objDto);

    void modifyUserStatus(Long id, Boolean status);
}
