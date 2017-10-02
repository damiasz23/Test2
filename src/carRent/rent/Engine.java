package carRent.rent;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Embeddable
public class Engine {

    private BigDecimal engineCapasity;

    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    private BigDecimal fuealCompsution;

    @Enumerated(EnumType.STRING)
    private GearBox gearBox;
    private Integer horsePower;
    private Integer torque;

    public Engine() {
    }

    public Engine(BigDecimal engineCapasity, EngineType engineType, BigDecimal fuealCompsution, GearBox gearBox, Integer horsePower, Integer torque) {
        this.engineCapasity = engineCapasity;
        this.engineType = engineType;
        this.fuealCompsution = fuealCompsution;
        this.gearBox = gearBox;
        this.horsePower = horsePower;
        this.torque = torque;
    }

    public BigDecimal getEngineCapasity() {
        return engineCapasity;
    }

    public void setEngineCapasity(BigDecimal engineCapasity) {
        this.engineCapasity = engineCapasity;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public BigDecimal getFuealCompsution() {
        return fuealCompsution;
    }

    public void setFuealCompsution(BigDecimal fuealCompsution) {
        this.fuealCompsution = fuealCompsution;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getTorqe() {
        return torque;
    }

    public void setTorqe(Integer torqe) {
        this.torque = torqe;
    }
}
