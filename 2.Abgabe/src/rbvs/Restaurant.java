package rbvs;
import rbvs.product.*;
import sun.java2d.pipe.SpanShapeRenderer;
import sun.plugin.perf.PluginRollup;

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

        SimpleProduct ham0 = new SimpleProduct("Hamburger", 4);
        SimpleProduct ham1 = new SimpleProduct("Cheeseburger", 4.1f);
        SimpleProduct ham2 = new SimpleProduct("Big Burger", 5);
        SimpleProduct ham3 = new SimpleProduct("Chilliburger", 7);
        SimpleProduct ham4 = new SimpleProduct("Sweetburger", 6.9f);

        ExtendedProduct tga = new ExtendedProduct("Trinkgeld Anna", 2);
        ExtendedProduct tgb = new ExtendedProduct("Trinkgeld Bettina", 2);
        ExtendedProduct tgc = new ExtendedProduct("Trinkgeld Chris", 2);
        ExtendedProduct tgd = new ExtendedProduct("Trinkgeld Daniel", 2);
        ExtendedProduct tgf = new ExtendedProduct("Trinkgeld Fiona", 2);

        CompositeProduct water = new CompositeProduct("Leitungswasser", 100);
        CompositeProduct soda = new CompositeProduct("Soda", 1);

        List<Product> diezwan = new ArrayList<>();
        diezwan.add(ham1);
        diezwan.add(ham0);
        CompositeProduct dis20 = new CompositeProduct("MitSparwoch", 20, diezwan);
        CompositeProduct dis10 = new CompositeProduct("DoSparTag", 10, diezwan);
        List<Product> disday = new ArrayList<>();
        disday.add(dis10);
        disday.add(dis20);
        CompositeProduct dis = new CompositeProduct("Spartage", 5,disday);

        Table eins = new Table("1",2);
        Table zwei = new Table("2",4);
        Table drei = new Table("3",8);









    }
}
