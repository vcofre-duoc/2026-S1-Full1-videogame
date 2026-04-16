package cl.duoc.videogames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleDTO {
    private Long id;
    private String name;
    private Integer releaseYear;
    private CompanieDTO companie;
}
