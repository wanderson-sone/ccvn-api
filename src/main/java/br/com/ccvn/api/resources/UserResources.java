package br.com.ccvn.api.resources;

import br.com.ccvn.api.models.User;
import br.com.ccvn.api.models.dto.UserDTO;
import br.com.ccvn.api.models.dto.UserListDTO;
import br.com.ccvn.api.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResources {

    private final UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserListDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserListDTO> listDto = list.stream()
                .map(obj -> new UserListDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> find(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/users")
    public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO newObj) {
        User obj = service.fromUserDTO(newObj);
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("users/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UserDTO objDto, @PathVariable Long id) {
        User obj = service.fromUserDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("users/{id}/status")
    public void modifyStatus(@PathVariable Long id, @RequestBody Boolean status) {
        service.modifyUserStatus(id, status);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
