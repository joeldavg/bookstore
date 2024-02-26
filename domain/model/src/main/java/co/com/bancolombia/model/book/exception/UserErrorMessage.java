package co.com.bancolombia.model.book.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorMessage {

    BOOK_DATABASE_ERROR_MESSAGE("Error executing query in database"),
    BOOK_TITLE_ERROR_MESSAGE("Book title should not be null or empty"),
    BOOK_SUBTITLE_ERROR_MESSAGE("Book subtitle should not be null or empty"),
    BOOK_AUTHORS_ERROR_MESSAGE("Book authors should not be null or empty"),
    BOOK_PUBLISHER_ERROR_MESSAGE("Book publisher should not be null or empty"),
    BOOK_PAGES_ERROR_MESSAGE("Book pages should be greater or equal to 0"),
    BOOK_YEAR_ERROR_MESSAGE("Book year should be greater or equal to 0"),
    BOOK_RATING_ERROR_MESSAGE("Book rating should be between 1 and 5"),
    BOOK_DESCRIPTION_ERROR_MESSAGE("Book description should not be null or empty"),
    BOOK_DESCRIPTION_LENGTH_ERROR_MESSAGE("Book description length should be less or equal than 255"),
    BOOK_PRICE_ERROR_MESSAGE("Book price should be greater or equal to 0"),
    BOOK_IMAGE_ERROR_MESSAGE("Book image should not be null or empty"),
    BOOK_URL_ERROR_MESSAGE("Book url should not be null or empty");

    private final String errorMessage;

}
