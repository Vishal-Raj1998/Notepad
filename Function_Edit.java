package notepad_clone;

public class Function_Edit {
	notepad gui;
	public Function_Edit() {
		// TODO Auto-generated constructor stub
		this.gui=gui;
		
	}
	public void undo() {
		gui.um.undo();
		
	}
	public void redo() {
		gui.um.redo();
	}
}
