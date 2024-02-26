package co.com.bancolombia.api.book.rest;

import co.com.bancolombia.api.book.dto.response.BookSearchByTitleResponse;
import co.com.bancolombia.api.book.mapper.IBookMapper;
import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.usecase.book.BookUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookHandlerTest {

    @InjectMocks
    private BookHandler bookHandler;
    @Mock
    private BookUseCase bookUseCase;
    @Mock
    private IBookMapper mapper;
    @Mock
    private ServerRequest request;
    private Book bookDomain;
    private BookSearchByTitleResponse bookSearchByTitleResponse;

    @BeforeEach
    void setUp() {
        bookDomain = Book.builder().id(1l).title("test").subtitle("test")
                .authors("test").publisher("test").pages(100).year(2024).rating((byte) 5)
                .desc("test").price(99).image("test").url("test").build();
        bookSearchByTitleResponse = new BookSearchByTitleResponse(1l, "test", "test",
                99f, "test", "test");
    }

    @Test
    void listenGETFindBooksContainingTitleSuccessTest() {
        when(bookUseCase.findBooksContainingTitle(anyString()))
                .thenReturn(Flux.just(bookDomain));
        when(mapper.toBookSearchByTitleResponse(any(Book.class)))
                .thenReturn(bookSearchByTitleResponse);
        when(request.queryParam("title")).thenReturn(Optional.of("test"));

        StepVerifier.create(bookHandler.listenGETFindBooksContainingTitle(request))
                .expectNextMatches(serverResponse -> serverResponse.statusCode().is2xxSuccessful())
                .expectComplete()
                .verify();
    }

    @Test
    void listenGETFindBooksContainingTitleNotFoundTest() {
        when(bookUseCase.findBooksContainingTitle(anyString()))
                .thenReturn(Flux.fromIterable(Collections.emptyList()));
        when(request.queryParam("title")).thenReturn(Optional.of("test"));

        StepVerifier.create(bookHandler.listenGETFindBooksContainingTitle(request))
                .expectNextMatches(serverResponse -> serverResponse.statusCode().is4xxClientError())
                .expectComplete()
                .verify();
    }

    @Test
    void listenGETFindBooksContainingTitleNotParamQueryTest() {
        StepVerifier.create(bookHandler.listenGETFindBooksContainingTitle(request))
                .expectNextMatches(serverResponse -> serverResponse.statusCode().is4xxClientError())
                .verifyComplete();
    }
}