package co.com.bancolombia.api.book.mapper.impl;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.dto.response.BookSearchByIdResponse;
import co.com.bancolombia.api.book.dto.response.BookSearchByTitleReponse;
import co.com.bancolombia.api.book.mapper.IBookMapper;
import co.com.bancolombia.model.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements IBookMapper {

    @Override
    public BookSearchByIdResponse toBookSearchByIdResponse(Book domain) {
        return new BookSearchByIdResponse(domain.getId(), domain.getTitle(), domain.getSubtitle(),
                domain.getAuthors(), domain.getPublisher(), domain.getPages(), domain.getYear(),
                domain.getRating(), domain.getDesc(), domain.getPrice(), domain.getImage(), domain.getUrl());
    }

    @Override
    public BookSearchByTitleReponse toBookSearchByTitleReponse(Book domain) {
        return new BookSearchByTitleReponse(domain.getId(), domain.getTitle(), domain.getSubtitle(),
                domain.getPrice(), domain.getImage(), domain.getUrl());
    }

    @Override
    public Book toBookDomain(BookCreateRequest bookCreateRequest) {
        return Book.builder()
                .title(bookCreateRequest.title())
                .subtitle(bookCreateRequest.subtitle())
                .authors(bookCreateRequest.authors())
                .publisher(bookCreateRequest.publisher())
                .pages(bookCreateRequest.pages())
                .year(bookCreateRequest.year())
                .rating(bookCreateRequest.rating())
                .desc(bookCreateRequest.desc())
                .price(bookCreateRequest.price())
                .image(bookCreateRequest.image())
                .url(bookCreateRequest.url())
                .build();
    }

}
