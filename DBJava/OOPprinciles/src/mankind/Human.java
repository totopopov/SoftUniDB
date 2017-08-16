package mankind;



public class Human {
    private String firstName;
    private String LastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length()<4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }

        if (lastName.length()<3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }

        LastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("First Name: %s",this.getFirstName())).append(System.lineSeparator());
        sb.append(String.format("Last Name: %s",this.getLastName()));
        return sb.toString();
    }

}
