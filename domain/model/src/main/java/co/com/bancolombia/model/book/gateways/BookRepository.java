package co.com.bancolombia.model.book.gateways;

import co.com.bancolombia.model.book.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

    Flux<Book> findBooksContainsTitle(String title);
    Mono<Book> findBookById(String id);
    Mono<Book> updateBook(String id, Book book);
    Mono<Book> createBook(Book book);
    Mono<Void> deleteBookById(String id);

}
