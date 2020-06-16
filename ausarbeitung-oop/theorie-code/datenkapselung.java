public class key{
  public int pubkey; //Datenkapselung verletzt
  private int prikey; //Datenkapselung intakt

  public key(){}
  //Kontrollierte Zugriff
  public int getKey(){
    return prikey;
  }
  public void setKey(int prikey){
    this.prikey = prikey;
  }
  //end Kontrollierter Zugriff

}
