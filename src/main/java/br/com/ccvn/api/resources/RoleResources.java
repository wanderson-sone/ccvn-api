package br.com.ccvn.api.resources;

import br.com.ccvn.api.models.Role;
import br.com.ccvn.api.services.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleResources {

    private final RoleService service;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> findAll() {
        List<Role> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/roles/{id}")
    ResponseEntity<Role> find(@PathVariable Long id){
        Role obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
