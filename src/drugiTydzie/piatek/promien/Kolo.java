package drugiTydzie.piatek.promien;

/**
 * Created by olaIdamian on 7/14/2017.
 */
public class Kolo {

    public double promien;

    public double Area(){
        double pole = Math.PI * (promien*promien);
        return pole;
    }

    public double Obwod(){
        double obwod = Math.PI * promien* 2;
        return obwod;
    }
}