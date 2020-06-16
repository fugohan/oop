public class EnterpriseServer {
  private Collection<Ticktet> tickets = new ArrayList<>();
  private static EnterpriseServer server;
  private Collection<Connection> connections = new ArrayList<>(); //<> mit oder ohne typ?

  private EnterpriseServer(){


    if(server != null)
      return server;
    else{
      server = new EnterpriseServer();
      this.connections.add(new FerryConnection("Venedig", "Bari", 500));
      this.connections.add(new FerryConnection("Venedig", "dub...", 800));
      this.connections.add(new FerryConnection("Venedig", "Izmir", 1700));
      return server;
    }
  }


public Collection<Collection> getConnections(String origin, String dest) throws NoConnectionException{
  Collection<Collection> l = new ArrayList<>();
  if(origin != null){
    if(dest != null){
      for(Connection connection: connections){
        if( connection instanceof FerryConnection){ //Cast sollte unnötig sein
          if( (FerryConnection)connection.checkConnection(origin,dest));
            l.add(connection);
          }
      }
      if(l.isEmpty())
        throw new NoConnectionException("Fehler: Leider konnte keine Verbindung ausgehend von "+origin+" gefunden werden.");
      return l;
    }
    else{
      for(Connection connection: connections){//Cast sollte unnötig sein, weil abstrakte Classe diese schon vorraussetzt
        if( connection instanceof FerryConnection){
          if( (FerryConnection)connection.compareOrigin(origin));
            l.add(connection);
          }
      }
      if(l.isEmpty())
        throw new NoConnectionException("Fehler: Leider konnte keine Verbindung ausgehend von "+origin+" gefunden werden.");
      return l;;
    }
  }
  else{
    throw new NoConnectionException("Fehler: Leider konnte keine Verbindung ausgehend von "+origin+" gefunden werden.");
  }
}

  public Ticket createTicket(Connection connection, PaymentCard card, Discount discount)throws PaymentException{
    float price = 0;
    String ticketCode = "";
    boolean payment;
    Ticket ticket;
    if(connection!=null&&card!=null&&discount!=null){
      if(connection instanceof FerryConnection){
        price += this.getPrice( ((FerryConnection)connection).getDistance(),discount);
      }
    ticketCode = this.generateTicketcode();
    if(card instanceof ATMCard){
      payment = BankServer.checkATMCard( (ATMCard)card);
    }
    if(card instanceof CreditCard){
      payment = BankServer.checkCreditCard( (CreditCard)card);
    }
    if (payment) {
      ticket = new Ticket(ticketCode,price, discount,connection);
      ticket.setPaymentCard(card);
      return ticket;
    }
    else{
      throw new PaymentException();
    }
   }
   else{
     throw new PaymentException();
   }
  }

  public boolean checkTicket(String origin, String ticketcode) throws NoTicketException{
    if(origin != null && ticketcode != null){
      for ( Ticket ticket:tickets ){
        String ticketcodeH = ticket.getTicketcode();
        Connection connectionH = ticket.getConnection();
        if(ticketcodeH.equals(ticketcode)){
          if(connectionH.compareOrigin(origin)){
            if(ticket.isValid()){
              return ticket.devalueTicket(ticketcode);
            }
            else{
              return false;
            }
          }
        }
      }
    }
    throw new NoTicketException();
  }
}
