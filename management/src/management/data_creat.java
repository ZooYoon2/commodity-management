package management;

import java.io.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class data_creat{
	static class creat_frame extends JFrame implements ActionListener{
		JFrame fp = new JFrame();
		JTextField name = new JTextField("");
		JSpinner qty = new  JSpinner(new SpinnerNumberModel());
		JComboBox place = new JComboBox();
		JTextField img_adress = new  JTextField("nopicture.jpg");
		JButton find_img = new JButton("찾아보기");
		JButton registration = new JButton("등록하기");
		JButton change = new JButton("수정");
		JButton cancle = new JButton("취소");
		JFileChooser find_img_adress = new JFileChooser();
		JLabel text;
		JScrollPane infor_sc;
		JLabel img_box = new JLabel();
		ImageIcon img;
		JTextArea infor = new JTextArea();
		String filename;
		//검색목록에 없는 파일추가
		public creat_frame(String filename){
			this.filename=filename;
			//
			fp.setSize(700,650);
			fp.setTitle("데이터 추가");
			fp.setLocationRelativeTo(null);
			fp.setLayout(null);
			//
			text = new JLabel("물건 이름 : ");
			text.setSize(80,20);
			text.setLocation(10,20);
			fp.add(text);
			text = new JLabel("물건 수량 : ");
			text.setSize(80,20);
			text.setLocation(10,60);
			fp.add(text);
			text = new JLabel("물건 위치 : ");
			text.setSize(80,20);
			text.setLocation(10,100);
			fp.add(text);
			text = new JLabel("물건 설명 : ");
			text.setSize(80,20);
			text.setLocation(10,270);
			fp.add(text);
			text = new JLabel("사진 경로 : ");
			text.setSize(80,20);
			text.setLocation(320,20);
			fp.add(text);
			text = new JLabel("미리보기 : ");
			text.setSize(80,20);
			text.setLocation(320,60);
			fp.add(text);
			//
			img_adress.setEditable(false);
			if(!filename.equals(""))
				name.setText(filename);
			name.setSize(200,20);
			name.setLocation(85,21);
			fp.add(name);
			qty.setSize(200,20);
			qty.setLocation(85,61);
			fp.add(qty);
			data_load.location_date(place);
			place.setSize(200,20);
			place.setLocation(85,101);
			fp.add(place);
			img_adress.setSize(180,20);
			img_adress.setLocation(395,21);
			fp.add(img_adress);
			find_img.setSize(100,20);
			find_img.setLocation(575,21);
			find_img.addActionListener(this);
			fp.add(find_img);
			img_box.setSize(355,190);
			img_box.setLocation(320,90);
			img=new ImageIcon("nopicture.jpg");
			img_box.setIcon(chage_size(img,355,190));
			fp.add(img_box);
			infor.setSize(660,200);
			infor.setLocation(10,300);
			infor_sc=new JScrollPane(infor);
			infor_sc.setSize(660,200);
			infor_sc.setLocation(10,300);
			fp.add(infor_sc);
			registration.setSize(120,50);
			registration.setLocation(380,520);
			registration.addActionListener(this);
			fp.add(registration);
			cancle.setSize(120,50);
			cancle.setLocation(550,520);
			cancle.addActionListener(this);
			fp.add(cancle);
			fp.setVisible(true);
		}
		//추가버튼을 이용한 파일추가
		public creat_frame(){
			//
			fp.setSize(700,650);
			fp.setTitle("데이터 추가");
			fp.setLocationRelativeTo(null);
			fp.setLayout(null);
			//
			text = new JLabel("물건 이름 : ");
			text.setSize(80,20);
			text.setLocation(10,20);
			fp.add(text);
			text = new JLabel("물건 수량 : ");
			text.setSize(80,20);
			text.setLocation(10,60);
			fp.add(text);
			text = new JLabel("물건 위치 : ");
			text.setSize(80,20);
			text.setLocation(10,100);
			fp.add(text);
			text = new JLabel("물건 설명 : ");
			text.setSize(80,20);
			text.setLocation(10,270);
			fp.add(text);
			text = new JLabel("사진 경로 : ");
			text.setSize(80,20);
			text.setLocation(320,20);
			fp.add(text);
			text = new JLabel("미리보기 : ");
			text.setSize(80,20);
			text.setLocation(320,60);
			fp.add(text);
			//
			img_adress.setEditable(false);
			name.setSize(200,20);
			name.setLocation(85,21);
			fp.add(name);
			qty.setSize(200,20);
			qty.setLocation(85,61);
			fp.add(qty);
			data_load.location_date(place);
			place.setSize(200,20);
			place.setLocation(85,101);
			fp.add(place);
			img_adress.setSize(180,20);
			img_adress.setLocation(395,21);
			fp.add(img_adress);
			find_img.setSize(100,20);
			find_img.setLocation(575,21);
			find_img.addActionListener(this);
			fp.add(find_img);
			img_box.setSize(355,190);
			img_box.setLocation(320,90);
			img=new ImageIcon("nopicture.jpg");
			img_box.setIcon(chage_size(img,355,190));
			fp.add(img_box);
			infor.setSize(660,200);
			infor.setLocation(10,300);
			infor_sc=new JScrollPane(infor);
			infor_sc.setSize(660,200);
			infor_sc.setLocation(10,300);
			fp.add(infor_sc);
			registration.setSize(120,50);
			registration.setLocation(380,520);
			registration.addActionListener(this);
			fp.add(registration);
			cancle.setSize(120,50);
			cancle.setLocation(550,520);
			cancle.addActionListener(this);
			fp.add(cancle);
			fp.setVisible(true);
		}
		//수정을 이용한 파일수정
		public creat_frame(String filename,String qty_o,String place_o,String img_adress_o,String infor_o){
			//
			this.filename=filename;
			name.setText(filename);
			qty.setValue(Integer.parseInt(qty_o));
			place.setSelectedItem(place_o);
			img_adress.setText(img_adress_o);
			infor.setText(infor_o);
			//
			fp.setSize(700,650);
			fp.setTitle("데이터 추가");
			fp.setLocationRelativeTo(null);
			fp.setLayout(null);
			//
			text = new JLabel("물건 이름 : ");
			text.setSize(80,20);
			text.setLocation(10,20);
			fp.add(text);
			text = new JLabel("물건 수량 : ");
			text.setSize(80,20);
			text.setLocation(10,60);
			fp.add(text);
			text = new JLabel("물건 위치 : ");
			text.setSize(80,20);
			text.setLocation(10,100);
			fp.add(text);
			text = new JLabel("물건 설명 : ");
			text.setSize(80,20);
			text.setLocation(10,270);
			fp.add(text);
			text = new JLabel("사진 경로 : ");
			text.setSize(80,20);
			text.setLocation(320,20);
			fp.add(text);
			text = new JLabel("미리보기 : ");
			text.setSize(80,20);
			text.setLocation(320,60);
			fp.add(text);
			//
			img_adress.setEditable(false);
			name.setSize(200,20);
			name.setLocation(85,21);
			name.setEditable(false);
			fp.add(name);
			qty.setSize(200,20);
			qty.setLocation(85,61);
			fp.add(qty);
			data_load.location_date(place);
			place.setSize(200,20);
			place.setLocation(85,101);
			fp.add(place);
			img_adress.setSize(180,20);
			img_adress.setLocation(395,21);
			fp.add(img_adress);
			find_img.setSize(100,20);
			find_img.setLocation(575,21);
			find_img.addActionListener(this);
			fp.add(find_img);
			img_box.setSize(355,190);
			img_box.setLocation(320,90);
			img=new ImageIcon("nopicture.jpg");
			img_box.setIcon(chage_size(img,355,190));
			fp.add(img_box);
			infor.setSize(660,200);
			infor.setLocation(10,300);
			infor_sc=new JScrollPane(infor);
			infor_sc.setSize(660,200);
			infor_sc.setLocation(10,300);
			fp.add(infor_sc);
			registration.setSize(120,50);
			registration.setLocation(380,520);
			registration.addActionListener(this);
			fp.add(registration);
			cancle.setSize(120,50);
			cancle.setLocation(550,520);
			cancle.addActionListener(this);
			fp.add(cancle);
			fp.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==find_img) {
				int r = find_img_adress.showOpenDialog(this);
				String adress = find_img_adress.getSelectedFile().getAbsolutePath();
				img_adress.setText(adress);
				img=new ImageIcon(adress);
				img_box.setIcon(chage_size(img,355,190));
			}
			if(e.getSource()==registration) {
				creat_file(name.getText(),name.getText(),Integer.toString((int)qty.getValue()),(String)place.getSelectedItem(),img_adress.getText(),infor.getText());
				main.delete_b.setEnabled(false);
				main.reset();
				main.search(main.search_name.getText(),(String)main.search_place.getSelectedItem());
				fp.dispose();
			}
			if(e.getSource()==cancle) {
				fp.dispose();
			}
		}
	}
	static ImageIcon chage_size(ImageIcon img1,int x,int y) {
		Image a = img1.getImage();
		a = a.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon img2=new ImageIcon(a);
		return img2;
	}
	public static void creat_file(String filename,String name,String qty,String place,String img_adress, String infor) {
		try{
			File file = new File("data\\"+filename+".txt");
			PrintWriter fp=new PrintWriter(new FileWriter(file));
			fp.println(name);
			fp.println(qty);
			fp.println(place);
			fp.println(img_adress);
			fp.println(infor);
			fp.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
