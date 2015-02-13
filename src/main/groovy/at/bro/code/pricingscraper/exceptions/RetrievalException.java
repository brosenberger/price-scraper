package at.bro.code.pricingscraper.exceptions;

public class RetrievalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public RetrievalException(Throwable cause) {
        super(cause);
    }

}
