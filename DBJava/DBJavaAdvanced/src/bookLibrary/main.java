package bookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Library library= new Library("Alexanria");

        int books = Integer.parseInt(reader.readLine());

        for (int i = 0; i < books; i++) {
           String[] bookarguments= reader.readLine().split("\\s");

           Book book= new Book(bookarguments[0],bookarguments[1],bookarguments[2],
                   bookarguments[3],bookarguments[4],Double.parseDouble(bookarguments[5]));

           library.addbook(book);
        }

        library.tsbpba();
    }
}
