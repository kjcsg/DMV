Objective:

As a group, you're going to make software to manage appointments at the DMV. Your program will read in several appointments from a data file and store them into a queue data structure. Then you'll determine who is next based on the order of their appointment times.

Requirements:

1. You shall create three classes: a main class called "Assignment6", an "Appointment" class, and an "AppointmentQueue" class

2. The “Appointment” class will hold the information for a single appointment (name, reason, time).

3. The “AppointmentQueue” class will hold all of the appointment objects. This queue class should at least have "push" and "pop" methods for adding and removing from the queue (more may be needed). The earliest remaining appointment should come off the queue when "pop" is called.

Flow of the main method:

1. Read in all the appointments from the data file, create an "Appointment" object for each one, and add each one to the "AppointmentQueue". The appointment objects should be pushed to the queue in correct order of appointment time (the queue should not sort the appointments). The data file to read from is here: DMV_Appointments.txt. Download DMV_Appointments.txt.

2. Prompt the user to enter their name and then determine whether or not they are next in the queue

3. If they are next, output to the screen that the DMV will help them now and remove them from the queue. If they are not next, give them a rejection message.

4. Keep prompting for the next person until everyone has been helped.

The Hard Part:

Your "AppointmentQueue" class must use a basic array of initial size 5 to hold the appointments. When the "push" method is called, your class must be able to automatically expand the array when needed to fit additional appointment objects.