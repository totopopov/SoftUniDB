package mankind;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 21:17.
 */
public class Student extends Human {
    private String number;


    public Student(String firstName, String lastName,String number) {
        super(firstName, lastName);
        this.setNumber(number);
    }

    private void setNumber(String number) {
        if (number.length()>10 || number.length()<5){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Faculty number: %s",this.getNumber())).append(System.lineSeparator());
        return sb.toString();
    }
}
