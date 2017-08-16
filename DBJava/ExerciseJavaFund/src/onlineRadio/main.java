package onlineRadio;

import onlineRadio.exception.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Todor Popov using Lenovo on 7.7.2017 г. at 18:34.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int songs=Integer.parseInt(reader.readLine());

        Radio radio= new Radio();

        for (int i = 0; i < songs; i++) {


          try {
              String[] songArguments=  reader.readLine().split(";");

              if (songArguments.length==0 || songArguments.length!=3 ){
                  throw new InvalidSongException("Invalid song.");
              }

              SongAble song=new Song(songArguments[0],songArguments[1],songArguments[2]);
              System.out.println(radio.addSong(song));
          }catch (InvalidSongException ise){
              System.out.println(ise.getMessage());
          }catch (NumberFormatException nfe){
              System.out.println("Invalid song length.");
          }

        }

        System.out.println(radio.getPlayListLenght());


    }
}
