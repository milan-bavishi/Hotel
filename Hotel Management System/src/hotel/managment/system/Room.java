package hotel.managment.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements  ActionListener{
    JTable table;
    JButton back;
    Room(){

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel l1 = new JLabel("Room Number");
            l1.setBounds(8,10,100,20);
            add(l1);

            JLabel l2 = new JLabel("Availability");
            l2.setBounds(110,10,100,20);
            add(l2);

            JLabel l3 = new JLabel("Status");
            l3.setBounds(210,10,100,20);
            add(l3);

            JLabel l4 = new JLabel("Price");
            l4.setBounds(310,10,100,20);
            add(l4);

            JLabel l5 = new JLabel("Bed Type");
            l5.setBounds(410,10,100,20);
            add(l5);

            table= new JTable();
            table.setBounds(0,40,500,400);
            add(table);

            try{

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from room");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }


            back = new JButton("Back");
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.setBounds(200,500,120,30);
            back.addActionListener(this);
            add(back);


            setBounds(300,200,1050,600);
            setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
