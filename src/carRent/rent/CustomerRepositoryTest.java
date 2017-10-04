package carRent.rent;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {

    public static final String EMAIL = "test@gmail.com";

    @Test
    public void test(){
        Optional<Customer> byEmail = CustomerRepository.findByEmail(EMAIL);

        Assert.assertTrue("should return user by email", byEmail.isPresent());
    }

}
