public class TicketTerminal   {
  private String terminalLocation;
  private EnterpriseServer server;
  private UserInterface ui;

  TicketTerminal(String location){
    this.terminalLocation = location;
    this.enterpriseServer = EnterpriseServer.getInstance();
    this.ui = UserInterface.getInstance();
  }
  public void run(PaymentCard card){
    //Sequenzdiagramm
    List<Connection> l = new List<Connection>();
    String origin = terminalLocation;
    String destination = null;
    Connection mn = null;

      do{
        try{
        l = server.getConnections(origin,destination);

        mn = ui.selectConnection(l);
        origin = mn.getDestination();
      }
      catch(NoConnectionsException e){
        ui.display(UIMessage.NO_Connection)
        return;
        }
      }
      while(mn != null){
      }
      Discount dis = ui.getDiscount();
      ui.display(UIMessag.GET_CONFIRMATION);
      boolean conf = ui.getConfirmation();
      try{
        this.server.createTicket(l,card,dis);
      }
      //Catches
      catch(PaymentException e){
        ui.display(UIMessage.PAYMENT_FAILED);
      }
      ui.display(UIMessage.CONFIRM_BOOKING);
    }
    public void checkTicketSegment(String ticketcode, String destination){
    try{
      if(
        this.server.checkTicket(terminalLocation,destination, ticketcode)
        )
          ui.display(UIMessage.TICKET_DEVALUED);
        else
          ui.display(UIMessage.TICKET_INVALID);
    }
    catch(TicketException e){
      ui.display(UIMessage.NO_TICKET)
    }
    }
  }

}
