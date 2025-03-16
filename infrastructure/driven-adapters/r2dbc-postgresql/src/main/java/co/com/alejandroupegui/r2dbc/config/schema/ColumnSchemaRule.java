package co.com.alejandroupegui.r2dbc.config.schema;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class ColumnSchemaRule implements SchameRule {
    @Override
    public String apply(Class<?> entityClass) {
        return Arrays.stream(entityClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(this::getColumnDefinition)
                .collect(Collectors.joining(", "));
    }

    private String getColumnDefinition(Field field) {
        Column column = field.getAnnotation(Column.class);
        String columnName = column.value();
        String columnType = getSqlType(field.getType());

        return columnName + " " + columnType;
    }

    private String getSqlType(Class<?> fieldType) {
        if (fieldType == String.class) return "VARCHAR(255)";
        if (fieldType == Integer.class) return "INT";
        if (fieldType == Long.class) return "BIGINT";
        if (fieldType == Boolean.class) return "BOOLEAN";
        if (fieldType == java.util.UUID.class) return "UUID";
        return "TEXT";
    }
}
