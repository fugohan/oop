package rbvs;
import rbvs.product.IProduct;

import java.util.ArrayList;
import java.util.List;
public class Restaurant extends Object {

    private String name;
    private List<Order> orderHistory;
    private List<IProduct> productAssortment;
    private List<Table> tables;
    private long uniqueOrderIdentifier;

    Restaurant(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public boolean createTable(String tableIdentifier){
        Table temp = new Table(tableIdentifier);

        if(this.tables.add(temp)==true){
            return true;
        }
        return false;

    }
    public List<String> getTableIdentifiers(){
        List<String> nimo = new ArrayList<>();
        for(Table i: this.tables){
            nimo.add(i.getTableIdentifier());
        }
        return nimo;
    }

    public
}
