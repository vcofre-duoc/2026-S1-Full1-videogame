package cl.duoc.videogames.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Companie {

    @Id //indica que es pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera autoincrementable
    private Long id;// campo

    @NotBlank //validar que no sea nulo ni vacio
    private String name;

    private String country;

    //Indica que la relacion es uno a muchos
    @OneToMany(mappedBy = "companie") //inicar que el dueño de la relacion es companie
    private Set<Console> consoles = new HashSet<>();//Incluimos la colección a la relación
}