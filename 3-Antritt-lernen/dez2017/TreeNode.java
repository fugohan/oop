import java.util.*;

public class TreeNode extends Node implements INode, ISubject{

  private Collection<IObserver> observer = new ArrayList<>();

  public TreeNode(IComparable data){
    super();
    super.setData(data);

    }

  public INode insertData(IComparable data) throws IncomparableTypesException{

      int a = super.getData().compareTo(data);

      if (a == 0)
        return this;

      else if (a == 1 ){
        INode ln = this.getLeft();
        if(ln.equals(null)){
          INode temp = new TreeNode(data.createCopy());
          super.setLeft(temp);
          return temp;
        }
        else{
          return  ln.insertData(data);
        }

      }
      else if (a == -1){
        INode rn = this.getRight();
        if(rn.equals(null)){
        INode temp = new TreeNode(data.createCopy());
        super.setRight(temp);
        return temp;
        }
        else{
          return  rn.insertData(data);
        }
      }

      else
        throw new IncomparableTypesException(super.getData(),data);


  }

  public boolean updateNodeData(IComparable data){
    INode ln = super.getLeft();
    IComparable ltemp = ((TreeNode)ln).getHighestSubTreeDataElement();
    INode rn = super.getRight();
    IComparable rtemp = ()(TreeNode)rn).getSmallestSubTreeDataElement();
  /*  if (ln.equals(null)) {
      ltemp = this.getNodeData();
    }
    if(rn.equals(null)){

    }*/
    try{
    int lnum = ln.getData().compareTo(data);
    int rnum= rn.getData().compareTo(data);
    if(lnum.equals(-1) && rnum.equal(1)){


    IComparable copy  = data.createCopy();


    if(super.setData(copy)) // nicht this weil this unnedig
    {
    this.notifyObservers();
    return true;
    }
    else{
      return false;
      }
  }
    else{
      return false;
      }
    }
    catch(IncomparableTypesException e){
      e.getMessage(); //Macht eh nix
      return false;

    }

  }

  public void addDataToSortedList(Collection<IComparable> data){
    this.addDataToSortedList(data);
    INode n = this.getData();
    IComparable copy = this.createCopy(data);

  }




































}
