package interview_300_questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Sergei Aleshchenko
 */
public class PriorityQueueExample {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    /*
Test data:
    12 \n
    ENTER John 3.75 50 \n
    ENTER Mark 3.8 24 \n
    ENTER Shafaet 3.7 35 \n
    SERVED \n
    SERVED \n
    ENTER Samiha 3.85 36 \n
    SERVED \n
    ENTER Ashley 3.9 42 \n
    ENTER Maria 3.6 46 \n
    ENTER Anik 3.95 49 \n
    ENTER Dan 3.95 50 \n
    SERVED \n


Result:
    Dan
    Ashley
    Shafaet
    Maria

     */



    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Queue<Student> priorQueue = new PriorityQueue<>(new StudentComparator());
        List<Student> result = new ArrayList<>();

        for(String event: events) {
            String[] eventsArr = event.split(" ");

            if(eventsArr[0].equals("ENTER")) {
                int id = Integer.valueOf(eventsArr[3]);
                String name = eventsArr[1];
                double cgpa = Double.valueOf(eventsArr[2]);

                priorQueue.add(new Student(id, name, cgpa));
            } else {
                priorQueue.poll();
            }
        }

        while (!priorQueue.isEmpty()) {
            result.add(priorQueue.poll());
        }

        return result;
    }
}

class StudentComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
        int compareCGPA = Double.compare(s2.getCGPA(), s1.getCGPA());

        if(compareCGPA != 0) {
            return compareCGPA;
        } else {
            int compareNames = s1.getName().compareTo(s2.getName());

            if(compareNames != 0) {
                return compareNames;
            } else {
                return s2.getID() - s1.getID();
            }
        }
    }
}
