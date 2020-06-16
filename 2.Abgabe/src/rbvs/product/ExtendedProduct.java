package rbvs.product;

import java.rmi.server.ExportException;

public class ExtendedProduct extends SimpleProduct {
    private ExtendedProduct savedState;
    public ExtendedProduct(String name, float price){
        super(name, price);
        this.savedState = null;
    }

    public ExtendedProduct(ExtendedProduct product){
        super(product.getName(), product.getPrice());
        this.savedState = product;
    }

    public ExtendedProduct deepCopy(){
        //TODO: Methode fertig schreiben (DONE)
        ExtendedProduct temp = this;
        return temp;

    }

    public void setName(String name){
        super.setName(name);
    }
    public void setPrice(float price){

    }

    public String toString(){
        String temp = "Type: ExtendedProduct Name:"+this.getName()+" Price:" +this.getPrice();
        return temp;
    }

    public boolean undo(){
        if(this.savedState.getName() != null) {
            this.setName(this.savedState.getName());
            this.setPrice(this.savedState.getPrice());
            return true;
        }
        else {
            return false;
        }
    }
}
