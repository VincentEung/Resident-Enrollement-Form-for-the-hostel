import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete extends JDialog {
    private JTextField textField1;
    private JPanel delete_data;
    private JButton supprimer;

    /* Initialization of text field and button of the form */

    public delete(JFrame parent){
        super(parent);
        setTitle("Delete on database");
        setContentPane(delete_data);
        setMinimumSize(new Dimension(600,600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /* Diferent parameters about the panel like the dimension, what to print, stop the program when we close the panel etc  */

        supprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_user();
            }
            /* When the user click on the "delete" button, we start the function who delete the user  */
        });
        setVisible(true);

        }

    private void delete_user() {
        String phone=textField1.getText();
        if(phone.isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to complete this fields", "One more time ",JOptionPane.ERROR_MESSAGE);
            return;
    }
        info=deleteDatabase(phone);
        /* We put a security to not put invalid informations on database, so the user have to put something on the field  */
}

    private Informations deleteDatabase(String phone1) {
        Informations info=null;
        String phone=textField1.getText();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate("DELETE FROM information WHERE phone='" +phone+"'");

            /* We are using an SQL operation to delete the good information we want to, those commands permits to put the string on the SQL console of our database */
        }catch (Exception e) {
            e.printStackTrace();
        }
        accueil gui=new accueil(null);

        /* After deleting an user, we go back on the menu */

        return info;
    }



    public Informations info;
}

