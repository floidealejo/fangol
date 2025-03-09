package co.com.alejandroupegui.r2dbc;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paises")
public class Country {
    @Id
    @Column("id")
    private UUID id;

    
    @Column("nombre")
    private String name;
}
