package carRent.rent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class EditCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String model = req.getParameter("model");
        String insurenceCost = req.getParameter("insurenceCost");
        String capacity = req.getParameter("capacity");
        String baseProce = req.getParameter("basePrice");
        String segment = req.getParameter("segment");
        String color = req.getParameter("color");
        String gearBox = req.getParameter("gearBox");
        String engineType = req.getParameter("engineType");
        String torque = req.getParameter("torque");
        String horsePower = req.getParameter("horsePower");
        String fuelConsumption = req.getParameter("fuelConsumption");
        String engineCapacity = req.getParameter("engineCapacity");
        String make = req.getParameter("make");



        boolean isValid = true;
        if(id!=null && id.trim().isEmpty()){
            isValid = false;
        }

        if(model!=null && model.trim().isEmpty()){
            isValid = false;
        }
        if(insurenceCost!=null && insurenceCost.trim().isEmpty()){
            isValid = false;
        }
        if(capacity!=null && capacity.trim().isEmpty()){
            isValid = false;
        }
        if(baseProce!=null && baseProce.trim().isEmpty()){
            isValid = false;
        }

        if(segment!=null && segment.trim().isEmpty()){
            isValid = false;
        }

        if(color!=null && color.trim().isEmpty()){
            isValid = false;
        }

        if(gearBox!=null && gearBox.trim().isEmpty()){
            isValid = false;
        }

        if(engineType!=null && engineType.trim().isEmpty()){
            isValid = false;
        }

        if(torque!=null && torque.trim().isEmpty()){
            isValid = false;
        }

        if(horsePower!=null && horsePower.trim().isEmpty()){
            isValid = false;
        }

        if(fuelConsumption!=null && fuelConsumption.trim().isEmpty()){
            isValid = false;
        }

        if(engineCapacity!=null && engineCapacity.trim().isEmpty()){
            isValid = false;
        }
        if(make!=null && make.trim().isEmpty()){
            isValid = false;
        }

        Integer _carId = null;
        Make _make = null;
        Integer _capacity = null;
        CarSegment _carSegment = null;
        Color _color = null;
        BigDecimal _basePrice = null;
        BigDecimal _insuranceCost = null;
        BigDecimal _engineCapacity = null;
        EngineType _engineType = null;
        BigDecimal _fuelConsumption = null;
        GearBox _gearBox = null;
        Integer _horsePower = null;
        Integer _torque = null;

        try {
            _carId = Integer.valueOf(id);
            _make = Make.valueOf(make);
            _capacity = Integer.valueOf(capacity);
            _carSegment = CarSegment.valueOf(segment);
            _color = Color.valueOf(color);
            _basePrice = new BigDecimal(baseProce);
            _insuranceCost = new BigDecimal(insurenceCost);
            _engineCapacity = new BigDecimal(engineCapacity);
            _engineType = EngineType.valueOf(engineType);
            _fuelConsumption = new BigDecimal(fuelConsumption);
            _gearBox = GearBox.valueOf(gearBox);
            _horsePower = Integer.valueOf(horsePower);
            _torque = Integer.valueOf(torque);


        }catch (Exception ex){
            ex.printStackTrace();
            isValid = false;
        }

    }
}
