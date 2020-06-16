package util;
public enum ProductCategory{

    FOOD,BEVERAGE,DEFAULT;
   public String getLabel(){
       if(this.equals(null))
           throw new NullPointerException();
       if( this.equals(ProductCategory.FOOD))
           return "THIS IS FOOD";
       if( this.equals(ProductCategory.BEVERAGE))
           return "THIS IS BEVERAGE";
       if( this.equals(ProductCategory.DEFAULT))
           return "THIS IS FOOD";
       throw new IllegalArgumentException();
   }
}

