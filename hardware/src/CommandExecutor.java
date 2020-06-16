public class CommandExecutor {

  // Sequenzdiagramm 1 executeOnHardware(cmd: Command)

  // Sequenzdiagramm 2 runCommands(boolean continueFromLastCommand)

    public void runCommands(boolean continueFromLastCommand){
        boolean resume = continueFromLastCommand;
        String lastId = this.loadLastCommandId();
        if(lastId.equals(null))
            break();
        for (Command temp: this.commands){
            if(resume.equals(true)){
                if(lastId.equals(temp.next())){
                    String this_id = temp.next();
                    this.saveCommandId()
                }
            }
            String this_id = temp.getID();

            this.saveCommandId(this_id);
            this.executeOnHardware(temp);
            this.next();
            //SUBCOMMANDS?
            //END SUBCOMMANDS
            Timer wait = new Timer();
            wait.waitBlocking();

        }

    }

    public void executeOnHardware( ){

    }

}
