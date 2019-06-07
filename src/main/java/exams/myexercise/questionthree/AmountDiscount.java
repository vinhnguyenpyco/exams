package exams.myexercise.questionthree;

import exams.myexercise.constant.Constant;
import exams.myexercise.model.Bill;
import exams.myexercise.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Class for resolve question three of test assessment
 */
public class AmountDiscount implements RuleDiscount {

    /**
     * Return price of bill when calculate with discount
     * @param bill
     * @return double
     */
    @Override
    public double calculateDiscount(Bill bill){
        double total = 0.0;

        List<Product> lstProduct;

        Optional<List<Product>> optLstProduct = Optional.of(bill.getLstProduct());

        if(optLstProduct.isPresent()){
            for(Product product : bill.getLstProduct()){
                total += product.getPrice();
            }

            if (total >= Constant.AMOUNT_FOR_DISCOUNT) total = total - (int) total / Constant.AMOUNT_FOR_DISCOUNT * Constant.DISCOUNT_EVERY_100_USD;

            bill.setTotal(total);
        }

        return bill.getTotal();
    }
}
