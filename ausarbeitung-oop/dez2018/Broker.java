import java.util.*;

public class Broker extends AbstractBroker<Message, IObserver> implements ISubjects{
  private static Broker INSTANCE;
  private Broker(){
  }

  public static Broker GET_INSTANCE(){
    if(this.INSTANCE == (null)){
      this.INSTANCE = new Broker();
    }
    return this.INSTANCE;
  }

  public void pushMessage(Message message){
    if (message != null){
    this.msgs.add( message );
    // Die nachfolgenden Zeilen leisten das gleiche, richtig?
    this.notifyObservers(message);
    //notifyObservers(message);
    }
  }

  public void register(IObserver observer){
    if(observer != null){
      this.notificationList.add(observer);
    }
  }

  private void  notifyObservers(Message message){
    if(message!=null){
      for (IObserver obs: this.notificationList){
        obs.notifyNewMessage(message.getIdentifier());
      }
    }
  }
  public Optional<Message> getMessage(Long identifier){
    if(identifier == 0 !&& !(this.msgs.isEmpty()){
      for(Message msg:this.msgs){
        if(msg.getIdentifier().equals(identifier)){
          return Optional.of(msg);
        }
      }
    }
    return Optional.empty();
  }


}
