package exams.myexercise.model;

public class Product {
    private String name;
    private double price;
    private boolean groceries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isGroceries() {
        return groceries;
    }

    public void setGroceries(boolean groceries) {
        this.groceries = groceries;
    }
}
