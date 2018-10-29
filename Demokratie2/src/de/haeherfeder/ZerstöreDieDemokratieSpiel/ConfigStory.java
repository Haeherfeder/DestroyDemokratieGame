package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigStory {
	private File StoryConfig = new File("Story/StoryConfig.xml");
	private File StoryFolder = new File("Story");
	private Properties p = new Properties();
	
	public ConfigStory() throws IOException {
		FileReader read = new FileReader(StoryConfig);
		p.load(read);
		read.close();
		if(!StoryFolder.exists()) {StoryFolder.mkdirs();}
		if(!StoryConfig.exists()) {new CreateConfigStory(StoryConfig,p);}
	}
	public String getText(String key){
		String vel = p.getProperty(key);
		return vel;
	}
	public int getLen(String key){
		System.out.println(key);
		String vel = p.getProperty(key);
		System.out.println(vel);
		int h = Integer.parseInt(vel);
		return h;
	}
}
