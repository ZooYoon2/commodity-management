package management;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class data_load extends JFrame{
	static class list_data{
		String name;
		String place;
		String qty;
		String info="";
		String img_adress;
		boolean error =false;
		int a;
		list_data(String filename){
			try(BufferedReader fp=new BufferedReader(new FileReader("data\\"+filename))){
				while(true) {
					if((this.name=fp.readLine())==null) {
						new askingJFrame("date error",filename);
						error = true;
						break;
					}
					if((this.qty=fp.readLine())==null) {
						new askingJFrame("date error",filename);
						error = true;
						break;
					}
					if((this.place=fp.readLine())==null) {
						new askingJFrame("date error",filename);
						error = true;
						break;
					}
					if((this.img_adress=fp.readLine())==null) {
						new askingJFrame("date error",filename);
						error = true;
						break;
					}
					while((a=fp.read())!=-1) {
						info=info+(char)a;
					}
					break;
				}
			}catch(IOException e) {
				new askingJFrame("can not found",filename);
			}
		}
	}
	static ArrayList<list_data> data_load(String filename,String place) throws IOException{
		ArrayList<list_data> list = new ArrayList<>();
		String l_filename;
		File dir = new File("data\\");
		File [] datalist = dir.listFiles();
		int j;
		for(File file:datalist) {
			if(file.isFile()) {
				l_filename=file.getName();
				list.add(new list_data(l_filename));}	
		}
		for(int i=0;i<list.size();i++) {
			if(list.get(list.size()-1).error==true) {
				System.out.println(list.get(i).name+"제거");
				list.remove(list.size()-1);}
		}
		if((!filename.equals(""))&&(place.equals("모두"))) {j=0;
			while(j<list.size()) {
				if(list.get(j).name.indexOf(filename)==-1)
					list.remove(j);
				else
					j++;}
		}
		else if((filename.equals(""))&&(!place.equals("모두"))) {j=0;
			while(j<list.size()) {
				if(!(list.get(j).place.equals(place)))
					list.remove(j);
				else
					j++;}
		}
		else if((!filename.equals(""))&&(!place.equals("모두"))) {j=0;
			while(j<list.size()) {
				if(!(list.get(j).place.equals(place))) 
					list.remove(j);
				else
					j++;
			}j=0;
			while(j<list.size()) {
				if(list.get(j).name.indexOf(filename)==-1)
					list.remove(j);
				else
					j++;}
		}
		return list;
	}
	static void location_date(JComboBox box){
		try (BufferedReader in = new BufferedReader(new FileReader("location.txt"))){
			String location;
			while((location=in.readLine())!=null) {
				box.addItem(location);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
