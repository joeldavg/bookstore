package co.com.bancolombia.model.book.gateways;

import co.com.bancolombia.model.book.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

    Flux<Book> findBooksContainsTitle(String title);
    Mono<Book> findBookById(long id);
    Mono<Book> updateBook(long id, Book book);
    Mono<Book> createBook(Book book);
    Mono<Void> deleteBookById(long id);

}
