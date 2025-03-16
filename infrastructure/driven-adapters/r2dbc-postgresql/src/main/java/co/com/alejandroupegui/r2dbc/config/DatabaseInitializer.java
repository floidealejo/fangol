package co.com.alejandroupegui.r2dbc.config;

import co.com.alejandroupegui.r2dbc.config.schema.EntityInspector;
import co.com.alejandroupegui.r2dbc.config.schema.SchemaGenerator;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DatabaseInitializer {

    private static final Logger log = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final DatabaseClient databaseClient;
    private final SchemaGenerator schemaGenerator;
    private final EntityInspector entityInspector;

    public DatabaseInitializer(DatabaseClient databaseClient,
                               SchemaGenerator schemaGenerator,
                               EntityInspector entityInspector) {
        this.databaseClient = databaseClient;
        this.schemaGenerator = schemaGenerator;
        this.entityInspector = entityInspector;
    }

    @PostConstruct
    public void initializeDatabase() {
        log.info("Iniciando la generación de esquemas...");

        Set<Class<?>> entityClasses = entityInspector.getEntityClasses();
        String schemaSql = schemaGenerator.generateSchema(entityClasses);

        databaseClient.sql(schemaSql)
                .fetch()
                .rowsUpdated()
                .doOnSuccess(count -> log.info("Esquema creado correctamente, filas afectadas: {}", count))
                .doOnError(error -> log.error("Error al ejecutar el SQL", error))
                .subscribe();
    }
}
