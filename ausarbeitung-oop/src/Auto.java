public class Auto extends Fahrzeug {

    public Auto(int a){
        super();
        super.setGear(a);

    }
    public Auto(){
        super();
    }

   /* public void printGear(){
        System.out.println(this.gear);
    }*/

    public static void main(String[] args){
        Auto a = new Auto();
      // a.printGear();
       a.irgendwie(1,1);
    }
    public void irgendwie(int a){
        this.setGear(a);
        //System.out.println();
    }
}


