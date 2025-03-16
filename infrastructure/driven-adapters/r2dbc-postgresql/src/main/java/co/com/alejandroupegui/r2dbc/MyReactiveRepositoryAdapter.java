package co.com.alejandroupegui.r2dbc;

import co.com.alejandroupegui.r2dbc.entities.Country;
import co.com.alejandroupegui.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Object/* change for domain model */,
        Country/* change for adapter model */,
        UUID,
        MyReactiveRepository
        >
{
    public MyReactiveRepositoryAdapter(MyReactiveRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Object.class/* change for domain model */));
    }

}

