import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.Random;

class Vindu extends JFrame {
	public Vindu(String tittel) {
		setTitle(tittel);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tegning tegningen = new Tegning();
		add(tegningen);
	}
}

class Tegning extends JPanel {
	private Random random = new Random();
	private int maksXverdi;
	private int maksYverdi;
	private int antLinjer = 10;


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);

		// Random-art (Try resizing)
		/*
		int startX = random.nextInt(getWidth()-1);
		int startY = random.nextInt(getHeight()-1);
		int x = 0;
		int y = 0;
		int forrigeX = 0;
		int forrigeY = 0;

		g.setColor(Color.WHITE);
		for (int i = 0; i < antLinjer; i++) {
			forrigeX = x;
			forrigeY = y;
			x = random.nextInt(getWidth()-1);
			y = random.nextInt(getHeight()-1);
			if (i == 0) {
				g.drawLine(startX, startY, x, y);
				g.drawOval(startX - 10, startY - 10, 20, 20);
			} else {
				g.drawLine(forrigeX, forrigeY, x, y);
			}
			if (i % 2 == 0) {
				g.fillOval(x-10, y-10, 20, 20);
			} else {
				g.drawOval(x-10, y-10, 20, 20);
			}

		}
		g.drawLine(forrigeX, forrigeY, startX, startY);
		*/

		// Smiley
		g.setColor(Color.YELLOW);
		g.fillOval(50, 50, 400, 400);
		g.setColor(Color.BLACK);
		g.fillOval(150,150, 100, 100);
		g.fillOval(350,150, 100, 100);
		g.drawArc(170, 90, 300, 300, 225, 70);
		g.drawLine(300, 200, 350, 300);
		g.drawLine(350, 300, 300, 300);
		Font bart = new Font("Arial", Font.PLAIN, 200);
		g.setFont(bart);
		g.drawString("=", 250, 410);
		g.drawString("-", 150, 180);
		g.drawString("-", 370, 180);
		g.fillArc(100, 30, 300, 100, 0, 180);
		g.setColor(Color.WHITE);
		g.drawArc(100, 30, 300, 100, 0, 180);
		g.setColor(Color.BLACK);
		g.fillRect(70, 70, 350, 40);
		g.setColor(Color.WHITE);
		g.drawRect(70, 70, 350, 40);
	}
}

class Smiley {
	public static void main(String[] args) {
		Vindu etVindu = new Vindu("Smilefjes");
		etVindu.setVisible(true);
	}
}
