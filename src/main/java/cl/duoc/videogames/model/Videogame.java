package cl.duoc.videogames.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="videogames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videogame {

    @Id //indica que es pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera autoincrementable
    private Long id;// campo

    @NotBlank //validar que no sea nulo ni vacio
    private String title;

    private String genre; //genero del juego

    private Integer releaseYear;

    private String developer; //Nombre de quien desarrollo el juego

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @JoinTable(
        name="videogame_console",
        joinColumns = @JoinColumn(name="videogame_id"),
        inverseJoinColumns = @JoinColumn(name="console_id")
    )
    private Set<Console> consoles = new HashSet<>();

    //Define cuando 2 objetos se consideran iguales
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Videogame)) return false;
        Videogame other = (Videogame) o;
        return id != null && id.equals(other.getId());
    }

    //Devuelve un numero entero que representa al objeto y se usa como estructura como hashset
    @Override
    public int hashCode(){
        return 31;
    }
}
