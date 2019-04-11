public class Capacitor extends HardwareComponent {

    private Float capacitorValue;

    public Capacitor( Float startValue) {
        super();
        this.capacitorValue = startValue;
    }

    public void setCapacitorValue(Float capacitorValue) {
        this.capacitorValue = capacitorValue;
    }
    public Float getCapacitorValue(){
        return this.capacitorValue;
    }
}
