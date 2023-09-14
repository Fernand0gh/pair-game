import java.util.Random;

public class GameLogic {
    public static int guesses = 0;
    public static int failures = 0;
    public static MyButton[] createButtons(int n){
        MyButton[] buttons = new MyButton[n];
        int halfSize = buttons.length/2;
        for(int i = 0; i < halfSize; i++){
            buttons[i] = new MyButton("assets\\" + (i+1) + ".jpeg", 200, 200);
            buttons[i + halfSize] = new MyButton("assets\\" + (i+1) + ".jpeg", 200, 200);
        }
        return shuffleButtons(buttons);
    }

    private static MyButton[] shuffleButtons(MyButton[] buttons){
        Random random = new Random();
        //switch 2 buttons
        for(int i = 0; i < buttons.length; i++){
            int rnd = random.nextInt(buttons.length - 1);
            MyButton aux = buttons[i];
            buttons[i] = buttons[rnd];
            buttons[rnd] = aux;
        }
        //fix modified ids
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setId(i);
        }
        return buttons;
    }

    public static void checkPair(MyButton btn1, MyButton btn2){
        if(btn1.isEqual(btn2)){
            btn1.disableButton();
            btn2.disableButton();
            guesses++;
            return;
        }
        failures++;
        btn1.setResizedImage(MyButton.DEFAULT_IMAGE);
        btn2.setResizedImage(MyButton.DEFAULT_IMAGE);
    }
}
