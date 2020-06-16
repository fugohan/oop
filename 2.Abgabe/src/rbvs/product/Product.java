package rbvs.product;

public abstract class Product extends Object implements IProduct{

    private String name;
    private float price;

    public Product(String name){
        this.name = this.name;
        this.price = 0;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }



    public abstract Product deepCopy(); //da es eine Abstrakte Methode ist muss es hier nicht definiert werden.

    public boolean equals(Object obj){
        Product temp = (Product) obj;
        if(temp.name == this.getName()){
            if(temp.price == this.getPrice()){
                return true;
            }
        }
        return false;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    private void initialize(String name, float price){
        this.name = name;
        this.price = price;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String s = "Name:" + this.getName() + " Price:" + this.getPrice();
        return s;

    }
}
