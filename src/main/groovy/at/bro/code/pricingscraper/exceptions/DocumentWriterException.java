package at.bro.code.pricingscraper.exceptions;

public class DocumentWriterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DocumentWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentWriterException(Throwable cause) {
        super(cause);
    }

}
