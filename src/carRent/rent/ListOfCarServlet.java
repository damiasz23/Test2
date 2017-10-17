package carRent.rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.List;


public class ListOfCarServlet extends HttpServlet{

    @Override
    protected void doGet (HttpServletRequest reg, HttpServletResponse resp)
        throws ServletException, IOException {


        List<Car> avilibleCar = CarRepository.findAvilibleCar(ZonedDateTime.now(), ZonedDateTime.now().plusDays(1));

        System.out.println("size: "+avilibleCar.size());
        PrintWriter writer = resp.getWriter();
        writer.write("<html><head></head>" +
        "<body>" +
        "<h2>Strona wypozyczalni</h2>" +
        "</body>" +
        "</html>");

        writer.write("<table><tr><td>Nazwa</td><td>Cena</td><td>Zobacz</td></tr>");
        for(Car c: avilibleCar){
            writer.write("<tr><td>" + c.getModel() + "</td><td>" +
            c.getBasePrice().toString() + "</td>" +
                    "<td><a href=\"carSpec?carId=" + c.getId() + "\">Zobacz</a></td></tr>");
        }
        writer.write(
                "</body>" +
                        "</html>");
    }
}
