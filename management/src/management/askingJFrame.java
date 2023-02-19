package management;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class askingJFrame implements ActionListener {
	JLabel asking_text_1=new JLabel();
	JLabel asking_text_2=new JLabel();
	JFrame asking=new JFrame();
	JButton answer_yes= new JButton("YES");
	JButton answer_no= new JButton("NO");
	String filename;
	String asking_t;
	public askingJFrame(String asking_t,String filename){
		this.filename=filename;
		this.asking_t=asking_t;
		asking = new JFrame();
		asking.setSize(250,200);
		asking.setTitle("경고!");
		asking.setLocationRelativeTo(null);
		asking.setLayout(null);
		asking_text_1.setLocation(10,30);
		asking_text_1.setSize(220,30);
		asking_text_1.setHorizontalAlignment(JLabel.CENTER);
		asking_text_2.setLocation(10,50);
		asking_text_2.setSize(220,30);
		asking_text_2.setHorizontalAlignment(JLabel.CENTER);
		asking.add(asking_text_1);
		asking.add(asking_text_2);
		asking.add(answer_yes);
		answer_yes.addActionListener(this);
		answer_yes.setSize(95,50);
		answer_yes.setLocation(10,100);
		asking.add(answer_no);
		answer_no.addActionListener(this);
		answer_no.setSize(95,50);
		answer_no.setLocation(132,100);
		set_text(asking_t,filename);
		asking.setVisible(true);
	}
	void set_text(String asking_t,String filename) {
		if(asking_t.equals("can not found")) {
			asking_text_1.setText("저장되 있지 않은 데이터입니다.");
			asking_text_2.setText(filename+" 데이터를 만들겠습니까?");
		}
		else if(asking_t.equals("delete")) {
			asking_text_1.setText("삭제시 돌릴수 없습니다");
			asking_text_2.setText(filename+"을 삭제하시겠습니까?");
		}
		else if(asking_t.equals("date error")){
			asking_text_1.setText("데이터파일이 손상됬습니다.");
			asking_text_2.setText(filename+"파일을 삭제하겠습니까?");
		}
		else {
			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==answer_yes) {
			if(asking_t.equals("can not found")) {
				new data_creat.creat_frame(filename);
			}
			if(asking_t.equals("date error")) {
				File file = new File("data\\"+filename);
				file.delete();
			}
			if(asking_t.equals("delete")) {
				File file = new File("data\\"+filename+".txt");
				file.delete();
				main.search(main.search_name.getText(),(String)main.search_place.getSelectedItem());
				main.delete_b.setEnabled(false);
				main.reset();
			}
			asking.dispose();
		}
		if(e.getSource()==answer_no) {
			asking.dispose();
		}
	}
}
