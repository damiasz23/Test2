package carRent.rent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {

    public static final String EMAIL = "gawel@gmail.com";
    public static final String PHONE_NUMBER = "987654321";

    @Test
    public void test(){
        Optional<Customer> byEmail = CustomerRepository.findByEmail(EMAIL);

        Assert.assertTrue("should return user by email", byEmail.isPresent());
    }

    @Test
    public void testUpdate(){
        Optional<Customer> byEmail = CustomerRepository.findByEmail(EMAIL);
        if(byEmail.isPresent()){
            Customer customer = byEmail.get();
            customer.setPhoneNumber(PHONE_NUMBER);
            CustomerRepository.update(customer);
            Assert.assertTrue("should have customer", CustomerRepository.update(customer));

            Customer customerEdit = CustomerRepository.findByEmail(EMAIL).get();
            Assert.assertTrue("should phone by email",
                    customerEdit.getPhoneNumber().equals(customer.getPhoneNumber()));
        }

    }

}
