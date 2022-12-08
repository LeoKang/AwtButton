package awt.dialog;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest implements ActionListener {
	private Dialog info;
	
	DialogTest() {
		Frame f = new Frame("parent");
		f.setSize(300, 200);
		f.setLocation(2300, 50);

		info = new Dialog(f, "Information", true);
		info.setSize(140, 90);
		info.setLocation(2250, 50);
		info.setLayout(new FlowLayout());

		Label msg = new Label("This is model dialog", Label.CENTER);
		Button ok = new Button("OK");
		ok.addActionListener(this);
		info.add(msg);
		info.add(ok);

		f.setVisible(true);
		info.setVisible(true);
	}

	public static void main(String[] args) {
		new DialogTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("OK")) {
//			System.exit(0);
			info.dispose();
		}
	}
}
