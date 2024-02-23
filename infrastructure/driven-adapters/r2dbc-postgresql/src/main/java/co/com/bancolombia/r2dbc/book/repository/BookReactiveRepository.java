package co.com.bancolombia.r2dbc.book.repository;

import co.com.bancolombia.r2dbc.book.entity.BookEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface BookReactiveRepository extends R2dbcRepository<BookEntity, Long> {

    /*@Query("SELECT b.id,  b.title, b.subtitle, b.authors, b.publisher, " +
            "b.pages, b.year, b.rating, b.description, b.price, b.image, b.url " +
            "FROM books as b " +
            "WHERE UPPER(b.title) LIKE UPPER(CONCAT('%', :title, '%'))")
    Flux<BookEntity> findByTitleContainingIgnoreCase(@Param("title") String title);*/

    Flux<BookEntity> findByTitleContainingIgnoreCase(String title);

}
