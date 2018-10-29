package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameWindow {

	public GameWindow() throws IOException {
		configFR conf = new configFR();
		ConfigStory confSt = new ConfigStory(); 
		TextField tf1,tf2,tf3 = null;
		Label l1,l2,l3 = null; 
		Panel p1,p2,p3 = null;
		Frame f = null;
		String Text = null;
		String tf1Text,tf2Text,tf3Text,tf1Fieldtext,tf2Fieldtext,tf3Fieldtext;
		int tf1Fieldlen,tf2Fieldlen,tf3Fieldlen;
		Story story = new Story();
		ConfigStory confStory = new ConfigStory();
		String tet = story.getText("FirstP");
		System.out.println("Tet: "+tet);
		tf1Text = story.getText(tet + "tf1Text");
		tf2Text = story.getText(tet + "tf2Text");
		tf3Text = story.getText(tet + "tf3Text");
		tf1Fieldtext = story.getText(tet + "tf1Fieldtext");
		tf2Fieldtext = story.getText(tet + "tf2Fieldtext");
		tf3Fieldtext = story.getText(tet + "tf3Fieldtext");
		
		tf1Fieldlen = confStory.getLen(tet + "tf1Fieldlen");
		tf2Fieldlen = confStory.getLen(tet + "tf2Fieldlen");
		tf3Fieldlen = confStory.getLen(tet + "tf3Fieldlen");
		
		System.out.println(Inhalt.values());
		int b,h;
		String StB = conf.getProp("width");
		System.out.println(StB + " hi");
		b = Integer.parseInt(StB);
		System.out.println(StB + "in Zahl");
		h = Integer.parseInt(conf.getProp("hight"));
		/*
		b = 800;
		h = 400;*/
		System.out.print("HI ");
		int hi = 3;
		System.out.println(hi);
		tf1 = TextFieldG(tf1Fieldtext,tf1Fieldlen);
		tf2 = TextFieldG(tf2Fieldtext,tf2Fieldlen);
		tf3 = TextFieldG(tf3Fieldtext,tf3Fieldlen);
		p1 = PanelG(tf1);
		p2 = PanelG(tf2);
		p3 = PanelG(tf3);
		l1 = LabelG(tf1Text);
		l2 = LabelG(tf2Text);
		f = FrameG("Text Show", h, b, 3, p1, l1, p2, l2, p3, l3);
//			f.remove(p1);
//			TextField tf2 = new TextField(Text);
		System.out.println("f");
//			f.add(p1);
		while(true) {
			System.out.println("Gelesen: " + tf2.getText());
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(tf2.getText().matches("J")) {
			System.out.println("Ende, J gelesen.");
			break;
		}
		}
		Text = tf1.getText();
		System.out.println("Text: " + Text);
		conf.getProp("key");
		String Inhalt2 = Inhalt.Start.getText();
		switch(Text) {
			case "a":
			case "A":
				f.removeAll();
				Label a = LabelG(Inhalt.Start.getnexta());
				f.add(a);
				f.pack();
				f.setSize(b, h);
				f.setVisible(true);
				break;
			default:
				break;
		}
		System.out.println(Inhalt2);
		try {
			TimeUnit.SECONDS.sleep(8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f.removeAll();
		f.setVisible(false);
		return;
	}
	public Label LabelG(String Namela) {
		Label la = new Label(Namela);
		return la;
	}
	public Panel PanelG(TextField tf) {
		Panel p = new Panel();
		p.add(tf);
		return p;
	}
	public TextField TextFieldG(String text, int len) {
		TextField tf = new TextField(text,len);
		return tf;
	}
	public Frame FrameG(String Name,int h, int b,int n, Panel p1, Label la1,Panel p2,Label la2,Panel p3, Label la3) {
		Frame f = new Frame(Name);
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
		f.setVisible(true);
		return f;
	}
}
