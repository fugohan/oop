import java.util.*;

public class Broker extends AbstractBroker<T extends Message, IObserver> implements ISubject{

  private Broker INSTANCE;

  private Broker(){}

  public Broker GET_INSTANCE(){
    if( INSTANCE == null)
      this.INSTANCE = new Broker();
    return this.INSTANCE;
  }

  public void pushMessage(Message message){
    if(message != null){
      this.msgs.add(message);
      for(IObserver obs : notificationList){
        this.notifyObservers(message);
      }
    }
  }
  public void register(IObserver observer){
    if(observer != null){
      this.notificationList.add(observer);
    }
  }
  private void notifyObservers(Message message){
    if(messsage!=null){
      for(IObserver obs : notificationList){
        obs.notifyNewMessage(message.getIdentifier());
      }
    }
  }
  public Optional<Message> getMessage(Long identifier){
    for(Message msg: this.msgs){
      if(msg.getIdentifier().equals(identifier))
        return  Optional.of(msg);
    }
    return Optional.empty();
  }

}
