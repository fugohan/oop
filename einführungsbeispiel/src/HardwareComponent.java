public abstract class HardwareComponent {
    private String id;
    Float price;


    public HardwareComponent(String id, Float price) {
        this.id = id;
        this.price = price;
    }

    public HardwareComponent() {

    }

    public Float getPrice(){

        return price;
    }
}
