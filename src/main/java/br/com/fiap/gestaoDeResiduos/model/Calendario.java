package br.com.fiap.gestaoDeResiduos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_calendario_coleta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Calendario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CALENDARIO"
    )
    @SequenceGenerator(
            name = "SEQ_CALENDARIO",
            sequenceName = "SEQ_CALENDARIO",
            allocationSize = 1
    )
    @Column(name = "id_calendario")
    private Long idCalendario;
    @Column(name = "nome_dia_coleta")
    private String nomeDiaColeta;
    @Column(name = "hora_coleta")
    private String horaColeta;

}
