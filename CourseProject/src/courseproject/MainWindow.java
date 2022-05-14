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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

/**
 * I don't know whether it's fine or not, this didn't use the java swing jar thingy.
 * My friend had helped me for this.
 * @author User
 */
public class MainWindow extends JFrame implements ActionListener {

//    private static final long serialVersionUID = 1L;
//    private JMenuBar menuBar;
//    private JMenu adminMenu;
//    private JMenu teacherMenu;
//    private JMenu staffMenu;
//
//    private JMenuItem ADMIN_EXIT;
//    private JMenuItem ADD_PART_TIME_TEACHER;
//    private JMenuItem ADD_FULL_TIME_TEACHER;
//    private JMenuItem ADD_STAFF;
//    private Map<Integer, Department> idVsDepartment;
//
    /**
     * Creates the main window GUI(?)
     * @param idVsDepartment 
     */
    public MainWindow(Map<Integer, Department> idVsDepartment) {
//        this.idVsDepartment = idVsDepartment;
//        initialize();
    }
//
//    /**
//     * Initialize the contents of the frame.
//     */
//    private void initialize() {
//
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception ex) {
//
//        }
//
//        setTitle("Admin Dashboard");
//
//        menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//
//        // adding adminMenu menu and menu items
//        adminMenu = new JMenu("ADMIN");
//        menuBar.add(adminMenu);
//
//        ADMIN_EXIT = new JMenuItem("Exit");
//        adminMenu.add(ADMIN_EXIT);
//        ADMIN_EXIT.addActionListener(this);
//
//        // adding Job Applicants menu and menu items
//        teacherMenu = new JMenu("TEACHER");
//        menuBar.add(teacherMenu);
//
//        ADD_PART_TIME_TEACHER = new JMenuItem("Add Part Time");
//        ADD_FULL_TIME_TEACHER = new JMenuItem("Add Full Time");
//
//        teacherMenu.add(ADD_PART_TIME_TEACHER);
//        teacherMenu.add(ADD_FULL_TIME_TEACHER);
//
//        for (int i = 0; i < teacherMenu.getItemCount(); i++) {
//                teacherMenu.getItem(i).addActionListener(this);
//        }
//
//        // adding membersMenu menu and menu items
//        staffMenu = new JMenu("STAFF");
//        menuBar.add(staffMenu);
//
//        ADD_STAFF = new JMenuItem("Add Staff");
//
//        staffMenu.add(ADD_STAFF);
//
//        ADD_STAFF.addActionListener(this);
//
//        setSize(800, 500);
//
//        setVisible(true);
//        setAutoRequestFocus(true);
//        // toFront();
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//    }
//
//    /**
//     * Implements actions listener on any of the menu item clicked The processing of
//     * every menu item is being done in its own Window
//     */
//    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == ADMIN_EXIT) {
//            exitProcessing();
//        } else if (ae.getSource() == ADD_FULL_TIME_TEACHER) {
//            new AddTeacher(this, idVsDepartment, "fullTime");
//        } else if (ae.getSource() == ADD_PART_TIME_TEACHER) {
//            new AddTeacher(this, idVsDepartment, "partTime");
//        } else if (ae.getSource() == ADD_STAFF) {
//            new AddStaff(this, idVsDepartment);
//        }
    }
//
//    private void exitProcessing() {
//            setVisible(false);
//            dispose();
//    }
}
