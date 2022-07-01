package notepad_clone;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.undo.UndoManager;
public class notepad extends JFrame implements ActionListener {
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn=false;
	JMenuBar menuBar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	JMenuItem iwrap;
	JMenu menuFont,menuFontSize;
	JMenuItem iFontArial,ifontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize26,iFontSize30;
	JMenuItem iColor1,iColor2,iColor3,iColor4;
	/**
	 * 
	 */
	JMenuItem iUndo,iRedo;
	Function_File file=new Function_File(this);
	Function_Format format=new Function_Format(this);
	Function_Color color=new Function_Color(this);
	
	UndoManager um=new UndoManager();
	public notepad() {
		createWindow();
		createTextArea();
		createMenuBar();
		createfileMenu();
		format.selectedFont="Arial";
		format.createFont(16);
		createEditMenu();
		createColorMenu();
		color.changeColor("White");
		createFormatMenu();
		
		window.setVisible(true);
	}
	public void createWindow() {
		window=new JFrame("Notepad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void createTextArea() {
		textArea=new JTextArea();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
				}
			});
		scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//window.add(textArea);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	public void createMenuBar() {
		menuBar= new JMenuBar();
		window.setJMenuBar(menuBar);
		menuFile=new JMenu("File");
		menuBar.add(menuFile);
		menuEdit=new JMenu("Edit");
		menuBar.add(menuEdit);
		menuFormat=new JMenu("Format");
		menuBar.add(menuFormat);
		menuColor=new JMenu("Color");
		menuBar.add(menuColor);	
	}
	public void createfileMenu() {
		iNew=new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		iOpen=new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		
		iSave=new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		iSaveAs=new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		iExit=new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	public void createEditMenu() {
		iUndo=new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo=new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	public void createFormatMenu() {
		
		iwrap=new JMenuItem("Word Wrap: off");
		iwrap.addActionListener(this);
		iwrap.setActionCommand("Word Wrap");
		menuFormat.add(iwrap);
		
		menuFont=new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial=new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		ifontCSMS=new JMenuItem("Comic Sans Ms");
		ifontCSMS.addActionListener(this);
		ifontCSMS.setActionCommand("Comic Sans Ms");
		menuFont.add(ifontCSMS);
		
		iFontTNR=new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		menuFontSize=new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8=new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12=new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16=new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		
		iFontSize20=new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		
		iFontSize24=new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize26=new JMenuItem("26");
		iFontSize26.addActionListener(this);
		iFontSize26.setActionCommand("size26");
		menuFontSize.add(iFontSize26);
		
		iFontSize30=new JMenuItem("30");
		iFontSize30.addActionListener(this);
		iFontSize30.setActionCommand("size30");
		menuFontSize.add(iFontSize30);	
	}
	public void createColorMenu() {
		iColor1=new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2=new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3=new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
		
		iColor4=new JMenuItem("Red");
		iColor4.addActionListener(this);
		iColor4.setActionCommand("Red");
		menuColor.add(iColor4);
	}
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {	
	
	
	      new notepad();
	       
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		switch(command) {
		case "New":file.newFile();break;
		case "Open":file.open();break;
		case "Save":file.save();break;
		case "SaveAs":file.saveAs();break;
		case "Exit":file.exit();break;
		case "Word Wrap":format.wordWrap(); break;
		case "Arial":format.setFont(command); break;
		case "Comic Sans Ms":format.setFont(command); break;
		case "Times New Roman":format.setFont(command); break;
		case "size8":format.createFont(8);break;
		case "size12":format.createFont(12);break;
		case "size16":format.createFont(16);break;
		case "size20":format.createFont(20);break;
		case "size24":format.createFont(24);break;
		case "size26":format.createFont(26);break;
		case "size30":format.createFont(36);break;
		case "White":color.changeColor(command);break;
		case "Black":color.changeColor(command);break;
		case "Blue":color.changeColor(command);break;
		case "Red":color.changeColor(command);break;
		
	
		
		
		}
	}

}
