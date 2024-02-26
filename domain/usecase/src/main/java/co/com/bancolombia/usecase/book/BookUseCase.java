package co.com.bancolombia.usecase.book;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.BookRepository;
import co.com.bancolombia.usecase.book.service.ValidateBookFieldsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BookUseCase {

    private final BookRepository bookRepository;
    private final ValidateBookFieldsService validateBookFieldsService;

    public Flux<Book> findBooksContainingTitle(String title) {
        return bookRepository.findBooksContainingTitle(title);
    }

    public Mono<Book> findBookById(long id) {
        return bookRepository.findBookById(id);
    }

    public Mono<Book> updateBook(long id, Book bookToUpdate) {
        return this.findBookById(id)
                .map(book -> {
                    validateBookFieldsService.execute(bookToUpdate);
                    book.setTitle(bookToUpdate.getTitle());
                    book.setSubtitle(bookToUpdate.getSubtitle());
                    book.setAuthors(bookToUpdate.getAuthors());
                    book.setPublisher(bookToUpdate.getPublisher());
                    book.setPages(bookToUpdate.getPages());
                    book.setYear(bookToUpdate.getYear());
                    book.setRating(bookToUpdate.getRating());
                    book.setDesc(bookToUpdate.getDesc());
                    book.setPrice(bookToUpdate.getPrice());
                    book.setImage(bookToUpdate.getImage());
                    book.setUrl(bookToUpdate.getUrl());
                    return book;
                })
                .flatMap(bookRepository::updateBook);
    }

    public Mono<Book> createBook(Book bookToCreate) {
        return Mono.just(validateBookFieldsService.execute(bookToCreate))
                .flatMap(bookRepository::createBook);
    }

    public Mono<Boolean> deleteBookById(long id) {
        return this.findBookById(id)
                .flatMap(book -> bookRepository.deleteBookById(book.getId())
                        .thenReturn(Boolean.TRUE))
                .defaultIfEmpty(Boolean.FALSE);
    }
}
