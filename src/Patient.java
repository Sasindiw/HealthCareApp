public class Patient extends Person{
   private String patientId;

   public Patient(String patientId, String name, String contactNumber, String id){
   super(name,contactNumber);
   this.patientId = patientId;
   }
   public String getPatientId(){
       return this.patientId;
   }

   public char getPatientType(){
       char firstLetter = this.patientId.charAt(0);
       return firstLetter; // getting the first character of patient ID
   }


}
