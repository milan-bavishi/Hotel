package hotel.managment.system;
import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

        JTextField username;
        JPasswordField password;
        JButton login,cancel;

    login(){
        getContentPane().setBackground(Color.WHITE);

        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        password  = new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);

        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("cancel");
        cancel.setBounds(180,150,120,30);
        cancel.addActionListener(this);
        add(cancel);

        setBounds(500,200,600,300);
        add(username);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
                if(ae.getSource() == login){
                    String user = username.getText();
                    String pass = password.getText();

                    try{

                        Conn c = new Conn();
                        String query = "select * from login where username = '" + user + "'and password = '" + pass + "'";
                        ResultSet rs = c.s.executeQuery(query);

                        if(rs.next()){
                                setVisible(false);
                                new Dashboard();
                        }else{
                                JOptionPane.showMessageDialog(null,"Invalid Username and password");
                                setVisible(false);
                        }

                    }catch (Exception e){
                            e.printStackTrace();
                    }

                } else if(ae.getSource() == cancel) {
                        setVisible(false);
                }
        }


    public static void main(String[] args) {
        new login();
    }
}
