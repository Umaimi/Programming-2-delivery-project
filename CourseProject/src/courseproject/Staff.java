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

import java.util.Objects;

/**
 *
 * @author User
 */
public class Staff extends Person implements PayRoll {
	private String duty;
	private double workload; // hours worked per week

	public Staff(String fName, String lName, int age, String gender, 
                    String origin, String duty, double workload) {
		super(fName, lName, age, gender, origin);
		if (workload > 40) {
			throw new IllegalArgumentException("The workload should "
                                + "be less than 40");
		}
		this.duty = duty;
		this.workload = workload;
	}

	public String getDuty() {
		return duty;
	}

	public double getWorkload() {
		return workload;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public void setWorkload(double workload) {
		if (workload > 40)
			throw new IllegalArgumentException("Workload should not "
                                + "be more than 40 hours");
		this.workload = workload;
	}

	@Override
	public double computePayRoll() {
		double salary = 0;
		salary = (workload * 32 * 2) * 0.75;
		return salary;
	}

	@Override
	public String getRole() {
		return "\nRole: Staff\n";
	}

	@Override
	public String toString() {
		String strOut = "";

		strOut += getRole();
		strOut += String.format("-----Staff Information & Details-----\n");
		strOut += String.format("%-21s: %s %s\n", "First and last name", fName, lName);
		strOut += String.format("%-21s: %s\n", "Duty", duty);
		strOut += String.format("%-21s: %.2f\n", "Workload", workload);
		strOut += String.format("%-21s: %s\n", "Salary", computePayRoll());
		return strOut;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return age == other.age && Objects.equals(fName, other.fName) 
                                && Objects.equals(gender, other.gender)
				&& Objects.equals(lName, other.lName) 
                                && Objects.equals(origin, other.origin)
				&& Objects.equals(duty, other.duty)
				&& Double.doubleToLongBits(workload) 
                                == Double.doubleToLongBits(other.workload);
	}

	public String printStaffDataToFile() {
		return fName + "," + lName + "," + age + "," + gender 
                        + "," + origin + "," + duty + "," + workload;
	}
}
