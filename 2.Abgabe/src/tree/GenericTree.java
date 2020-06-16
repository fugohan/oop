package tree;

import tree.node.ITreeNode;

public class GenericTree<TREETYPE> extends Object implements ITree<TREETYPE> {

    // ALL TREETYPES MUST BE GENERICTREES!
    ITreeNode<TREETYPE> root;

    GenericTree(){
        this.root = null;
    }

    GenericTree(ITreeNode<TREETYPE> root){
        this.root = root;
    }

    public void setRoot(ITreeNode<TREETYPE> root){
        this.root = root;
    }
    public ITreeNode<TREETYPE> getRoot(){
        return this.root;
    }
    public ITreeNode<TREETYPE> findNode(TREETYPE searchValue){

    }
}
