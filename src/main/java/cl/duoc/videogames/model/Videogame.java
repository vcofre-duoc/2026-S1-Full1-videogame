package cl.duoc.videogames.model;
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
}
