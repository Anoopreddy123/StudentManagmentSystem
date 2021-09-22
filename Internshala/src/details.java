import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class details implements ActionListener {
    Statement stmt;
    Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    JFrame jf = new JFrame("Get details");
    JLabel jl1 = new JLabel();
    JLabel Error = new JLabel();
    String sql = null;

    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    JLabel jl7 = new JLabel();
    JLabel label2 = new JLabel();
    JTextField text;

    String Stdid;
    JButton jb, jb2;

    details() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Anoop@123");
        stmt = conn.createStatement();


        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setLayout(null);
        jl1.setText("Enter the Name");
        jl1.setBounds(10, 10, 500, 50);
        text = new JTextField("");
        text.setBounds(10, 80, 100, 20);
        jb = new JButton("Get details");
        jb.addActionListener(this);
        jb.setBounds(10, 270, 100, 20);
        jf.add(jl1);
        jf.add(text);
        jf.add(jb);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(Error);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = text.getText();


            String sql = null;

            sql = "select * from studentdata WHERE lcase(trim(Name))='" + name + "'";
            boolean q = stmt.execute(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                jl3.setText("Name : " + rs.getString(1) + " ");
                jl3.setBounds(10, 90, 500, 50);
                jl4.setText("Branch : " + rs.getString(2) + " ");
                jl4.setBounds(10, 110, 500, 50);
                jl5.setText("MobileNumber : " + rs.getString(3) + " ");
                jl5.setBounds(10, 130, 500, 50);
                jl6.setText("Gender : " + rs.getString(4) + " ");
                jl6.setBounds(10, 150, 500, 50);


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}


