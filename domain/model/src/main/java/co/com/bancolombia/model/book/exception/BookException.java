package co.com.bancolombia.model.book.exception;

public class BookException extends RuntimeException {

    public BookException(String message) {
        super(message);
    }

    public BookException(UserErrorMessage userErrorMessage) {
        super(userErrorMessage.getErrorMessage());
    }

}
