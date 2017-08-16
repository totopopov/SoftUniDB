package telephony;

public class Phone implements Calling,Browsing {

    @Override
    public String Call(String number) {

        for (int i = 0; i < number.length(); i++) {
          if (Character.isDigit(number.charAt(i))){
              continue;
          }
            return "Invalid number!";
        }
        return "Calling... "+number;
    }

    @Override
    public String Browse(String URL) {

        for (int i = 0; i < URL.length(); i++) {
            if (Character.isDigit(URL.charAt(i))){
                return "Invalid URL!";
            }
        }
        return "Browsing: "+URL+"!";
    }
}
