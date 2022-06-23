package edu.ilp.sisgailp.controller;

import edu.ilp.sisgailp.dao.IRolDao;
import edu.ilp.sisgailp.dao.IUsuarioDao;
import edu.ilp.sisgailp.entity.Rol;
import edu.ilp.sisgailp.entity.Usuario;
import edu.ilp.sisgailp.payload.JwtAuthenticationResponse;
import edu.ilp.sisgailp.payload.LoginRequest;
import edu.ilp.sisgailp.payload.RestResponse;
import edu.ilp.sisgailp.payload.SignUpRequest;
import edu.ilp.sisgailp.security.JwtTokenProvider;
import edu.ilp.sisgailp.service.IUsuarioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    private IRolDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private IUsuarioService userService;

    private static final Log LOGGER = LogFactory.getLog(AuthController.class);

    @PostMapping("/signin")
    public JwtAuthenticationResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        LOGGER.info(" PARAMETROS DE LOGUEO: <<<<<<<>>>>>> '"+ loginRequest.toString() + "'");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

            Usuario user = this.userService.getPersonaByUsuario(loginRequest.getUsernameOrEmail());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenProvider.generateToken(authentication);

        if(jwt != null){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            Collection<? extends GrantedAuthority> rol = userDetails.getAuthorities();

            return new JwtAuthenticationResponse(HttpStatus.OK.value(),"Sesión de inicio correcto",jwt, userDetails.getUsername(),userDetails.getAuthorities(), user.getPersona().getNombre(),user.getPersona().getIdpersona());
        }
        return new JwtAuthenticationResponse(HttpStatus.UNAUTHORIZED.value(),"Credenciales invalidas o usuario no registrado");
        }

    @PostMapping("/signup")
    public RestResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        LOGGER.info(" PARAMETROS DE LOGUEO: <<<<<<<>>>>>> '"+ signUpRequest.toString() + "'");

        if (usuarioDao.existsByUsername(signUpRequest.getUsername())) {
            return new RestResponse(HttpStatus.BAD_REQUEST.value(),"Fail -> Username is already taken!");
        }

        // Creating user's account
        Usuario user = new Usuario(signUpRequest.getUsername(),passwordEncoder.encode(signUpRequest.getPassword()),signUpRequest.getIdpersona());

        Long strRoles = signUpRequest.getIdrole();

        Set<Rol> roles = new HashSet<>();

                Rol adminRole = this.roleDao.findByIdrol(strRoles);

                roles.add(adminRole);

        user.setRoles(roles);
        usuarioDao.save(user);
        return new RestResponse(HttpStatus.OK.value(),"User registered successfully!");
    }
}
