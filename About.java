/*******************************************************************/
/** Class Description:                                            **/
/**     The main functionality of this class is to provide an     **/
/**     explanaiton as to what the aim of this program is. This   **/
/**     is being done through the use of JLabels.                 **/
/*******************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JMenuBar mbar;
    JMenu m1,m2;
    JMenuItem m1_1, m2_1;
    
    public About()
    {
//creating a JFrame with multiple label to output text
        jf=new JFrame();
        jf.setLayout(null);
        
        mbar = new JMenuBar();
	jf.setJMenuBar(mbar);
        
        m1 = new JMenu("Main Menu");
	mbar.add(m1);
        
        m2 = new JMenu("Exit");
	mbar.add(m2);
        
        m1_1 = new JMenuItem("Main Menu");
	m1.add(m1_1);
        m1_1.addActionListener(this);
        
        m2_1 = new JMenuItem("Exit");
	m2.add(m2_1);
        m2_1.addActionListener(this);
        
	l1 = new JLabel("Information About this Component Seach System.");
	l1.setFont(new Font("Arial",Font.BOLD,25));
	l1.setBounds(100,30,600,40);
        l1.setForeground(Color.white);
	jf.add(l1);

	l2 = new JLabel("This System aims to allow ");
	l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.LIGHT_GRAY);
	l2.setBounds(100,150,600,40);
	jf.add(l2);

	l3 = new JLabel("Students, Teachers or Gurdiance");
	l3.setFont(new Font("Arial",Font.BOLD,20));
	l3.setBounds(100,200,400,40);
        l3.setForeground(Color.LIGHT_GRAY);
	jf.add(l3);

	l4 = new JLabel("to search thorugh a database");
	l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.LIGHT_GRAY);
	l4.setBounds(100,250,800,40);
	jf.add(l4);

	l5 = new JLabel("containing computer components");
	l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.LIGHT_GRAY);
	l5.setBounds(100,300,800,40);
	jf.add(l5);

	l6 = new JLabel("which can also be adapted to ones liking");
	l6.setFont(new Font("Arial",Font.BOLD,20));
        l6.setForeground(Color.LIGHT_GRAY);
	l6.setBounds(100,350,800,40);
	jf.add(l6);
//jButton used to implement "owl_mini" icon into JFrame                
        ImageIcon xx = new ImageIcon ("src/owl_mini.png");
        l7 = new JLabel(xx);
        l7.setBounds(750,10,100,120);
        jf.add(l7);
//ImageIcon used to establish the background                
        ImageIcon yy = new ImageIcon ("src/gray.png");
        l8 = new JLabel(yy);
        l8.setBounds(0,0,900,700);
        jf.add(l8);
             	
        jf.setTitle("About");
	jf.setSize(900,700);
	jf.setLocation(500,100);
	jf.setResizable(false);
	jf.getContentPane().setBackground(Color.GRAY);
	jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== m2_1)
        {
            System.exit(0);
	}

        else if(ae.getSource()== m1_1)
	{
            new MainMenu();
            jf.setVisible(false);
        }
    }
    //2017-02-13T09:10:45.732009Z 1 [Note] A temporary password is generated for root@localhost: S/8z*;isXr/d
    
    public static void main(String args[])
    {
        new About();
    }
}
