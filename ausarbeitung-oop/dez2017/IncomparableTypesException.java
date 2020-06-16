public class IncomparableTypesException extends Exception{

  private Object value1 = null;
  private Object value2 = null;

  public IncomparableTypesException(Object value1, Object value2){
    this.value1 = value1;
    this.value2 = value2;
  }

  public String getMessage(){
    return "Fehler beim vergleich von " + this.value1.toString() +  " und " + this.value2.toString();
  }

}
