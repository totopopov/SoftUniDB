package reverse_number;


public class Number {

    private String number;

    public Number(String number) {
        this.number = number;
    }

    public String ReverseNumber() {

        StringBuilder sb = new StringBuilder(this.number);
        return sb.reverse().toString();

    }
}
