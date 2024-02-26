package co.com.bancolombia.api.book.rest;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.dto.request.BookUpdateRequest;
import co.com.bancolombia.api.book.dto.response.ErrorResponse;
import co.com.bancolombia.api.book.mapper.IBookMapper;
import co.com.bancolombia.model.book.exception.BookException;
import co.com.bancolombia.usecase.book.BookUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static co.com.bancolombia.api.book.rest.PathConstants.*;

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
        var id = Long.parseLong(idString);
        return bookUseCase.findBookById(id)
                .map(mapper::toBookDetailResponse)
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
                .map(mapper::toBookSearchByTitleResponse)
                .collectList()
                .flatMap(books -> {
                    if (books.isEmpty()) {
                        return ServerResponse.notFound().build();
                    }
                    return ServerResponse.ok().bodyValue(books);
                });
    }

    public Mono<ServerResponse> listenPUTUpdateBook(ServerRequest serverRequest) {
        var idString = serverRequest.pathVariable("id");
        if (!idString.matches("^[0-9]+$")) {
            return ServerResponse.badRequest().build();
        }
        var id = Long.parseLong(idString);
        return serverRequest.bodyToMono(BookUpdateRequest.class)
                .map(mapper::toBookDomain)
                .flatMap(book -> bookUseCase.updateBook(id, book))
                .map(mapper::toBookDetailResponse)
                .flatMap(ServerResponse.ok()::bodyValue)
                .switchIfEmpty(ServerResponse.notFound().build())
                .onErrorResume(BookException.class, error -> ServerResponse.badRequest()
                        .bodyValue(new ErrorResponse(error.getMessage())));
    }

    public Mono<ServerResponse> listenPOSTCreateBook(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(BookCreateRequest.class)
                .map(mapper::toBookDomain)
                .flatMap(bookUseCase::createBook)
                .map(mapper::toBookDetailResponse)
                .flatMap(bookCreated -> ServerResponse
                        .created(URI.create(String.format(SEARCH_BOOK_CREATED_PATH, bookCreated.id())))
                        .bodyValue(bookCreated))
                .onErrorResume(BookException.class, error -> ServerResponse.badRequest()
                        .bodyValue(new ErrorResponse(error.getMessage())));
    }

    public Mono<ServerResponse> listenDELETEDeleteBookById(ServerRequest serverRequest) {
        var idString = serverRequest.pathVariable("id");
        if (!idString.matches("^[0-9]+$")) {
            return ServerResponse.badRequest().build();
        }
        var id = Long.parseLong(idString);
        return bookUseCase.deleteBookById(id)
                .flatMap(value -> {
                    if (value) {
                        return ServerResponse.noContent().build();
                    }
                    return ServerResponse.notFound().build();
                });
    }

}
