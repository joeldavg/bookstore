package co.com.bancolombia.model.book.gateways;

import co.com.bancolombia.model.book.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

    Flux<Book> findBooksContainingTitle(String title);
    Mono<Book> findBookById(long id);
    Mono<Book> updateBook(Book bookToUpdate);
    Mono<Book> createBook(Book bookToCreate);
    Mono<Void> deleteBookById(long id);

}
