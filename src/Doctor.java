import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor extends Person { //

     private int id;
    private String specialization;

    private  String doctorBirthday;

    private  ArrayList<Date> availability ;
    private  HashMap <Date,ArrayList<Appointment>>allAppointments = new HashMap<>();


    //Constructor
    public Doctor (int doctorId ,String doctorName, String doctorBirthday, String doctorSpecialization , String contactNumber){
        super(doctorName,contactNumber);
        this.id = doctorId;
        this.specialization = doctorSpecialization;
        this.doctorBirthday = doctorBirthday;
        availability = new ArrayList<>();
    }


    //methods
   public boolean isPhysician(){
        Boolean isEndingWithPhysician = this.specialization.endsWith("physician");
        return isEndingWithPhysician;
}



public void setAvailability(Date availableDate) {
        this.availability.add(availableDate);
    }

    public void setAppointment(Appointment appointment,Date date) {
        ArrayList<Appointment> currentAppointments = this.allAppointments.get(date);
        if (currentAppointments == null) {
            ArrayList<Appointment> tempArraylist = new ArrayList<>();
            tempArraylist.add(appointment);
            this.allAppointments.put(date, tempArraylist);
        } else {
            currentAppointments.add(appointment);
            this.allAppointments.put(date, currentAppointments);
        }

    }

    //getters and setters
    public ArrayList<Date> getAvailability() {
        return availability;
    }

    public HashMap<Date, ArrayList<Appointment>> getAllAppointments() {
        return allAppointments;
    }
    public int getId() {
        return id;
    }

    public String getBirthday() {
        return doctorBirthday;
    }

    public void setBirthday(String birthday) {
        this.doctorBirthday = birthday;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
