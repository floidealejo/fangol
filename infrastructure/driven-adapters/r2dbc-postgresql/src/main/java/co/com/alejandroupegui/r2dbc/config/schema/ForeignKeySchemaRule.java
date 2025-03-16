package co.com.alejandroupegui.r2dbc.config.schema;


import org.springframework.stereotype.Component;


@Component
public class ForeignKeySchemaRule implements SchameRule {

    @Override
    public String apply(Class<?> entityClass) {
        return "";
//                Arrays.stream(entityClass.getDeclaredFields())
//                .filter(field -> field.isAnnotationPresent(ForeignKey.class)) // Suponiendo que creamos una anotación personalizada
//                .map(this::getForeignKeyDefinition)
//                .collect(Collectors.joining(", "));
    }

//    private String getForeignKeyDefinition(Field field) {
//        ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);
//        String columnName = foreignKey.column();
//        String referencedTable = foreignKey.referencedTable();
//        String referencedColumn = foreignKey.referencedColumn();

//        return "";
//                "FOREIGN KEY (" + columnName + ") REFERENCES " + referencedTable + "(" + referencedColumn + ")";
//    }
}
