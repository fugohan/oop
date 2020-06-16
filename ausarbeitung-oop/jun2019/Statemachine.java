/*
  was ist mit extends BehavioralModel im Klassenkopf?

  True hab ich nicht drauf geachtet ...

  im Klassendiagrann ist kein Konstruktor definiert!!!!!!!!!!

  Aber auf seite 1 steht header = header + Konstruktor + attribute

  wenn man keinen Konstruktor definiert ist automatisch ein default Konstruktor vorhanden der eh leer ist


  Brauch grad länger muss das richtig durchdenken

  Meiner Meinung nach kann man mit dieser Angabe die Methode nicht korrekt implementieren wenn man sich das logisch
  durchdenkt

  noch da?
  Bin wieder da

  Ja bin da aber ich bin mega verwirrt


*/

//weil die Superklasse eh auch der Generic extend Vertex steht, und ich nicht genau weiß welcher Vertex verwendet wird

//man verwendet ja in Statemachine den Platzhalter noch deswegen kann bei der Superklasse der Generic S stehen bleiben

// Passt dann lag ich eh richtig
// man muss nur die Typen explizit angeben wenn die Platzhalter nicht mehr in Klasse vorkommen

public class Statemachine<S extends Vertex> extends BehavioralModel<S>{ // S oder Vertex und warum ?  hier!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

/* Sollte aber kein Fehler sein ...
  public Statemachine(){

    super(); //Müsste leer sein
  }*/
  //end Bracked

  public boolean addVertex(S vertexToAdd,S afterVertex){
      //this.getBehavioralModel().add(vertexToAdd);
  //if(vertexToAdd != null && afterVertex != null){
      this.getModelElements().add(vertexToAdd);
      for (S vertex:getModelElements()){
        if(vertex.equals(afterVertex){
          if( vertex.getNextVertex()!=null){
          vertexToAdd.setNextVertex(vertex.getNextVertex());
        }
        vertex.setNextVertex(vertexToAdd);

      }
      if(vertex instanceof CompositeVertex){
        ((CompositeVertex)vertex).getBehavioralModel().addVertex(vertexToAdd,afterVertex);
      }
    //}
  }
  return false;
}
  /*
    wie kann ich helfen?

    Run hat kein SQ :/

    es steht eh in der Beschreibung was es genau macht

    yes

    und der ExceptionName gibt auch einen Hinweis was man verwerden muss
  */
  public void run() throws NoInitalVertexException{
    //ja schon aber ... ich bin verwirrt heute :/
    try{
      this.getInitialVertex().run(); // diese Methode wirft keine Exception, warum glaubst du das? steht nicht in der Angabe

    }
    catch(NoInitalVertexException temp){
      throw new NoInitialVertexException(temp);
    //  throw temp;//  wirft MEthode weiter
    }
// http://i.imgur.com/iqGKLYfl.png


  //  InitialVertex.run... //das ist nicht statisch I Know aber Ivan hat ein eFrage gerade, Hier oben ^ hallo? wo? //Zeile 26
  /* so hab ich es geschrieben
  if(this.getInitalVertex() != null)
    {
        try
        {
            this.getInitalVertex().run;/// <--- run() , ja aber das ist run() von Vertex und nicht von BehavioralModel
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
   //Han meint man muss nicht unbedingt eine Werfen weil getInitialVertex eine wirft und man kann diese WEiterleiten
                                            // getInitalVertex wirft nix, sorry die wirft doch

     So nun überarbeitet
  */
  }
}
//Zeile 26
