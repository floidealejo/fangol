package co.com.alejandroupegui.r2dbc.config.schema;

import org.springframework.stereotype.Component;

@Component
public class IndexSchemaRule implements SchameRule {
    @Override
    public String apply(Class<?> entityClass) {
        return "";
//                Arrays.stream(entityClass.getDeclaredFields())
//                .filter(field -> field.isAnnotationPresent(Index.class)) // Suponiendo que creamos una anotación personalizada
//                .map(this::getIndexDefinition)
//                .collect(Collectors.joining(", "));
    }

//    private String getIndexDefinition(Field field) {
//        Index index = field.getAnnotation(Index.class);
//        String columnName = index.column();
//        return "";
//                "CREATE INDEX idx_" + columnName + " ON " + index.table() + " (" + columnName + ")";
//    }
}
