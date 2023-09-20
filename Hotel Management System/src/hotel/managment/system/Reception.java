package hotel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception  extends JFrame implements ActionListener {

    JButton newCustomers,rooms,department,allEmployee,customersInfo,managerInfo,checkOut,searchRoom;
        Reception(){

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            newCustomers = new JButton("NEW CUSTOMERS");
            newCustomers.setBounds(10,30,200,30);
            newCustomers.setBackground(Color.BLACK);
            newCustomers.setForeground(Color.WHITE);
            newCustomers.addActionListener(this);
            add(newCustomers);

            rooms = new JButton("ROOMS");
            rooms.setBounds(10,70,200,30);
            rooms.setBackground(Color.BLACK);
            rooms.setForeground(Color.WHITE);
            rooms.addActionListener(this);
            add(rooms);

            department = new JButton("DEPARTMENT");
            department.setBounds(10,110,200,30);
            department.setBackground(Color.BLACK);
            department.setForeground(Color.WHITE);
            department.addActionListener(this);
            add(department);

            allEmployee = new JButton("ALL EMPLOYEE");
            allEmployee.setBounds(10,150,200,30);
            allEmployee.setBackground(Color.BLACK);
            allEmployee.setForeground(Color.WHITE);
            allEmployee.addActionListener(this);
            add(allEmployee);

            customersInfo = new JButton("CUSTOMERS INFO");
            customersInfo.setBounds(10,190,200,30);
            customersInfo.setBackground(Color.BLACK);
            customersInfo.setForeground(Color.WHITE);
            customersInfo.addActionListener(this);
            add(customersInfo);

            managerInfo = new JButton("MANAGER INFO");
            managerInfo.setBounds(10,230,200,30);
            managerInfo.setBackground(Color.BLACK);
            managerInfo.setForeground(Color.WHITE);
            managerInfo.addActionListener(this);
            add(managerInfo);

            JButton checkOut = new JButton("CHECKOUT");
            checkOut.setBounds(10,270,200,30);
            checkOut.setBackground(Color.BLACK);
            checkOut.setForeground(Color.WHITE);
            newCustomers.addActionListener(this);
            add(checkOut);

            searchRoom = new JButton("SEARCH ROOM");
            searchRoom.setBounds(10,310,200,30);
            searchRoom.setBackground(Color.BLACK);
            searchRoom.setForeground(Color.WHITE);
            searchRoom.addActionListener(this);
            add(searchRoom);

            JButton logOut = new JButton("LOGOUT");
            logOut.setBounds(10,350,200,30);
            logOut.setBackground(Color.BLACK);
            logOut.setForeground(Color.WHITE);
            newCustomers.addActionListener(this);
            add(logOut);

            setBounds(350,200,800,570);
            setVisible(true);
        }

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == newCustomers){
                setVisible(false);
                new AddCustomers();
            }
            if(ae.getSource() == rooms){
                setVisible(false);
                new Room();
            }
            if(ae.getSource() == department){
                setVisible(false);
                new Department();
            }
            if(ae.getSource() == allEmployee){
                setVisible(false);
                new EmployeeInfo();
            }
            if(ae.getSource() == managerInfo){
                setVisible(false);
                new ManagerInfo();
            }
            if(ae.getSource() == customersInfo){
                setVisible(false);
                new CustomersInfo();
            }
            if(ae.getSource() == searchRoom){
                setVisible(false);
                new SearchRoom();
            }
    }

    public static void main(String[] args) {
        new Reception();
    }
}

