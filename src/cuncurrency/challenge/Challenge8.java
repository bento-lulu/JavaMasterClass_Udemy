package cuncurrency.challenge;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {
	 
    public static void main(String[] args) {
    	Lock lock = new ReentrantLock();
    	
        Tutor tutor = new Tutor();
        Student student = new Student(tutor, lock);
        tutor.setStudent(student, lock);
 
        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });
 
        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });
 
        tutorThread.start();
        studentThread.start();
    }
}
 
class Tutor {
	private Lock lock;
    private Student student;
 
    public void setStudent(Student student, Lock lock ) {
        this.student = student;
        this.lock = lock;
    }
 
    public void studyTime() {
    	lock.lock();
    	try {
	        System.out.println("Tutor has arrived");
	        try {
	            // wait for student to arrive and hand in assignment
	            Thread.sleep(300);
	        }
	        catch (InterruptedException e) {
	 
	        }
	        student.startStudy();
	        System.out.println("Tutor is studying with student");
    	} finally {
    		lock.unlock();
    	}
    }
 
    public void getProgressReport() {
        // get progress report
    	System.out.println("Tutor gave progress report");
    }
}
 
class Student {
	private Lock lock;
    private Tutor tutor;
 
    Student(Tutor tutor, Lock lock ) {
        this.tutor = tutor;
        this.lock = lock;
    }
 
    public void startStudy() {
        // study
    	System.out.println("Student is studying");
    }
 
    public void handInAssignment() {
    	lock.lock();
    	try {
	        tutor.getProgressReport();
	        System.out.println("Student handed in assignment");
    	} finally {
			lock.unlock();
		}
    }
}






