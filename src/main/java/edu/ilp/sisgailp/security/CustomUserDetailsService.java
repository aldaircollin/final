package edu.ilp.sisgailp.security;

import edu.ilp.sisgailp.dao.IUsuarioDao;
import edu.ilp.sisgailp.entity.Usuario;
import edu.ilp.sisgailp.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HeverFernandez on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Usuario user = usuarioDao.findByUsername(usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado : " + usernameOrEmail)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Usuario user = usuarioDao.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Usuario", "id", id)
        );
        return UserPrincipal.create(user);
    }
}