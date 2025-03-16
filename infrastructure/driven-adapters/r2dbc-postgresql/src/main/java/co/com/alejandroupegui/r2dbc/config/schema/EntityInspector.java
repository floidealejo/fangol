package co.com.alejandroupegui.r2dbc.config.schema;

import org.reflections.Reflections;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EntityInspector {

    private final Reflections reflections;

    public EntityInspector() {
        this.reflections = new Reflections("co.com.alejandroupegui.r2dbc.entities");
    }

    public Set<Class<?>> getEntityClasses() {
        return reflections.getTypesAnnotatedWith(Table.class);
    }
}
