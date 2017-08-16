package onlineRadio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 21:44.
 */
public class Radio {
    private List<SongAble> songs;

    public Radio() {
        this.songs = new ArrayList<>();
    }

    public String addSong(SongAble song){
        this.songs.add(song);
        return "Song added.";
    }

    public String getPlayListLenght(){

        int sum = this.songs.stream().mapToInt(SongAble::getDuration).sum();
        int hour=sum/(60*60);
        int mins=sum%(60*60)/60;
        int sec=sum%60;

        return String.format("Songs added: %d%nPlaylist length: %dh %dm %ds",this.songs.size(),hour,mins,sec);
    }
}
