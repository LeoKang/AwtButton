package awt.login;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldTest {
	public static void main(String[] args) {
		String STRING_ID = "seungjin";
		String STRING_PWD = "green1234";
		
		Frame f = new Frame("Login");
		f.setSize(400, 105);
		f.setLayout(new FlowLayout());

		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);
		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');
		
		TextField tfMsg = new TextField(45);
		tfMsg.setEditable(false);
		tfMsg.setFocusable(false);
		
		Button b = new Button("Login");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(id.getText().equals(STRING_ID) && pwd.getText().equals(STRING_PWD)) {
					tfMsg.setText("로그인이 되었습니다.");
				}else {
					tfMsg.setText("다시 입력하세요.");
				}
			}
		});
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(b);
		f.add(tfMsg);
		f.setVisible(true);
	}
}
