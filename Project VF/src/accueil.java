
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;


public class accueil extends JDialog{

    private JButton ADDButton;
    private JButton DELETEButton;
    private JPanel accueil_info;

/* Initialization of text field and button of the form */

    public accueil(JFrame parent){
        super(parent);
        setTitle("Database project");
        setContentPane(accueil_info);
        setMinimumSize(new Dimension(400,400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        /* Diferent parameters about the panel like the dimension, what to print, stop the program when we close the panel etc  */

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiform gui= new guiform(null);
            }
        });
        /* When the user click on "add", we go on the menu to put informations about the person and add it on the database*/


        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete del=new delete(null);
            }
        });
        /* When the user click on the "delete" button, we start the function who delete the user  */

        setVisible(true);

    }
    public static void main(String[] args) {

            accueil accueil = new accueil(null);

            /* Launching the graphic console */

    }
}

