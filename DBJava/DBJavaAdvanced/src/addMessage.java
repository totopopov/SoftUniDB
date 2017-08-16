import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by Todor Popov using Lenovo on 29.6.2017 г. at 19:53.
 */
public class addMessage {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commnets = Integer.parseInt(reader.readLine());

        String[]phrases= new String[]{"Excellent product.",
                "Such a great product.",
        "I always use that product.",
        "Best product of its category.",
        "Exceptional product.",
        "I can’t live without this product."};

        String[] events=new String[]{
                "Now I feel good.",
        "I have succeeded with this product.",
        "Makes miracles. I am happy of the results!",
        "I cannot believe but now I feel awesome.",
        "Try it yourself, I am very satisfied.",
        "I feel great!"
        };

        String[] authors=new String[]{
                "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = new String[]{
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
        };

        Random random = new Random();

        int phaseIndex = random.nextInt(phrases.length);
        int eventsIndex = random.nextInt(events.length);
        int authorIndex = random.nextInt(authors.length);
        int citiesIndex = random.nextInt(cities.length);

        for (int i = 0; i < commnets; i++) {

            System.out.println(String.format("%s %s %s - %s",
                    phrases[phaseIndex], events[eventsIndex], authors[authorIndex],cities[citiesIndex]));
        }

    }
}
