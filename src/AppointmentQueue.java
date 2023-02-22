public class AppointmentQueue {
    private static Appointment[] queue = new Appointment[5];

    public static void push(Appointment appt){
        int qLength = queue.length; //Get the current length of the queue
        if(queue[qLength-1]==null){ //If the last element doesn't have any data in it, find out which element does and add new data after that one 
            int i = 0;
            while(queue[i]!=null){i++;} //Checks if the element/slot is empty, if not, move to the next one
            queue[i] = appt; //Set the first empty slot to the appointment sent in with push call
        }
        else{
            Appointment[] oldQueue = queue; //Copy current queue
            Appointment[] newQueue = new Appointment[qLength+1]; //Temp array to hold new queue until it's copied to main queue 2 lines down, arraycopy won't work without this
            System.arraycopy(oldQueue, 0, newQueue, 0, qLength); //Recreate queue array with one extra slot
            queue = newQueue; //Set main queue to new, longer queue
            queue[qLength] = appt; //Set the new slot to the appointment data being pushed in
        }
    }

    public static Appointment pop(){
        int qLength = queue.length; //Get the current length of the queue
        Appointment info = queue[0]; //Grab the info fromt the top of the queue
        Appointment[] oldQueue = queue; //Copy current queue 
        Appointment[] newQueue = new Appointment[qLength-1]; //Temp array to hold new queue until it's copied to main queue 2 lines down, arraycopy won't work without this
        System.arraycopy(oldQueue, 1, newQueue, 0, qLength-1); //Recreate queue array with one less slot & remove the top of the queue
        queue = newQueue; //Set main queue to new, shorter queue
        return info; //Send the info for who's next back to what called this function
    }

    public static Appointment peek(){
        return queue[0]; //Send the appointment object at the top of the queue back
    }

    public static void show(){ //This is just for troubleshooting purposes, will remove before turning in. Prints out the current queue
        int i = 0; 
        System.out.println("Current Queue:");
        while(i<queue.length){
            System.out.println(i+1 + " " + queue[i].name + ", " + queue[i].reason + ", " + queue[i].time);
            i++;
        }
        
    }
}
