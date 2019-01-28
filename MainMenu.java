/*******************************************************************/
/** Class Description:                                            **/
/**     The main functionality of this class is act as            **/
/**     main directory and provie acces to all areas of           **/
/**     the program as the user is able to select a               **/
/**     button which will initialise the dedicated class          **/
/*******************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener
{
    JFrame jf;
    JMenuBar mbar;
    JMenu m1,m2,m3;
    JButton b1,b2;
    JMenuItem m1_1,m1_2,m1_3,m1_4,m1_5,m2_1,m3_1;
    JLabel l1,l2,l3,l4;
    

    public MainMenu()
    {
        jf = new JFrame();
	
	jf.setLayout(null);
        
	l1= new JLabel("IRIS COMPONENT SEARCH SYSTEM");
        l1.setFont(new Font("Arial",Font.BOLD,40));
        l1.setBounds(100,75,800,30);
        l1.setForeground(Color.white);
        jf.add(l1);
        
        mbar = new JMenuBar();
	jf.setJMenuBar(mbar);

	m1 = new JMenu("Component");
	mbar.add(m1);
	m1_1 = new JMenuItem("Add New Component");
	m1.add(m1_1);
	m1_2 = new JMenuItem("Search Component");
	m1.add(m1_2);
	m1_3 = new JMenuItem("Update Component");
	m1.add(m1_3);
	m1_4 = new JMenuItem("Delete Component");
	m1.add(m1_4);
        m1_5 = new JMenuItem("Component List");
	m1.add(m1_5);

	m2 = new JMenu("About");
	mbar.add(m2);
	m2_1 = new JMenuItem("About System");
	m2.add(m2_1);

	m3 = new JMenu("Exit");
	mbar.add(m3);
	m3_1 = new JMenuItem("Exit");
	m3.add(m3_1);

        m1_1.addActionListener(this);
	m1_2.addActionListener(this);
	m1_3.addActionListener(this);
	m1_4.addActionListener(this);
        m1_5.addActionListener(this);
        m2_1.addActionListener(this);
	m3_1.addActionListener(this);    
        
        ImageIcon xx = new ImageIcon ("src/owl_maxi.png");
        l4 = new JLabel(xx);
        l4.setBounds (332,160,236,363);
        jf.add(l4);
               
        ImageIcon yy = new ImageIcon ("src/gray.png");
        l2 = new JLabel(yy);
        l2.setBounds(0,0,900,700);
        jf.add(l2);
            
	jf.setTitle("IRIS COMPONENT SEARCH SYSTEM");
	jf.setLocation(500,100);
	jf.setSize(900,700);
	jf.setResizable(false);
        jf.getContentPane().setBackground(Color.gray);
        jf.setVisible(true);        
    }

    public void actionPerformed(ActionEvent ae)
    {
//when the asigned button is being selected the dedicated class will be initialised 
        if(ae.getSource()== m1_1)
	{
            jf.setVisible(false);
            new AddNewComponent();
        }
	else if(ae.getSource()== m1_2)
        {
            jf.setVisible(false);
            new SearchComponent();
	}
	else if(ae.getSource()== m1_3)
	{
            jf.setVisible(false);
            new UpdateComponent();
	}
	else if(ae.getSource()== m1_4)
	{
            jf.setVisible(false);
            new DeleteComponent();
	}
        else if(ae.getSource()== m1_5)
	{
            jf.setVisible(false);
            new ComponentList();
	}
	else if(ae.getSource()== m2_1)
	{
            jf.setVisible(false);
            new About();    
        }
	else if(ae.getSource()== m3_1)
        {
            System.exit(0);
	}
    }
    public static void main(String args[])
    {
        new MainMenu();
    }
}
