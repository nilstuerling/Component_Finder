/*******************************************************************/
/** Class Description:                                            **/
/**     The main functionality of this class is to set a login    **/
/**     where the user will be asked to input a valid username    **/
/**     and password. Once entered the Username and Password      **/
/**     will then be checked for its validity.                    **/
/*******************************************************************/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class InvalidException extends Exception
{
}

class Login extends JFrame implements ActionListener
{
    JFrame jf;
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2;
    JPasswordField p1;
    Font f;
    int cnt=0,cnt1=0;

    public Login()
    {
        jf=new JFrame();
        f = new Font("Arial",Font.BOLD,25);
	jf.setLayout(null);

        l5 = new JLabel("User Login");
        l5.setFont(new Font("Arial",Font.BOLD,40));
        l5.setBounds(300,100,300,50);
        l5.setForeground(Color.white);
	jf.add(l5);
                
        l7 = new JLabel("----------------");
        l7.setFont(new Font("Arial",Font.BOLD,40));
        l7.setBounds(300,125,300,50);
        l7.setForeground(Color.white);
	jf.add(l7);

	l1 = new JLabel("Username: "); 
        l1.setFont(f);
        l1.setForeground(Color.LIGHT_GRAY);
	l1.setBounds(200,250,200,25);
        l1.setToolTipText("Enter Username");
	jf.add(l1);

	t1 = new JTextField(20);
	t1.setBounds(350,250,200,25);
	jf.add(t1);

	l2 = new JLabel("Password: "); 
        l2.setFont(f);
        l2.setForeground(Color.LIGHT_GRAY);
        l2.setBounds(200,300,200,25);
        l2.setToolTipText("Enter Password");
	jf.add(l2);

	p1 = new JPasswordField(20);
	p1.setBounds(350,300,200,25);
	jf.add(p1);

	b1 = new JButton("Exit");
	b1.setBounds(150,400,130,45);
        b1.addActionListener(this);
	jf.add(b1);
        
	b2 = new JButton("Clear");
	b2.setBounds(350,400,130,45);
        b2.addActionListener(this);
	jf.add(b2);
        
	b3 = new JButton("Login");
	b3.setBounds(550,400,130,45);
        b3.addActionListener(this);
	jf.add(b3);
                
        b4= new JButton(new ImageIcon ("src/owl_mini.png"));
        b4.setBounds(750,10,100,120);
        b4.addActionListener(this);
        jf.add(b4);
                
        ImageIcon pp = new ImageIcon ("src/gray.png");
        l8 = new JLabel(pp);
        l8.setBounds(0,0,900,700);
        jf.add(l8);

	jf.setTitle("Login");
	jf.setLocation(500,100);
	jf.setSize(900,700);
	jf.setResizable(false);
	jf.getContentPane().setBackground(Color.gray);
	jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b3)
        {
            try
                {
                    String s = t1.getText();
                    String s1 = new String(p1.getPassword());
                    if((s.compareTo("admin")==0)&&(s1.compareTo("admin")==0))
                    {
                        JOptionPane.showMessageDialog(null," Welcome To The Iris Component Finder","WELCOME",JOptionPane.INFORMATION_MESSAGE);
			new MainMenu();
                        jf.setVisible(false);
                    }
                    else
                    {
                        throw new InvalidException();
                    }
		}
		catch(Exception e1)
		{
                    cnt++;
                    JOptionPane.showMessageDialog(null,"The entered Username or Password does not exist, Please try again","WARNING",JOptionPane.ERROR_MESSAGE);
                    t1.setText("");
                    p1.setText("");
                    if(cnt==3)
                    {
                        JOptionPane.showMessageDialog(null,"Sorry, your 3 attempts are over.","WARNING",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
                    }
                }
            }
            else if(ae.getSource()==b2)
            {
                t1.setText("");
                p1.setText("");
            }
            else if(ae.getSource()==b1)
            {
                System.exit(0);
            }
            else if(ae.getSource() ==b4)
            {
                jf.setVisible(false);
                new MainMenu();
            }
    }

    public static void main(String args[])
    {
    new Login();
    }
}
