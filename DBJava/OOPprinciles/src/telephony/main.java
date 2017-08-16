package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 19:06.
 */
public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Calling phoneCall=new Phone();
        Browsing phoneBrowse=new Phone();

        String[] phones= Arrays.stream(reader.readLine().split("\\s+")).toArray(String[]::new);
        String[] URLs= Arrays.stream(reader.readLine().split("\\s+")).toArray(String[]::new);


//        if (phones.length==0){
//            System.out.println("Calling... ");
//        }

        for (String phone : phones) {
            System.out.println(phoneCall.Call(phone));
        }

//        if (phones.length==0){
//            System.out.println("Browsing: !");
//        }


        for (String url : URLs) {
            System.out.println(phoneBrowse.Browse(url));
        }

    }
}
