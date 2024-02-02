package in.ajay.AnnieProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerticalGridLayoutDataEntryForm extends JFrame {

    public VerticalGridLayoutDataEntryForm() {
        setTitle("Vertical GridLayout Data Entry Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an array of labels and text fields
        String[] labels = {"File No:", "Form No:", "First Name:", "Last Name:", "Initial:", "Email:", "Father name:",
                "DOB:", "Gender:", "Profession:", "Mailing street:", "Mailing city:", "Mailing postal code:",
                "Mailing country:", "Service provider:", "File no2:", "Reference number:", "Sim no:",
                "Type of network:", "Cell model number:", "IMMEI-1:", "IMMEI-2:", "Type of plan:", "Credit card type:",
                "Contact value:", "Date of issue:", "Date of renewal:", "Installments:", "Amount in words:", "Remarks:"};

        JTextField[] textFields = new JTextField[labels.length];

        // Create a panel with GridLayout
        JPanel contentPanel = new JPanel(new FlowLayout());
        
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Arial", Font.BOLD, 25)); // Set font size for labels
            label.setHorizontalAlignment(JLabel.RIGHT);
            contentPanel.add(label);

            textFields[i] = new JTextField(15);
            textFields[i].setFont(new Font("Arial", Font.PLAIN, 25)); // Set font size for text fields
            contentPanel.add(textFields[i]);
        }

        // Create a JScrollPane and add the panel to it
//        JScrollPane scrollPane = new JScrollPane(contentPanel);
//
//        // Set the vertical scrollbar policy to "always"
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Create a submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setSize(new Dimension(150,50));

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display confirmation dialog
                int result = JOptionPane.showConfirmDialog(VerticalGridLayoutDataEntryForm.this,
                        "Are you sure you want to submit the form?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    // Perform actions upon confirmation (you can customize this part)
                    JOptionPane.showMessageDialog(VerticalGridLayoutDataEntryForm.this, "Form submitted successfully!");
                }
            }
        });

        // Create a panel for the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100,50));
        buttonPanel.add(submitButton);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200,50));
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(200,50));
        
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200,100));
        

        // Set BorderLayout for the main frame
        setLayout(new BorderLayout());

        // Add the JScrollPane to the center of the BorderLayout
        add(contentPanel, BorderLayout.CENTER);

        // Add the buttonPanel to the south of the BorderLayout
        add(buttonPanel, BorderLayout.SOUTH);
        add(rightPanel,BorderLayout.EAST);
        add(topPanel,BorderLayout.NORTH);
        add(leftPanel,BorderLayout.WEST);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VerticalGridLayoutDataEntryForm();
            }
        });
    }
}

