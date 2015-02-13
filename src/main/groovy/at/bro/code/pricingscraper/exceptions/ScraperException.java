package at.bro.code.pricingscraper.exceptions;

public class ScraperException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ScraperException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScraperException(Throwable cause) {
        super(cause);
    }

}
