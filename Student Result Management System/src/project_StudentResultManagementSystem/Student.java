package project_StudentResultManagementSystem;

public class Student {
    private String name;
    private int rollNo;
    private int[] marks;

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public int getTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getPercentage() {
        return getTotal() / (double) marks.length;
    }

    public String getGrade() {
        double percent = getPercentage();
        if (percent >= 90) return "A+";
        else if (percent >= 75) return "A";
        else if (percent >= 60) return "B";
        else if (percent >= 40) return "C";
        else return "Fail";
    }

    public boolean isPass() {
        return !getGrade().equals("Fail");
    }

    public void displayStudentReport() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.print("Marks   : ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\nTotal   : " + getTotal());
        System.out.println("Percent : " + getPercentage() + "%");
        System.out.println("Grade   : " + getGrade());
        System.out.println("Status  : " + (isPass() ? "Passed" : "Failed"));
        System.out.println("-------------------------------------------------");
    }
}
