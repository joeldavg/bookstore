package co.com.bancolombia.r2dbc;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.BookRepository;
import co.com.bancolombia.r2dbc.entity.BookEntity;
import co.com.bancolombia.r2dbc.repository.helper.ReactiveAdapterOperations;
import co.com.bancolombia.r2dbc.repository.BookReactiveRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class BookReactiveRepositoryAdapter extends ReactiveAdapterOperations<Book, BookEntity, Long, BookReactiveRepository>
        implements BookRepository {

    public BookReactiveRepositoryAdapter(BookReactiveRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Book.class));
    }

    @Override
    public Flux<Book> findBooksContainsTitle(String title) {
        return repository.findBooksContainsTitle(title)
                .map(super::toEntity);
    }

    @Override
    public Mono<Book> findBookById(long id) {
        return super.findById(id);
    }

    @Override
    public Mono<Book> updateBook(long id, Book book) {
        return null;
    }

    @Override
    public Mono<Book> createBook(Book book) {
        return super.save(book);
    }

    @Override
    public Mono<Void> deleteBookById(long id) {
        return super.deleteById(id);
    }
}
