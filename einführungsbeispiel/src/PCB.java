import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PCB {
    private Collection<HardwareComponent> hwComponents = new ArrayList<HardwareComponent>();
    private Collection<CircuitPath> connections = new ArrayList<CircuitPath>();

    public PCB() {

    }

    public void placeComponent(HardwareComponent hw){
        this.hwComponents.add(hw);
    }

    public boolean connectComponents(HardwareComponent hw1, HardwareComponent hw2){

        if (this.hwComponents.equals(hw1)){
            if (this.hwComponents.equals((hw2))){


                return true;
            }

        }
        return false;
    }

    public void addConnection(CircuitPath connection){
        this.connections.add(connection);
    }

    public float calculatePrice(){
        float price = 0;
        for (HardwareComponent temp : this.hwComponents) {
           price += temp.getPrice();
        }


        return price;
    }

    public Collection<HardwareComponent> getHwComponents() {
        return hwComponents;
    }

    public void showConnectionDetails(){
        System.out.println(this.connections);
        System.out.println(this.calculatePrice());
    }
}
