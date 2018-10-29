package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.File;
import java.util.Properties;

public class CreateStory {

	public CreateStory(File Story,File StoryFolder,Properties p) {
		if(Story.exists()) {
			return;
		}
		setPr("FirstP","Start",p);
		setPr("Start"+"tf1"+"Text","Hallo, Herzlich Willkommen.",p);
		setPr("Start"+"tf2"+"Text","Hallo, Feld2",p);
		setPr("Start"+"Next"+"A","Register",p);
//		setPr("Start");
	}
	private void setPr(String key,String vel,Properties p) {
		if(p.getProperty(key)==null) {
			p.setProperty(key, vel);
			System.out.println(key + " wurde erstellt");
			return;
		}
		System.out.println(key + " ist vorhanden " + p.getProperty(key));
		return;
	}
}