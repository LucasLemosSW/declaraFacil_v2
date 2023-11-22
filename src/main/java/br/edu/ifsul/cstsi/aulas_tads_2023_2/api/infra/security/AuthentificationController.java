package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.infra.security;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.UserRole;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.Usuario;
import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")

public class AuthentificationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login ( @RequestBody AuthentificationDTO data){

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(),data.password());
        System.out.println(data.login());
        System.out.println(data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody @Valid RegisterDTO data){

        if(this.usuarioRepository.findByLogin(data.email())!=null) return ResponseEntity.badRequest().body("email already registered");

        System.out.println("chegou");
        String EncriptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.email(),data.nome(), data.sobrenome(),EncriptedPassword, UserRole.ADMIN);

        this.usuarioRepository.save(newUser);
//        TODO:Devolver URL para o recurso
//        return ResponseEntity.created().build();
        return ResponseEntity.ok().build();

    }
}
