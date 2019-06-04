package tree;


import rbvs.product.IProduct;

public class GenericTree extends Object implements ITree<TREETYPE> {

    protected ITreeNode<NODETYPE> root;
    public GenericTree(){
        this.root = null;
    }
    public GenericTree(ITreeNode<TREETYPE> root){

        this.root = root;

    }


    public void setRoot (ITreeNode<TREETYPE> root){
        this.root = root;
    }

    public ITreeNode<TREETYPE> getRoot(){
        return this.root;
    }

    //TODO:findNode
    //TODO:findNode
    //TODO:generateConsoleView
/* public String generateConsoleView(String spacer){
        String out = "";
        out += spacer
    }*/
    //TODO:searchByFilter
    //TODO:deepCopy
}
