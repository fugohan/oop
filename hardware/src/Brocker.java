public class Brocker extends AbstractBrocker<T extends Message,E> implements ISubject {

    private static Brocker INSTANCE = null;

    private Brocker(){

    }

    public Brocker GET_INSTANCE(){
        if(this.INSTANCE.equals(null))
            return new Brocker();
        return this.INSTANCE;
    }

    public void pushMessage(Message message){
        this.msgs.add(message);
        this.notifyObservers(message);
    }

    public void register(IObserver observer){
        if(observer.equals(null)!=true){
            this.notificationList.add(observer);
        }

    }

    private void notifyObservers(Message message){

        for(E element: this.notificationList){
            if( element instanceof IObserver){
                IObserver temp = (IObserver) element;
            }
            temp.notifyNewMessage(message.getIdentifier);
        }

    }

    public Optional<Message> getMessage(Long id){
        for(T temp:super.msgs){
            if (temp instanceof Message){
                Message ttemp = (Message)temp;
            }
            if(ttemp.getIdentifier().equals(id))
                return Optional.of(temp);
        }
        return Optional.empty();
    }
}
