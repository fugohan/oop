import java.util.*;

public class StorageManager<T extends StorageCompartment> {
  public Collection<T> StorageCompartments;


  public StorageManager(){

  }
public boolean storeObject(Storable additionalObject){ //und was ist das hier

  for(T comp: StorageCompartments){
    if(comp.checkWidth(additionalObject) && comp.checkWeight(additionalObject) ){

  try{
    comp.storeObject(additionalObject);
    return true;
  }
  catch( NotStoreableException e){
    continue;
    }
  }
}
  return false;
}




public boolean storeObject(Storable additionalObject){
  for (T temp : StorageCompartments){
    if(temp.checkWidth(additionalObject)&&temp.checkWeight(additionalObject)){

        temp.storedObject(additionalObject);
      return true;
    }
  }
  return false;
}

  public Optional<T> findCompartmentByMetric(){
    //Optional<T> bad = Optional.empty();
    Collection<float> bewertungen = new Collection<float>();
    for(T nope: StorageCompartments){
      float allweight = 0;
      float allwidth = 0;
      if(nope.storedObject.equals(null)){
        bewertungen.add(Float.MAX_VALUE);
      }
      else{
      for (Storable nooo: StorageCompartment.storedObject){
        allweight += nooo.getWeight();
        allwidth += nooo.getWidth();
      }

      bewertungen.add(2*(nope.getMaxWeight()-allweight )+(nope.getMaxwidth()-allwidth()))
      }

    }
    float min = Collection.min(bewertungen, )
    int minpos;
    for(int i, i<bewertungen.size(),i++){
     if()
    }
  }
}
