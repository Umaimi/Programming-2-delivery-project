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

/**
 *
 * @author User
 */
public class PartTime extends Teacher implements PayRoll {
	private double hoursWorked;

	public PartTime(String fName, String lName, int age, String gender, 
                String origin, String specialty, String degree, double hoursWorked) {
		super(fName, lName, age, gender, origin, specialty, degree);
		this.hoursWorked = hoursWorked;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	@Override
	public double computePayRoll() {
		double degreeRate = getDegreeRate(degree);
		double salary = 0;
		salary = (hoursWorked * degreeRate * 2) * 0.76;
		return salary;
	}

	@Override
	public String toString() {
		String output = super.toString();
		output += String.format("%-21s: %s\n", "Type", "Part Time");
		output += String.format("%-21s: %s\n", "Hours Worked", hoursWorked);
		output += String.format("%-21s: %s\n", "Salary", computePayRoll());
		return output;
	}

	@Override
	public String printTeacherDataToFile() {
		return "PartTime" + "," + super.printTeacherDataToFile() + "," + hoursWorked;
	}
}
