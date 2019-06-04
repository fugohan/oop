package tree;

import rbvs.product.IProduct;
import rbvs.product.Product;

public class ProductTree extends GenericTree<IProduct> {


    public ProductTree(ITreeNode<IProduct> root){
        super(root);

    }
    //TODO:secound CONSTRUTOR
   /* public ProductTree(IProduct product){
        ITreeNode<IProduct> temp = product;
        super(temp);
    }
    /
    */

   public ProductTree(){
       super();
       // this.root = null;
   }
}
