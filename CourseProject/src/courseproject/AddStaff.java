/*
 * The MIT License
 *
 * Copyright 2022 User.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package courseproject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class AddStaff extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private MainWindow mw;
    private JTextField fName = new JTextField();
    private JTextField lName = new JTextField();
    private JTextField age = new JTextField();
    private JTextField gender = new JTextField();
    private JTextField origin = new JTextField();
    private JTextField duty = new JTextField();
    private JTextField workLoad = new JTextField();
    private JTextField department = new JTextField();

    private JButton addBtn = new JButton("Add");
    private JButton cancelBtn = new JButton("Cancel");

    //map class for containsKey method. (checks whether deptID exist or not?)
    private Map<Integer, Department> idVsDepartment;

    public AddStaff(MainWindow mw, Map<Integer, Department> idVsDepartment) {
        this.mw = mw;
        this.idVsDepartment = idVsDepartment;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * 
     * @param teacherType
     */
    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("Add New Teacher");

        setSize(300, 200);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(8, 3));
        topPanel.add(new JLabel("First Name : "));
        topPanel.add(fName);
        topPanel.add(new JLabel("Last Name : "));
        topPanel.add(lName);
        topPanel.add(new JLabel("Age : "));
        topPanel.add(age);
        topPanel.add(new JLabel("Gender : "));
        topPanel.add(gender);
        topPanel.add(new JLabel("Origin : "));
        topPanel.add(origin);
        topPanel.add(new JLabel("Duty : "));
        topPanel.add(duty);
        topPanel.add(new JLabel("Work Load : "));
        topPanel.add(workLoad);
        topPanel.add(new JLabel("Department : "));
        topPanel.add(department);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(new JLabel("     "));
        bottomPanel.add(addBtn);
        bottomPanel.add(cancelBtn);

        addBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        this.getContentPane().add(topPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(mw);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            addStaff();
            this.dispose();
        } else if (ae.getSource() == cancelBtn) {
            this.setVisible(false);
            this.dispose();
        }

    }

    /**
     * A method to add a staff informations
     */
    private void addStaff() {
        try {
            int deptId = Integer.parseInt(department.getText());
            if (idVsDepartment.containsKey(deptId)) {
                Staff staff = getStaff();
                Department department = idVsDepartment.get(deptId);
                department.addStaff(staff);
                JOptionPane.showMessageDialog(this, "Staff Added Successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Department with id " 
                                + department.getText() + " does not exist",
                                "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex, "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private Staff getStaff() {
        Staff staff = new Staff(fName.getText(), lName.getText(), 
                        Integer.parseInt(age.getText()), gender.getText(),
                        origin.getText(), duty.getText(), 
                        Double.parseDouble(workLoad.getText()));
        return staff;
    }
}
