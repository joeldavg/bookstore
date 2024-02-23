package co.com.bancolombia.r2dbc.book.adapter;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.BookRepository;
import co.com.bancolombia.r2dbc.book.entity.BookEntity;
import co.com.bancolombia.r2dbc.helper.ReactiveAdapterOperations;
import co.com.bancolombia.r2dbc.book.repository.BookReactiveRepository;
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
    public Flux<Book> findBooksContainingTitle(String title) {
        return super.repository.findByTitleContainingIgnoreCase(title)
                .map(super::toEntity);
    }

    @Override
    public Mono<Book> findBookById(long id) {
        return super.findById(id);
    }

    @Override
    public Mono<Book> updateBook(Book bookToUpdate) {
        return super.save(bookToUpdate);
    }

    @Override
    public Mono<Book> createBook(Book bookToCreate) {
        return super.save(bookToCreate);
    }

    @Override
    public Mono<Void> deleteBookById(long id) {
        return super.deleteById(id);
    }

    @Override
    public Flux<Book> findALlBooks() {
        return super.findAll();
    }
}
