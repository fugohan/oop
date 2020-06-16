public class CompositeVertex<T extends Vertex, E extends BehavioralModel<T>> extends Vertex{

  /*
  Ja macht sinn

  */

  //private T region;
  private E BehavioralModel;
  public CompositeVertex(String id){
    super(id); // Spar-Pause ab 11:44 // essen ab 12:02, ivan ist jz auch da aber geht essen, also immer noch pause yes so 10 - 15 minn, kk
    BehavioralModel = null;
  }

  /*
      was machst du aber wenn dir getInitialVertex keinen InitalVertex zurückgibt, oder gibt das immer einen InitalVertex zurück?
      DAnn mache ich nichts, ich glaube das gibt immer einen InitalVertex zurück sofern es einen gibt
      Ja hätte ich auch gesagt, aber wenn es keinen gibt dann soll ja nix gemacht werden lat CV-Klassen Beschreibung
      ich denke wenn im BehavioralModel kein InitalVertex vorhanden ist gibt getInitialVertex null zurück, aber das steht nicht in der Angabe, da würde ich dann bei der Prüfung wahrscheinlich nachfragen
      true
  */
  protected void runInternal(){ //TRY CHATCH FEHLT , yes
    try{
      //  this.getBehavioralModel().getInitialVertex().run();
        this.getBehavioralModel().run();
      }
    catch(NoInitialVertexException e){
      //Bitte programm mache nix
    }
  }


}
