package br.com.fiap.gestaoDeResiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_bairro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Bairro {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_BAIRRO"
    )
    @SequenceGenerator(
            name = "SEQ_BAIRRO",
            sequenceName = "SEQ_BAIRRO",
            allocationSize = 1
    )
    @Column(name = "id_bairro")
    private Long idBairro;
    @Column(name = "nome_bairro")
    private String nomeBairro;
    @Column(name = "nome_cidade")
    private String nomeCidade;
    @Column(name = "numero_cep")
    private String numeroCep;

}
