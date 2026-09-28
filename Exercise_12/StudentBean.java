package Exercise_12;

import java.io.Serializable;

public class StudentBean implements Serializable {

    private String name;
    private int roll;
    private int[] marks = new int[5];

    public StudentBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public int[] getMarks() {
        return marks;
    }

    public int getTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    public double getAverage() {
        return getTotal() / 5.0;
    }

    public String getGrade() {

        double avg = getAverage();

        if (avg >= 90)
            return "A+";
        else if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "F";
    }

    public String getResult() {

        for (int mark : marks) {
            if (mark < 35)
                return "FAIL";
        }

        return "PASS";
    }
}