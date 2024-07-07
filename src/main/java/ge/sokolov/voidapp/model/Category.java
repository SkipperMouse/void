package ge.sokolov.voidapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @Column("id")
    private UUID id;

    @Column("name")
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
