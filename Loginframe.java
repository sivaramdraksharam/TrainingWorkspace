package librarypackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Loginframe extends JFrame implements ActionListener{

	
	//attributes
	JLabel userNamelbl,passWordlbl;
	JTextField userNametxt;
	JPasswordField passWordfld;
	JButton signUp,signIn;
	
	Loginuser login=new Loginuser();
	//no-arg constructor
	Loginframe()
	{
		//set the title for this frame
		setTitle("Login");
		
		//instantiate GUI components
		 userNamelbl=new JLabel("User Name");
		 passWordlbl=new JLabel("Password");
		 userNametxt=new JTextField(20);
		 passWordfld=new JPasswordField(10);
		 signUp=new JButton("Sign Up");
		 signIn=new JButton("Sign In");
		 
		 //set Layout for this frame
		 setLayout(new FlowLayout());
		 setBounds(10,10,350,150);
		 
		 //add components to this frame
		 add(userNamelbl);
		 add(userNametxt);
		 add(passWordlbl);
		 add(passWordfld);
		 add(signUp);
		 add(signIn);
		 
		 signIn.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equalsIgnoreCase("sign in"))
		{
			login.setUserid(userNametxt.getText().trim());
			login.setPassword(passWordfld.getPassword().toString().trim());
			
			if(login.DoVerification(login.getUserid()))
			{
				System.out.println("Admin logged in");
			Librarymenu lm=new Librarymenu();
			this.setVisible(false);
			lm.setVisible(true);
			}else
			{
				
				this.setVisible(true);
			}
		}
	}
}
