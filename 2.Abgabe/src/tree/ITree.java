package tree;
import ict.basics.IDeepCopy;
import tree.node.ITreeNode;
import util.searchable.ISearchableByFilter;

public interface ITree<TREETYPE> extends IDeepCopy, ISearchableByFilter<ITreeNode<TREETYPE>> {

    void setRoot(ITreeNode<TREETYPE> root);
    ITreeNode<TREETYPE> getRoot();
    ITreeNode<TREETYPE> findNode(TREETYPE searchValue);
    ITreeNode<TREETYPE> findNode(tree.node.ITreeNode<TREETYPE> searchNode);
    String generateConsoleView(String spacer);
    ITree<TREETYPE> deepCopy();
}
