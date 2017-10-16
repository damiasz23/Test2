package carRent.rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CarSpecServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String id = req.getParameter("carId");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy").withZone(ZoneId.of("Europe/Warsaw"));

        Optional<Car> car = CarRepository.findCar(Integer.valueOf(id));

//        car.ifPresent(x->x.rentCar());

        PrintWriter writer = resp.getWriter();
        writer.write("<html><head></head><body>");
        writer.write("ok");

        if(car.isPresent()) {
            writer.write("<div><p>Model: " + car.map(x->x.getModel()).orElse("") + "</p></div>");
            writer.write("<div><p>Producent: " + car.get().getMake().name() + "</p></div>");
            writer.write("<div><p>Cena: " + car.get().getBasePrice().toString() + "</p></div>");
            writer.write("<div>Parametry: <ul>");
            for(Option o : car.get().getOptionSet()){
                writer.write("<li>" + o.getName() + "</li>");
            }
            writer.write("</ul></div>");
            writer.write("<div><form action=\"carSpec?carId=" + car.get().getId() + "\" method=\"POST\">");
            writer.write("<input type=\"submit\" value=\"Dodaj\" />");
            writer.write("</form></div>");
        }

        writer.write("<br/>" + id);

        writer.write("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.write("dodano");


        String id = req.getParameter("carId");
        Optional<Car> car = CarRepository.findCar(Integer.valueOf(id));
        Customer nowak = new Customer("Geniu", "Kapi", LocalDateTime.now(), LocalDateTime.now(),true,"432242443324");
        car.ifPresent(x->x.rentCar(nowak, ZonedDateTime.now(), ZonedDateTime.now().plusDays(3)));
    }
}
