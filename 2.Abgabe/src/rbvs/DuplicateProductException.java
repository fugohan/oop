package rbvs;

import rbvs.product.IProduct;

public class DuplicateProductException extends Exception {

    private IProduct product;
    private static final long serialVersionUID = 0;
    DuplicateProductException(IProduct product){
        this.product = product;
    }
    public String getMessage(){
        return "Product"+" already exists!" ;
    }
}
