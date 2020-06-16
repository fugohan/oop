public class FerryConnection extends FerryConnection {
  private int distance;

  public FerryConnection(String origin, String dest, int distance){
    super(origin,dest);
    this.distance = distance;
  }

  public boolean checkConnection(String origin, String dest){
    if(this.getOrigin().equals(origin) && this.getDestionation().equals(dest)){
      return true;
    }
    return false;
  }

  public boolean compareOrigin(String origin){
    if(this.getOrigin().equals(origin))
      return true;
    return false;
  }
}
