package transmission;

public interface JsonTransceiver<E extends Json<T>, T > extends Observer<E>, Transceiver<E> {//T in der Implementierung Serializable
  public void register(ReceiveListener<E> l);
  public void unregister(ReceiveListener<E> l);

}
