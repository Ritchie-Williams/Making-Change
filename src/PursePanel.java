import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;


    public PursePanel() {
        this.purse = new Purse(); // Initialize with an empty purse
        setBackground(java.awt.Color.WHITE); // Set a white background
    }

    // Set the purse and trigger a repaint
    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    // Paint the contents of the purse
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel

        if (purse != null) {
            // Iterate over the purse's denominations and draw each denomination
            int x = 10;
            int y = 20;

            for (Map.Entry<Denomination, Integer> entry : purse.getCashEntries().entrySet()) {
                Denomination denomination = entry.getKey();
                int count = entry.getValue();

                // Draws the denomination name and count
                g.drawString(denomination.name() + ": " + count, x, y);

                // Loads the image for the denomination
                try {
                    Image img = ImageIO.read(new File(denomination.img()));
                    for (int i = 0; i < count; i++) {
                        g.drawImage(img, x, y + 20, null); // Draw image below the text
                        y += img.getHeight(null) + 10; // Adjust y position after each image
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                y += 30; // Adjust y position for the next denomination
            }
        }
    }
}
