package exams.myexercise.questionthree;

import exams.myexercise.constant.Constant;
import exams.myexercise.model.Bill;
import exams.myexercise.model.Product;
import exams.myexercise.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Class for resolve question three of test assessment
 */
public class PercentDiscount implements RuleDiscount {

    /**
     * Return price of bill when calculate with discount
     * @param bill
     * @return double
     */
    @Override
    public double calculateDiscount(Bill bill){
        double total = 0;

        double percentDiscount = Constant.NON_DISCOUNT;
        List<Product> lstProduct;

        Optional<User> optUser = Optional.of(bill.getUser());
        Optional<List<Product>> optLstProduct = Optional.of(bill.getLstProduct());

        if(optUser.isPresent()){
            percentDiscount = getPercentDiscount(bill.getUser());
        }

        if(optLstProduct.isPresent()){
            lstProduct = bill.getLstProduct();

            for(Product product : lstProduct){
                if (product.isGroceries()) {
                    total += product.getPrice();
                } else {
                    total += product.getPrice() - (product.getPrice() * percentDiscount);
                }
            }

            bill.setTotal(total);
        }

        return bill.getTotal();
    }

    private double getPercentDiscount(User user){
        if (user.isEmployee()) return Constant.DISCOUNT_EMPLOYEE;

        if (user.isAffiliate()) return Constant.DISCOUNT_AFFILIATE;

        if (user.getYearOfMember() > Constant.LONG_MEMBER) return Constant.DISCOUNT_LONG_MEMBER;

        return Constant.NON_DISCOUNT;
    }
}
