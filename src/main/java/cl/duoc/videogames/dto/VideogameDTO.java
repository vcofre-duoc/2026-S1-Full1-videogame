package cl.duoc.videogames.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideogameDTO {

    private Long id;
    private String title;
    private String genre;
    private Integer releaseYear;
    private String developer;
    private List<ConsoleDTO> consoles; 

}
