package rbvs;

import javafx.scene.control.Tab;

public class Table extends Object{

    private String id;
    private int seats;

    Table(String id){
        this.id = id;
        this.seats= 0;
    }
    Table(String id, int seats){
        this.id = id;
        this.seats = seats;
    }

    public boolean equals(Object obj){
        Table temp = (Table)obj;
        if(this.id == temp.getTableIdentifier()){
            if(this.seats==temp.getSeatCount());
                return true;
        }
        return false;
    }
    public String getTableIdentifier(){
        return this.id;
    }

    public int getSeatCount(){
        return this.seats;
    }
    public void setSeatCount(int seatCount){
        this.seats = seatCount;
    }
    public String toString(){
        return "ID:" + this.getTableIdentifier() + " Seats:" + this.getSeatCount();
    }
}
