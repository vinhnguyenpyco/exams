package exams.myexercise.questionthree;

import exams.myexercise.model.Bill;
import exams.myexercise.model.Product;

import java.util.List;

public interface RuleDiscount {
    double calculateDiscount(Bill bill);

    default double calculateTotalPrice(List<Product> lstProduct){
        double total = 0;
        for(Product product : lstProduct){
            total += product.getPrice();
        }
        return total;
    }
}
