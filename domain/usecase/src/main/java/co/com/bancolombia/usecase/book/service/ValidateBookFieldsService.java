package co.com.bancolombia.usecase.book.service;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.exception.BookException;
import co.com.bancolombia.model.book.exception.UserErrorMessage;

public class ValidateBookFieldsService {

    public Book execute(Book book) {
        validateBookTitle(book);
        validateBookSubtitle(book);
        validateBookAuthors(book);
        validateBookPublisher(book);
        validateBookPages(book);
        validateBookYear(book);
        validateBookRating(book);
        validateBookDesc(book);
        validateBookPrice(book);
        validateBookImage(book);
        validateBookUrl(book);
        return book;
    }

    private void validateBookTitle(Book book) {
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_TITLE_ERROR_MESSAGE);
        }
    }

    private void validateBookSubtitle(Book book) {
        if (book.getSubtitle() == null || book.getSubtitle().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_SUBTITLE_ERROR_MESSAGE);
        }
    }

    private void validateBookAuthors(Book book) {
        if (book.getAuthors() == null || book.getAuthors().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_AUTHORS_ERROR_MESSAGE);
        }
    }

    private void validateBookPublisher(Book book) {
        if (book.getPublisher() == null || book.getPublisher().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_PUBLISHER_ERROR_MESSAGE);
        }
    }

    private void validateBookPages(Book book) {
        if (book.getPages() < 0) {
            throw new BookException(UserErrorMessage.BOOK_PAGES_ERROR_MESSAGE);
        }
    }

    private void validateBookYear(Book book) {
        if (book.getYear() < 0) {
            throw new BookException(UserErrorMessage.BOOK_YEAR_ERROR_MESSAGE);
        }
    }

    private void validateBookRating(Book book) {
        if (book.getRating() < 1 || book.getRating() > 5) {
            throw new BookException(UserErrorMessage.BOOK_RATING_ERROR_MESSAGE);
        }
    }

    private void validateBookDesc(Book book) {
        if (book.getDesc() == null || book.getDesc().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_DESCRIPTION_ERROR_MESSAGE);
        }
        if (book.getDesc().length() > 255) {
            throw new BookException(UserErrorMessage.BOOK_DESCRIPTION_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateBookPrice(Book book) {
        if (book.getPrice() < 0) {
            throw new BookException(UserErrorMessage.BOOK_PRICE_ERROR_MESSAGE);
        }
    }

    private void validateBookImage(Book book) {
        if (book.getImage() == null || book.getImage().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_IMAGE_ERROR_MESSAGE);
        }
    }

    private void validateBookUrl(Book book) {
        if (book.getUrl() == null || book.getUrl().isBlank()) {
            throw new BookException(UserErrorMessage.BOOK_URL_ERROR_MESSAGE);
        }
    }

}
