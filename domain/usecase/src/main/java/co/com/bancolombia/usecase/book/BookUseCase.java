package co.com.bancolombia.usecase.book;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.BookRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BookUseCase {

    private final BookRepository bookRepository;

    public Flux<Book> findAllBooks() {
        return bookRepository.findALlBooks();
    }
    
    public Flux<Book> findBooksContainingTitle(String title) {
        return bookRepository.findBooksContainingTitle(title);
    }

    public Mono<Book> findBookById(long id) {
        return bookRepository.findBookById(id);
    }

    public Mono<Book> updateBook(long id, Book bookToUpdateRequest) {
        this.findBookById(id)
                .map(bookRepository::updateBook);
        return bookRepository.updateBook(bookToUpdateRequest);
    }

    public Mono<Book> createBook(Book bookToCreate) {
        return bookRepository.createBook(bookToCreate);
    }

    public Mono<Boolean> deleteBookById(long id) {
        return this.findBookById(id)
                .flatMap(book ->  bookRepository.deleteBookById(book.getId())
                        .thenReturn(Boolean.TRUE))
                .defaultIfEmpty(Boolean.FALSE);
    }
}
