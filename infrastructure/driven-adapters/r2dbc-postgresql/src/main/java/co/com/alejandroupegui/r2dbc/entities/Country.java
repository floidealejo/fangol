package co.com.alejandroupegui.r2dbc.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public", name = "paises")
public class Country {
    @Id
    @Column("id")
    private UUID id;

    @Column("nombre")
    private String name;
}
