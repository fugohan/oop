public class NotStoreableException extends Exception {
  private Storable storableObject;
  private StorageCompartment storageArea;
public NotStoreableException(StorageCompartment storageArea, Storable storable){
  this.storableObject = storable;
  this.storageArea = storageArea;
}
  public String getMessage(){
    return "ERRRRRRRRORRRR -- 1"
  }
}
