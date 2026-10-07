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
    //referenced oracle help center for scrollpane help



    public Layout() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Layout swingControlDemo = new Layout();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("graded layout hw ");
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
        display.setBackground(new Color(0, 216, 4, 84));
        display.setForeground(new Color(73, 33, 191, 97));
        inputPanel.add(inputLabel);
        inputPanel.add(display);
        inputPanel.setBackground(new Color(220, 185, 9));

        JPanel buttonPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.ORANGE);
        submitButton.setForeground(Color.BLUE);
        submitButton.setOpaque(true);
        //referenced stackoverflow and w3 schools to figure out how to do color
        resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(17, 186, 127));
        resetButton.setForeground(new Color(162, 195, 143));
        resetButton.setOpaque(true);
        clearInputButton = new JButton("Clear Input Only");
        clearInputButton.setBackground(Color.MAGENTA);
        clearInputButton.setForeground(Color.PINK);
        clearInputButton.setOpaque(true);

        submitButton.setActionCommand("Submit");
        resetButton.setActionCommand("Reset");
        clearInputButton.setActionCommand("ClearInput");

        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        clearInputButton.addActionListener(this);

        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(clearInputButton);
        buttonPanel.setBackground(Color.YELLOW);

        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);
        mainFrame.setVisible(true);
        mainFrame.setBackground(Color.CYAN);
        textArea = new JTextArea();
        textArea.setBackground(new Color(255,165,0));
        textArea.setEditable(false);
        textArea.setForeground(Color.BLUE);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBackground(Color.GREEN);

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
            //referenced oracle java documents for help
        } else if (command.equals("Reset")) {
            display.setText("");
            textArea.setText("");
        } else if (command.equals("ClearInput")) {
            display.setText("");
        }
    }


}