package co.com.alejandroupegui.r2dbc;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// TODO: This file is just an example, you should delete or modify it
public interface MyReactiveRepository
        extends ReactiveCrudRepository<Country, String>, ReactiveQueryByExampleExecutor<Country>
{

}
