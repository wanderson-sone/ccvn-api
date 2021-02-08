package br.com.ccvn.api.services.impl;

import br.com.ccvn.api.models.Role;
import br.com.ccvn.api.repositories.RoleRepository;
import br.com.ccvn.api.services.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    @Override
    public List<Role> findAll() {
        return repo.findAll();
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> obj = repo.findById(id);
        return obj.get();
    }

    @Override
    public Role findByName(String name) {
        return null;
    }
}
