import javax.swing.JFrame;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

class aboutWindow {

	JFrame frame;

	
	public aboutWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 445, 169);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("About - Notepad");
		
		Label label = new Label("It is a Simple Notepad Application Practical made for SVIIT");
		label.setBounds(10, 93, 409, 27);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setForeground(Color.CYAN);
		label.setBackground(Color.BLACK);
		frame.getContentPane().add(label);
		
		Label label_1 = new Label("Name - Aman Bind");
		label_1.setForeground(Color.RED);
		label_1.setBounds(128, 10, 168, 22);
		frame.getContentPane().add(label_1);
		
		Label label_2 = new Label("Roll No. - 19100BTCSEMA05472");
		label_2.setForeground(Color.ORANGE);
		label_2.setBounds(69, 38, 298, 22);
		frame.getContentPane().add(label_2);
		
		Label label_3 = new Label("Subject Name - Advance Java Programming");
		label_3.setForeground(Color.GREEN);
		label_3.setBounds(20, 66, 392, 22);
		frame.getContentPane().add(label_3);
	}
}

public class notepad {

	private JFrame frmNotepad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notepad window = new notepad();
					window.frmNotepad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public notepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNotepad = new JFrame();
		frmNotepad.setTitle("Notepad");
		frmNotepad.setBackground(Color.WHITE);
		frmNotepad.getContentPane().setBackground(Color.BLACK);
		frmNotepad.setBounds(100, 100, 571, 430);
		frmNotepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
        
        frmNotepad.getContentPane().setLayout(null);
        
        TextArea textArea = new TextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setBounds(0, 0, 555, 371);
        frmNotepad.getContentPane().add(textArea);
        
        MenuBar menuBar = new MenuBar();  
        Menu menu = new Menu("Menu"); 
        menuBar.add(menu);
        
        Menu help = new Menu("Help");
        menuBar.add(help);
        
        MenuItem newFile = new MenuItem("New");
        menu.add(newFile);  
		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
        
        MenuItem openFile = new MenuItem("Open");
        menu.add(openFile);
		openFile.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		           try
		            {
		                FileDialog fileDialog = new FileDialog(frmNotepad,"Open Txt File",FileDialog.LOAD);
		                fileDialog.setVisible(true);
		                String fileName = fileDialog.getFile();
		                String dir = fileDialog.getDirectory();
		                frmNotepad.setTitle("Notepad - " + fileName);
		                FileInputStream fis=new FileInputStream(dir+fileName);
		                DataInputStream dis=new DataInputStream(fis);
		                String str ="";
		                String msg ="";
		                while((str=dis.readLine())!=null)
		                {
		                    msg=msg+str;
		                    msg+="\n";
		                }
		                textArea.setText(msg);
		                dis.close();
		            }
		            catch(Exception ae){
		            	textArea.setText("Error : " + ae);
		           }
			}	
		});
        
        MenuItem saveFile = new MenuItem("Save");
        menu.add(saveFile);
        saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
	            {
	                FileDialog fileDialog = new FileDialog(frmNotepad,"Save File",FileDialog.SAVE);
	                fileDialog.setVisible(true);
	                String dir = fileDialog.getDirectory();
	                String fileName = fileDialog.getFile();
	                frmNotepad.setTitle("Notepad - " + fileName);
	                FileOutputStream fos = new FileOutputStream(dir+fileName);
	                DataOutputStream dos = new DataOutputStream(fos);
	                dos.writeBytes(textArea.getText());
	                dos.close();
	            }
	            catch(Exception ae){
	            	textArea.setText("Error : " + ae);
	            }
			}
		});
        
        
        MenuItem exitFile = new MenuItem("Exit"); 
        menu.add(exitFile);
        exitFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
        
        MenuItem about = new MenuItem("About");
        help.add(about);
        about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutWindow window = new aboutWindow();
				window.frame.setVisible(true);
			}
		});
        
        frmNotepad.setMenuBar(menuBar);  
	}
}
