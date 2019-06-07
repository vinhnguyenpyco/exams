package exams.myexercise.questionthree;

import exams.myexercise.model.Bill;
import exams.myexercise.model.Product;
import exams.myexercise.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for question three
 */
public class CheckoutTest {

    private static final double DELTA = 0.1;

    @Test
    public void testFinalPrice() {
        Bill bill = new Bill();
        User user = new User();

        user.setEmployee(true);

        List<Product> lstProduct = new ArrayList<>();

        Product productOne = new Product();

        productOne.setName("product 1");
        productOne.setPrice(200.2);

        Product productTwo = new Product();

        productTwo.setName("product 2");
        productTwo.setPrice(90.2);

        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setUser(user);
        bill.setLstProduct(lstProduct);

        Checkout checkout = new Checkout();
        double total = checkout.calculateFinal(bill);

        assertEquals(193.28, total,DELTA);
    }
}
