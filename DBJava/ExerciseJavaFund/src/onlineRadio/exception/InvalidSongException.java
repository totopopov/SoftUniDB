package onlineRadio.exception;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:45.
 */
public class InvalidSongException extends RuntimeException {
    public InvalidSongException(String message) {
        super(message);
    }
}
