package tree;

import ict.basics.IDeepCopy;

public interface ITree extends IDeepCopy,ISearchableByFilter<ITreeNode<TREETYPE>> {
    void setRoot(ITreeNode<TREETYPE> root);
    ITreeNode<TREETYPE> getRoot();
    ITreeNode<TREETYPE> findNode(TREETYPE searchValue);
    ITreeNode<TREETYPE> findNode(ITREENODE<TREETYPE> searchNode);
    String generateConsoleView(String spacer);
    ITree<TREETYPE> deepCopy();
}
