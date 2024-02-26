package co.com.bancolombia.usecase.book.service;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.exception.BookException;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ValidateBookFieldsServiceTest {

    @InjectMocks
    private ValidateBookFieldsService validateBookFieldsService;

    private Book newBookRequest;

    @BeforeEach
    void setUp() {
        newBookRequest = Book.builder().title("test").subtitle("test").authors("test")
                .publisher("test").pages(100).year(2024).rating((byte) 5).desc("test")
                .price(99).image("test").url("test").build();
    }

    @Test
    void shouldValidateFields() {
        assertEquals(newBookRequest.getTitle(), validateBookFieldsService.execute(newBookRequest).getTitle());
    }

    @Test
    void shouldValidateNullTitleException() {
        newBookRequest.setTitle(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptyTitleException() {
        newBookRequest.setTitle(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNullSubtitleException() {
        newBookRequest.setSubtitle(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptySubtitleException() {
        newBookRequest.setSubtitle(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNullAuthorsException() {
        newBookRequest.setAuthors(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptyAuthorsException() {
        newBookRequest.setAuthors(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNullPublisherException() {
        newBookRequest.setPublisher(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptyPublisherException() {
        newBookRequest.setPublisher(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNegativeValuePagesException() {
        newBookRequest.setPages(-1);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNegativeValueYearException() {
        newBookRequest.setYear(-1);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateLessThanOneValueRatingException() {
        newBookRequest.setRating((byte) 0);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateMoreThanFiveValueRatingException() {
        newBookRequest.setRating((byte) 6);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNullDescException() {
        newBookRequest.setDesc(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptyDescException() {
        newBookRequest.setDesc(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateLengthDescException() {
        newBookRequest.setDesc("test test test test test test test test test test test test test " +
                "test test test test test test test test test test test test test test test test " +
                "test test test test test test test test test test test test test test test test " +
                "test test test test test test test test test test test test test test test test " +
                "test test test test test test test test test test test test test test test test " +
                "test test test test test test test test test test test test test test test test");
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNegativeValuePriceException() {
        newBookRequest.setPrice(-1);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNullImageException() {
        newBookRequest.setImage(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptyImageException() {
        newBookRequest.setImage(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateNullUrlException() {
        newBookRequest.setUrl(null);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }

    @Test
    void shouldValidateEmptyUrlException() {
        newBookRequest.setUrl(Strings.EMPTY);
        assertThrows(BookException.class, () -> validateBookFieldsService.execute(newBookRequest));
    }
}