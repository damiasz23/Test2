package carRent.account;

import carRent.rent.Customer;
import carRent.rent.CustomerRepository;
import carRent.rent.ProjectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Optional;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordRepeat");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phoneNumber = req.getParameter("phoneNumber");
        String dayOfBirth = req.getParameter("dayOfBirth");
        String licenceCarDay = req.getParameter("licenceCarDay");


        HashMap<String, String> errors = new HashMap<>();
        Boolean isValid = true;
        if(email == null || email.isEmpty()){
            isValid = false;
            errors.put("email", "Wrong email");
        }
        if(password == null || password.isEmpty() || password.length() < 6){
            isValid = false;
            errors.put("password", "Password is too short, min 6 characters");
        }
        if(passwordRepeat == null || passwordRepeat.isEmpty()|| !password.equals(passwordRepeat)){
            isValid = false;
            errors.put("passwordRepeat", "Password must be the same");
        }
        if(firstName == null || firstName.isEmpty()){
            isValid = false;
            errors.put("firstName", "Add first name");
        }
        if(lastName == null || lastName.isEmpty()){
            isValid = false;
            errors.put("lastName", "Add lastname");
        }
        if(phoneNumber == null || phoneNumber.isEmpty()){
            isValid = false;
            errors.put("phoneNumber","Add phone number");
        }
        if(dayOfBirth == null || dayOfBirth.isEmpty()){
            isValid = false;
            errors.put("dayOfBirth", "Add date of birth");
        }
        else if(Period.between(ProjectUtil.parseDateFromCalendar(dayOfBirth).toLocalDate(),
                ZonedDateTime.now().toLocalDate()).getYears() < 18
                ||
                Period.between(ProjectUtil.parseDateFromCalendar(dayOfBirth).toLocalDate(),
                        ZonedDateTime.now().toLocalDate()).getYears() > 90){
            isValid = false;
            errors.put("dayOfBirth", "Your age doesn't fit to our regulations");
        }

        if(licenceCarDay == null || licenceCarDay.isEmpty()|| ProjectUtil.parseDateFromCalendar(dayOfBirth).isBefore(ProjectUtil.parseDateFromCalendar(licenceCarDay))){
            isValid = false;
            errors.put("licenceCarDay","Add licence car day");
        }

        if(!isValid){
            resp.sendRedirect("register.jsp");
        }
        else {
            User user = new User(email, password);
            UserRepository.save(user);
            Optional<Customer> customerOptional = CustomerRepository.findByEmail(email);
            if(customerOptional.isPresent()){
                Customer customer = customerOptional.get();
                customer.setPhoneNumber(phoneNumber);
                customer.setBirthday(ProjectUtil.parseDateFromCalendar(dayOfBirth).toLocalDateTime());
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setDriversLicenceDate(ProjectUtil.parseDateFromCalendar(licenceCarDay).toLocalDateTime());
                CustomerRepository.saveOrUpdate(customer);
                resp.sendRedirect("login.jsp");
            }else {
                resp.sendRedirect("register.jsp");
            }
        }
    }
}
