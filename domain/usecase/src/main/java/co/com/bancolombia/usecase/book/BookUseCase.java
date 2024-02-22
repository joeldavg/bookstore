package co.com.bancolombia.usecase.book;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.BookRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BookUseCase {

    private final BookRepository bookRepository;
    
    public Flux<Book> findBooksContainsTitle(String title) {
        return bookRepository.findBooksContainsTitle(title);
    }

    public Mono<Book> findBookById(String id) {
        return bookRepository.findBookById(id);
    }

    public Mono<Book> updateBook(String id, Book book) {
        return bookRepository.updateBook(id, book);
    }

    public Mono<Book> createBook(Book book) {
        return bookRepository.createBook(book);
    }

    public Mono<Void> deleteBookById(String id) {
        return bookRepository.deleteBookById(id);
    }
}
