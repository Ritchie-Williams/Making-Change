//Ritchie Williams
//Lab 1 Making Change
//08 - 27 - 24
//Side note I know I can import *, but I like making sure the imports are there lol



import javax.swing.JFrame;

public class MakingChange {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 786);
        frame.add(new RegisterPanel());
        frame.setVisible(true);
    }
}

