package rbvs.record;

public abstract class Record extends Object implements IRecord {
    private long id;
    public Record(long identifier){
        this.id = identifier;
    }
    public long getIdentifier(){
        return this.id;
    }
}
