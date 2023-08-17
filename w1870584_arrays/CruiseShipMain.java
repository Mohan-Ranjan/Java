import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CruiseShipMain {
    public static void main(String[] args) {
        CruiseShipCabin[] cabinList = new CruiseShipCabin[12];
        CruiseShipCircularQueue queue = new CruiseShipCircularQueue(12);
        initialiseCabinList(cabinList);
        while (true){
            cruiseMenu(cabinList, queue);
        }

    }
    // cabin list
    public static void initialiseCabinList(CruiseShipCabin[] cabinList) {
        for(int i = 0; i < 12; i++){
            cabinList[i] = new CruiseShipCabin();
            cabinList[i].initializethePassengerList();
        }
    }

    public static void cruiseMenu(CruiseShipCabin[] cabinList, CruiseShipCircularQueue queue){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Welcome to Cruise Ship Menu-----");
            // Print out the Menu
        System.out.println(" A : Add customer to Cabin ");
        System.out.println(" V : View all Cabins ");
        System.out.println(" E : Display Empty Cabins ");
        System.out.println(" D : Delete customer from Cabin ");
        System.out.println(" F : Find Cabin from Customer Name ");
        System.out.println(" T : Display passenger expenses ");
        System.out.println(" S : Store program data into a Text file ");
        System.out.println(" L : Load program data from Text file ");
        System.out.println(" O : View passengers ordered alphabetically by name ");
        System.out.println(" Q : Exit ");
        System.out.println("-----------------------------------------------------------------------");

        String input = scanner.next().toLowerCase(Locale.ROOT);

        switch (input){ // use switch to order from menu
            case "a": addCustomer(cabinList, queue);
                break;
            case "v" : viewCabins(cabinList);
                break;
            case "e" : emptyCabins(cabinList);
                break;
            case "d" : deleteCustomer(cabinList, queue);
                break;
            case "f" : findCustomerCabin(cabinList);
                break;
            case "t" : displayPassengersExpenses(cabinList);
                break;
            case "s" : storeData(cabinList);
                break;
            case "l" : loadData();
                break;
            case "o" : alphabeticalPassengerOrder(cabinList);
                break;
            case "q" : exitcabin();
                break;
            default:
                System.out.println(" Invalid input   !!!");
        }
    }

    private static boolean isShipFull(CruiseShipCabin[] cabinArray) {
        for(CruiseShipCabin cabin : cabinArray) {
            if(!cabin.isFullBoard()) {
                return false;
            }
        }
        return true;
    }
        // Add Customer to Cabin
    private static void addCustomer(CruiseShipCabin[] cabinArray, CruiseShipCircularQueue queue) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                System.out.println("Enter the cabin Number :");
                int cabinNo = scanner.nextInt();
                if (cabinNo == 12){
                    break;
                }
                if(isShipFull(cabinArray)) {
                    System.out.println("Ship is full. Adding passengers to the waiting list.");
                    System.out.println("Enter first name : ");
                    String firstName = scanner.next();
                    System.out.println("Enter surname : ");
                    String surname = scanner.next();
                    System.out.println("Enter expenses : ");
                    double expenses = scanner.nextDouble();
                    queue.newQueue(new CruiseShipPassenger(firstName, surname, expenses));
                } else if (0 <= cabinNo && cabinNo < 12 && !cabinArray[cabinNo].isFullBoard()){
                    int passengerNo = 1;
                    while (true) {
                        boolean endLoop = false;
                        System.out.println("Adding passenger " + passengerNo);
                        System.out.println("Enter first name : ");  // Get first name
                        String firstName = scanner.next();
                        System.out.println("Enter surname : ");
                        String surname = scanner.next();
                        System.out.println("Enter expenses : ");
                        double expenses = scanner.nextDouble();
                        for (int i = 0; i < 3; i++ ){
                            if(cabinArray[cabinNo].getPassengerList()[i].getFirstName().equals("e")) {
                                cabinArray[cabinNo].getPassengerList()[i].setFirstName(firstName);
                                cabinArray[cabinNo].getPassengerList()[i].setSurname(surname);
                                cabinArray[cabinNo].getPassengerList()[i].setExpenses(expenses);
                                passengerNo++;
                                System.out.println("Do you want to add another passenger into this same cabin " + cabinNo + "?");
                                System.out.println("Press 'Y' to add another passenger and press any other key to exit to the previous menu.");
                                scanner.nextLine();
                                String userInput = scanner.nextLine().toLowerCase(Locale.ROOT);
                                if(!userInput.equals("y")) {
                                    endLoop = true;
                                }
                                break;
                            }
                        }
                        if(endLoop) {
                            System.out.println("Leaving cabin " + cabinNo + ".....");
                            break;
                        }
                    }
                } else if(cabinArray[cabinNo].isFullBoard()) {
                    System.out.println("Try another cabin.");
                } else {
                    System.out.println("Enter a number between 0 - 12");
                }
            } catch (InputMismatchException x) {
                System.out.println("Enter a number between 0 - 12");
                break;
            }
        }
    }
        // View the Cabins
    public static void viewCabins(CruiseShipCabin[] cabins){
        for(int i = 0; i < 12; i++){
            if(!cabins[i].isEmpty()){
                System.out.println("\nCabin " + i + " : \n");
                for (int j = 0; j < 3; j++){
                    CruiseShipPassenger passenger = cabins[i].getPassengerList()[j];
                    if(!passenger.getFirstName().equals("e")){
                        System.out.println("First Name = " + passenger.getFirstName()); //  Print first name
                        System.out.println("Surname    = " + passenger.getSurname());
                        System.out.println("Expenses   = " + passenger.getExpenses() + "\n");
                    }
                }
            }else{
                System.out.println("Cabin no :" + i + " is empty");
            }
        }
    }
        // Cabin empty seats
    private static void emptyCabins(CruiseShipCabin[] cabins) {
        for(int i = 0; i < 12; i++) {
            if(!cabins[i].isFullBoard()) {
                for(int j = 0; j < 3; j++) {
                    if(cabins[i].getPassengerList()[j].getFirstName().equals("e")) {
                        System.out.println("Cabin " + i + " has empty seats.");
                        break;
                    }
                }
            }
        }
    }
            // Delete Customer from Cabin
    private static void deleteCustomer(CruiseShipCabin[] cabins, CruiseShipCircularQueue queue) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the passenger's name");
        String input = scanner.nextLine();
        for(int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if(cabins[i].getPassengerList()[j].getFirstName().toLowerCase(Locale.ROOT).equals(input.toLowerCase(Locale.ROOT))) {
                    CruiseShipPassenger deQueuedPassenger = null;
                    if(isShipFull(cabins)) {
                        deQueuedPassenger = queue.oldQueue();
                    }
                    cabins[i].getPassengerList()[j].setFirstName("e");
                    cabins[i].getPassengerList()[j].setSurname("e");
                    cabins[i].getPassengerList()[j].setExpenses(0);
                    System.out.println("Passenger was Deleted");
                    if(deQueuedPassenger != null) {
                        cabins[i].getPassengerList()[j].setFirstName(deQueuedPassenger.getFirstName());
                        cabins[i].getPassengerList()[j].setSurname(deQueuedPassenger.getSurname());
                        cabins[i].getPassengerList()[j].setExpenses(deQueuedPassenger.getExpenses());
                        System.out.println("Passenger added to the ship from the waiting list to the Cruise Ship");
                    }
                    break;
                }
            }
        }
    }
        // Find the customer from Cabin
    private static void findCustomerCabin(CruiseShipCabin[] cabins) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the passenger's name");
        String input = scanner.nextLine();
        boolean isPassengerAvailable = false;
        for(int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                if(cabins[i].getPassengerList()[j].getFirstName().toLowerCase(Locale.ROOT).equals(input.toLowerCase(Locale.ROOT))) {
                    System.out.println("Passenger found and the cabin number is " + i);
                    isPassengerAvailable = true;
                    break;
                }
            }
        }
        if(!isPassengerAvailable) {
            System.out.println("Invalid name passenger");
        }
    }
        // Display Expenses
    private static void displayPassengersExpenses(CruiseShipCabin[] cabins) {
        System.out.println("---------------------------------------------");
        double total = 0;
        for(int i = 0; i < 12; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(cabins[i].getPassengerList()[j].getExpenses() == 0)) {
                    System.out.println(cabins[i].getPassengerList()[j].getFirstName() + "   -   " + cabins[i].getPassengerList()[j].getExpenses());
                    total += cabins[i].getPassengerList()[j].getExpenses();
                }
            }
        }
        System.out.println("----------------------------------------------------");
        System.out.println("*  Total   =   " + total);
        System.out.println("----------------------------------------------------");
    }
        // Store Data in the Text file
    private static void storeData(CruiseShipCabin[] cabins) {
        try {
            FileWriter myWriter = new FileWriter("Data.txt");
            for (int i = 0; i < 12; i++) {
                myWriter.write("Cabin : " + i);
                myWriter.write(System.lineSeparator());
                for (int j = 0; j < cabins[j].passengerList.length; j++) {
                    myWriter.write("Passenger " + j + " : ");
                    myWriter.write("{ FirstName : " + cabins[i].passengerList[j].getFirstName());
                    myWriter.write(", Surname : " + cabins[i].passengerList[j].getSurname());
                    myWriter.write(", Expenses : " + cabins[i].passengerList[j].getExpenses() + "}");
                    myWriter.write(System.lineSeparator());
                }
            }
            myWriter.close();
            System.out.println("Ship data saved to the text file !");
        } catch (IOException x ) {
            System.out.println("Error occur ! " + x );
        }
        System.out.println("-------------------------------");
    }

   // Load to text file
    private static void loadData() {
        try {
            File file = new File("Data.txt");
            Scanner readFile = new Scanner(file);
            while (readFile.hasNext()){
                System.out.println(readFile.nextLine());
            }
            System.out.println("----------------------------------------------");
        } catch (IOException x) {
            System.out.println("Error occur ! " + x);
        }
    }
        // Order in the Alphabetical order
    private static void alphabeticalPassengerOrder(CruiseShipCabin[] cabins) {
        int totalCabinPassengers = cabins.length * 3;
        CruiseShipPassenger[] passengerArray = new CruiseShipPassenger[totalCabinPassengers];
        int index = 0;
        for (CruiseShipCabin cabin : cabins) {
            for (int j = 0; j < 3; j++) {
                if (!cabin.getPassengerList()[j].getFirstName().equals("e")) {
                    passengerArray[index] = cabin.getPassengerList()[j];
                    index++;
                }
            }
        }
        CruiseShipPassenger tempPassenger = null;
        for (int i = 0; i < passengerArray.length; i++) {
            for (int j = i + 1 ; j < passengerArray.length; j++) {
                if(passengerArray[i] != null && passengerArray[j] != null) {
                    if (passengerArray[i].getFirstName().compareTo(passengerArray[j].getFirstName()) > 0){
                        tempPassenger = passengerArray[i];
                        passengerArray[i] = passengerArray[j];
                        passengerArray[j] = tempPassenger;
                    }
                }
            }
        }
        System.out.println("Display in Alphabetic Order : ");
        for (CruiseShipPassenger s : passengerArray) {
            if (s != null && !s.getFirstName().equals("e")) {
                System.out.println(s.getFirstName() + " ");
            }
        }
    }

    private static void exitcabin() {
        System.exit(0);
    }

}
