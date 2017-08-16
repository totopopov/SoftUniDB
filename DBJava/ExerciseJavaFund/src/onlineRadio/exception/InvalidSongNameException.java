package onlineRadio.exception;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:49.
 */
public class InvalidSongNameException extends InvalidSongException {
    public InvalidSongNameException() {
        super("Song name should be between 3 and 30 symbols.");
    }
}
