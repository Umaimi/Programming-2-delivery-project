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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CourseProject {

    /** 
     * Hello miss. You kindly gave me extra time to finish this project 
     * but I don't think I can finish it. I've tried for days and my brain
     * can't put the pieces together. :')
     * 
     * I'm not going to lie, a friend of mine helped me a lot for this project 
     * and I still can't finish it. I don't care too much if I don't get a passing 
     * grade for this project. I'm just trying to collect as much points as possible
     * so it helps my final grade for this course. 
     * 
     * So, yes this source code is unfinished!
     * 
     * Other notes: Without a pre-existing teacher and staff .txt file,
     *              this won't work. I think.
     */
    
    // used Map class to store deptIDs because its mehtods are more
    // specific unlike arrayList
    static Map<Integer, Department> idVsDepartment = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Teacher> listOfTeacher = new ArrayList<>();
        ArrayList<Staff> listOfStaff = new ArrayList<>();
        Teacher dean = new Teacher();

        loadTeacherData("teacher.txt", listOfTeacher, dean);
        loadStaffData("staff.txt", listOfStaff);

        try {
            Department department = new Department(listOfTeacher, listOfStaff, dean);
            idVsDepartment.put(department.getDeptId(), department);
        } catch (InvalidDean e) {
            System.out.println(e);
        }

        System.out.println();
        showMenu();

    }

    /**
     * Load staff datas from a staff.txt file
     * @param fileName
     * @param listOfStaff 
     */
    private static void loadStaffData(String fileName, ArrayList<Staff> listOfStaff) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] split = line.split(",");
                Staff staff = getStaff(split);
                listOfStaff.add(staff);
            }

            System.out.println("Staff data loaded successfully from file staff.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    /**
     * Load teacher datas from a teacher.txt file
     * @param fileName
     * @param listOfTeacher
     * @param dean 
     */
    private static void loadTeacherData(String fileName, ArrayList<Teacher> listOfTeacher, Teacher dean) {
        try {
            Scanner sc = new Scanner(new File(fileName));
            
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] split = line.split(",");
                
                if (split[0].equalsIgnoreCase("PartTime")) {
                    Teacher partTime = getPartTime(split);
                    listOfTeacher.add(partTime);
                } else if (split[0].equalsIgnoreCase("FullTime")) {
                    Teacher fullTime = getFullTime(split);
                    listOfTeacher.add(fullTime);
                } else if (split[0].equalsIgnoreCase("Dean")) {
                    Teacher teacher = getDean(split);
                    dean.setfName(teacher.getfName());
                    dean.setlName(teacher.getlName());
                    dean.setAge(teacher.getAge());
                    dean.setGender(teacher.getGender());
                    dean.setOrigin(teacher.getOrigin());
                    dean.setSpecialty(teacher.getSpecialty());
                    dean.setDegree(teacher.getDegree());
                }
            }

                System.out.println("Teacher data loaded successfully from file teachers.txt");
        } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
        }
    }

    /**
     * console menu
     */
    private static void showMenu() {
        System.out.println("==================");
        System.out.println("List of Operations");
        System.out.println("==================");
        System.out.println("1. Show Department Data");
        System.out.println("2. Add Teacher/Staff to the Department(GUI)");
        System.out.println("3. Exit and Save the data");

        System.out.print("\nEnter your choice: ");
        try (Scanner sc = new Scanner(System.in)) {
                String choice = sc.nextLine();
                performAction(choice);
        }
    }

    /**
     * Enter either 1, 2 or 3 to choose what to execute
     * @param choice 
     */
    private static void performAction(String choice) {
        
        switch (choice) {
            
        case "1":
            printDepartmentData();
            showMenu();
            break;
        case "2":
            new MainWindow(idVsDepartment);
            System.out.println("\n\n");
            showMenu();
            break;
        case "3":
            try {
                    updateTeacherAndStaffDataToFile();
            } catch (IOException e) {
                    System.out.println("Error - " + e);
            }
            break;
        default:
            System.out.println("Entered choice(" + choice + ") is not correct");
            System.out.println("\n\n");
            showMenu();
            break;
        }
        
        System.out.println("\nFinished executing");
        System.exit(0);
    }

    /**
     * A method for third option of the console output. 
     * This will update respective teacher and staff file.
     * @throws IOException 
     */
    private static void updateTeacherAndStaffDataToFile() throws IOException {
        BufferedWriter teacherDataWriter = new BufferedWriter(new FileWriter("teacher.txt"));
        BufferedWriter staffDataWriter = new BufferedWriter(new FileWriter("staff.txt"));
        Iterator<Department> itr = getDepartmentData();
        
        while (itr.hasNext()) {
            Department department = itr.next();
            ArrayList<Teacher> listOfTeachers = department.getListOfTeacher();
            
            for (Teacher teacher : listOfTeachers) {
                teacherDataWriter.write(teacher.printTeacherDataToFile());
                teacherDataWriter.write("\n");
            }
            Teacher dean = department.getDean();
            teacherDataWriter.write("Dean" + "," + dean.printTeacherDataToFile());

            ArrayList<Staff> listOfStaffs = department.getListOfStaff();
            
            for (Staff staff : listOfStaffs) {
                staffDataWriter.write(staff.printStaffDataToFile());
                staffDataWriter.write("\n");
            }
        }
        
        teacherDataWriter.close();
        staffDataWriter.close();
        System.out.println("Teacher/Staff data successfully updated to "
                + "the respective files");
    }

    /**
     * Write out the department datas
     */
    private static void printDepartmentData() {
        Iterator<Department> iterator = getDepartmentData();
        
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        
        System.out.println("\n\n");
    }

    /**
     * Gets the department datas so it can be used as iteration later
     * @return 
     */
    private static Iterator<Department> getDepartmentData() {
        Collection<Department> departments = idVsDepartment.values();
        Iterator<Department> iterator = departments.iterator();
        
        return iterator;
    }

    private static Teacher getDean(String[] split) {
        String fName = split[1];
        String lName = split[2];
        int age = Integer.parseInt(split[3]);
        String gender = split[4];
        String origin = split[5];
        String speciality = split[6];
        String degree = split[7];

        Teacher dean = new Teacher(fName, lName, age, gender, 
                origin, speciality, degree);
        return dean;
    }

    private static Teacher getFullTime(String[] split) {
        // FullTime,Bin,Zhang,30,Female,LA,Java,PHD
        String fName = split[1];
        String lName = split[2];
        int age = Integer.parseInt(split[3]);
        String gender = split[4];
        String origin = split[5];
        String speciality = split[6];
        String degree = split[7];

        Teacher fullTimeTeacher = new FullTime(fName, lName, age, gender, 
                origin, speciality, degree);
        
        
        return fullTimeTeacher;
    }

    private static Teacher getPartTime(String[] split) {
        // PartTime,Klaus,Winzon,28,Male,Chicago,Data Structures,Master,20
        String fName = split[1];
        String lName = split[2];
        int age = Integer.parseInt(split[3]);
        String gender = split[4];
        String origin = split[5];
        String speciality = split[6];
        String degree = split[7];
        double hoursWorked = Double.parseDouble(split[8]);

        Teacher partTimeTeacher = new PartTime(fName, lName, age, gender, origin, 
                speciality, degree, hoursWorked);
        
        return partTimeTeacher;
    }

    private static Staff getStaff(String[] split) {
        String fName = split[0];
        String lName = split[1];
        int age = Integer.parseInt(split[2]);
        String gender = split[3];
        String origin = split[4];
        String duty = split[5];
        double workload = Double.parseDouble(split[6]);

        Staff staff = new Staff(fName, lName, age, gender, origin, duty, workload);
        
        return staff;
    }
}
