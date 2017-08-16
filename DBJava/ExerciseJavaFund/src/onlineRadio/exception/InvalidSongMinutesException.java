package onlineRadio.exception;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:50.
 */
public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException() {
        super("Song minutes should be between 0 and 14.");
    }
}
