package exams.myexercise.questionthree;

import exams.myexercise.model.Bill;

public class Checkout {

    public double calculateFinal(Bill bill){
        RuleDiscount percentDiscount = new PercentDiscount();
        RuleDiscount amountDiscount = new AmountDiscount();

        double total;

        double totalWithPercentDiscount = percentDiscount.calculateDiscount(bill);
        total = totalWithPercentDiscount - amountDiscount.calculateDiscount(bill);

        return total;
    }
}
