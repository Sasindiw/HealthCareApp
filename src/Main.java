import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {


            public static void adminMenu () {

                boolean runAdmin = true;
                while (runAdmin) {

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Press 1 to add a doctor , press 2 to add a doctor availability , press 3 to exit");
                    int userObjective = scanner.nextInt();

                    if (userObjective == 1) {
                        Controller.addDoctor();
                        System.out.println("Doctor is added Successfully");
                    }
                    else if (userObjective == 2) {
                        Controller.addAvailabilityForDoctor();
                        System.out.println("Doctor Availability Added Successfully");

                    } else if (userObjective == 3) {
                        runAdmin = false;
                        System.out.println("Exit");
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            }


            public static void patientMenu() {

                    boolean runPatient = true;
                    while (runPatient) {

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("press 1 to view Doctors , press 2 to book appointments ,  press 3 to view selected doctors booking ,press 4 to add a Patient , press 5 to exit");
                        int userService = scanner.nextInt();

                        if (userService == 1) {
                              Controller.viewAllDoctors();

                        } else if (userService == 2) {
                            Controller.bookAppointment();

                        } else if (userService == 3) {
                            System.out.println(" View Selected doctors booking");
                            
                        } else if (userService == 4) {
                            Controller.addNewPatient();


                        } else if (userService == 5){
                            runPatient = false; // ending loop
                            System.out.println("Exit");
                        }
                          else {
                              System.out.println("Invalid input ");
                        }

                    }
            }



            public static void run () {

                        boolean runMain = true;
                        while (runMain) {

                            Scanner scanner = new Scanner(System.in);
                            System.out.println("If you are a hospital administrator please press 1, if you are a patient please press 2, and press 3 to exit");
                            int userType = scanner.nextInt();

                            if (userType == 1) {
                                adminMenu();
                            } else if (userType == 2) {
                                patientMenu();
                            } else if (userType == 3) {
                                runMain = false;
                                System.out.println("Exit");
                            } else {
                                System.out.println("Invalid input");
                            }
                        }

                    }



        public  static void main (String [] args){

                Doctor sampleDoc = new Doctor(123,"rose","2002-05-21","Dermatologist","0779493832");

                Patient samplePatient = new Patient("Jack","2003-04-15","0773456939","T-12");

                Controller.allDoctors.add(sampleDoc);
                Controller.allPatients.add(samplePatient);

                run();



        // Doctor Objects
        Doctor doctorA = new Doctor(102,"max","1967-04-25","Neurophysiology","07734506650");
        Doctor doctorB = new Doctor(106,"rose","1956-07-14","Dermatologist","07754066944");


            System.out.println("Doctor A:");
            System.out.println("Is Physician: "+ doctorA.isPhysician());

            System.out.println("\nDoctorB:");
            System.out.println("Is Physician: "+ doctorB.isPhysician());


        Patient patientA = new Patient("rose","2002-11-25","0775969434","T-0034");
        Patient patientB = new Patient("john","2005-05-24","0775495643","D-5690");


            System.out.println("\nPatientA");
            System.out.println("Patient type: " + patientA.getPatientType());


            System.out.println("\nPatientB");
            System.out.println("Patient type: "+ patientB.getPatientType());
        }

}