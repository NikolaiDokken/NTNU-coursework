import javax.swing.*;
import java.awt.*;

public class SmileyApplet extends JApplet {
	public void init() {
		add(new Tegning());
	}
}

class Tegning extends JPanel {
	public void paintComponent(Graphics tegneflate) {
		super.paintComponent(tegneflate);
		setBackground(Color.LIGHT_GRAY);
		tegneflate.setColor(Color.YELLOW);
		tegneflate.fillOval(50, 50, 400, 400);
		tegneflate.setColor(Color.BLACK);
		tegneflate.fillOval(150,150, 100, 100);
		tegneflate.fillOval(350,150, 100, 100);
		tegneflate.drawArc(170, 60, 300, 300, 225, 70);
		tegneflate.drawLine(300, 200, 350, 300);
		tegneflate.drawLine(350, 300, 300, 300);
	}	
}
