/**
 * 
 */
package de.haeherfeder.ZerstöreDieDemokratieSpiel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author benjamin
 *
 */
public class Story {
	private File Story = new File("Story/config.txt");
	private File StoryFolder = new File("Story");
	private Properties p = new Properties();
	
	/**
	 * 
	 * 
	 */
	public Story() throws IOException {
		if(!StoryFolder.exists()) {StoryFolder.mkdirs();}
		if(!Story.exists()) {
			new CreateStory(Story,StoryFolder,p);
		}
		
		
		FileReader read = new FileReader(Story);
		p.load(read);
		read.close();
	}
	public String f(){
		return "fqw";
	}
	public String getText(String key){
		
		return "f";
	}
}
