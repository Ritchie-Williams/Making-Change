import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;

    public RegisterPanel() {
        this.register = new Register();
        this.input = new JTextField(15);
        this.changePanel = new PursePanel();

        // Set up the panel layout
        setLayout(new BorderLayout());

        // Create input panel for user to enter an amount
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Amount:"));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.NORTH);

        // Add the PursePanel to display results
        add(changePanel, BorderLayout.CENTER);

        // Handle input events
        input.addActionListener(new InputListener());
    }

    // Event listener for input field
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount); // Calculate the change
                changePanel.setPurse(purse); // Update the PursePanel with the new purse
            } catch (NumberFormatException ex) {
                ex.printStackTrace(); // Handle invalid input
            }
        }
    }
}
