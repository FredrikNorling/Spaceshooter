package Game;
import javax.swing.*;

public class frame {
    public static void main(String[] args) {
        new frame();
    }

    public frame() {
        JFrame f = new JFrame("TicTacToe");
        Window w = new Window();
        f.setBounds(150,0,1080,720);
        f.add(w);
        f.addKeyListener(w);
        f.setVisible(true);
        System.out.println(w.getBounds());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
