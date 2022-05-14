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
public class Teacher extends Person implements PayRoll {
	protected String specialty;
	protected String degree;

	protected static final double PHD_DEGREE_RATE = 112;
	protected static final double MASTER_DEGREE_RATE = 82;
	protected static final double BACHELOR_DEGREE_RATE = 42;

	private static final String PHD = "phd";
	private static final String MASTER = "master";
	private static final String BACHELOR = "bachelor";

	protected Teacher(String fName, String lName, int age, String gender, 
                            String origin, String specialty, String degree) {
		super(fName, lName, age, gender, origin);
		this.specialty = specialty;
		this.degree = degree;
	}

	public Teacher() {
	}

	public String getSpecialty() {
		return specialty;
	}

	public String getDegree() {
		return degree;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Override
	public String getRole() {
		return "\nRole: Teacher\n";
	}

	@Override
	public String toString() {
		String strOut = "";

		strOut += getRole();
		strOut += String.format("----Teacher Information & Details-----\n");
		strOut += String.format("%-21s: %s %s\n", "First and last name", this.fName, this.lName);
		strOut += String.format("%-21s: %s\n", "Specialty", this.specialty);
		strOut += String.format("%-21s: %s\n", "Degree", this.degree);
		strOut += String.format("%-21s: %s\n", "Salary", computePayRoll());

		return strOut;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return age == other.age && Objects.equals(fName, other.fName) 
                                && Objects.equals(gender, other.gender)
				&& Objects.equals(lName, other.lName) 
                                && Objects.equals(origin, other.origin)
				&& Objects.equals(degree, other.degree) 
                                && Objects.equals(specialty, other.specialty);
	}

	protected double getDegreeRate(String degree) {
		if (PHD.equalsIgnoreCase(degree)) {
			return PHD_DEGREE_RATE;
		} else if (MASTER.equalsIgnoreCase(degree)) {
			return MASTER_DEGREE_RATE;
		} else if (BACHELOR.equalsIgnoreCase(degree)) {
			return MASTER_DEGREE_RATE;
		}

		return 0.0;
	}

	public String printTeacherDataToFile() {
		return fName + "," + lName + "," + age + "," + gender
                        + "," + origin + "," + specialty + "," + degree;
	}

	@Override
	public double computePayRoll() {
		double degreeRate = getDegreeRate(degree);
		double salary = 0;
		salary = (32 * degreeRate * 2) * 0.85;
		return salary;
	}
}
