package co.com.alejandroupegui.r2dbc;

import co.com.alejandroupegui.r2dbc.entities.Country;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

// TODO: This file is just an example, you should delete or modify it
public interface MyReactiveRepository
        extends ReactiveCrudRepository<Country, UUID>, ReactiveQueryByExampleExecutor<Country>
{

}
