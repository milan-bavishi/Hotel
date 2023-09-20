package hotel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {

        JButton add,cancel;
        JTextField tfName,tfAge,tfModel,tfCompany,tfPhone;
        JRadioButton rbMale,rbFemale;

    AddDriver(){

            getContentPane().setBackground(Color.white);
            setLayout(null);

            JLabel heading = new JLabel("Add Driver");
            heading.setFont(new Font("Tahoma",Font.BOLD,17));
            heading.setBounds(150,20,200,20);
            add(heading);

            JLabel lblName = new JLabel("NAME");
            lblName.setBounds(60,60,120,30);
            lblName.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(lblName);

            tfName = new JTextField();
            tfName.setBounds(200,60,120,30);
            add(tfName);

            JLabel lblAge = new JLabel("AGE");
            lblAge.setBounds(60,110,120,30);
            lblAge.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(lblAge);

            tfAge = new JTextField();
            tfAge.setBounds(200,110,120,30);
            add(tfAge);

            JLabel lblGender = new JLabel("GENDER");
            lblGender.setBounds(60,160,120,30);
            lblGender.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(lblGender);

            rbMale = new JRadioButton("MALE");
            rbMale.setBounds(200,160,70,30);
            rbMale.setFont(new Font("Tahoma",Font.PLAIN,14));
            rbMale.setBackground(Color.WHITE);
            add(rbMale);

            rbFemale = new JRadioButton("FEMALE");
            rbFemale.setBounds(280,160,100,30);
            rbFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
            rbFemale.setBackground(Color.WHITE);
            add(rbFemale);

            ButtonGroup bg = new ButtonGroup();
            bg.add(rbFemale);
            bg.add(rbMale);

            JLabel lblPhone = new JLabel("PHONE ");
            lblPhone.setBounds(60,210,120,30);
            lblPhone.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(lblPhone);

            tfPhone = new JTextField();
            tfPhone.setBounds(200,210,120,30);
            add(tfPhone);

            JLabel lblModel = new JLabel("CAR NAME");
            lblModel.setBounds(60,260,120,30);
            lblModel.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(lblModel);

            tfModel = new JTextField();
            tfModel.setBounds(200,260,120,30);
            add(tfModel);

            JLabel lblCompany = new JLabel("CAR COMPANY");
            lblCompany.setBounds(60,310,120,30);
            lblCompany.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(lblCompany);

            tfCompany = new JTextField();
            tfCompany.setBounds(200,310,120,30);
            add(tfCompany);

            JButton add = new JButton("Add Driver");
            add.setForeground(Color.WHITE);
            add.setForeground(Color.BLACK);
            add.setBounds(60,370,130,30);
            add.addActionListener(this);
            add(add);



            setBounds(330,200,940,470);
            setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

                String name = tfName.getText();
                String age = tfAge.getText();
                String model = tfModel.getText();
                String company = tfCompany.getText();
                String phone = tfPhone.getText();
                String gender = null;

                if(name.equals("")){
                        JOptionPane.showMessageDialog(null,"Name should not be empty");
                        return;
                }

                if(age.equals("")){
                        JOptionPane.showMessageDialog(null,"Age should not be empty");
                        return;
                }

                if(phone.equals("")){
                        JOptionPane.showMessageDialog(null,"Phone number should not be empty");
                        return;
                }

                if(rbMale.isSelected()){
                    gender = "MALE";
                } else if(rbFemale.isSelected()) {
                    gender = "FEMALE";
                }
                try{
                    Conn conn = new Conn();
                    String query = "insert into driver values ('"+name+"','"+age+"','"+phone+"','"+gender+"','"+model+"','"+company+"')";
                    conn.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Driver Added Successfully");
                }catch (Exception e){
                    e.printStackTrace();
                }

    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
