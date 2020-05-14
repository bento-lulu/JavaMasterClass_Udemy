package cuncurrency.challenge;

/**
 * Created by timbuchalka on 16/08/2016.
 */
public class Challenge9 {
    public static void main(String[] args) {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent(tutor);
        tutor.setStudent(student);

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

class NewTutor {
    private NewStudent student;
	private boolean arrived;

    public void setStudent(NewStudent student) {
        this.student = student;
    }
    
    public void studyTime() {
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
        synchronized (this) {
        	System.err.println("Tutor got tutor lock");
            System.out.println("Tutor has arrived");
            arrived = true;
            synchronized (student) {
            	System.err.println("Student got student lock");
            	while( !student.hasArrived() ) {
	                try {
	                    // wait for student to arrive
	                	this.wait(100);
	                } catch (InterruptedException e) {
	        			System.err.println(e);
					}
            	}
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }
    }

    public void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
    
    public boolean hasArrived() {
    	return arrived;
    }
}

class NewStudent {

	private boolean arrived;
    private NewTutor tutor;

    NewStudent(NewTutor tutor) {
        this.tutor = tutor;
    }

    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        synchronized (tutor) {
        	System.err.println("Student got tutor lock");
        	while ( !tutor.hasArrived() ) {
        		try {
					tutor.wait(100);
				} catch (InterruptedException e) {
					System.err.println(e);
				}
        	}
            System.out.println("Student has arrived");
            tutor.getProgressReport();
            System.out.println("Student handed in assignment");
            arrived = true;
            tutor.notifyAll();
        }
    }
    
    public boolean hasArrived() {
    	return arrived;
    }
}