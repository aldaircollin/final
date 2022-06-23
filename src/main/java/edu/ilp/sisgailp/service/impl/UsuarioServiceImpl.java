package edu.ilp.sisgailp.service.impl;

import edu.ilp.sisgailp.dao.IUsuarioDao;
import edu.ilp.sisgailp.entity.Usuario;
import edu.ilp.sisgailp.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public Usuario getPersonaByUsuario(String username) {
        System.out.println("ESTOY EN EL METODO SERVICE USER >>> ");
        Usuario user = this.usuarioDao.findPersonaByUsername(username);

        System.out.println("ID EXTRAIDO DEL USUARIO >>>> " + user.getPersona());

        return user;
    }
}
