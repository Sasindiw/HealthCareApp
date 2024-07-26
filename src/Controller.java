import java.sql.SQLOutput;
import java.util.*;

public class Controller {

    public static ArrayList<Doctor> allDoctors = new ArrayList<>();
    public static ArrayList<Patient> allPatients = new ArrayList<>();

    public static int NUMBER_OF_SLOTS = 5;

    public static void addDoctor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter Birthday ");
        String birthday = sc.nextLine();
        System.out.println("Enter Specialization");
        String specialization = sc.nextLine();
        System.out.println("Enter Contact Number: ");
        String contact = sc.nextLine();

        Random random = new Random();
        Doctor tempDoctor = new Doctor(random.nextInt(), name, birthday, specialization, contact);
        allDoctors.add(tempDoctor);
    }

    public static void addAvailabilityForDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the doctor you want to add Availability : ");
        int docId = scanner.nextInt();


        Doctor selectedDoctor = null;
        for (Doctor doc : Controller.allDoctors) {
            if (doc.getId() == docId) {
                selectedDoctor = doc;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("No Doctor Found");
            return;
        }

        System.out.println("Enter the day you want to add availability");
        int day = scanner.nextInt();
        System.out.println("Enter the month you want to add availability");
        int month = scanner.nextInt();
        System.out.println("Enter the year you want to add availability");
        int year = scanner.nextInt();

        Date bookingDate = new Date(year, month, day);


        selectedDoctor.setAvailability(bookingDate);
    }

    public static void viewAllDoctors() {
        for (Doctor doc : Controller.allDoctors) {
            System.out.println(doc.getName() + " has a specialization of " + doc.getSpecialization() + " has an ID of " + doc.getId() + " and has an availability of " + doc.getAvailability().toString()); // printing doctors name and the specialization
        }
    }


    public static void addNewPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Patient name: ");
        String name = sc.nextLine();
        System.out.println("Enter Patient Birthday ");
        String birthday = sc.nextLine();
        System.out.println("Enter Patient Contact Number: ");
        String contactNumber = sc.nextLine();
        System.out.println("Enter Patient ID: ");
        String id = sc.nextLine();
        Patient tempPatient = new Patient(name, birthday, contactNumber, id);
        allPatients.add(tempPatient);
        System.out.println("Patient Added Successfully");


    }


    public static void bookAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Doctors ID: ");
        int docId = scanner.nextInt();
        System.out.println("Enter the Patients ID: ");
        String patientId = scanner.next();

        System.out.println("Enter the day you want to add an appointment: ");
        String day = scanner.next();
        System.out.println("Enter the month you want to add an appointment: ");
        String month = scanner.next();
        System.out.println("Enter the year you want to add an appointment: ");
        String year = scanner.next();
        System.out.println("Appointment Booked Successfully");



        Patient selectedPatient = getPatientById(patientId);
        Doctor selectedDoctor = getDoctorById(docId);
        if (selectedDoctor == null || selectedPatient == null) {
            System.out.println("Invalid Doctor and Patient ID ");
            return;
        }





        Date appointmentDate = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        Boolean isAvailable = checkAvailability(selectedDoctor, appointmentDate);
        if (isAvailable) {
            String appTime = getTimeForBooking(selectedDoctor,appointmentDate);
            if(appTime != null){
                Appointment appointment = new Appointment(selectedDoctor, selectedPatient, "NO Notes", appointmentDate, "");
                selectedDoctor.setAppointment(appointment, appointmentDate);
            }
            else {
                System.out.println("All the slots are full");
            }



        } else {
            System.out.println("Doctor is not available on the selected Date ");
        }
    }






    private static String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking) {
        for (Map.Entry<Date, ArrayList<Appointment>> appointment : selectedDoctor.getAllAppointments().entrySet()) {
            if (appointment.getKey().equals(dateOfBooking)) {
                int numberOfSlots = appointment.getValue().size();
                if (numberOfSlots > NUMBER_OF_SLOTS - 1) {
                    return null;
                }
                System.out.println("We can make a booking ");
                int time = 17 + appointment.getValue().size();
                String strTime = time + " :  00";
                return strTime;
            }
        }

        return "17 : 00 ";
    }




    private static boolean checkAvailability (Doctor selectedDoctor , Date dateOfBooking){
        for ( Date day : selectedDoctor.getAvailability()){
            if(day.equals(dateOfBooking)){
                return true;
            }
        }
             return false;

    }



    public static Patient getPatientById(String id) {

        for (Patient patient : allPatients) {

            if (patient.getPatientId().equals(id)) {

                return patient;
            }
        }

        System.out.println("Np Patient Found");
        return null;

    }

    public static Doctor getDoctorById(int id) {
        for (Doctor doc : allDoctors) {
            if (doc.getId() == id) {
                return doc;
            }
        }
        System.out.println("No Doctor Found");
        return null;

    }


}
