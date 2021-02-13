package br.com.ccvn.api.security.service;

import br.com.ccvn.api.repositories.UserRepository;
import br.com.ccvn.api.services.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService, IUsuarioService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UserRepository repo;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        br.com.ccvn.api.models.User user = repo.findByEmail(username);

        if(user == null){
            logger.error("Erro ao logar! O email informado: '"+ username +"'não esta vinculado a nenhum usuário.");
            throw  new UsernameNotFoundException("Erro ao logar! O email informado: '"+ username +"'não esta vinculado a nenhum usuário.");
        }

        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(user.getEmail(), user.getPassword(), user.getStatus(), true, true, true, authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public br.com.ccvn.api.models.User findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
