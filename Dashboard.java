package hotel.managment.system;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends  JFrame implements ActionListener {
    Dashboard(){
        setBounds(0,0,1550,1000);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE ITC GROUP WELCOME YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Thoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        hotel.setForeground(Color.blue);
        mb.add(admin);

        JMenuItem addEmployee= new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRoom = new JMenuItem("ADD ROOM");
        addRoom.addActionListener(this);
        admin.add(addRoom);

        JMenuItem addDrives = new JMenuItem("ADD DRIVES");
        addDrives.addActionListener(this);
        admin.add(addDrives);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("ADD EMPLOYEE")){
                new AddEmployee();
            } else if(ae.getActionCommand().equals("ADD ROOM")){
                new AddRooms();
            }else if(ae.getActionCommand().equals("ADD DRIVES")){
                new AddDriver();
            }else if(ae.getActionCommand().equals("RECEPTION")){
                new Reception();
            }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
