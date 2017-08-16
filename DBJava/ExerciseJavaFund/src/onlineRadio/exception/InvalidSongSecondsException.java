package onlineRadio.exception;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:50.
 */
public class InvalidSongSecondsException extends InvalidSongLengthException {
        public InvalidSongSecondsException() {
        super("Song seconds should be between 0 and 59.");
    }
}
