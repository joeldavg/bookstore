package co.com.bancolombia.api.book.mapper;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.dto.response.BookSearchByIdResponse;
import co.com.bancolombia.api.book.dto.response.BookSearchByTitleReponse;
import co.com.bancolombia.model.book.Book;

public interface IBookMapper {

    BookSearchByIdResponse toBookSearchByIdResponse(Book domain);
    BookSearchByTitleReponse toBookSearchByTitleReponse(Book domain);
    Book toBookDomain(BookCreateRequest bookCreateRequest);

}
