package librarypackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Librarymenu extends JFrame implements ActionListener{
    
    	JMenuBar mb;    
    	JMenu book,student,help;    
    	JMenuItem addBook,modifyBook,deleteBook,addStudent,modifyStudent,deleteStudent;    
    
    	
    	Librarymenu(){    
    	   
    	//create menu items
    	addBook=new JMenuItem("Create new Book");    
    	modifyBook=new JMenuItem("Edit Book details");    
    	deleteBook=new JMenuItem("Delete book");    
    	   
    	//register the listener with source
    	addBook.addActionListener(this);    
    	modifyBook.addActionListener(this);    
    	deleteBook.addActionListener(this);    
    	 
    	
    	//create menu items
    	addStudent=new JMenuItem("Create new Student");    
    	modifyStudent=new JMenuItem("Edit Student details");    
    	deleteStudent=new JMenuItem("Delete student");    
    	   
    	//register the listener with source
    	addStudent.addActionListener(this);    
    	modifyStudent.addActionListener(this);    
    	deleteStudent.addActionListener(this); 
    	//create Menu Bar
    	mb=new JMenuBar(); 
    	
    	//create Menu
    	book=new JMenu("Book");    
    	student=new JMenu("Student");    
    	help=new JMenu("Help");    
    	
    	book.add(addBook);  	book.add(modifyBook);    	book.add(deleteBook);
    	 	
    	
    	student.add(addStudent);student.add(modifyStudent);student.add(deleteStudent);    
    	//adding menus to menu bar
    	mb.add(book);mb.add(student);mb.add(help);    
    	
    	JTextField ta=new JTextField(10);    
    	ta.setToolTipText("Shows the status");
    	ta.setBounds(5,5,360,320);    
    	add(mb);
    	add(ta);    
    	this.setJMenuBar(mb);  
    	setLayout(null);    
    	setSize(400,400);    
    	setVisible(true);    
    	}    
    	
    	

		public void actionPerformed(ActionEvent e) {
			  
				if(e.getActionCommand().equals("book"))
				{
					
				}
				
		}
}  


