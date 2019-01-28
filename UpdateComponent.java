/*******************************************************************/
/** Class Description:                                            **/
/**     The main functionality of this class is to enable         **/
/**     the user to update certain specifications of the          **/
/**     component that might have changed. This is being          **/
/**     done through the user entering some data and the          **/
/**     class the accessing the databse to chnage the             **/
/**     selected component`s specifications.                      **/
/*******************************************************************/

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateComponent extends JFrame implements ActionListener
{
    JFrame jf;
    JTextField t2,t3,t4,t5,t6,t7,t8;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JButton b0,b1,b2,b3;
    Font f;
    JMenuBar mbar;
    JMenu m1,m2;
    JMenuItem m1_1, m2_1;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public UpdateComponent()
    {
	jf=new JFrame();
	f = new Font("Arial",Font.BOLD,18);
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

	l1 = new JLabel("Update Component");
        l1.setFont(new Font("Arial",Font.BOLD,25));
	l1.setBounds(300,1,300,40);
        l1.setForeground(Color.white);
	jf.add(l1);

	l2 = new JLabel("Component Name:");
        l2.setFont(f);
        l2.setForeground(Color.LIGHT_GRAY);
        l2.setBounds(130,50,170,25);
        jf.add(l2);
        t2 = new JTextField(20);
        t2.setBounds(380,50,200,25);
        t2.setToolTipText("Enter Component Name");
        jf.add(t2);
        
        l3 = new JLabel("Component ID:");
        l3.setFont(f);
        l3.setForeground(Color.LIGHT_GRAY);
        l3.setBounds(130,90,170,25);
        jf.add(l3);
        t3 = new JTextField(20);
        t3.setBounds(380,90,200,25);
        t3.setToolTipText("Enter Component ID");
        jf.add(t3);

        l4 = new JLabel("Compnent Brand:");
	l4.setFont(f);
        l4.setForeground(Color.LIGHT_GRAY);
        l4.setBounds(130,130,170,25);
        jf.add(l4);
	t4 = new JTextField(20);
	t4.setBounds(380,130,200,25);
        t4.setToolTipText("Enter Component Brand");
        jf.add(t4);

	l5 = new JLabel("Component Price:");
        l5.setFont(f);
        l5.setForeground(Color.LIGHT_GRAY);
        l5.setBounds(130,170,170,25);
	jf.add(l5);
	t5 = new JTextField(20);
	t5.setBounds(380,170,200,25);
        t5.setToolTipText("Enter Component Price");
        jf.add(t5);

        l6 = new JLabel("Component Rating:");
        l6.setFont(f);
        l6.setForeground(Color.LIGHT_GRAY);
        l6.setBounds(130,210,200,25);
	jf.add(l6);
	t6 = new JTextField(20);
	t6.setBounds(380,210,200,25);
        t6.setToolTipText("Enter Component Rating (out of 5)");
	jf.add(t6);
                
        l7 = new JLabel("Component Speed:");
        l7.setFont(f);
        l7.setForeground(Color.LIGHT_GRAY);
        l7.setBounds(130,250,200,25);
	jf.add(l7);
	t7 = new JTextField(20);
	t7.setBounds(380,250,200,25);
        t7.setToolTipText("Enter Component Speed");
	jf.add(t7);

        l8 = new JLabel("Component Storage:");
        l8.setFont(f);
        l8.setForeground(Color.LIGHT_GRAY);
        l8.setBounds(130,290,200,25);
        jf.add(l8);
	t8 = new JTextField(20);
	t8.setBounds(380,290,200,25);
        t8.setToolTipText("Enter Component Storage");
	jf.add(t8);

        b0 = new JButton("Open");
	b0.setBounds(150,330,100,35);
        b0.addActionListener(this);
        jf.add(b0); 
       

        b1 = new JButton("Update");
        b1.setBounds(300,330,120,35);
        b1.addActionListener(this);
        jf.add(b1);
        

        b2 = new JButton("Clear");
        b2.setBounds(450,330,100,35);
        b2.addActionListener(this);
        jf.add(b2); 
        

        b3 = new JButton("All");
        b3.setBounds(600,330,100,35);
        b3.addActionListener(this);
	jf.add(b3); 
        
               
        ImageIcon xx = new ImageIcon ("src/owl_mini.png");
        l9 = new JLabel(xx);
        l9.setBounds(750,10,100,120);
        jf.add(l9);
                
        ImageIcon yy = new ImageIcon ("src/gray.png");
        l9 = new JLabel(yy);
        l9.setBounds(0,0,900,380);
        jf.add(l9);
              
        scrlPane.setBounds(0,380,900,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Arial",0,15));

        model.addColumn("Component_Name");
        model.addColumn("Component_ID");
        model.addColumn("Component_Brand");
        model.addColumn("Component_Price");
        model.addColumn("Component_Rating");
        model.addColumn("Component_Speed");
        model.addColumn("Component_Storage");
        
        jf.setTitle("Search Component");
        jf.setSize(900,700);
	jf.setLocation(500,100);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
	jf.setVisible(true);	
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b0)
        {
            if(((t2.getText()).equals(""))&&((t3.getText()).equals("")))
	    {
                JOptionPane.showMessageDialog(this,"Please enter Component Name or Component ID !","WARNING",JOptionPane.WARNING_MESSAGE);
	    }
	    else
	    {
                try
                {
                    int foundrec = 0;
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11159021","sql11159021","veqjgTfu5N");
                    System.out.println("Connected to database.");
                    ps=con.prepareStatement("select * from Units where Component_Name='"+t2.getText()+"' or Component_ID='"+t3.getText()+"'");
                    rs=ps.executeQuery();
                    while(rs.next())
                    {
                        t2.setText(rs.getString(1));
                        t3.setText(rs.getString(2));
                        t4.setText(rs.getString(3));
                        t5.setText(rs.getString(4));
                        t6.setText(rs.getString(5));
                        t7.setText(rs.getString(6));
                        t8.setText(rs.getString(7));
                        foundrec = 1;
                    }
                    if (foundrec == 0)
                    {
                        JOptionPane.showMessageDialog(null,"Data is unavailable","ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                    con.close();
                }
                catch(SQLException se)
		{
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"Error:"+e);
                }
            }
        }
        else if(ae.getSource()==b1)
        {//update
            String name = t2.getText();
	    Pattern p = Pattern.compile("[_a-z_A-Z_0-9]");
	    Matcher m = p.matcher(name);
	    boolean matchFound=m.matches();
            if(((t2.getText()).equals(""))&&((t3.getText()).equals("")))
	    {
                JOptionPane.showMessageDialog(this,"Please enter Component Name or ID !","WARNING",JOptionPane.ERROR_MESSAGE);
	    }
	    else if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals(""))||((t6.getText()).equals(""))||((t7.getText()).equals(""))||((t8.getText()).equals("")))
	    {
                JOptionPane.showMessageDialog(this,"There are some details missing, Please try again!","WARNING",JOptionPane.ERROR_MESSAGE);
	    }
	    else if(!matchFound)
	    {
                JOptionPane.showMessageDialog(this,"Invalid Component Name, Please try again","WARNING",JOptionPane.WARNING_MESSAGE);
	    }
            else
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    con=DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11159021","sql11159021","veqjgTfu5N");
                    System.out.println("Connected to database.");
                    stmt=con.createStatement();
                    String str1="UPDATE Units SET Component_Name='"+t2.getText()+"',Component_Brand='"+t3.getText()+"',Component_ID='"+t4.getText()+"',Component_Price='"+t5.getText()+"',Component_Rating='"+t6.getText()+"',Component_Speed='"+t7.getText()+"',Component_Storage='"+t8.getText()+"' where Component_Name='"+t2.getText()+"' or Component_ID='"+t3.getText()+"' ";
                    stmt.executeUpdate(str1);
                    JOptionPane.showMessageDialog(null, "The Component has been updated");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    con.close();
                }
                catch(SQLException se)
                {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL ERROR:"+se);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"ERROR:"+e);
                }
            }
        }
        else if(ae.getSource()==b2)
        {//clear
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
        }
        else if(ae.getSource()==b3)
        {
//listing all of the components
            int r = 0;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11159021","sql11159021","veqjgTfu5N");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs = stmt.executeQuery("SELECT * from Units" );
                while(rs.next())
                {
                    model.insertRow(r++, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
                }
                con.close();
            }
            catch(SQLException se)
            {
                System.out.println(se);
                JOptionPane.showMessageDialog(null,"SQL ERROR"+se);
            }
            catch(Exception e)
            {
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"ERROR"+e);
            }
	}
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
    
    public static void main(String args[])
    {
        new UpdateComponent();
    }
}

