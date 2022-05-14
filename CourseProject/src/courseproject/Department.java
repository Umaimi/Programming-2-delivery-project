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

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Department {
	private ArrayList<Teacher> listOfTeacher;
	private ArrayList<Staff> listOfStaff;
	private Teacher dean;
	private static int deptId;

	public Department(ArrayList<Teacher> listOfTeachers, 
                ArrayList<Staff> listOfStaffs, Teacher dean) throws InvalidDean {
            if (dean == null) {
                    throw new InvalidDean("Dean can't be null");
            } else if (!(dean instanceof Teacher)) {
                    throw new InvalidDean("Dean must be a teacher");
            }
            this.listOfTeacher = listOfTeachers;
            this.listOfStaff = listOfStaffs;
            this.dean = dean;
            deptId++;
	}

	/**
	 * Take a teacher object and then add it to the department's Teacher array list
	 * (listOfTeachers)
	 * 
	 * @param path    the department file you wish to add teachers to
	 * @param teacher teacher object
	 */
	public void addTeacher(Teacher teacher) {
            if (listOfTeacher.contains(teacher)) {
                    System.out.println(teacher);
                    System.out.println("This teacher already exist.");
            } else {
                    // add the teacher
                    listOfTeacher.add(teacher);
            }
	}

	public void addStaff(Staff staff) {
            if (listOfStaff.contains(staff)) {
                    System.out.println("This staff already exist.");
            } else {
                    // add the staff
                    listOfStaff.add(staff);
            }
	}

	public ArrayList<Teacher> getListOfTeacher() {
            return listOfTeacher;
	}

	public void setListOfTeacher(ArrayList<Teacher> listOfTeachers) {
            this.listOfTeacher = listOfTeachers;
	}

	public ArrayList<Staff> getListOfStaff() {
            return listOfStaff;
	}

	public void setListOfStaff(ArrayList<Staff> listOfStaffs) {
            this.listOfStaff = listOfStaffs;
	}

	public Teacher getDean() {
            return dean;
	}

	public void setDean(Teacher dean) throws InvalidDean {
            if (this.dean != null) {
                    throw new InvalidDean("Dean is already assigned");
            } else if (dean == null) {
                    throw new InvalidDean("Dean can't be null");
            } else if (!(dean instanceof Teacher)) {
                    throw new InvalidDean("Dean must be a teacher");
            }
            this.dean = dean;
	}

	public int getDeptId() {
            return deptId;
	}

	@Override
	public String toString() {
            String output = "Department [Dept Id:" + deptId + "]\n";
            output += "\n===============";
            output += "\nList of Teacher";
            output += "\n===============";
            for (int i = 0; i < listOfTeacher.size(); i++) {
                    output += listOfTeacher.get(i).toString();
            }

            output += "\n=============";
            output += "\nList of Staff";
            output += "\n=============";
            for (int i = 0; i < listOfStaff.size(); i++) {
                    output += listOfStaff.get(i).toString();
            }

            output += "\n====";
            output += "\nDean";
            output += "\n====";
            output += dean.toString();

            return output;
	}
}
