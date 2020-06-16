package hardware;

public enum ReadingProtocol { 
  IMAGE(1),
  NFC(2),
  MANUAL(3);

  private int priority;

  ReadingProtocol(int priority){
    this.priority = priority;
  }

  public int getPriority(){
    return this.priority;
  }


}
