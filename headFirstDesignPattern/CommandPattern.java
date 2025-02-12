package headFirstDesignPattern;

public class CommandPattern {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl= new SimpleRemoteControl(3);
        Light light =new Light();
        
    }
}

interface Command{

    void execute();
}

class noCommand implements  Command{

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        System.out.println("Nothing done");
    }

}


class  Light{

    void on(){
        System.out.println("Light is on");
    }

    void off(){
        System.out.println("Light is off");
    }
}

class LightCommandOn implements Command{
    Light light;

    public LightCommandOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
    
} 


class SimpleRemoteControl {
   private Command[] onCommands;
   private Command[] offCommands;
   private int cnt;

    public SimpleRemoteControl(int cnt) {
        onCommands = new Command[cnt];
        offCommands = new Command[cnt];
        this.cnt=cnt;
        for(int i=0;i<cnt;i++){
            onCommands[i]=new noCommand();
            offCommands[i]=new noCommand();
        }


    }
    
    public void setOnCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot]=onCommand;
        offCommands[slot]=offCommand;
    }

    
    public void onButtonPressed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonPressed(int slot){
        offCommands[slot].execute();
    }

    @Override
   public String toString(){
    StringBuffer sb=new StringBuffer();

        sb.append("\n--------Welcome to the remote--------\n");
        for (int i = 0; i < cnt; i++) {
            sb.append("slot ").append(i).append("\n On Command:\n").append(onCommands[i].getClass().getName()).append("\n Off Command:\n").append(onCommands[i].getClass().getName());
        }
        
        return sb.toString();

    }   



}