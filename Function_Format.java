package notepad_clone;
import java.awt.Font;
public class Function_Format {
	notepad gui;
	Font arial,comicSansMS,timesNewRoman;
	String selectedFont;
	public Function_Format(notepad gui) {
		// TODO Auto-generated constructor stub
		this.gui=gui;
	}
	public void wordWrap() {
		if(gui.wordWrapOn==false)
		{
			gui.wordWrapOn=true;
			gui.textArea.setLineWrap(true);
			gui.textArea.setWrapStyleWord(true);
			gui.iwrap.setText("Word Wrap: ON");
			
		}
		else if(gui.wordWrapOn==true) 
		{
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.textArea.setWrapStyleWord(false);
			gui.iwrap.setText("Word Wrap: Off");
		}
	}
	public void createFont(int fontSize) {
		arial=new Font("Arial",Font.PLAIN,fontSize);
		comicSansMS=new Font("Comic Sans Ms",Font.PLAIN,fontSize);
		timesNewRoman=new Font("Times New Roman",Font.PLAIN,fontSize);
		setFont(selectedFont);
	}
	public void setFont(String font){
		selectedFont=font;
		switch(selectedFont)
		{
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "Comic Sans Ms":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Times New Roman":
			gui.textArea.setFont(timesNewRoman);
			break;
		}
	}
}
