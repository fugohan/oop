import java.util.*;

public class CommandExecutor {

  private Collection<Hardware> Hardware= new List<Hardware>();
  private Collection<Command> commands = new List<Command>();

  public void runCommands(boolean continueFromLastCommand){
    String lc = loadLastCommandID();
    if(continueFromLastCommand){
      for(Command cmd: this.commands){
        if(lc.equals(cmd.getID()) && lc.equals(cmd.next.getID()) ){
          this.saveCommandId(cmd.getID());
          this.executeOnHardware(cmd);
          //Dumme Mehtode
          cmd = cmd.next();
          while(cmdhasnext !=null){
            this.executeOnHardware(cmd);
            cmd  = cmd.next();
          }
          // Effizient
          /*
          while(cmd.hasNext()){
            cmd = cmd.next();
            this.executeOnHardware(cmd);
          }*/
          Timer.waitBlocking();
        }
      }
    }
  }

  public void executeOnHardware(Command cmd){
    if(cmd != null){
      Command copy = cmd.deepCopy();
      int hid = copy.getHardwareId();
      HardwareType hty = copy.getType();

      Hardware fundus = this.findHartware(hid, hty);

      if(fundus instanceof ADC){
      int adc = ((ADC)fundus).read();
      if (adc != null) //muss abgefragt werden
        Message msg = MessageFactory.createMessage(OperationState.SUCCESS,copy,adc);
      }
      else if(fundus instanceof DAC){
        ((DAC)fundus).write(copy.getValue());
        Message msg = MessageFactory.createMessage(OperationState.SUCCESS,copy);
      }
      else if(fundus instanceof GPIO){
        //OperationType mimimi = copy.getOperationType();
        if(copy.getOperationType().equals(OperationType.READ)){
          boolean gpio = ((GPIO)fundus).read();
          Message msg = MessageFactory.createMessage(OperationState.SUCCESS,copy, copy.getValue());
        }
        else if(copy.getOperationType().equals(OperationType.WRITE)){
          boolean val =   copy.getValueAsBoolean();
          ((GPIO)fundus).write(val);
          Message msg = MessageFactory.createMessage(OperationState.SUCCESS, copy);
        }
        else {
          Message msg = MessageFactory.createMessage(OperationState.FAILED, copy);
        }

      }
      else{
        Message msg = MessageFactory.createMessage(OperationState.FAILED, copy);
      }
      Broker.GET_INSTANCE().pushMessage();


    }
  }




}
