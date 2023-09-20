package hotel.managment.system;
import javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;

public class AddRooms extends  JFrame implements ActionListener{

    JButton add,cancel;
    JTextField tfRoom,tfPrice;
    JComboBox typeCombo,availableCombo,cleanCombo;
    AddRooms(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,17));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblRommno = new JLabel("Room No");
        lblRommno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblRommno.setBounds(60,80,120,30);
        add(lblRommno);

        tfRoom = new JTextField();
        tfRoom.setBounds(200,80,150,30);
        add(tfRoom);

        JLabel lblAvailable = new JLabel("Available");
        lblAvailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblAvailable.setBounds(60,130,120,30);
        add(lblAvailable);

        String availableOption[] = {"Available" , "Occupied"};

        availableCombo = new JComboBox(availableOption);
        availableCombo.setBounds(200,130,150,30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblStatus.setBounds(60,180,120,30);
        add(lblStatus);

        String cleanOption[] = {"Cleaned" , "Dirty"};

        cleanCombo = new JComboBox(cleanOption);
        cleanCombo.setBounds(200,180,150,30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblPrice.setBounds(60,230,120,30);
        add(lblPrice);

        tfPrice = new JTextField();
        tfPrice.setBounds(200,230,150,30);
        add(tfPrice);


        JLabel lblType = new JLabel("Room Type");
        lblType.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblType.setBounds(60,280,120,30);
        add(lblType);

        String typeOption[] = {"Single" , "Master","Family Room" ,"Suite","Deluxe Room","Presidential Suite"};

        typeCombo = new JComboBox(typeOption);
        typeCombo.setBounds(200,280,150,30);
        typeCombo.setBackground(Color.WHITE);
        add(typeCombo);

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);


        setBounds(330,200,940,470);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
                String roomNumber = tfRoom.getText();
                String availability = (String) availableCombo.getSelectedItem();
                String status = (String) cleanCombo.getSelectedItem();
                String price = tfPrice.getText();
                String type = (String) typeCombo.getSelectedItem();

                try{
                        Conn conn = new Conn();
                        String query = "insert into room values ('"+roomNumber+"', '"+availability+"','"+status+"','"+price+"','"+type+"')";

                        conn.s.executeUpdate(query);


                        JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                        setVisible(false);
                }catch (Exception e){
                        e.printStackTrace();
                }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
