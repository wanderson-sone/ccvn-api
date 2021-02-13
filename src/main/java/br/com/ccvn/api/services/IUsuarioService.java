package br.com.ccvn.api.services;

import br.com.ccvn.api.models.User;

public interface IUsuarioService {

    User findByEmail(String email);
}
