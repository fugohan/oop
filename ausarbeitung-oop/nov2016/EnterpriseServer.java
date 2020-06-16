public class EnterpriseServer {
  private List<Connection> connections;
  private EnterpriseServer server;
  private List<Ticket> tickets;

  public Ticket createTicket(List<Connection> connections, PaymentCard card, Discount discount) throws PaymentException {
    if(connections != null && discount != null){
      if(card != null){
        float price = 0;
        for(Connection temp : connections){
          if(temp instanceof FerryConnection){
            price += this.getPrice((FerryConnection)temp.getDistance(),discount);
          }
        }
        Ticket tik = new Ticket(this.generateTicketcode(), price, discount);
        for(Connection temp : connections){
          if(temp instanceof FerryConnection){
            tik.addConnection((FerryConnection)temp);
          }
        }
        if( card instanceof ATMCard){
          if(BankServer.checkATMCard((ATMCard)card)){
            tickets.add(tik)
            return tik;
          }
        }
        if( card instanceof CreditCard){
          if(BankServer.checkATMCard((CreditCard)card)){
            tickets.add(tik)
            return tik;
          }
        }
      }

        throw new PaymentException(card);

    }

  }
  public boolean checkTicket(String origin, String dest, String ticketcode) throws TicketException{
    if(origin != null && dest != null && ticketcode !=null){
      for (Ticket temp:tickets){
        String tc = temp.getTicketcode();
        if(tc.equals(ticketcode)){
        boolean isexpired = temp.isExpired();
        if(isExpired){
        List<Connection> hans = temp.getConnections();
        for(Connection kinder_von_hans: hans){
          boolean wahr = kinder_von_hans.checkConnection(origin,dest);
          boolean wahrnicht = temp.devalueConnection(tc,kinder_von_hans);
          if(wahr){
            if(wahrnicht){
              return true;
            }
            else{
              return false;
            }
          }
          else{
            throw new TicketException();
            }
          }
        }
        else{
          return false;
        }
      }
    }
    }
    throw new TicketException();
  }
  public List<Conection> getConnections(String origin, String dest) throws NoConnectionsException{
    List<Connnection> l = new List<Connection>;

    if(origin != null){
      if(dest == null){
        for(Connection kim: connections){
          if(kim.comopareOrigin(origin))
            l.add(kim);
        }
        if(l.isEmpty().false())
          throw new NoConnectionsException();
        return l;
      }
      else if (dest!=null){
        for(Connection jim:connections){
          if(jim.checkConnection(origin,dest))
          l.add(jim);

        }
        if(l.isEmpty().false())
          throw new NoConnectionsException();
        return l;
      }
    else{

      }
    }

    return l;

  }
}
