package br.com.ccvn.api.repositories;

import br.com.ccvn.api.models.Role;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    Optional<Role> findById(Long id);

//    @Query(value = "SELECT r FROM vn_roles r WHERE r.name = ?1", nativeQuery = true)
//    Role findByName(String name);
}