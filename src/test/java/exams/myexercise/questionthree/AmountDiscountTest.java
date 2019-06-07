package exams.myexercise.questionthree;

import exams.myexercise.model.Bill;
import exams.myexercise.model.Product;
import exams.myexercise.questionthree.AmountDiscount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for question three
 */
public class AmountDiscountTest {

    private static final double DELTA = 1e-15;

    @Test
    public void testAmountDiscount() {
        Bill bill = new Bill();
        List<Product> lstProduct = new ArrayList<>();

        Product productOne = new Product();

        productOne.setName("product 1");
        productOne.setPrice(20.2);

        Product productTwo = new Product();

        productTwo.setName("product 2");
        productTwo.setPrice(90.2);

        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        AmountDiscount amountDiscount = new AmountDiscount();
        double total = amountDiscount.calculateDiscount(bill);

        assertEquals(105.4, total,DELTA);
    }

    @Test
    public void testAmountNormal() {
        Bill bill = new Bill();
        List<Product> lstProduct = new ArrayList<>();

        Product productOne = new Product();

        productOne.setName("product 1");
        productOne.setPrice(20.2);

        Product productTwo = new Product();

        productTwo.setName("product 2");
        productTwo.setPrice(70.2);

        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        AmountDiscount amountDiscount = new AmountDiscount();
        double total = amountDiscount.calculateDiscount(bill);

        assertEquals(90.4, total,DELTA);
    }
}
