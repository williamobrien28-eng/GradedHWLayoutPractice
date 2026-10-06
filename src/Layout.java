import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Layout implements ActionListener {
    private JFrame mainFrame;
    private JTextArea textArea;
    private JTextField display;
    private int WIDTH=800;
    private int HEIGHT=700;
    private JButton submitButton;
    private JButton resetButton;
    private JButton clearInputButton;
    private JScrollPane scrollPane;



    public Layout() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Layout swingControlDemo = new Layout();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("simple application");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

        //menu at top





        //end menu at top

        // ta = new JTextArea();
        // ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        // mainFrame.add(mb);  //add menu bar
        //  mainFrame.add(ta);//add typing area
        // mainFrame.setJMenuBar(mb); //set menu bar


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        // controlPanel = new JPanel();
        //  controlPanel.setLayout(new BorderLayout()); //set the layout of the pannel

        //mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel("Input: ");
        display = new JTextField(30);
        inputPanel.add(inputLabel);
        inputPanel.add(display);

        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");
        clearInputButton = new JButton("Clear Input Only");

        submitButton.setActionCommand("Submit");
        resetButton.setActionCommand("Reset");
        clearInputButton.setActionCommand("ClearInput");

        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        clearInputButton.addActionListener(this);

        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(clearInputButton);

        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);
        mainFrame.setVisible(true);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);

        // Add components to main frame
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(scrollPane, BorderLayout.CENTER);














        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Submit")) {
            String text = display.getText();
            textArea.append(text + "\n");
        } else if (command.equals("Reset")) {
            display.setText("");
            textArea.setText("");
        } else if (command.equals("ClearInput")) {
            display.setText("");
        }
    }


}