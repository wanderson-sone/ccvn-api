package br.com.ccvn.api.services;

import br.com.ccvn.api.models.Role;

import java.util.List;

public interface RoleService {

    Role findById(Long id);

    Role findByName(String name);

    public List<Role> findAll();
}
