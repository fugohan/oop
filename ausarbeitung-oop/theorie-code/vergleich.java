String s = new String("hallo");
String p = new String("hallo");

if(s.equals(p)){
  System.out.print(...) //liefert true
}

if(s==p){ //liefert false
  System.out.print(...)//liefert false
}

s=p; //Zuweisung: Referenzen sind gleich, zeigen auf das selbe Objekt
if(s.equals(p)){
  System.out.print(...) //liefert true
}

if(s==p){ //liefert false
  System.out.print(...)//liefert true
}
