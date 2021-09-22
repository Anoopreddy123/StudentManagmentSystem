
import java.sql.*;
import javax.swing.*;
public class ShowData {
    Statement stmt;
    Connection conn;
    JFrame jf = new JFrame("Get details");
    JLabel jl1 = new JLabel();
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    ShowData() throws  SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Anoop@123");
        stmt = conn.createStatement();
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setLayout(null);
        jl1.setText("Top 5 students details :");
        jl1.setBounds(10,90,500,50);
        String sql = "select * from studentdata";
        jf.add(jl1);
        jf.add(jl3);
        PreparedStatement ps = conn.prepareStatement(sql);
        Statement sta = conn.createStatement();
        ResultSet res = sta.executeQuery(sql);

          while(res.next()) {
              String Name = res.getString("Name");
              String branch = res.getString("branch");
              String mobileNumber = res.getString("mobilenumber");
              String gender = res.getString("gender");
              jl3.setText(Name + " " + branch + " " + mobileNumber + " " + gender);
              jl3.setBounds(10,120,500,50);
              System.out.println(Name);
          }





    }

}

