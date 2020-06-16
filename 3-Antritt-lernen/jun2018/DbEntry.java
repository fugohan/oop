package core;

public class DbEntry<E extends Serializable> extends Json<E> {
  private LocalDateTime date;
  private String identifier;
  private E meterValue;
  private ReadingProtocol protocol;

  public DbEntry(String id, E value, ReadingProtocol p){
    this.identifier = id;
    this.meterValue = value;
    this.protocol = p;
    this.date = LocalDateTime.now();
  }
  public static DbEntry<String> createFrom(String info) throws JsonException{
    HashMap<String,String> map;
    map = DbEntry.split(info);
    String id = map.get("ID");
    String value = map.get("VALUE");
    String protocol = map.get("PROTOCOL");
    ReadingProtocol prot = ReadingProtocol.valueOf(protocol);

    if(id != null && value != null, protocol!=null){
      DbEntry<String> newEntry = new DbEntry(id,value,prot);
    }
    else{
      throw new JsonException();
    }
  }

  public boolean equals(Object obj){
    if(obj != null && obj instanceof String){
      if(this.equals((String)obj)){
        return true;
      }
    }
    if(obj != null && obj instanceof DbEntry){
      if(this.identifier.equals(((DbEntry)obj).getIdentifier())){
        return true;
      }
    }
    return false;
  }
}
