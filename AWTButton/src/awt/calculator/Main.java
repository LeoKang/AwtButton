package awt.calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends WindowAdapter{
	private Frame frame;
	private TextField tf;
	private Panel panel;
	private Button[] btnNum;
	private Button[] btnOp;

	public Main() {
		frame = new Frame("calculator");
		tf = new TextField("0");
		tf.setEditable(false);
		tf.setFocusable(false);
		panel = new Panel();
		panel.setLayout(new GridLayout(3, 0));
		panel.setBackground(Color.PINK);

		btnNum = new Button[10];
		for (int i = 0; i < btnNum.length; i++) {
			Integer intVar = i;
			btnNum[i] = new Button(intVar.toString());
			panel.add(btnNum[i]);
		}

		char arOp[] = { '+', '-', '*', '/', '=' };
		btnOp = new Button[arOp.length];
		for (int i = 0; i < arOp.length; i++) {
			btnOp[i] = new Button(arOp[i] + "");
			panel.add(btnOp[i]);
		}

		frame.add(tf, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);

		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new Main();
	}
}
