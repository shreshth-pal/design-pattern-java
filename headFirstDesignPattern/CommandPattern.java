package headFirstDesignPattern;

public class CommandPattern {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl= new SimpleRemoteControl(4);
        Light bedroomLight=new Light("bedroom");
        Light bathroomLight=new Light("bathroom");
        CeilingFan drawingRoomFan= new CeilingFan("Drawing room");
        Setero setero=new Setero();

        simpleRemoteControl.setOnCommand(0, new LightCommandOn(bedroomLight),new LightCommandOff(bedroomLight));
        simpleRemoteControl.setOnCommand(1, new LightCommandOn(bathroomLight),new LightCommandOff(bathroomLight));
        simpleRemoteControl.setOnCommand(2,new CeilingFanCommandOn(drawingRoomFan),new CeilingFanCommandOff(drawingRoomFan));
        simpleRemoteControl.setOnCommand(3,new SeteroCommandOn(setero),new SeteroCommandOff(setero));

        simpleRemoteControl.onButtonPressed(0);
        simpleRemoteControl.onButtonPressed(1);
        simpleRemoteControl.onButtonPressed(2);
        simpleRemoteControl.onButtonPressed(3);

        simpleRemoteControl.offButtonPressed(3);
        simpleRemoteControl.offButtonPressed(2);
        simpleRemoteControl.offButtonPressed(1);
        simpleRemoteControl.offButtonPressed(0);
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
    String place;
    

    public Light(String place) {
        this.place = place;
    }

    void on(){
        System.out.println(place+" Light is on");
    }

    void off(){
        System.out.println(place+" Light is off");
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
class LightCommandOff implements Command{
    Light light;

    public LightCommandOff(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
    
} 

class Setero{
    int vol;
    String type;
    boolean isActive;

    Setero(){
        vol=0;
        type="none";
        isActive=false;
    }

    void on(){
        isActive=true;
        setDvd();
        setVolume(10);
        System.out.println("Set DvD player at vol 10");
    }
    
    void off(){
        isActive=false;
    }

    void setDvd(){
        type="dvd";
    }

    void setRadio(){
        type="radio";
    }

    void setVolume(int vol){
        this.vol=vol;
    }


}
class SeteroCommandOn implements Command{
    
    Setero setero;
    public SeteroCommandOn(Setero setero) {
        this.setero = setero;
    }
    @Override
    public void execute(){
        setero.on();
    }
}
class SeteroCommandOff implements Command{
    
    Setero setero;
    public SeteroCommandOff(Setero setero) {
        this.setero = setero;
    }
    @Override
    public void execute(){
        setero.off();
    }
}

class CeilingFan{
    boolean isActive;
    String place;
    public CeilingFan(String place) {
        isActive=false;
        this.place=place;
    }

    void on(){
        isActive=true;
        System.out.println(place +" Fan is on");
    }

    void off(){
        isActive=false;
        System.out.println(place +"Fan is off");
    }

    

}
class CeilingFanCommandOn implements  Command{
    
    CeilingFan ceilingFan;

    


    public CeilingFanCommandOn(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }




    @Override
    public  void execute(){
        ceilingFan.on();
    }
}
class CeilingFanCommandOff implements  Command{
    
    CeilingFan ceilingFan;

    


    public CeilingFanCommandOff(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }


    @Override
    public  void execute(){
        ceilingFan.off();
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