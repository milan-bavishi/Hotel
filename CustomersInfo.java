package hotel.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomersInfo extends  JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomersInfo(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2 = new JLabel("Document Number");
        l2.setBounds(140,10,120,20);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(280,10,100,20);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(390,10,100,20);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(520,10,100,20);
        add(l5);

        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);

        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(760,10,100,20);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(910,10,100,20);
        add(l8);

        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try{

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(400,500,120,30);
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
        new CustomersInfo();
    }
}
