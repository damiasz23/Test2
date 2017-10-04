package carRent.account;


import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;


public class UserRepositoryTest {

        private static final String EMAIL = "gawel@gmail.com";
        public static final String TAJNE_HASLO = "123456";


        @Test
        public void findUserByEmailAndPassword() throws Exception {
            Optional<User> user = UserRepository.findUserByEmailAndPassword(EMAIL, TAJNE_HASLO);
            Assert.assertTrue("find User", user.isPresent());
        }

        @Test
        public void save() throws Exception {

            User user = new User(EMAIL, TAJNE_HASLO);

            Assert.assertTrue("add User",UserRepository.save(user));
        }
}