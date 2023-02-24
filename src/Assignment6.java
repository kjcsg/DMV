import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Assignment6 {
  //Method that is desginated for reading the DMV_Appointments.txt file//
  private static void readFile() {
    String name;
    String reason;
    int time;

    try {

      File myFile = new File("DMV_Appointments.txt");
      Scanner scnr = new Scanner(myFile).useDelimiter(",|\r\n");

      while(scnr.hasNext()) {
        name = scnr.next();
        reason = scnr.next();
        time = scnr.nextInt();
        //This is going to push in the contents of the Appointment class into our Appointment Queue class
        AppointmentQueue.push(new Appointment(name, reason, time));
      }
      scnr.close();
    }
    catch(FileNotFoundException e) {
      System.out.println("No file found.");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    readFile();
    String name;
    int qLength = AppointmentQueue.length(); 
    int i;

    do{
  //Will prompt the user to enter their name in order to check 
        System.out.print("\nPlease enter your name: ");
        name = read.next().toLowerCase();
        if(AppointmentQueue.has(name)){
            if(Objects.equals(AppointmentQueue.peek().name.toLowerCase(), name)){
                Appointment appoint = AppointmentQueue.pop();
                System.out.println(appoint.name+", You're now up, the DMV will assist you now.");
                qLength = AppointmentQueue.length();
            }
            else{
                i=0;
                while (i < qLength) {
                    if (Objects.equals(AppointmentQueue.peek(i).name.toLowerCase(), name)) {
                        int j = i+1;
                        System.out.println("Sorry "+ name +", you are in position "+j+".");
                        break;
                    }
                    else{i++;}
                }
            }
        }
        else{System.out.println("Sorry, "+name+" isn't in the queue.");}   
    }while(qLength>0);
    System.out.println("\nThe queue is empty. Goodbye.");
    read.close();
    System.exit(0);
  }
}