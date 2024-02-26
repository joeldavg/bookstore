package co.com.bancolombia.r2dbc.book.adapter;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.r2dbc.book.entity.BookEntity;
import co.com.bancolombia.r2dbc.book.repository.BookReactiveRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.utils.ObjectMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookReactiveRepositoryAdapterTest {

    @InjectMocks
    private BookReactiveRepositoryAdapter adapter;
    @Mock
    private BookReactiveRepository repository;
    @Mock
    private ObjectMapper mapper;

    private BookEntity bookDD;
    private Book bookDomain;
    private BookEntity bookDDRequest;
    private Book bookDomainRequest;

    @BeforeEach
    void setUp() {
        bookDD = BookEntity.builder().id(1l).title("test").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
        bookDomain = Book.builder().id(1l).title("test").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
        bookDDRequest = BookEntity.builder().title("test").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
        bookDomainRequest = Book.builder().title("test").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
    }

    @Test
    void shouldFindBooksContainingTitleSuccessTest() {
        when(repository.findByTitleContainingIgnoreCase(any(String.class))).thenReturn(Flux.just(bookDD));
        when(mapper.map(any(BookEntity.class), any())).thenReturn(bookDomain);
        StepVerifier.create(adapter.findBooksContainingTitle("title"))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void shouldFindABookDetailByIdSuccessTest() {
        when(repository.findById(any(Long.class))).thenReturn(Mono.just(bookDD));
        when(mapper.map(any(BookEntity.class), any())).thenReturn(bookDomain);
        StepVerifier.create(adapter.findBookById(1))
                .expectNextMatches(book -> book.getId().equals(bookDD.getId()))
                .verifyComplete();
    }

    @Test
    void shouldUpdateABookSuccessTest() {
        when(mapper.map(any(Book.class), any())).thenReturn(bookDDRequest);
        when(repository.save(any(BookEntity.class))).thenReturn(Mono.just(bookDD));
        when(mapper.map(any(BookEntity.class), any())).thenReturn(bookDomain);
        StepVerifier.create(adapter.updateBook(bookDomainRequest))
                .expectNextMatches(book -> book.getId().equals(bookDomain.getId()))
                .verifyComplete();
    }

    @Test
    void shouldCreateABookSuccessTest() {
        when(mapper.map(any(Book.class), any())).thenReturn(bookDDRequest);
        when(repository.save(any(BookEntity.class))).thenReturn(Mono.just(bookDD));
        when(mapper.map(any(BookEntity.class), any())).thenReturn(bookDomain);
        StepVerifier.create(adapter.createBook(bookDomainRequest))
                .expectNextMatches(book -> book.getId().equals(bookDomain.getId()))
                .verifyComplete();
    }


    @Test
    void shouldDeleteABookSuccessTest() {
        when(repository.deleteById(any(Long.class))).thenReturn(Mono.empty());
        StepVerifier.create(adapter.deleteBookById(1l))
                .expectNext()
                .verifyComplete();
    }

}