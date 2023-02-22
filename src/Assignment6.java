import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Assignment6 {
  AppointmentQueue appointQue;
  Assignment6() {
    appointQue = new AppointmentQueue();
  }

  //Method that is desginated for reading the DMV_Appointments.txt file//
  void readFile() {
    String name;
    String reason;
    int time;

    try {

      File myFile = new File("DMV_Appointments.txt");
      Scanner scnr = new Scanner(myFile);

      while(scnr.hasNext()) {
        name = scnr.next();
        reason = scnr.next();
        time = scnr.nextInt();

  //This is going to push in the contents of the Appointment class into our Appointment Queue class//
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
    Assignment6 appoint = new Assignment6();
    appoint.readFile();
    String name;
    int i;
    int value;

      do {
        value = 0;

  //Will prompt the user to enter their name in order to check 
        System.out.println("\nPlease enter your name: ");
        name = read.next();

//Need to have the rear end method to indicate the end of the queue//
        //        would go here after appoint.appointQue.  // 
        for (i = 0; i < appoint.appointQue.; i++) {
          if (name.compareTo(appoint.appointQue.peek(i).name) == 0) {
            value = 1;
            break;
          }
        }
    //The name entered is up in the Queue//
        if (value == 1)
          System.out.println(appoint.appointQue.pop() + "You're now up, the DMV will assist you now.");
    //The name entered is not next in the Queue//
        else
          System.out.println("\nIt is not your turn, please wait until it is.");
    //Will let the user know that the Queue is currently empty//
      }
        while(true);
  }
}