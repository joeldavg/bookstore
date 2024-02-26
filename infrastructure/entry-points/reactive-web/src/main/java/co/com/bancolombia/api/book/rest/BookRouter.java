package co.com.bancolombia.api.book.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(BookHandler handler) {
        return route()
                .path(PathConstants.BOOKSTORE_PATH, builder -> builder
                        .GET(PathConstants.SEARCH_BOOKS_CONTAINING_TITLE_PATH, accept(APPLICATION_JSON), handler::listenGETFindBooksContainingTitle)
                        .GET(PathConstants.SEARCH_BOOK_BY_ID_PATH, accept(APPLICATION_JSON), handler::listenGETFindBookById)
                        .PUT(PathConstants.UPDATE_BOOK_BY_ID_PATH, accept(APPLICATION_JSON), handler::listenPUTUpdateBook)
                        .POST(PathConstants.CREATE_BOOK_PATH, accept(APPLICATION_JSON), handler::listenPOSTCreateBook)
                        .DELETE(PathConstants.DELETE_BOOK_BY_ID_PATH, accept(APPLICATION_JSON), handler::listenDELETEDeleteBookById))
                .build();
    }
}
