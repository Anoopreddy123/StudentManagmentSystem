import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Gui  {
    JLabel jlabel = new JLabel();
    JButton jb1;
    JLabel jl = new JLabel();
    JLabel jl2 = new JLabel();
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    Gui() {
        JFrame jf = new JFrame("Sphoorthy Engg College. ");
        jf.setLayout(null);
        jf.setVisible(true);
        jf.getContentPane().setBackground(Color.WHITE);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jl.setText("Choose your action :");
        jl.setBounds(10, 10, 500, 30);
        jl2.setText("1. Enter details of student : ");
        jl2.setBounds(10, 30, 500, 30);
        jl2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new Student();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jl3.setText("2. Get details of a student :");
        jl3.setBounds(10, 50, 500, 30);
        jl3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new details();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jl4.setText("3. update details of student  : ");
        jl4.setBounds(10, 70, 500, 30);
        jl4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    new Update();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jl5.setText("4. Delete data of a student : ");
        jl5.setBounds(10, 90, 500, 30);
        jl5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    new Delete();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jl6.setText("5. Details of student : ");
        jl6.setBounds(10, 120, 500, 30);
        jl6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    new ShowData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        jf.add(jl);
        jf.add(jl2);
        jf.add(jl3);
        jf.add(jl4);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(jlabel);

    }


}
