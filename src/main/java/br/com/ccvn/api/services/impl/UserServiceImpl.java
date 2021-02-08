package br.com.ccvn.api.services.impl;

import br.com.ccvn.api.models.Role;
import br.com.ccvn.api.models.dto.UserDTO;
import br.com.ccvn.api.services.RoleService;
import br.com.ccvn.api.services.UserService;
import br.com.ccvn.api.models.User;
import br.com.ccvn.api.repositories.UserRepository;
import br.com.ccvn.api.services.exceptions.DataIntegrityException;
import br.com.ccvn.api.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    private final RoleService roleService;

    @Override
    public List<User> findAll() {
        log.info("Listando todos os usuários");
        return repo.findAll();
    }

    @Override
    public User findById(Long id) {
        log.info("Listando usuário por ID");
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }

    @Override
    public User create(User obj) {
        obj.setId(null);
        userExists(obj.getEmail());
        obj = repo.save(obj);
        return obj;
    }

    @Override
    public User update(User obj) {
        User newObj  = findById(obj.getId());
        updateData(newObj, obj);
        BeanUtils.copyProperties(obj, newObj, "id");
        return repo.save(newObj);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityException e) {
            throw new DataIntegrityException("Não e possivel...");
        }
    }

    public User fromUserDTO(UserDTO objDto) {
        User user = new User(null, objDto.getName(), objDto.getEmail(),
                objDto.getPassword(), objDto.getStatus());
        Role role = roleService.findById(objDto.getRoles());
        user.setRoles(Collections.singletonList(role));
        return user;
    }

    @Override
    public void modifyUserStatus(Long id, Boolean status) {
        User user = findById(id);
        user.setStatus(status);
        repo.save(user);
    }

    private void userExists(String email){
        User user = repo.findByEmail(email);

        if(user != null) {
            throw new EmptyResultDataAccessException(1);
//            throw new DataIntegrityException("Email ja utilizado por outro usuário!");
        }



//        try{
//            return user != null;
//        }catch (DataIntegrityException e) {
//            throw new DataIntegrityException("Email ja utilizado por outro usuário!");
//        }
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setPassword(obj.getPassword());
        newObj.setStatus(obj.getStatus());

        Role role = roleService.findById(obj.getRoles().get(0).getId());

        Integer qtde = obj.getRoles().size();

        List<Role> listRole = new ArrayList<>();
        listRole.add(role);

        newObj.setRoles(listRole);
    }


    private void updadeRoleUser (User obj) {

//        for (User user : obj.getRoles()){
//            Role role = roleService.findById(obj.getRoles().get(Math.toIntExact(x)-1));
//            List<Role> list = new ArrayList<>();
//            list.add(role);
//            user.setRoles(list);
//        }

    }
}
