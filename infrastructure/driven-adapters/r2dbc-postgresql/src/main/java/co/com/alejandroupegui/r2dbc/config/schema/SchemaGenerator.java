package co.com.alejandroupegui.r2dbc.config.schema;

import lombok.AllArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SchemaGenerator {

    private final List<SchameRule> rules;

    public String generateSchema(Set<Class<?>> entityClasses) {
        return entityClasses.stream()
                .map(this::generateTableSchema)
                .collect(Collectors.joining("; "));
    }

    private String generateTableSchema(Class<?> entityClass) {
        String tableName = entityClass.getAnnotation(Table.class).name();
        String columnsAndConstraints = rules.stream()
                .map(rule -> rule.apply(entityClass))
                .filter(column -> column != null && !column.isBlank())
                .collect(Collectors.joining(", "));

        return "CREATE TABLE IF NOT EXISTS " + tableName + " (" + columnsAndConstraints + ")";
    }
}
