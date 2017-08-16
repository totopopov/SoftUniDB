package shopping;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {

            if (name.equals(null) || name.equals("") || name.trim().isEmpty()){
                throw new IllegalStateException("Name cannot be empty");
            }
            this.name = name;
    }

    private void setCost(double cost) {

            if (cost<0){
                throw new IllegalStateException("Money cannot be negative");
            }
            this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
