package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class login {

	public login(int h, int b,int n, Panel p1, Label la1,Panel p2,Label la2,Panel p3, Label la3,TextField tf1,TextField tf2,TextField tf3) throws IOException {
		Frame f = new Frame("Register");
		f.setLayout(new GridLayout());
		for(int i = 0;i<n;i++) {
			System.out.println("for");
			switch(i) {
			case 0:
				System.out.println("case 0");
			case 1:	
				f.add(la1);
				f.add(p1);
				System.out.println("case 1");
				break;
			case 2:
				f.add(la2);
				f.add(p2);
				System.out.println("case 2");
				break;
			case 3:
				f.add(la3);
				f.add(p3);
				System.out.println("case 3");
				break;
			default:
				System.out.println("cas def");
				break;
			}
		}
		f.pack();
		f.setSize(b, h);
//		Image d = new Image("fde.png");
		f.setBackground(Color.green);
//		f.setIconImage(d);
		f.setVisible(true);
		configFR conf = new configFR();
		int timesleep = conf.getInt("timesleep");
		while(true) {
		System.out.println("Gelesen: " + tf2.getText());
		try {
			TimeUnit.SECONDS.sleep(timesleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(tf2.getText().matches("J")) {
				System.out.println("Ende, J gelesen.");
				break;
			}	
		}	
		Properties p = new Properties();
		FileReader reader= new FileReader("config/config.xml");
		p.load(reader);
		reader.close();
		String Name = tf1.getText();
		
		if(p.getProperty(Name)==null) {
			register r = new register(Name);
		}
		
	}
}