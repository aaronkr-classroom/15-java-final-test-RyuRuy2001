package a_Calulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class final_test_calculator extends JFrame implements ActionListener {
	private JTextField display;
    private JPanel panel;
    private String[] buttons = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "0", "AC", "=", "/"
    };
    private double temp, temp1, result;
    private char operator;

    public final_test_calculator() {
  
    	// Create display field
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(200, 50));

        // Create panel for buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        // Set up frame layout
        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // Create menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");

        // Add menu items to menus
        fileMenu.add(newItem);
        fileMenu.add(openItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Add menu bar to frame
        setJMenuBar(menuBar);

        // Set frame properties
        setTitle("계산기");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            display.setText(display.getText() + command);
        } else if (command.equals("AC")) {
            display.setText("");
            temp = temp1 = result = 0;
            operator = '\0';
        } else if (command.equals("=")) {
            temp1 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+' -> result = temp + temp1;
                case '-' -> result = temp - temp1;
                case '*' -> result = temp * temp1;
                case '/' -> result = temp / temp1;
            }
            display.setText(Double.toString(result));
            operator = '\0'; // Reset operator after calculation
        } else {
            if (operator == '\0') {
                temp = Double.parseDouble(display.getText());
            } else {
                temp1 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+' -> temp = temp + temp1;
                    case '-' -> temp = temp - temp1;
                    case '*' -> temp = temp * temp1;
                    case '/' -> temp = temp / temp1;
                }
            }
            operator = command.charAt(0);
            display.setText("");
        }
    }



    public static void main(String[] args) {
        new final_test_calculator();
    }
}
