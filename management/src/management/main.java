package management;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import management.data_load.list_data;

public class main extends JFrame {
	JLabel text;
	Font a=new Font("맑은고딕",Font.BOLD,15);
	static ArrayList <JButton> list_b=new ArrayList<>();
	static ArrayList<list_data> data_list;
	static JPanel search_panel = new JPanel();
	static JPanel list_panel = new JPanel();
	JScrollPane list_scroll;
	static JPanel infor_panel = new JPanel();
	static JTextArea infor = new JTextArea(7,30);
	static JComboBox search_place = new JComboBox();
	static JTextField search_name = new JTextField("검색할 물건의 이름을 적어주세요");
	static JTextField info_name;
	static JTextField info_qty;
	static JTextField info_place;
	static JTextField info_info;
	static JLabel info_img;
	static ImageIcon nothing = new ImageIcon("nothing.jpg");
	static String info_img_adress;
	JButton search_b = new JButton("찾기");
	static JButton delete_b = new JButton("삭제");
	JButton creat_b = new JButton("추가");
	static JButton change_b = new JButton("수정");
	JScrollPane infor_sc;
	main(){
		setTitle("관리 프로그램");
		setSize(800,700);
		setLayout(null);
		setLocationRelativeTo(null);
		add(creat_b);
		creat_b.setSize(70,50);
		creat_b.setLocation(600,600);
		creat_b.addActionListener(new option_b());
		add(delete_b);
		delete_b.setSize(70,50);
		delete_b.setLocation(680,600);
		delete_b.addActionListener(new option_b());
		delete_b.setEnabled(false);
		add(change_b);
		change_b.setSize(70,50);
		change_b.setLocation(520,600);
		change_b.addActionListener(new option_b());
		change_b.setEnabled(false);
		//1.
		list_panel.setPreferredSize(new Dimension(190,1000));
		list_panel.setLayout(null);
		list_scroll=new JScrollPane(list_panel);
		list_scroll.setSize(220,560);
		list_scroll.setLocation(10,20);
		list_scroll.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		add(list_scroll);
		//2.
		search_panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		search_panel.setSize(250,350);
		search_panel.setLocation(250,20);
		search_panel.setLayout(null);
		add(search_panel);
		text = new JLabel("물건 이름 : ");
		text.setSize(70,30);
		text.setLocation(5,15);
		search_panel.add(text);
		search_name.setSize(170,25);
		search_name.setLocation(75,18);
		search_panel.add(search_name);
		text = new JLabel("물건 위치 : ");
		text.setSize(70,40);
		text.setLocation(5,55);
		search_panel.add(text);
		search_place.setSize(170,25);
		search_place.setLocation(75,63);
		search_panel.add(search_place);
		search_place.addItem("모두");
		data_load.location_date(search_place);
		search_b.setSize(240,30);
		search_b.setLocation(6,313);
		search_b.addActionListener(new option_b());
		search_panel.add(search_b);
		//3.
		infor_panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		infor_panel.setSize(250,350);
		infor_panel.setLocation(520,20);
		infor_panel.setLayout(null);
		add(infor_panel);
		text = new JLabel("물건 이름 : ");
		text.setSize(70,30);
		text.setLocation(5,15);
		infor_panel.add(text);
		text = new JLabel("물건 수량 : ");
		text.setSize(70,30);
		text.setLocation(5,55);
		infor_panel.add(text);
		text = new JLabel("물건 위치 : ");
		text.setSize(70,30);
		text.setLocation(5,95);
		infor_panel.add(text);
		text = new JLabel("물건 사진 : ");
		text.setSize(70,30);
		text.setLocation(5,135);
		infor_panel.add(text);
		info_name = new JTextField();
		info_name.setFont(a);
		info_name.setEnabled(false);
		info_name.setSize(170,25);
		info_name.setLocation(75,17);
		infor_panel.add(info_name);
		info_qty = new JTextField();
		info_qty.setFont(a);
		info_qty.setEnabled(false);
		info_qty.setSize(170,25);
		info_qty.setLocation(75,57);
		infor_panel.add(info_qty);
		info_place = new JTextField();
		info_place.setFont(a);
		info_place.setEnabled(false);
		info_place.setSize(170,25);
		info_place.setLocation(75,97);
		infor_panel.add(info_place);
		info_img = new JLabel();
		info_img.setSize(225,150);
		info_img.setLocation(17,160);
		infor_panel.add(info_img);
		//
		infor.setEnabled(false);
		infor.setSize(520,180);
		infor.setLocation(250,400);
		infor_sc=new JScrollPane(infor);
		infor_sc.setEnabled(false);
		infor_sc.setSize(520,180);
		infor_sc.setLocation(250,400);
		add(infor_sc);
		//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
		public class option_b implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==search_b) {
					search(search_name.getText(),(String)search_place.getSelectedItem());
				}
				if(e.getSource()==creat_b) {
					new data_creat.creat_frame();
				}
				if(e.getSource()==delete_b) {
					new askingJFrame("delete",info_name.getText());
				}
				if(e.getSource()==change_b) {
					new data_creat.creat_frame(info_name.getText(),info_qty.getText(),info_place.getText(),info_img_adress,infor.getText());
				}
			}
		}
		public static class list_b implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<data_list.size();i++) {
					if(e.getSource()==list_b.get(i)) {
						delete_b.setEnabled(true);
						change_b.setEnabled(true);
						info_name.setText(data_list.get(i).name);
						info_qty.setText(data_list.get(i).qty);
						info_place.setText(data_list.get(i).place);
						info_img_adress = data_list.get(i).img_adress;
						info_img.setIcon(data_creat.chage_size(new ImageIcon(info_img_adress),225,150));
						infor.setText(data_list.get(i).info);
						infor_panel.revalidate();
						infor_panel.repaint();
					}
				}
			}
		}
		static void reset() {
			info_name.setText("");
			info_qty.setText("");
			info_place.setText("");
			info_img.setIcon(nothing);
		}
		static void search(String name,String place) {
			try {
				list_b=new ArrayList<JButton>();
				data_list = data_load.data_load(name,place);
				list_panel.removeAll();
				if(data_list.size()>0) {
					for(int i=0;i<data_list.size();i++) {
						list_b.add(new JButton(data_list.get(i).name));
						list_b.get(i).addActionListener(new list_b());
						list_panel.add(list_b.get(i));
						list_b.get(i).setSize(213,30);
						list_b.get(i).setLocation(0,30*i);
					}
				}
				else {
					new askingJFrame("can not found",name);
				}
				list_panel.revalidate();
				list_panel.repaint();
			} catch (IOException e) {
				new askingJFrame("can not found",name);
		}
	}
	public static void main(String[]args) {
		main a = new main();
	}
}
