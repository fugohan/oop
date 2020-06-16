package tree.node;

import tree.ITree;

import java.util.ArrayList;
import java.util.Collection;

public class GenericTreeNode<NODETYPE> extends Object implements ITreeNode<NODETYPE> {

        private NODETYPE nodeValue;
        private String label;
        private Collection<ITreeNode<NODETYPE>> children;



        GenericTreeNode(String label, NODETYPE value){

        this.label = label;
        this.nodeValue = value;
        }

        //TODO: Wie geht das?
        public Collection<ITreeNode<NODETYPE>> getChildren(){
            return this.children;
        }

        public boolean isLeaf(){
            if (this.children.isEmpty())
                return true;
            return false;
        }

        public NODETYPE nodeValue(){
            return this.nodeValue;
        }
        public String getLabel(){
            return this.label;
        }
        public ITreeNode<NODETYPE> findNodeByValue(NODETYPE searchValue){
            if(this.isLeaf() != true){
                for(ITreeNode<NODETYPE> temp:this.children){
                    temp.findNodeByValue(searchValue);

                    if(temp.nodeValue().equals(searchValue))
                        return temp;
                }
            }
            return null;
        }

        public ITreeNode<NODETYPE> findNodeByNode(ITreeNode<NODETYPE> searchNode){
            if(this.isLeaf()!=true) {
                for (ITreeNode<NODETYPE> temp : this.children) {
                    temp.findNodeByNode(searchNode);

                    if(temp.equals(searchNode))
                        return searchNode;
                }
            }
            return null;
        }

        public boolean checkNodeByValue(NODETYPE value){
            if (this.nodeValue.equals(value))
                return true;
            return false;
        }
        public String generateConsoleView(String spacer, String preamble){
            String out = "";

            for(int i=0;i<3;i++){
                out += spacer;
            }
               out += this.getLabel();
            return out;
        }

        public String toString(){
            return this.getClass()+":"+this.getLabel();

        }

}