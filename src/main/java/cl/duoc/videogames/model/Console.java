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

    @Builder.Default
    @ManyToMany(mappedBy = "consoles")
    private Set<Videogame> videogames = new HashSet<>();

    //Define cuando 2 objetos se consideran iguales
    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(!(o instanceof Console)) return false;

        Console other = (Console) o;
        return id != null && id.equals(other.getId());
    }

    //Devuelve un numero entero que representa al objeto y se usa como estructura como hashset

    @Override
    public int hashCode(){
        return 31;
    }
}
