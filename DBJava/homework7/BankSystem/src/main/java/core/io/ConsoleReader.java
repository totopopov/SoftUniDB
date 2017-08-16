package core.io;

import interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Todor Popov using Lenovo on 23.4.2017 г. at 16:09.
 */
public class ConsoleReader implements InputReader {
    private BufferedReader bufferedReader;

    public ConsoleReader() {
        this.bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        try {
            return this.bufferedReader.readLine();
        } catch (IOException e) {
            e.getCause();
        }
        return null;
    }
}
