package rbvs;
import rbvs.product.CompositeProduct;
import rbvs.product.IProduct;
import rbvs.product.Product;
import rbvs.product.SimpleProduct;

import java.awt.color.ICC_ProfileRGB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class Restaurant extends Object {

    private String name;
    private List<Order> orderHistory = new ArrayList<>();
    private List<IProduct> productAssortment = new ArrayList<>();
    private List<Table> tables  = new ArrayList<>();
    private long uniqueOrderIdentifier ;


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

    public Table getSpecificTable(String identifier){
        for(Table i:this.tables){
           if( i.getTableIdentifier() == identifier) {
               return i;
           }
        }
        return null;
    }

    public boolean addProduct(IProduct product) throws DuplicateProductException{
        for(IProduct i:this.productAssortment){
            if(i.equals(product)){
                    throw new DuplicateProductException(product);
            }


        }

        if(this.productAssortment.add(product)==true){return true;}


        return false;
    }
    public boolean addProduct(Collection<IProduct> products) throws DuplicateProductException{
        for(IProduct i:products){
            for(IProduct j:this.productAssortment){
                if(i.equals(j)){
                    throw new DuplicateProductException(i);
                }
            }
        }
        if(this.productAssortment.addAll(products)==true){
            return true;
        }
        return false;
    }
    public List<IProduct> getProducts(){
        List<IProduct> temp = new ArrayList<>();
        for (IProduct i:this.productAssortment){
            temp.add(i);
        }
        return temp;
    }

    public boolean orderProductForTable(Table table,IProduct product){
        if(table.equals(null)==false){
            if(product.equals(null)==false){
                if(this.tables.contains(table)==true){
                    if(this.productAssortment.contains(product)==true){
                        List<IProduct> tem = new ArrayList<>();
                        tem.add(product);
                        Order temp = new Order(uniqueOrderIdentifier,table,tem);
                        this.orderHistory.add(temp);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean orderProductForTable(Table table,IProduct product, int count){
        if(table.equals(null)==false){
            if(product.equals(null)==false){
                if(this.tables.contains(table)==true){
                    if(this.productAssortment.contains(product)==true){
                        List<IProduct> tem = new ArrayList<>();
                        for(long i=0;i<count;i++){
                            tem.add(product);
                        }
                        Order temp = new Order(uniqueOrderIdentifier,table,tem);
                        this.orderHistory.add(temp);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsProduct(IProduct compareProduct){
        for(IProduct i:this.productAssortment){
            if(i.equals(compareProduct)==true){
                return true;
            }
        }

       // if(this.productAssortment.contains(compareProduct)==true);
        return false;
    }

    private IProduct findProduct(IProduct compareProduct){
        for(IProduct i:this.productAssortment){
            if(i.equals(compareProduct)==true){
                return i;
            }
        }
        return null;
    }

    private long generateUniqueIdentifier(){
        this.uniqueOrderIdentifier +=1;
        return this.uniqueOrderIdentifier;
    }

    public static List<IProduct> generateSimpleProducts(){
        List<IProduct> temp = new ArrayList<>();
        for(long i=0;i<5;i++){
            SimpleProduct tee = new SimpleProduct("name"+i,i*3);
            temp.add(tee);
        }
        return temp;
    }
/* TODO:Angabefehler?

    public static List<IProduct> generateCompositeProduct(){
        List<IProduct> temp = new ArrayList<>();

        for(long i=0;i<5;i++){
            List<IProduct> sp = generateSimpleProducts();
            CompositeProduct tee = new CompositeProduct("name"+i,(i*30)%23,sp);
            temp.add(tee);
        }
        return temp;
    }*/

    public String toString(){
        return "Restaurant-name:"+this.getName();
    }


    public static void main(String[] args){
        Restaurant one = new Restaurant("One");
        System.out.println(one.toString());
        System.out.print(generateSimpleProducts());
    }
}
