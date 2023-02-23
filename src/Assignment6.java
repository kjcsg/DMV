import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Assignment6 {
  /*AppointmentQueue appointQue;
  Assignment6() {
    appointQue = new AppointmentQueue();
  }*/ //Not needed as the AppointmentQueue class stores the queue {Kyle}

  //Method that is desginated for reading the DMV_Appointments.txt file//
  private static void readFile() { //Made private static to work with main method line 44 {Kyle}
    String name;
    String reason;
    int time; //Changed to int to work with appointment class {Kyle}

    try {

      File myFile = new File("DMV_Appointments.txt");
      Scanner scnr = new Scanner(myFile).useDelimiter(",|\r\n"); //Added delimiter to separate each part of the file {Kyle}

      while(scnr.hasNext()) {
        name = scnr.next();
        reason = scnr.next();
        time = scnr.nextInt(); //Changed to int to work with appointment class {Kyle}
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
    //Assignment6 appoint = new Assignment6(); --Changing to appointment object on {Kyle}
    readFile(); //Directly calling readFile function {Kyle}
    String name;
    int qLength = AppointmentQueue.length(); 
    int i;

    while(qLength>0){
  //Will prompt the user to enter their name in order to check 
        System.out.print("\nPlease enter your name: ");
        name = read.next().toLowerCase(); //Added toLowerCase to prevent errors from someone typing in all lowercase {Kyle}

//Need to have the rear end method to indicate the end of the queue// I added a length function so we can get the end of the queue and exit {Kyle}
        //        would go here after appoint.appointQue.
        if(AppointmentQueue.has(name)){ //Added a function in AppointmentQueue to check if the name is in the queue {Kyle}
            if(Objects.equals(AppointmentQueue.peek().name.toLowerCase(), name)){ //Added toLowerCase to prevent errors from someone typing in all lowercase {Kyle}
                Appointment appoint = AppointmentQueue.pop();
                System.out.println(appoint.name+", You're now up, the DMV will assist you now.");
                qLength = AppointmentQueue.length();
            }
            else{
                i=0;
                while (i < qLength) {
                    if (Objects.equals(AppointmentQueue.peek(i).name.toLowerCase(), name)) { //Added toLowerCase to prevent errors from someone typing in all lowercase {Kyle}
                        int j = i+1;
                        System.out.println("Sorry "+ name +", you are in position "+j+".");
                        break;
                    }
                    else{i++;}
                }
            }
        }
        else{System.out.println("Sorry, "+name+" isn't in the queue.");}   
    }
    System.out.println("\nThe queue is empty. Goodbye.");
    read.close();
    System.exit(0);
  }
}