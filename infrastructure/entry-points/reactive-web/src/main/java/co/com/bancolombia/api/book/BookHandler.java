package co.com.bancolombia.api.book;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.mapper.IBookMapper;
import co.com.bancolombia.usecase.book.BookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class BookHandler {

    private final BookUseCase bookUseCase;
    private final IBookMapper mapper;

    public Mono<ServerResponse> listenGETFindBookById(ServerRequest serverRequest) {
        var idString = serverRequest.pathVariable("id");
        if (!idString.matches("^[0-9]+$")) {
            return ServerResponse.badRequest().build();
        }
        var bookId = Long.parseLong(idString);
        return bookUseCase.findBookById(bookId)
                .map(mapper::toBookSearchByIdResponse)
                .flatMap(ServerResponse.ok()::bodyValue)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> listenGETFindBooksContainingTitle(ServerRequest serverRequest) {
        var titleOptional = serverRequest.queryParam("title");
        if (titleOptional.isEmpty()) {
            return ServerResponse.badRequest().build();
        }
        var title = titleOptional.get();
        return bookUseCase.findBooksContainingTitle(title)
                .map(mapper::toBookSearchByTitleReponse)
                .collectList()
                .flatMap(books -> {
                    if (books.isEmpty()) {
                        return ServerResponse.notFound().build();
                    }
                    return ServerResponse.ok().bodyValue(books);
                });
    }

    public Mono<ServerResponse> listenPOSTCreateBook(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(BookCreateRequest.class)
                .map(mapper::toBookDomain)
                .flatMap(bookUseCase::createBook)
                .map(mapper::toBookSearchByIdResponse)
                .flatMap(ServerResponse.created(URI.create(""))::bodyValue);
    }

    public Mono<ServerResponse> listenDELETEDeleteBookById(ServerRequest serverRequest) {
        var idString = serverRequest.pathVariable("id");
        if (!idString.matches("^[0-9]+$")) {
            return ServerResponse.badRequest().build();
        }
        var bookId = Long.parseLong(idString);
        return bookUseCase.deleteBookById(bookId)
                .flatMap(value -> {
                    if (value) {
                        return ServerResponse.noContent().build();
                    }
                    return ServerResponse.notFound().build();
                });
    }

    public Mono<ServerResponse> listenGETFindAllBooks(ServerRequest serverRequest) {
        return bookUseCase.findAllBooks()
                .map(mapper::toBookSearchByIdResponse)
                .collectList()
                .flatMap(ServerResponse.ok()::bodyValue);
    }
}
