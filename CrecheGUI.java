package za.ac.tut.ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import za.ac.tut.model.Child;
public class CrecheGUI extends JFrame {
    private JPanel mainPnl, nameGenderPnl, displayRegisterPnl, namePnl, genderPnl, textAreaPnl;
    private JLabel nameLbl, genderLbl;
    private JTextField nameTxtFld;
    private JButton registerBtn, displayBtn;
    private JRadioButton radioMale, radioFemale;
    private ButtonGroup genderGroup;
    private JTextArea textArea;
    private JScrollPane scrollpane;
    private ArrayList<Child> kidsList;
    public CrecheGUI() {
        setTitle("CRECHE 4 YOUR KIDDIE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 250);
         kidsList = new ArrayList<>();
        mainPnl = new JPanel(new BorderLayout());
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameGenderPnl = new JPanel(new GridLayout(2, 1));
        displayRegisterPnl = new JPanel(new FlowLayout());
        textAreaPnl = new JPanel(new BorderLayout());
        nameTxtFld = new JTextField(15);
        nameLbl = new JLabel("Name:");
        genderLbl = new JLabel("Gender:");
        radioMale = new JRadioButton("Male");
        radioFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);
        registerBtn = new JButton("Register kiddie");
        displayBtn = new JButton("Display kiddies");
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        scrollpane = new JScrollPane(textArea);
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        genderPnl.add(genderLbl);
        genderPnl.add(radioMale);
        genderPnl.add(radioFemale);
        nameGenderPnl.add(namePnl);
        nameGenderPnl.add(genderPnl);
        displayRegisterPnl.add(registerBtn);
        displayRegisterPnl.add(displayBtn);
        textAreaPnl.add(scrollpane, BorderLayout.CENTER);
        mainPnl.add(nameGenderPnl, BorderLayout.NORTH);
        mainPnl.add(displayRegisterPnl, BorderLayout.CENTER);
        mainPnl.add(textAreaPnl, BorderLayout.SOUTH);
        add(mainPnl);
        registerBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                registerKid();
            }
        });
        displayBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                displayKiddie();
           }
        });
        setVisible(true);
    }
    private void  registerKid(){
        String name = nameTxtFld.getText().trim();
        String gender = null;
        if (radioMale.isSelected()) {
            gender = "Male";
        }else if(radioFemale.isSelected()){
            gender = "Female";
        }
        if (name.isEmpty()|| gender == null) {
            JOptionPane.showMessageDialog(null, "Please enter all details.", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        kidsList.add(new Child(name, gender));
        nameTxtFld.setText("");
        genderGroup.clearSelection();
        JOptionPane.showMessageDialog(null, "Kid registered successfully!");
    }
    private void  displayKiddie(){
        textArea.setText("");
        if (kidsList.isEmpty()) {
            textArea.setText("No kids registered yet.");
        }else{
               for (Child kid : kidsList) {
                textArea.append(kid.toString() + "\n");} }}}
