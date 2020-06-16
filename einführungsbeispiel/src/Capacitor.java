public class Capacitor extends HardwareComponent {

    private float capacitorValue;

    public Capacitor(String id, float price, float capacitorValue) {
        super(id, price);
        this.capacitorValue = capacitorValue;
    }


    public void setCapacitorValue(Float capacitorValue) {
        this.capacitorValue = capacitorValue;
    }
    public Float getCapacitorValue(){
        return this.capacitorValue;
    }
}
