package co.com.bancolombia.api.book.mapper.impl;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.dto.request.BookUpdateRequest;
import co.com.bancolombia.api.book.dto.response.BookDetailResponse;
import co.com.bancolombia.api.book.dto.response.BookSearchByTitleResponse;
import co.com.bancolombia.api.book.mapper.IBookMapper;
import co.com.bancolombia.model.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements IBookMapper {

    @Override
    public BookDetailResponse toBookDetailResponse(Book domain) {
        return new BookDetailResponse(domain.getId(), domain.getTitle(), domain.getSubtitle(),
                domain.getAuthors(), domain.getPublisher(), domain.getPages(), domain.getYear(),
                domain.getRating(), domain.getDesc(), domain.getPrice(), domain.getImage(), domain.getUrl());
    }

    @Override
    public BookSearchByTitleResponse toBookSearchByTitleResponse(Book domain) {
        return new BookSearchByTitleResponse(domain.getId(), domain.getTitle(), domain.getSubtitle(),
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

    @Override
    public Book toBookDomain(BookUpdateRequest bookUpdateRequest) {
        return Book.builder()
                .title(bookUpdateRequest.title())
                .subtitle(bookUpdateRequest.subtitle())
                .authors(bookUpdateRequest.authors())
                .publisher(bookUpdateRequest.publisher())
                .pages(bookUpdateRequest.pages())
                .year(bookUpdateRequest.year())
                .rating(bookUpdateRequest.rating())
                .desc(bookUpdateRequest.desc())
                .price(bookUpdateRequest.price())
                .image(bookUpdateRequest.image())
                .url(bookUpdateRequest.url())
                .build();
    }

}
