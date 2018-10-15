package ua.od.hillel.lesson_31_patterns.behavioral.command;

public class TurnOnLightCommand implements Command{
    private Light theLight;

    public TurnOnLightCommand(Light light){
        this.theLight=light;
    }

    public void execute(){
        theLight.turnOn();
    }
}
