package rbvs;

import com.sun.org.apache.xpath.internal.operations.Or;
import ict.basics.IDeepCopy;
import rbvs.product.IProduct;
import rbvs.product.Product;
import rbvs.record.Record;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Order extends Record implements IDeepCopy {

    private OrderState currentState;
    private List<IProduct> products;
    private Table table;


    Order(long identifier, Table table, List<IProduct> products){
        super(identifier);
        this.table = table;
        this.products = products;
    }

    public List<IProduct> getProducts(){
        return this.products;
    }
    public boolean setState(OrderState newStatus){
        this.currentState = newStatus;
        return true;
    }
    public OrderState getState(){
        return this.currentState;
    }

    public boolean isCancelled(){
        if(this.currentState == OrderState.CANCELLED) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isPaid(){
        if(this.currentState == OrderState.PAID) {
            return true;
        }
        else{
            return false;
        }
    }

    public Table getTable(){

        return this.table;

    }


    @Override
    public Order deepCopy() {
       //TODO: DEEPCOPY (DONE)

        List<IProduct> mimo = new ArrayList<>();
        for(IProduct i:this.getProducts()){
            mimo.add((Product)i.deepCopy());
        }
       // Order copy = new Order(this.getIdentifier(),this.getTable(),mimo);
        Order copy = new Order(this.getIdentifier(), this.getTable(),  mimo);
        return copy;
    }
}
