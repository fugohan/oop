package util.searchable;

import rbvs.product.Product;

public class ProductPriceLessFilter extends Object implements ISearchFilter {

    public ProductPriceLessFilter(){

    }
    public boolean searchFilterFunction(Object originalObject, Object compareObject){
        if(originalObject instanceof Product){
            if(compareObject instanceof Product){


                return (((Product) originalObject).getPrice()<((Product) compareObject).getPrice());
            }
        }
        return false;
    }

}
