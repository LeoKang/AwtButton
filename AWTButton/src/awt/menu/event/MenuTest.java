package awt.menu.event;

import java.awt.*;
import java.awt.event.*;

public class MenuTest extends Frame {
	MenuBar mb;
	Menu file, color, sub_color, mEvent;
	MenuItem miOpen, miSave, miExit, miYellow, miGray;
	Label lb;

	public MenuTest() {
		super("MenuTest");
		// 1. 메뉴바 생성--------
		mb = new MenuBar();
		setMenuBar(mb); // 메뉴바를 프레임에 부착
		// 2. 메뉴생성 및 부착
		file = new Menu("파일");
		mb.add(file);
		// 3. 메뉴 아이템 생성 및 부착
		miOpen = new MenuItem("열기");
		MenuShortcut ms = new MenuShortcut('S'); // 단축키
		miSave = new MenuItem("저장", ms);
		miExit = new MenuItem("종료", new MenuShortcut('X', true)); // true=> shift키와 함께 사용

		file.add(miOpen);
		file.add(miSave);
		file.addSeparator(); // 메뉴 아이템에 분리선 주기...
		file.add(miExit);
		// 리스너 부착
		MyHandler my = new MyHandler();
		miOpen.addActionListener(my);
		miSave.addActionListener(my);
		miExit.addActionListener(my);

		color = new Menu("색상");
		mb.add(color);
		miYellow = new MenuItem("노 랑");
		miGray = new MenuItem("회 색");
		color.add(miYellow);
		color.add(miGray);
		color.addSeparator();

		sub_color = new Menu("글자색");
		color.add(sub_color);
		sub_color.add("빨강");
		sub_color.add("파랑");

		mEvent = new Menu("mEvent");
		mb.add(mEvent);

		lb = new Label("안녕하세요?", Label.CENTER);
		add(lb, "South");
		// 색상 메뉴 관련 리스너 부착
		miYellow.addActionListener(my);
		miGray.addActionListener(my);
		sub_color.addActionListener(my);
		mEvent.addActionListener(my);
	}// 생성자-----

	class MyHandler implements ActionListener {
		Color bgCr = Color.white;
		Color fntCr = Color.black;

		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			String cmd = e.getActionCommand();
			if (obj == miOpen) {
				// 파일 대화상자 열기
				// 1>FileDialog 객체 생성해서 FileDialog(Frame parent)
				// FileDialog fd = new FileDialog(fr=new Frame());
				// 새로운 프레임을 생성하면 안되고, MenuTest프레임과 연동되어야 한다==> MenuTest.this
				FileDialog fd = new FileDialog(MenuTest.this);
				fd.setVisible(true);

				// 내가 선택한 파일명을 프레임 타이틀에 나오게....
				String dir = fd.getDirectory(); // 디렉토리 얻어오기
				String filename = fd.getFile(); // 파일명 얻어오기
				setTitle(dir + filename);

			} else if (obj == miSave) {
				FileDialog fd = new FileDialog(MenuTest.this, "저장", FileDialog.SAVE); // 저장모드
				fd.setVisible(true);
			} else if (obj == miExit) {
				System.exit(0);
			} else if (obj == miYellow) {
				bgCr = Color.yellow;
			} else if (obj == miGray) {
				bgCr = Color.gray;
			} else if (obj == mEvent) {
				System.out.println("mEvent");
			}
			if (cmd.equals("빨강")) {
				fntCr = Color.red;
			} else if (cmd.equals("파랑")) {
				fntCr = Color.blue;
			}
			lb.setForeground(fntCr);
			setBackground(bgCr);
			lb.setBackground(bgCr);

		}
	}//////////////////////

	public static void main(String[] args) {
		MenuTest mt = new MenuTest();
		mt.setSize(400, 400);
		mt.setVisible(true);
	}
}