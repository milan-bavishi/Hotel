package hotel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame  implements ActionListener {

    JTextField tfName,tfAge,tfSalary,tfPhone,tfEmail,tfAdhar;
    JRadioButton rbMale,rbFemale;
    JButton submit;
    JComboBox cbJob;
    AddEmployee(){
        setLayout(null);

        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60,30,120,30);
        lblName.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200,30,150,30);
        add(tfName);

        JLabel lblAge = new JLabel("AGE");
        lblAge.setBounds(60,80,120,30);
        lblAge.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblAge);

        tfAge = new JTextField();
        tfAge.setBounds(200,80,150,30);
        add(tfAge);

        JLabel lblGender = new JLabel("GENDER");
        lblGender.setBounds(60,130,120,30);
        lblGender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblGender);

        rbMale = new JRadioButton("MALE");
        rbMale.setBounds(200,130,70,30);
        rbMale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbFemale = new JRadioButton("FEMALE");
        rbFemale.setBounds(280,130,100,30);
        rbFemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbFemale);
        bg.add(rbMale);

        JLabel lblJob = new JLabel("JOB");
        lblJob.setBounds(60,180,120,30);
        lblJob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblJob);

        String str[] = {  "Manager" ,"Room-service" ,"Chefs","waiter","housekeeping" ,"Porter","Accountant"};
        cbJob = new JComboBox(str);
        cbJob.setBounds(200,180,150,30);
        cbJob.setBackground(Color.WHITE);
        add(cbJob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);

        tfSalary = new JTextField();
        tfSalary.setBounds(200,230,150,30);
        add(tfSalary);

        JLabel lblPhone = new JLabel("PHONE");
        lblPhone.setBounds(60,280,120,30);
        lblPhone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(200,280,150,30);
        add(tfPhone);

        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(60,330,120,30);
        lblEmail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200,330,150,30);
        add(tfEmail);

        JLabel lblAdhar = new JLabel("Aadhar");
        lblAdhar.setBounds(60,380,120,30);
        lblAdhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblAdhar);

        tfAdhar = new JTextField();
        tfAdhar.setBounds(200,380,150,30);
        add(tfAdhar);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
        setVisible(true);

    }

    public  void actionPerformed(ActionEvent ae){
        String name = tfName.getText();
        String age = tfAge.getText();
        String salary = tfSalary.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        String aadhar = tfAdhar.getText();

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
        if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Email should not be empty");
            return;
        }

        if(rbMale.isSelected()){
            gender = "MALE";
        } else if(rbFemale.isSelected()) {
            gender = "FEMALE";
        }

        String job = (String) cbJob.getSelectedItem();

        try{
            Conn conn = new Conn();

            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
