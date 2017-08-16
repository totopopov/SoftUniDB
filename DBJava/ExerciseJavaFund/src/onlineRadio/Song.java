package onlineRadio;

import jdk.nashorn.internal.ir.IfNode;
import onlineRadio.exception.*;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:44.
 */
public class Song implements SongAble {

    private String artist;
    private String name;
    private int duration;

    public Song(String artist,String name,  String durationMMSS) {
        this.setArtist(artist);
        this.setName(name);
        this.setDuration(durationMMSS);
    }

    private void setName(String name) {

        if(name.length()<3 || name.length()>30){
            throw new InvalidSongNameException();
        }

        this.name = name;
    }

    private void setArtist(String artist) {
        if(artist.length()<3 || artist.length()>20){
            throw new InvalidArtistNameException();
        }


        this.artist = artist;
    }

    private void setDuration(String duration) {


        String[] tokens=duration.split(":");

        int minutes=Integer.parseInt(tokens[0]);
        int seconds=Integer.parseInt(tokens[1]);

        if (minutes<0 || minutes>14){
            throw new InvalidSongMinutesException();
        }

        if (seconds<0 || seconds>59){
            throw new InvalidSongSecondsException();
        }

        this.duration = minutes*60+seconds;
    }

    @Override
    public int getDuration() {
        return this.duration;
    }
}
