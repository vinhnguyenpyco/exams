package questionthree;

import exams.myexercise.model.Bill;
import exams.myexercise.model.Product;
import exams.myexercise.model.User;
import exams.myexercise.questionthree.PercentDiscount;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for question three
 */
public class PercentDiscountTest {

    private static final double DELTA = 1e-15;
    Bill bill = new Bill();
    List<Product> lstProduct = new ArrayList<>();
    Product productOne = new Product();
    Product productTwo = new Product();

    @Before
    public void setup(){
        productOne.setName("product 1");
        productOne.setPrice(20.2);

        productTwo.setName("product 2");
        productTwo.setPrice(70.2);
    }


    @Test
    public void testPercentEmployee() {
        User user = new User();
        user.setEmployee(true);

        bill.setUser(user);

        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        PercentDiscount percentDiscount = new PercentDiscount();
        double total = percentDiscount.calculateDiscount(bill);

        assertEquals(63.28, total,DELTA);
    }

    @Test
    public void testPercentAffiliate() {
        User user = new User();
        user.setAffiliate(true);

        bill.setUser(user);
        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        PercentDiscount percentDiscount = new PercentDiscount();
        double total = percentDiscount.calculateDiscount(bill);

        assertEquals(81.36, total,DELTA);
    }

    @Test
    public void testPercentLongMember() {
        User user = new User();
        user.setYearOfMember(3);

        bill.setUser(user);
        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        PercentDiscount percentDiscount = new PercentDiscount();
        double total = percentDiscount.calculateDiscount(bill);

        assertEquals(85.88, total,DELTA);
    }

    @Test
    public void testProductIsGroceries() {
        User user = new User();

        bill.setUser(user);

        productOne.setGroceries(true);
        productTwo.setGroceries(true);

        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        PercentDiscount percentDiscount = new PercentDiscount();
        double total = percentDiscount.calculateDiscount(bill);

        assertEquals(90.4, total,DELTA);
    }

    /**
     * Test for case some product in grocery with user is employee
     */
    @Test
    public void testSomeProductIsGroceries() {
        User user = new User();
        user.setEmployee(true);

        bill.setUser(user);

        productOne.setGroceries(true);
        productTwo.setGroceries(false);

        lstProduct.add(productOne);
        lstProduct.add(productTwo);

        bill.setLstProduct(lstProduct);

        PercentDiscount percentDiscount = new PercentDiscount();
        double total = percentDiscount.calculateDiscount(bill);

        assertEquals(69.34, total,DELTA);
    }
}
