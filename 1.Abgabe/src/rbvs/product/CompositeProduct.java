package rbvs.product;

import java.util.Collection;

public class CompositeProduct extends Product {
    private Collection<Product> containedProducts;
    private float discount;

    CompositeProduct(String name, float discountPercentage){
        super(name);
        this.discount = discountPercentage;
    }

    CompositeProduct(String name, float
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
        return null;
    }
    public float getPrice(){
    return super.getPrice();
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
