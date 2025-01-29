package java;

public class GreetingsChooser {
    private String[] greetings = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int i;

    public GreetingsChooser(){

    }

    public String NextGreeting(){
        if(i >= greetings.length) i = 0;
        return greetings[i++];
    }
}
