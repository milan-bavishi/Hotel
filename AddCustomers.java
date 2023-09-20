package hotel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import  java.util.Date;

public class AddCustomers extends JFrame implements ActionListener {

    JTextField tfName,tfAge,tfDeposit,tfPhone,tfCountry,tfNumber;
    JRadioButton rbMale,rbFemale;
    JButton add,back;
    Choice croom;
    JComboBox comboid;
    JLabel checkTime;

    AddCustomers(){
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMERS");
        heading.setFont(new Font("Tahoma",Font.BOLD,17));
        heading.setBounds(100,20,300,30);
        add(heading);

        JLabel lblID = new JLabel("ID");
        lblID.setBounds(35,80,100,25);
        lblID.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblID);

        String options[] = {"Aadhar card" , "Passport","Pan card","Voter Id" ,"Driving Licence","Ration Card"};

        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        add(comboid);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(35,120,100,20);
        lblNumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(200,120,150,25);
        add(tfNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(35,160,100,25);
        lblName.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200,160,150,25);
        add(tfName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(35,200,100,25);
        lblGender.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblGender);

        rbMale = new JRadioButton("MALE");
        rbMale.setBounds(200,200,70,30);
        rbMale.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbFemale = new JRadioButton("FEMALE");
        rbFemale.setBounds(280,200,100,30);
        rbFemale.setFont(new Font("Tahoma",Font.PLAIN,16));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbFemale);
        bg.add(rbMale);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(35,240,100,25);
        lblCountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(200,240,150,25);
        add(tfCountry);

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(35,280,150,20);
        lblRoom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblRoom);

        croom = new Choice();

        try{
                Conn conn = new Conn();
                String query = "select * from room where availability = 'Available' ";
                ResultSet rs = conn.s.executeQuery(query);

                while(rs.next()){
                    croom.add(rs.getString("roomnumber"));
                }


        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);

        JLabel lblTime = new JLabel("Checkin Time");
        lblTime.setBounds(35,320,150,20);
        lblTime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblTime);

        Date date = new Date();

        checkTime = new JLabel(" " + date);
        checkTime.setBounds(200,320,150,25);
        checkTime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkTime);

        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setBounds(35,360,100,25);
        lblDeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblDeposit);

        tfDeposit = new JTextField();
        tfDeposit.setBounds(200,360,150,25);
        add(tfDeposit);

        add = new JButton("Add");
        add.setBounds(50,410,120,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(205,410,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setBounds(350,200,800,550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
                String id = (String) comboid.getSelectedItem();
                String number = tfNumber.getText();
                String name = tfName.getText();

            String gender = null;

            if(rbMale.isSelected()){
                gender = "MALE";
            } else if(rbFemale.isSelected()) {
                gender = "FEMALE";
            }

            String country = tfCountry.getText();
            String room = croom.getSelectedItem();
            String time = checkTime.getText();
            String deposit = tfDeposit.getText();

            try{

                String query =  "insert into customer values ('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+time+"', '"+deposit+"' ) ";
                String query2 = "update room set  availability = 'Occupied'  where roomnumber = '"+room+"' ";


                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customers Added SuccessFully");

                setVisible(false);
                new Reception();


            }catch (Exception e){
                e.printStackTrace();
            }
      } else if (ae.getSource() == back) {
                setVisible(false);
                new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomers();
    }
}
