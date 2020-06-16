public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
       // HardwareComponent a = new HardwareComponent("a",3);

       /* float start = 3;
        Capacitor a = new Capacitor(start);
        System.out.println(a.getCapacitorValue());
        Capacitor b = new Capacitor(3f);*/

       //test PCB

        PCB one = new PCB();
        //HardwareComponent R1 = new HardwareComponent("test", 0.1f);
        Resistor R1 = new Resistor("R1", 0.01f,1000f);
        Resistor R2 = new Resistor("R1", 0.01f,2000f);
        Resistor R3 = new Resistor("R1", 0.01f,3000f);
        Resistor R4 = new Resistor("R1", 0.01f,4000f);
        Resistor R5 = new Resistor("R1", 0.01f,5000f);

        Capacitor C1 = new Capacitor("C1", 0.1f,0.1f);
        Capacitor C2 = new Capacitor("C1", 0.1f,0.2f);
        Capacitor C3 = new Capacitor("C1", 0.1f,0.3f);
        Capacitor C4 = new Capacitor("C1", 0.1f,0.4f);
        Capacitor C5 = new Capacitor("C1", 0.1f,0.5f);





        //one.placeComponent(R1);
        //one.placeComponent(C1);
        //System.out.println(C1.getPrice());
        one.placeComponent(R1);
        one.placeComponent(C1);
        one.showConnectionDetails();

        PCB two = new PCB();
        for(int i=0; i<4; i++){
            String temp_name = "R" + i;
            Resistor temp = new Resistor(temp_name, 0.02f, i*150);
            two.placeComponent(temp);
        }

       /* for(HardwareComponent temp: two.getHwComponents()){
            System.out.print(temp.getId()+"\t");
        }*/
        two.placeComponent(R1);
        two.placeComponent(R2);
        System.out.println(two.connectComponents(R1, R2));

        two.showConnectionDetails();


    }
}
