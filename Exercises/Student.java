import java.util.*;
import java.io.*;

class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int score;

    public Student (String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public int compareTo(Student b) {
        int lastDiff = lastName.compareTo(b.lastName);
        if (lastDiff != 0) {
            return lastDiff;
        }
        else { // last names are equal
            return firstName.compareTo(b.firstName);
        }
    }

    public static void print(Student[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].firstName + " " + arr[i].lastName + ": " + arr[i].score);
        }
    }


    public static void main (String[] args) {
        int n = 4;
        Student arr[] = new Student[n];

        arr[0] = new Student("Jene", "Choi", 3);
        arr[1] = new Student("Jennie", "Choi", 4);
        arr[2] = new Student("Jane", "Choi", 5);
        arr[3] = new Student("Aby", "Kim", 2);

        Arrays.sort(arr);
        print(arr);
    }
}