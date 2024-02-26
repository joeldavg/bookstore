package co.com.bancolombia.api.book.mapper;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.dto.request.BookUpdateRequest;
import co.com.bancolombia.api.book.dto.response.BookDetailResponse;
import co.com.bancolombia.api.book.dto.response.BookSearchByTitleResponse;
import co.com.bancolombia.model.book.Book;

public interface IBookMapper {

    BookDetailResponse toBookDetailResponse(Book domain);
    BookSearchByTitleResponse toBookSearchByTitleResponse(Book domain);
    Book toBookDomain(BookCreateRequest bookCreateRequest);
    Book toBookDomain(BookUpdateRequest bookUpdateRequest);

}
