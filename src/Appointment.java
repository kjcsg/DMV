public class Appointment {
    /* Game Plan:
     * Method that takes a string of text and makes it into an appointment object
     * and then sends it to AppointmentQueue.java via queue.push
     */
    
     public String name, reason;
     public int time;

     Appointment(String name, String reason, int time){
        this.name = name;
        this.reason = reason;
        this.time = time;
     }

}
