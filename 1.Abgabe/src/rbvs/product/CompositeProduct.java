package rbvs.product;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collection;

public class CompositeProduct extends Product {
    private Collection<Product> containedProducts = new ArrayList<>();
    private float discount;

    public CompositeProduct(String name, float discountPercentage){
        super(name);
        this.discount = discountPercentage;
    }

    public CompositeProduct(String name, float
                      discountPercentage, Collection<Product> products){
        super(name);
        this.discount = discountPercentage;
        this.containedProducts = products;
    }


    public  void addProduct(Product product){
        this.containedProducts.add(product);
    }
    @Override
    public CompositeProduct deepCopy() {
        Collection<Product> mimo= new ArrayList<>();
        for(Product i:this.getProducts()){
            mimo.add(i.deepCopy());
        }
        CompositeProduct temp = new CompositeProduct(this.getName(),this.discount,mimo);
        return temp;
    }
    public float getPrice(){
        float all=0;
        for(Product i:this.getProducts()){
            all+=i.getPrice();
        }
        return all;
    }

    public Collection<Product> getProducts(){
        return this.containedProducts;
    }
    public boolean removeProduct(Product product) {
        if (this.containedProducts.contains(product) == true) {
            this.containedProducts.remove(product);
            return true;
        }
        return false;
    }
    public String toString(){
        return "Type:CompositeProduct Name:" + this.getName() + " Price:"+this.getPrice() + " List:"+ this.getProducts();
        }

}
