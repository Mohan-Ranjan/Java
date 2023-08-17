// Cabin of Crusie Ship
public class CruiseShipCabin {
    CruiseShipPassenger[] passengerList = new CruiseShipPassenger[3]; // Create new list


    public CruiseShipPassenger[] getPassengerList() {
        return passengerList;
    }

    public void initializethePassengerList() {  // in list format
        for (int i = 0; i < passengerList.length; i++) {
            passengerList[i] = new CruiseShipPassenger("e", "e", 0);
        }
    }

    public boolean isFullBoard() {    // Check of full of board
        for (int i = 0; i < 3; i++) {
            if (!passengerList[i].firstName.equals("e")) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {     // Check of empty board
        for (CruiseShipPassenger passenger : passengerList) {
            if(!passenger.firstName.equals("e")) {
                return false;
            }
        }
        return true;
    }
}
