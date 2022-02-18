package exception;

public class NewsApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewsApiException()
    {
    }

    public NewsApiException(String message)
    {
        super(message);
    }

    public NewsApiException(Throwable cause)
    {
        super(cause);
    }

    public NewsApiException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NewsApiException(String message, Throwable cause, 
                                       boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
