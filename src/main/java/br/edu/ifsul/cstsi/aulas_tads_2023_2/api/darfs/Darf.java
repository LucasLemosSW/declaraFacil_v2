package br.edu.ifsul.cstsi.aulas_tads_2023_2.api.darfs;

import br.edu.ifsul.cstsi.aulas_tads_2023_2.api.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Darf {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer codDarf;

    private Long codDoImposto;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "codUsuario", referencedColumnName = "codUsuario")
    private Usuario usuarioByCodUsuario;


}

