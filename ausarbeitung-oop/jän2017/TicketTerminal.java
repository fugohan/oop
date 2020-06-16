public class TicketTerminal{
private String terminalLocation;
private EnterpriseServer enterpriseServer;
private UserInterface ui;

public TicketTerminal(String location){
  this.terminalLocation = location;
  this.enterpriseServer = EnterpriseServer.getInstance();
  this.ui = UserInterface.getInstance();
}
/*
  Im Prüfungsbogen abgedruckt

  public static void main(String[] arg){
    TicketTerminal t = new TicketTerminal("Venedig");
    t.run();
  }

*/

public void run(){
  //create Ticket
  //Checkticket
try{
  Collection<Connection> l = this.enterpriseServer.getConnections(terminalLocation,null);
}
catch(NoConnectionException e)
{
  ui.display(e.getMessage());
}
  Connection c = ui.selectConnection(l);
  PaymentCard p = ui.getPaymentCard();
  int d;
  if (c instanceof FerryConnection){
    d = ((FerryConnection)c).getDistance();
  }
  float price = enterpriseServer.getPrice(d,Discount.NO_DISCOUNT);
  ui.display("Der Ticketpreis ist € "+ price.toString()+"." );
  float price = enterpriseServer.getPrice(d,ui.getDiscount());
  ui.display("Der Ticketpreis ist € "+ price.toString()+". Wollen Sie das Ticket kaufen?" );


  if(ui.getConfirmation()){
    try{
    Ticket t=enterpriseServer.createTicket(c,p,ui.getDiscount());
  }
  catch(PaymentException e){
    ui.display("Fehler: Die Karte zur Bezahlung ist ungültig.");
  }
    String x = t.getTicketcode();
    ui.display("Ihr Ticket wurde gebrucht. Ihr Ticket-Code lautet: "+x );


  }
  try{
  if(  enterpriseServer.checkTicket(this.terminalLocation, t.getTicketcode()))
    ui.display("Das Ticket ist gültig und wurde entwertet");
  else
    ui.display("Das Ticket ist bereits entwertet");
  }
  catch(NoTicketException e){
    ui.display("Es wurde kein Ticket mit dem Ticketcode gefunden");
  }


  }
}

//bin wieder da
//run ist diesmal irgendwie lustiger xD
//ich hab grad einmal FerryConnection fertig
//macht ihr auch nachher die fehlersuche und das gear?
//Ja ok



/*
preis ist 88 Wollen kaufen?
preis ist 77 wollen kaufen?
schreib mir wenn ihr fertig mit dem Programm seit und mit den anderen dingen anfängt?
Nachricht bitte in Telegramm
noch da??

kk 
*/
