package awt.button.eventtest;

// 2023-01-16, 

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonTest extends WindowAdapter implements ActionListener {
	private Button b;

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public ButtonTest() {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		f.setLayout(null);
		f.addWindowListener(this);

		b = new Button("확인");
		b.setSize(100, 50);
		b.setLocation(100, 75);
		b.addActionListener(this);

		f.add(b);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (b.getLabel().equals("확인")) {
			b.setLabel("취소");
		}else {
			b.setLabel("확인");
		}
	}
}
