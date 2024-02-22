package co.com.bancolombia.r2dbc.repository;

import co.com.bancolombia.r2dbc.entity.BookEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface BookReactiveRepository extends R2dbcRepository<BookEntity, Long> {

    Flux<BookEntity> findBooksContainsTitle(String title);

}
