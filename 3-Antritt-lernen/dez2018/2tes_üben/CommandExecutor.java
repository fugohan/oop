import java.util.*;

public class CommandExecuter {
  private Collection<Hardware> hardware;
  private Collection<Command> commands;

  public void executeOnHardware (Command cmd){
    if(cmd != null){
      Command copy = cmd.deepCopy();
      int hid = copy.getHardwareId();
      HardwareType hty = copy.getType();
      Hardware hw= this.findHardware(hid, hty);
try{
      if(hty.equals(HardwareType.ADC) && hw instanceof ADC){

        int adc = ((ADC)hw).read();


        Message msg = MessageFactory.createMessage(OperationState.SUCESSFUL, cmd,adc);
      }
      else if(hw instanceof DAC){

        ((DAC)hw).write(cmd.getValue());

        Message msg = MessageFactory.createMessage(OperationState.SUCESSFUL, cmd);
      }
      else if(hw instanceof GPIO){
        if( cmd.getOperation().equals(OperationType.READ)){

            boolean adc = ((GPIO)hw).read();
            int val=0;
            if(adc)
              val = 1;

          }

            Message msg = MessageFactory.createMessage(OperationState.SUCESSFUL, cmd, val);
        }
        else if(cmd.getOperation).equals(OperationType.WRITE){
          boolean cmb = cmd.getValueAsBoolean();
          ((GPIO)hw).write(cmb);
          Message msg = MessageFactory.createMessage(OperationState.SUCESSFUL, cmd);
        }
      }
      catch(HardwareException e){}
      else{
        Message msg = Message.createMessage(OperationState.FAILED,cmd);
      }
      Broker.GET_INSTANCE().pushMessage(msg);
    }

    }

    public void runCommands(boolean continueFromLastCommand){
      String lid = this.loadLastCommandId();
      for(Command cmd = commands){
        if(continueFromLastCommand && lid.equals(cmd.getId()) && cmd.next().getId().equals(lid)){
          this.saveCommandId(cmd.getId());

          this.executeOnHardware(cmd);
          cmd = cmd.next();

          while(cmd.getId().equals(lid) && cmdn !=null){
            this.executeOnHardware(cmdn);
            cmd = cmd.next();
          }
          Timer.waitingBlocking();
        }
      }
    }

}
