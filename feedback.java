
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class feedback extends JFrame{
    JLabel LABEL;
    JTextField NAMEOFUSER;
    JLabel NAME;
    JLabel EMAIL;
    JCheckBox check;
    JComboBox<String> AGEBOX;
    JTextField EMAILOFUSER;
    JLabel descp;
    JTextField PUTFEED;
    JButton SUBMIT;
    JButton RESET;
    JPanel MainPanel;
    JRadioButton one;
    JRadioButton two;
    JRadioButton four;
    JRadioButton three;
    JRadioButton five;
    JLabel AGE;
    JLabel RATING;

    ButtonGroup RATEBUTTON;

    Container cp;

    JFrame f;

    String[] ages= {"Below 18","18-25","25-30","30-40","40+"};
    public feedback(){


        this.setTitle("FEEDBACK SURVEY");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700, 600);
       // cp= getContentPane();
        this.setLayout(null);
        //this.cp.setBackground(new java.awt.Color(0000));
        setVisible(true);
        //setContentPane(MainPanel);

        ImageIcon icon= new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());

        JLabel LABEL= new JLabel();
        LABEL.setText("FEEDBACK SURVEY");
        LABEL.setFont(new Font("Arial", Font.BOLD, 36));
        LABEL.setBounds(80,0,440,45);
        this.cp.add(LABEL);

        JLabel NAME= new JLabel();
        NAME.setText("NAME OF USER");
        NAME.setFont(new Font("Calibri", Font.PLAIN, 18));
        NAME.setBounds(50,60,80,28);
        this.cp.add(NAME);

        NAMEOFUSER = new JTextField();
        NAMEOFUSER.setFont(new Font("Calibri", Font.PLAIN, 16));
        NAMEOFUSER.setBounds(230, 60, 240, 28);
        this.cp.add(NAMEOFUSER);

        JLabel EMAIL= new JLabel();
        EMAIL.setText("EMAIL");
        EMAIL.setFont(new Font("Calibri", Font.PLAIN, 18));
        EMAIL.setBounds(50,110, 150, 28);
        this.cp.add(EMAIL);

        EMAILOFUSER = new JTextField();
        EMAILOFUSER.setFont(new Font("Calibri", Font.PLAIN, 16));
        EMAILOFUSER.setBounds(230, 105, 240, 28);
        this.cp.add(EMAILOFUSER);

        check = new JCheckBox("Receive Promotional Email");
        check.setFont(new Font("Calibri", Font.PLAIN, 15));
        check.setBounds(230, 135, 240, 20);
        check.setSelected(true);
        this.cp.add(check);

        JLabel AGE= new JLabel();
        AGE.setText("AGE GROUP");
        AGE.setFont(new Font("Calibri", Font.PLAIN, 18));
        AGE.setBounds(50,180,150,28);
        this.cp.add(AGE);

        AGEBOX= new JComboBox<>(ages);
        AGEBOX.setBounds(230,180,120,28);
        this.cp.add(AGEBOX);

        JLabel RATING= new JLabel();
        RATING.setText("RATING");
        RATING.setFont(new Font("Calibri", Font.PLAIN, 18));
        RATING.setBounds(50,230,100,28);
        this.cp.add(RATING);


        one=new JRadioButton("1");
        two=new JRadioButton("2");
        three=new JRadioButton("3");
        four=new JRadioButton("4");
        five=new JRadioButton("5");

        one.setBounds(230, 230, 40, 28);
        two.setBounds(280, 230, 40, 28);
        three.setBounds(330, 230, 40, 28);
        four.setBounds(380, 230, 40, 28);
        five.setBounds(430, 230, 40, 28);
        five.setSelected(true);

        RATEBUTTON = new ButtonGroup();
        RATEBUTTON.add(one);
        RATEBUTTON.add(two);
        RATEBUTTON.add(three);
        RATEBUTTON.add(four);
        RATEBUTTON.add(five);



        JLabel decp= new JLabel();
        decp.setText("DESSCRIPTION (optional)");
        decp.setFont(new Font("Calibri", Font.PLAIN, 18));
        decp.setBounds(50,280,170,28);
        this.cp.add(decp);

        PUTFEED = new JTextField();
        PUTFEED.setFont(new Font("Calibri", Font.PLAIN, 16));
        PUTFEED.setBounds(230, 280, 240, 84);
        this.cp.add(PUTFEED);

        SUBMIT = new JButton("SUBMIT");
        SUBMIT.setFont(new Font("Calibri", Font.PLAIN, 18));
        SUBMIT.setBounds(165, 410, 100, 28);
        this.cp.add(SUBMIT);


        RESET = new JButton("RESET");
        RESET.setFont(new Font("Calibri", Font.PLAIN, 18));
        RESET.setBounds(275, 410, 100, 28);
        this.cp.add(RESET);





        SUBMIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(feedback.this,"FEEDBACK SUBMITTED SUCCESSFULLY \n THANKS FOR VISITING");
            }
        });
        RESET.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(feedback.this,"RESET DONE \n PLEASE FILL FEEDBACK FORM");
            }
        });

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        boolean flag=false;
        String emailvalidation = "^[a-zA-Z0-9+_.-]+@(.+)$";
        Pattern p= Pattern.compile(emailvalidation);
        Matcher mat= p.matcher(EMAILOFUSER.getText());
        f= new JFrame();

        if(e.getSource()== SUBMIT)
        {
            if((NAMEOFUSER.getText().isEmpty()) || (NAMEOFUSER.getText() == null))
            {
                JOptionPane.showMessageDialog(f, "Name cannot be empty");
            }
            else if((EMAILOFUSER.getText().isEmpty()) || (EMAILOFUSER.getText() == null))
            {
                JOptionPane.showMessageDialog(f, "Email cannot be empty");
            }
            else if(!mat.matches())
            {
                JOptionPane.showMessageDialog(f, "Please Enter a valid Email");
            }
            else
                flag=true;

            if(flag)
            {
                String r;
                if(one.isSelected())
                    r="One star";
                else if(two.isSelected())
                    r="Two stars";
                else if(three.isSelected())
                    r="Three stars";
                else if(four.isSelected())
                    r="Four stars";
                else
                    r="Five stars";
                String s1= "Thank you for your valuable Feeedback!\n\nYour Responses:-\n";
                String s2= "Name: "+NAMEOFUSER.getText()+"\nEmail: "+EMAILOFUSER.getText()+"\nAge group: "+(String)AGEBOX.getSelectedItem()+"\nRating: "+r+"\nFeedback: "+ descp.getText();
                String disp=s1+s2;
                JOptionPane.showMessageDialog(f, disp);
            }

        }

        else if( e.getSource()==RESET){
            NAMEOFUSER.setText(null);
            EMAILOFUSER.setText(null);
            descp.setText(null);
            AGEBOX.setSelectedIndex(0);
            one.setSelected(false);
            two.setSelected(false);
            three.setSelected(false);
            four.setSelected(false);
            five.setSelected(true);
        }

    }
}

