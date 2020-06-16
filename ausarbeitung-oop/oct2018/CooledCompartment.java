public class CooledCompartment extends StorageCompartment {

  private int targetTemperature;
  CooledCompartment(float maxWeight, float maxWidth, int targetTemperature){
    super(maxWeight, maxWidth, targetTemperature);
  }

  public void storeObject(Storable storeable) throws NotStoreableException {
    if(storable.equals(null))
    {
      throw new NotStoreableException();
    }

    /*if(super.caluculateSumOfWeight()+storable.getWeight() <= this.getMaxWeight() && super.caluculateSumOfWidth()+storable.getWidth()<=this.getMaxWidth())
    {
      if(storable.getType().equals(StorageType.COOLED))
    }*/

    if(this.checkWeight(storable)){
      if(this.checkWidth(storable)){
        if(storable.getType().equals(StorageType.COOLED)){
          if (storable instanceof CooledObject){
         if(((CooledObject)storable).getRequiredTemperature()>this.targetTemperature){

           super.storeObject(storable);
            }
          }
        }
      }
    }

    else{
      throw new NotStoreableException();
    }
  }

}
