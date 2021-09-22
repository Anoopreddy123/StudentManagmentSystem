import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Delete implements ActionListener{
    JFrame jf = new JFrame("Clearing");
    JLabel jl1=new JLabel();
    JLabel Error = new JLabel();
    String sql = null;
    JLabel label2 = new JLabel();
    JTextField text;
    Statement stmt;
    Connection conn;

    JButton jb,jb2;
    Delete() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Anoop@123");
        stmt = conn.createStatement();
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setLayout(null);
        jl1.setText("Enter the Name");
        jl1.setBounds(10, 10, 500, 50);
        text= new JTextField("");
        text.setBounds(10, 80, 100, 20);
        jb = new JButton("Delete");
        jb.addActionListener(this);
        jb.setBounds(10,270,100,20);
        jf.add(jb);
        jf.add(jl1);
        jf.add(label2);
        jf.add(text);
        jf.add(Error);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
    String name = text.getText();
            stmt.execute("delete from studentdata where name = '" + name + "'");

            label2.setText("Deleted successfully.");
            label2.setBounds(10,90,500,50);
        } catch (Exception ex) {
            Error.setText("Failed to remove Clear studentdata Data.");
            Error.setBounds(10,90,500,50);

        }
    }
}
