package core;
import java.util.*;
public class ElectricMeterReader extends HttpServer<DbEntry<String>> implements ReceiveListener<DbEntry<String>>, Subject<DbEntry<String>>{
  private Collection<HardwareDevice> hardware;
  private Collection<Pair<String,String>> database;
  private static ElectricMeterReader INSTANCE; //final
  private JsonTransceiver<String, DbEntry<String>> transceiver; //final
  private Collection<Observer<?>> observer;

  private ElectricMeterReader(String ip, String port, JsonTransceiverFactory factory){
    super(ip,port);
    if(this.transceiver!=null){
      this.transceiver = factory.createInstance();
    }
    observer.add(transceiver);
    this.initHardware();
  }

  public Collection<DbEntry<String>> getDataToSend(){ //Angabe fehlt
    this.transceiver.transmit();

    //weiter später
  }
  public Collection<DbEntry<String>> getHistory(String entryId){ //Angabe fehlt
    if(entryId != null){
      Collection<DbEntry<String>> ret = new ArrayList();
      for(Pair<String,String> dbe : database){
        if(dbe.key.equals(entryId)){
          ret.add(new DbEntry.createFrom(dbe.value));
        }
      }
      return ret;
    }

  }

  public DbEntry<String> readMeterValue() throws NoResultException{

    for(HardwareDevice hard: hardware){
      if(hard != null &&!(hard.read().equals(null))){
          DbEntry<String> temp =  DbEntry.createFrom(hard.read());
          Pair<String,String> save = new Pair(temp.getIdentifier(), temp.getMeterValue());
          database.add(save);
          for(Observer<?> obs:observer){
            obs.dataReadyToSend();
          }
          return temp;
      }
      else if(hard == null){
        throw new NoResultException("Nothing found!");
      }
      else{
        continue;
      }
    }
  }
}
