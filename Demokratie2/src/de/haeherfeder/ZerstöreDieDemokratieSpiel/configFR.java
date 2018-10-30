package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
//import java.io.Writer;

//import java.util.HashMap;

public class configFR{
	private Properties p = new Properties();
//	Files
	private File config = new File("config/config.xml");
	private File player = new File("config/player.txt");
	private File Story = new File("Story/config.txt");

	public configFR() {
		return;
	}
	public void configFRSt() throws IOException {
//		Ordner
		File configFolder = new File("config");
		File StoryFolder = new File("Story");
		File PlayerFolder = new File("config/players");
//		Proof if exist
		
		if(!configFolder.exists()) 	{configFolder.mkdirs();}
		if(!StoryFolder.exists()) 	{StoryFolder.mkdirs();}
		if(!PlayerFolder.exists()) 	{PlayerFolder.mkdirs();}
	
//		Proof if exist
		if(!config.exists()) 	{new CreateConfig(p);}
		if(!player.exists()) 	{player.createNewFile();}
		if(!Story.exists()) 	{Story.createNewFile();}
		
//		Properties 1
		FileReader read = new FileReader(config);
		p.load(read);
		read.close();
		
//		if(!p.contains("e")) {p.setProperty("e", "1");
//			System.out.println("e nicht vorhanden.");}
		System.out.println(p);
		System.out.println(config);
		return;
	}
	public void setPr(String key,String vel,Properties p) {
		if(p.getProperty(key)==null) {
			p.setProperty(key, vel);
			System.out.println(key + " wurde erstellt");
			return;
		}
		System.out.println(key + " ist vorhanden " + p.getProperty(key));
		return;
	}
	public String getProp(String key) throws IOException {
		FileReader read = new FileReader(config);
		p.load(read);
		read.close();
		System.out.println(key);
		System.out.println(p.getProperty(key));
		if(p.getProperty(key)==null) {return "not defined";}
		return p.getProperty(key);
	}
	public int getInt(String key){
		String vel = p.getProperty(key);
		if(vel==null) {
			if (key=="default") {
				return 5;
			}
		return getInt("default");
		}
		int h = Integer.parseInt(vel);
		return h;
	}
}