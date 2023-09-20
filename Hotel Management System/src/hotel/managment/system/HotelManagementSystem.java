package hotel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setBounds(100,100,1366,565);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        JLabel image = new JLabel(i1);

        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,400,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("poppins", Font.PLAIN,60));
        image.add(text);

        JButton next = new JButton("Next");
        next.setBounds(1150,450,100,40);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("poppins",Font.PLAIN,17));
        next.addActionListener(this);
        image.add(next);

        setVisible(true);
    }

    public void  actionPerformed(ActionEvent ae){
        
         setVisible(false);
         new login();
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
