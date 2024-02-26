package co.com.bancolombia.usecase.book;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.BookRepository;
import co.com.bancolombia.usecase.book.service.ValidateBookFieldsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookUseCaseTest {

    @InjectMocks
    private BookUseCase bookUseCase;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private ValidateBookFieldsService validateBookFieldsService;

    private Book bookDD;
    private Book newBookRequest;
    private Book newBookResponse;

    @BeforeEach
    void setUp() {
        bookDD = Book.builder().id(1l).title("test").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
        newBookRequest = Book.builder().title("test new").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
        newBookResponse = Book.builder().id(1l).title("test new").subtitle("test")
                .authors("test").publisher("test").pages(100).year(2024).rating((byte) 5)
                .desc("test").price(99).image("test").url("test").build();
    }

    @Test
    void shouldFindABookDetailByIdSuccessTest() {
        when(bookRepository.findBookById(any(Long.class))).thenReturn(Mono.just(bookDD));
        StepVerifier.create(bookUseCase.findBookById(1))
                .expectNextMatches(book -> book.getTitle().equals(bookDD.getTitle()))
                .verifyComplete();
    }

    @Test
    void shouldFindBooksContainingTitleSuccessTest() {
        when(bookRepository.findBooksContainingTitle(any(String.class))).thenReturn(Flux.just(bookDD));
        StepVerifier.create(bookUseCase.findBooksContainingTitle("title"))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void shouldUpdateABookSuccessTest() {
        when(validateBookFieldsService.execute(any(Book.class))).thenReturn(newBookRequest);
        when(bookRepository.findBookById(any(Long.class))).thenReturn(Mono.just(bookDD));
        when(bookRepository.updateBook(any(Book.class))).thenReturn(Mono.just(newBookResponse));
        StepVerifier.create(bookUseCase.updateBook(1l, newBookRequest))
                .expectNextMatches(book -> book.getTitle().equals(newBookResponse.getTitle()))
                .verifyComplete();
    }

    @Test
    void shouldCreateABookSuccessTest() {
        when(validateBookFieldsService.execute(any(Book.class))).thenReturn(newBookRequest);
        when(bookRepository.createBook(any(Book.class))).thenReturn(Mono.just(newBookResponse));
        StepVerifier.create(bookUseCase.createBook(newBookRequest))
                .expectNextMatches(book -> book.getId().equals(newBookResponse.getId()))
                .verifyComplete();
    }

    @Test
    void shouldDeleteABookSuccessTrueTest() {
        when(bookRepository.findBookById(any(Long.class))).thenReturn(Mono.just(bookDD));
        when(bookRepository.deleteBookById(any(Long.class))).thenReturn(Mono.empty());
        StepVerifier.create(bookUseCase.deleteBookById(1l))
                .expectNextMatches(deleted -> deleted.equals(Boolean.TRUE))
                .verifyComplete();
    }

    @Test
    void shouldDeleteABookNotSuccessFalseTest() {
        when(bookRepository.findBookById(any(Long.class))).thenReturn(Mono.empty());
        StepVerifier.create(bookUseCase.deleteBookById(1l))
                .expectNextMatches(deleted -> deleted.equals(Boolean.FALSE))
                .verifyComplete();
    }

}