import java.util.*;

public abstract class Vertex extends ModelElement {
  private Vertex nextVertex;
  private String id;

  public Vertex(String id){
    this.id = id;
  }

  /* Fehler in der Angabe
  Vertex besitzt die Methode getID und gibt einen  String zurück
  */
/*
Comments
es gibt ne Methode die alle Vertexes in so einem Model in eine liste hinzuügt, die steht in der Angabe

Aber es die gibt mir eine Liste von ModelElement zurück
und was ist mit addVertexesToList das is ne void Methode

Ist das wirklich ihr ernst?
*/
  public void addVertexToList(List<? super Vertex> list){
    if(list != null){
      list.add(this);

      if(this instanceof CompositeVertex){
        ((CompositeVertex<?,?>)this).getBehavioralModel().addVertexesToList(list);
      }

    }

    //end bracked
  }

  public boolean equals(Object obj){
    if(obj != null){
      if( obj.getClass() == this.getClass()){
       if(this.id.equals( ((Vertex(obj)).getId()) ) ) //getId gibt es nicht   Doch gibt es die haben es vergessen hinzuzufügen und es in der Prüfung gesagt. OK?
          return true;
      }


    }

    //end Method
    return false;
  }
//end bracked
}
