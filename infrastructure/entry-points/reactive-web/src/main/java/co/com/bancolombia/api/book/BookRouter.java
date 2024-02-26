package co.com.bancolombia.api.book;

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
                .path("/api/bookstore", builder -> builder
                        .GET("/search/books/", accept(APPLICATION_JSON), handler::listenGETFindBooksContainingTitle)
                        .GET("/search/book/{id}", accept(APPLICATION_JSON), handler::listenGETFindBookById)
                        .PUT("/update/book/{id}", accept(APPLICATION_JSON), handler::listenPUTUpdateBook)
                        .POST("/save/book", accept(APPLICATION_JSON), handler::listenPOSTCreateBook)
                        .DELETE("/delete/book/{id}", accept(APPLICATION_JSON), handler::listenDELETEDeleteBookById))
                .build();
    }
}
