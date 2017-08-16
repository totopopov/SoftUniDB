import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class countDays {
    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat dfShort = new SimpleDateFormat("dd-MM");
        Date date1 = df.parse(reader.readLine());

        Date date2 = df.parse(reader.readLine());
        Calendar calendar = Calendar.getInstance();

        List<String> holidays = Arrays.asList(
                ("01-01"),
                ("03-03"),
                ("01-05"),
                ("06-05"),
                ("24-05"),
                ("06-09"),
                ("22-09"),
                ("01-11"),
                ("24-12"),
                ("25-12"),
                ("26-12"));

        int days = 0;

        for (Date date = date1; date.compareTo(date2) <= 0; date = new Date(date.getTime() + TimeUnit.DAYS.toMillis(1))) {
            calendar.setTime(date);
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                continue;
            }
            String dateStrong = dfShort.format(date);

            if (holidays.contains(dateStrong)) {
                continue;
            }
            days++;
        }

        System.out.println(days);
    }
}
