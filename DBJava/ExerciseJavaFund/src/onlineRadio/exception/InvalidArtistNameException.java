package onlineRadio.exception;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:47.
 */
public class InvalidArtistNameException extends InvalidSongException{
    public InvalidArtistNameException() {
        super("Artist name should be between 3 and 20 symbols.");
    }
}
