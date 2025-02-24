package headFirstDesignPattern;

public class CommandPattern {
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl= new SimpleRemoteControl(4);
        Light bedroomLight=new Light("bedroom");
        Light bathroomLight=new Light("bathroom");
        CeilingFan drawingRoomFan= new CeilingFan("Drawing room");
        Setero setero=new Setero();
        LightCommandOff bedroomLightCommandOff=new LightCommandOff(bedroomLight);
        LightCommandOff bathroomLightCommandOff=new LightCommandOff(bathroomLight);
        CeilingFanHighSpeed ceilingFanHighSpeed = new CeilingFanHighSpeed(drawingRoomFan);

        LightCommandOn bedroomLightCommandOn=new LightCommandOn(bedroomLight);
        LightCommandOn bathroomLightCommandOn=new LightCommandOn(bathroomLight);
        Command gnMacro[]={bedroomLightCommandOff,bathroomLightCommandOff};
        Command gmMacro[]={bedroomLightCommandOn,bathroomLightCommandOn};
        Macro goodNightMacro= new Macro(gnMacro);
        Macro goodMorningMacro =new Macro(gmMacro);
        simpleRemoteControl.setOnCommand(0, goodMorningMacro,goodNightMacro);
        simpleRemoteControl.setOnCommand(1, ceilingFanHighSpeed,new LightCommandOff(bathroomLight));
        // simpleRemoteControl.setOnCommand(2,new CeilingFanCommandOn(drawingRoomFan),new CeilingFanCommandOff(drawingRoomFan));
        // simpleRemoteControl.setOnCommand(3,new SeteroCommandOn(setero),new SeteroCommandOff(setero));
        

       System.out.println( simpleRemoteControl.toString());

        simpleRemoteControl.onButtonPressed(0);
        simpleRemoteControl.undoPressed();
        // simpleRemoteControl.onButtonPressed(1);
        // simpleRemoteControl.onButtonPressed(2);
        // simpleRemoteControl.onButtonPressed(3);

        // simpleRemoteControl.offButtonPressed(3);
        // simpleRemoteControl.offButtonPressed(2);
        // simpleRemoteControl.offButtonPressed(1);
        simpleRemoteControl.offButtonPressed(0);
        simpleRemoteControl.onButtonPressed(1);
        simpleRemoteControl.undoPressed();
    }
}

class CeilingFanHighSpeed implements Command{
    CeilingFan cf;
    int prevSpeed;
    

    public CeilingFanHighSpeed(CeilingFan cf) {
        this.cf=cf;
        prevSpeed=cf.getSpeed();
    }
    @Override
    public void execute() {
       cf.setSpeed(5);
    }

    @Override
    public void undo() {
        cf.setSpeed(prevSpeed);
    }
    
}


interface Command{

    void execute();
    void undo();
}

class Macro implements  Command{
    Command commands[];

    Macro(Command commands[]){
        this.commands=commands;
    }


    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
    
}

class noCommand implements  Command{

    @Override
    public void execute() {
    }

    @Override
    public void undo() {
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

    @Override
    public void undo() {
        light.off();
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

    @Override
    public void undo() {
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

    @Override
    public void undo() {
        setero.off();
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

    @Override
    public void undo() {
        setero.off();
    }
}

class CeilingFan{
    boolean isActive;
    String place;
    int speed;
    public CeilingFan(String place) {
        isActive=false;
        this.place=place;
        speed=0;
    }

    void on(){
        isActive=true;
        speed=5;
        System.out.println(place +" Fan is on");
    }

    void off(){
        isActive=false;
        System.out.println(place +"Fan is off");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        System.out.println("Speed has been set to"+speed);
        this.speed = speed;
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

    @Override
    public void undo() {
        ceilingFan.off();
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

    @Override
    public void undo() {
        ceilingFan.on();
    }
}
class SimpleRemoteControl {
   private Command[] onCommands;
   private Command[] offCommands;
   private Command undo;
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
        undo=onCommands[slot];
    }

    public void offButtonPressed(int slot){
        offCommands[slot].execute();
        undo=onCommands[slot];    }

    public void undoPressed(){
        undo.undo();
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