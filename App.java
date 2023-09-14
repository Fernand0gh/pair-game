import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    MyButton[] buttons = GameLogic.createButtons(12);
    int buttonsPressed = 0;
    int[] lastPairPressed = new int[2];
    public App(){
        super("Pair Game!");
        makeGUI();
        makeListeners();
    }

    public void makeGUI(){
        setSize(900, 800);
        setResizable(false);
        setLayout(new GridLayout(0, 3));

        for(JButton btn : buttons){
            add(btn);
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void makeListeners(){
        for(MyButton btn : buttons){
            btn.addActionListener(this);
        }
    }

    public static void main(String[] args) {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton aux = (MyButton) e.getSource();
        int index = aux.getId();
        buttonsPressed++;
        lastPairPressed[buttonsPressed - 1] = index;

        buttons[index].setResizedImage(buttons[index].getRevealed_image());

        if(buttonsPressed == 2){
            try{
                Thread.sleep(150);
            }catch(Exception x){
                //
            }

            paint(this.getGraphics());

            try{
                Thread.sleep(500);
            }catch(Exception x){
                //
            }

            GameLogic.checkPair(buttons[lastPairPressed[0]], buttons[lastPairPressed[1]]);
            buttonsPressed = 0;

            if(GameLogic.guesses == buttons.length / 2){
                int totalMoves = GameLogic.guesses + GameLogic.failures;
                if(GameLogic.failures == 0){
                    JOptionPane.showMessageDialog(this,"You won with a perfect score!");
                }else{
                    JOptionPane.showMessageDialog(this,"You Won in " + totalMoves + " attempts!");
                }
            }
        }
    }
}
