package co.com.bancolombia.r2dbc.helper;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.r2dbc.book.adapter.BookReactiveRepositoryAdapter;
import co.com.bancolombia.r2dbc.book.entity.BookEntity;
import co.com.bancolombia.r2dbc.book.repository.BookReactiveRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.utils.ObjectMapper;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReactiveAdapterOperationsTest {

    @InjectMocks
    private BookReactiveRepositoryAdapter repositoryAdapter;

    @Mock
    BookReactiveRepository repository;

    @Mock
    ObjectMapper mapper;

  /*  @Test
    void mustFindValueById() {

        when(repository.findById(1l)).thenReturn(Mono.just(new BookEntity()));
        when(mapper.map("test", Object.class)).thenReturn("test");

        Mono<Book> result = repositoryAdapter.findById(1l);

        StepVerifier.create(result)
                .expectNextMatches(value -> value.equals("test"))
                .verifyComplete();
    }

    @Test
    void mustSaveValue() {
        when(repository.save("test")).thenReturn(Mono.just("test"));
        when(mapper.map("test", Object.class)).thenReturn("test");

        Mono<Object> result = repositoryAdapter.save("test");

        StepVerifier.create(result)
                .expectNextMatches(value -> value.equals("test"))
                .verifyComplete();
    }*/

}