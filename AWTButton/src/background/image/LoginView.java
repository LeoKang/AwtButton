package background.image;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class LoginView extends JFrame implements ActionListener {
	BufferedImage img = null;
	Button btn;

	public LoginView() {
		setTitle("배경화면 테스트");

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(480, 640);
		layeredPane.setLayout(null);

		try {
			img = ImageIO.read(new File("D:\\awt\\drum1.jpg"));
		} catch (IOException e) {
			System.out.println(e);
		}

		btn = new Button("BUTTON");
		btn.setSize(100, 50);
		btn.setLocation(150, 250);
		layeredPane.add(btn);

		MyPanel panel = new MyPanel();
		panel.setSize(480, 640);
		layeredPane.add(panel);

		setLayout(null);
		add(layeredPane);

		setBounds(720, 220, 480, 640);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class MyPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

	public static void main(String[] args) {
		new LoginView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
