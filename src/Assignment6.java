import java.io.File;
import java.util.Scanner;

public class Assignment6 {
    //Code coming from Daneyra, everything I put is just for testing purposes
    public static void main(String[] args) throws Exception{
        File input = new File("list.txt"); //Read the file
        Scanner scan = new Scanner(input).useDelimiter(",|\r\n"); //Set commas, carriage returns, and new lines as scanner pause points

        String name, reason;
        int time;

        while(scan.hasNextLine()){ //While we haven't reached the end of the file
            name = scan.next(); //Read the name, stops at comma
            reason = scan.next(); //Read the reason, stops at comma
            time = scan.nextInt(); //Read the time, stops at line break
            Appointment appt =  new Appointment(name, reason, time); //Make new appointment object with read info
            AppointmentQueue.push(appt); //Add new appointment to queue
        }
        Appointment peek = AppointmentQueue.peek(); //View next appointment without removing from queue
        Appointment next = AppointmentQueue.pop(); //Get next appointment (WILL remove from queue as this is a pop function)
        System.out.println("Up next is: " + next.name + ", " + next.reason + ", " + next.time); //Just for testing purposes
        AppointmentQueue.show(); //Just for testing purposes
    }

}
