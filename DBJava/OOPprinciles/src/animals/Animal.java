package animals;

/**
 * Created by Todor Popov using Lenovo on 6.7.2017 г. at 19:21.
 */
public abstract class Animal implements Beast{
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    protected String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.equals(null) || name.isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    protected int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age<0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    protected String getGender() {
        return this.gender;
    }

    private void setGender(String gender) {
        if (gender.equals("Female") || gender.equals("Male")){
            this.gender = gender;
        }else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    @Override
    public String makeSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %s %s",this.getClass().getSimpleName(),this.getName(),this.getAge(),this.getGender());
    }
}
