package co.com.bancolombia.api.book.mapper.impl;

import co.com.bancolombia.api.book.dto.request.BookCreateRequest;
import co.com.bancolombia.api.book.dto.request.BookUpdateRequest;
import co.com.bancolombia.api.book.dto.response.BookDetailResponse;
import co.com.bancolombia.api.book.dto.response.BookSearchByTitleResponse;
import co.com.bancolombia.model.book.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BookMapperImplTest {

    @InjectMocks
    private BookMapperImpl bookMapper;
    private Book bookDomain;

    @BeforeEach
    void setUp() {
        bookDomain = new Book(1l, "test", "test", "test"
                , "test", 99, 2024, (byte) 5, "test", 99f, "test", "test");
    }

    @Test
    void shouldMapToBookDetailResponse() {
        var expected = new BookDetailResponse(1l, "test", "test", "test"
                , "test", 99, 2024, (byte) 5, "test", 99f, "test", "test");
        var actual = bookMapper.toBookDetailResponse(bookDomain);
        assertEquals(expected, actual);
    }

    @Test
    void shouldMapToBookSearchByTitleResponse() {
        var expected = new BookSearchByTitleResponse(1l, "test", "test",
                99f, "test", "test");
        var actual = bookMapper.toBookSearchByTitleResponse(bookDomain);
        assertEquals(expected, actual);
    }

    @Test
    void shouldMapToBookDomainFromBookCreateRequest() {
        bookDomain.setId(null);
        var bookCreateRequest = new BookCreateRequest("test", "test", "test"
                , "test", 99, 2024, (byte) 5, "test", 99f, "test", "test");
        var actual = bookMapper.toBookDomain(bookCreateRequest);

        assertEquals(bookDomain, actual);
    }

    @Test
    void shouldMapToBookDomainFromBookUpdateRequest() {
        bookDomain.setId(null);
        var bookUpdateRequest = new BookUpdateRequest("test", "test", "test"
                , "test", 99, 2024, (byte) 5, "test", 99f, "test", "test");
        var actual = bookMapper.toBookDomain(bookUpdateRequest);

        assertEquals(bookDomain, actual);
    }
}