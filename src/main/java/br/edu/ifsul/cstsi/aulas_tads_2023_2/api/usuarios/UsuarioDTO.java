package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UsuarioDTO {

    private Integer codUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String password;

    public static UsuarioDTO create(Usuario usuario){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public static Usuario converterDtoParaObjeto(UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        return usuario;
    }
}
