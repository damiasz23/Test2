package carRent.account;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import java.util.Optional;


public class UserRepositoryTest {

    @Test
    public void findUser(){

        Optional<User> user = UserRepository.findUserByEmailAndPassword("test@gmail.com", "1234");
//        Assert.assertTrue("find User", user.ifPresent());

    }

    @Test
    public void save() {
        User user = new User("test@gmail.com", "1234");
        Assert.assertTrue("add User", UserRepository.save(user));

    }
}