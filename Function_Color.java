package notepad_clone;

import java.awt.Color;

public class Function_Color {
	notepad gui;
	public Function_Color(notepad gui) {
		// TODO Auto-generated constructor stub
		this.gui=gui;
	}
	public void changeColor(String color) {
		switch(color) {
		case "White":
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.white);
			gui.textArea.setForeground(Color.BLACK);
			break;
			
			
			case "Black":
			gui.window.getContentPane().setBackground(Color.black);
			gui.textArea.setBackground(Color.BLACK);
			gui.textArea.setForeground(Color.white);
			break;
			
			case "Blue":
			gui.window.getContentPane().setBackground(new Color(28,186,186));
			gui.textArea.setBackground(new Color(28,186,186));
			gui.textArea.setForeground(Color.white);
			break;
			
			case "Red":
				gui.window.getContentPane().setBackground(Color.red);
				gui.textArea.setBackground(Color.yellow);
				gui.textArea.setForeground(Color.blue);
				break;
		}
	}

}
