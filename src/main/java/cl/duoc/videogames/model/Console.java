package cl.duoc.videogames.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="consoles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Console {

    @Id //indica que es pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera autoincrementable
    private Long id;// campo

    @NotBlank //validar que no sea nulo ni vacio
    private String name;

    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "companie_id", nullable = false)
    private Companie companie;

}
