import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class guiform extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton ajouterButton;
    private JPanel Informations;

    /* Initialization of text field and button of the form */

    public guiform(JFrame parent){
        super(parent);
        setTitle("Create an user ");
        setContentPane(Informations);
        setMinimumSize(new Dimension(600,650));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /* Diferent parameters about the panel like the dimension, what to print, stop the program when we close the panel etc  */


        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerNew();
                /* When the user click on "add", we go on the menu to put informations about the person and add it on the database*/
            }
        });
        setVisible(true);

    }

    public void registerNew() {
        String name= textField1.getText();
        String phone = textField2.getText();
        String Email= textField3.getText();

        /* We put the diferents informations on three variables */

        if (name.isEmpty() || phone.isEmpty() || Email.isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to complete every fields","One more time !",JOptionPane.ERROR_MESSAGE );
            return;
        }
        info=addOnDatabase(name,phone,Email);
        if(info!= null){
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Error", "Try one more time", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Some security for the database, the user must complete every fields to add the user on the database*/

    public Informations info;

 private Informations addOnDatabase(String name, String phone, String email) {
        Informations info=null;

        try{
            Connection test=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","");
            Statement users= test.createStatement();
            String sql="INSERT INTO information(name,email,phone)" + "VALUES (?, ?, ?)";
            PreparedStatement preparedStatement=test.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,phone);

            /* We're connecting into our local database and we're putting the values that the user complete before into database via SQL commands */

            int add=preparedStatement.executeUpdate();
            if(add>0){
                info= new Informations();
                info.name=name;
                info.phone=phone;
                info.email=email;
            }
            users.close();
            test.close();

            /* Closing everything to avoid a bug or a crash */

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }



}


