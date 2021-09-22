
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Update implements  ActionListener{
    Statement stmt;
    Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    JFrame jf = new JFrame("Get details");
    JLabel jl1 = new JLabel();
    JLabel Error = new JLabel();
    JButton jb;
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JTextField text,text2,text3;
           Update() throws  SQLException{
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Anoop@123");
    stmt = conn.createStatement();
     jf.setSize(500, 500);
               jf.setVisible(true);
               jf.setLayout(null);
    jl1.setText("Enter the Name");
    jl1.setBounds(10, 10, 500, 50);
    text = new JTextField();
    text.setBounds(10, 80, 100, 20);
    jb = new JButton("Update");
    jb.addActionListener(this);
    jb.setBounds(10, 270, 100, 20);
     jl3.setText("Change which Attribute :");
     jl3.setBounds(10,120,500,50);
     text2 = new JTextField();
     text2.setBounds(160,140,100,20);
     jl4.setText("Enter the new Data :");
     jl4.setBounds(10,150,500,50);
     text3 = new JTextField();
     text3.setBounds(130,170,100,20);
    jf.add(jl1);
    jf.add(text);
    jf.add(jb);
    jf.add(text2);
    jf.add(text3);
    jf.add(jl3);
    jf.add(jl4);
    jf.add(Error);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        //jl1 text jb
        String  name = text.getText();

        String changecolumn = text2.getText();

        String changedData = text3.getText();
        try{
            String sql = null;

            sql = "update studentdata set "+changecolumn+ "="+changedData+ " where lcase(trim(Name))='"+ name + "'";
            PreparedStatement ps = conn.prepareStatement(sql);

            int rs = stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
