/*******************************************************************/
/** Class Description:                                            **/
/**     The main functionality of this class is to connect        **/ 
/**      to the database and display all of the infomation        **/
/**      stored on the database in a table.                        **/
/*******************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class ComponentList extends JFrame implements ActionListener
{
//creating a JFRAME
    JFrame jf;
    JLabel l1,l2,l3;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    JMenuBar mbar;
    JMenu m1,m2;
    JMenuItem m1_1, m2_1;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

    public ComponentList()
    {
        jf = new JFrame();
        jf.setLayout(null);
        
        l1= new JLabel("Component List");
	l1.setFont(new Font("Arial",Font.BOLD,25));
	l1.setBounds(300,20,300,40);
        l1.setForeground(Color.white);
	jf.add(l1);
        
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
        
        ImageIcon xx = new ImageIcon ("src/owl_mini.png");
        l2 = new JLabel(xx);
        l2.setBounds(750,10,100,120);
        jf.add(l2);
               
        ImageIcon yy = new ImageIcon ("src/gray.png");
        l3 = new JLabel(yy);
        l3.setBounds(0,0,900,200);
        jf.add(l3);
               
        scrlPane.setBounds(0,200,900,500);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Arial",0,15));

        model.addColumn("Component_Name");
        model.addColumn("Component_ID");
        model.addColumn("Component_Brand");
        model.addColumn("Component_Price");
        model.addColumn("Component_Rating");
        model.addColumn("Component_Speed");
        model.addColumn("Component_Storage");
        
        int r = 0;
        try
        {
//accessing the database to print the stored data
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11159021","sql11159021","veqjgTfu5N");
            System.out.println("Connected to database.");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("SELECT * FROM Units");
            while(rs.next())
            {
                model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});

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
//setting size and name of the created JFrame 
        jf.setTitle("Component List");
        jf.setSize(900,700);
	jf.setLocation(500,100);
	jf.setResizable(false);
        jf.getContentPane().setBackground(Color.cyan);
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
    public static void main(String args[])
    {
    	new ComponentList();
    }
}