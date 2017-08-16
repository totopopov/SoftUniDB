package shopping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;


    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {

            if (name.equals(null) || name.equals("") || name.trim().isEmpty()){
                throw new IllegalStateException("Name cannot be empty");
            }
            this.name = name;

    }

    private void setMoney(double money) {

            if (money<0){
                throw new IllegalStateException("Money cannot be negative");
            }
            this.money = money;

    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public String buyProduct(Product product){
        if (this.getMoney()>=product.getCost()){
            this.setMoney(this.getMoney()-product.getCost());
            this.bagOfProducts.add(product);
            return String.format("%s bought %s", this.name, product.getName());
        }else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }

    }

    @Override
    public String toString() {
        if (this.bagOfProducts.isEmpty()){
            return String.format("%s - Nothing bought",this.name);
        }else {
            return  String.format("%s - %s", this.name, this.bagOfProducts.stream().map(Product::getName).
                    collect(Collectors.joining(", ")));
        }
    }
}
