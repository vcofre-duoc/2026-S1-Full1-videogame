package cl.duoc.videogames.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanieDTO {

    private Long id;
    private String name;
    private String country;
}
