import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton{
    public int id;
    public static final String DEFAULT_IMAGE = "assets\\0.png";
    private String revealed_image;
    private int width, height; //size of the image inside the button

    public MyButton(String image, int width, int height){
        this.revealed_image = image;
        this.width = width;
        this.height = height;
        this.setResizedImage(DEFAULT_IMAGE);
    }

    private ImageIcon resizeImage(String image){
        ImageIcon aux = new ImageIcon(image);
        return new ImageIcon(aux.getImage().getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH));
    }

    public void setResizedImage(String image){
        this.setIcon(resizeImage(image));
    }

    public void disableButton(){
        this.setEnabled(false);
        this.setDisabledIcon(resizeImage(revealed_image));
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getRevealed_image(){
        return this.revealed_image;
    }

    public boolean isEqual(MyButton btn){
        return this.revealed_image.equals(btn.getRevealed_image());
    }
}
