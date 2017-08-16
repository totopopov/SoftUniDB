import java.util.Scanner;

/**
 * Created by Todor Popov using Lenovo on 9.7.2017 г. at 17:23.
 */
public class URL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input=scanner.nextLine();
        String protocol=input.substring(0,input.indexOf("://"));
        String serverInit=input.substring(input.indexOf("://")+3);
        String server=input.substring(0,serverInit.lastIndexOf("/"));

        String resource=input.substring(serverInit.lastIndexOf("/")+1);

        System.out.println("[protocol] = "+protocol);
        System.out.println("[server] = "+server);
        System.out.println("[resource] = "+resource);



    }
}
