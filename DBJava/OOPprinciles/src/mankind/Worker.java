package mankind;

/**
 * Created by Todor Popov using Lenovo on 4.7.2017 г. at 21:25.
 */
public class Worker extends Human {
    private double workersSalary;
    private double workingHours;

    public Worker(String firstName, String lastName,double workersSalary, double workingHours) {
        super(firstName, lastName);
        this.setWorkersSalary(workersSalary);
        this.setWorkingHours(workingHours);
    }


    private void setWorkersSalary(double workersSalary) {
        if (workersSalary<=10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.workersSalary = workersSalary;
    }

    private void setWorkingHours(double workingHours) {
        if (workingHours<1 || workingHours>12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    public double getWorkersSalary() {
        return workersSalary;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public double getMoneyPerHour(){
        return this.getWorkersSalary()/(this.getWorkingHours()*7);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Week Salary: %.2f",this.getWorkersSalary())).append(System.lineSeparator());
        sb.append(String.format("Hours per day: %.2f",this.getWorkingHours())).append(System.lineSeparator());
        sb.append(String.format("Salary per hour: %.2f",this.getMoneyPerHour())).append(System.lineSeparator());

        return sb.toString();
    }
}
