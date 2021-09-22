import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

// creating the student profile
class Student implements  ActionListener{

    JTextField text1,text2,text3,text4;
    JLabel jlabel = new JLabel();
    JButton jb1;
    String name,branch,mobileNumber,gender;
    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    JLabel Error = new JLabel();
    Label label1 = new Label();
    Statement stmt;
    Connection conn;
    String sql=" null";
    PreparedStatement ps;
    Student() throws SQLException {
        JFrame jf = new JFrame("Student details ");
        jf.setLayout(null);
        jf.setVisible(true);
        jf.getContentPane().setBackground(Color.WHITE);

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementsystem", "root", "Anoop@123");
        stmt = conn.createStatement();






        JLabel jl1 = new JLabel();
        jl1.setText("enter Name");
        jl1.setBounds(10,10,500,50);
        text1=new JTextField(" ");
        text1.setBounds(135,25,100,20);
        jl2.setText("enter branch");
        jl2.setBounds(10,40,500,50);
        text2=new JTextField(" ");
        text2.setBounds(135,55,100,20);
        jl3.setText("enter mobile number");
        jl3.setBounds(10,70,500,50);
        text3=new JTextField(" ");
        text3.setBounds(135,85,100,20);
        jl4.setText("enter gender");
        jl4.setBounds(10,100,500,50);
        text4=new JTextField(" ");
        text4.setBounds(135,115,100,20);
        JButton jb = new JButton("SUBMIT");
        jb.setBounds(10,220,150,30);
        jf.add(jl1);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(jlabel);
        jf.add(text1);
        jf.add(text2);
        jf.add(text3);
        jf.add(text4);
        jf.add(jb);
        jf.add(Error);
        jf.add(label1);
        jb.addActionListener( this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            sql= "insert into studentdata (Name,branch,mobilenumber,gender) values (  ? , ? , ? , ?)";
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex);

        }
        try {
            ps = conn.prepareStatement(sql);
        }catch (Exception ex ){
            ex.printStackTrace();
            System.out.println(ex);
        }


        // set param values
        name = text1.getText();
        branch = text2.getText();
        mobileNumber = text3.getText();
        gender = text4.getText();

        try {
            ps.setString(1, name);
            ps.setString(2, branch);
            ps.setString(3, mobileNumber);
            ps.setString(4, gender);

        }catch(Exception ex ){
            ex.printStackTrace();
            System.out.println(ex);
        }
        try{
            ps.executeUpdate();

            label1.setText("Submitted!");
            label1.setBounds(10,350,100,25);
            text2.setText(" " );
            text3.setText(" " );
            text4.setText(" " );
            text1.setText(" ");
        }catch (Exception ex ){

            Error.setText("Error caught check Info provided");
            Error.setBounds(10,350,500,25);

        }


    }
}


