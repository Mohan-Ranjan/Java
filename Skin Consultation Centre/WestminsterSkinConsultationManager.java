import java.io.*;
import java.util.*;
import java.io.IOException;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{



    public LinkedList<Doctor> doctorList = new LinkedList<>();
    public ArrayList<Consultation> consultationList = new ArrayList<>();
    public LinkedList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(LinkedList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public ArrayList<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(ArrayList<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    public static WestminsterSkinConsultationManager s1 = new WestminsterSkinConsultationManager();



    //Method - Add a Doctor to a center.
    public void addDoctor(){

        Scanner scn = new Scanner(System.in);
        int docCount = this.doctorList.size();

        if (docCount < 10) {
            System.out.print("Enter the Doctor's First Name: ");
            String fName = scn.next().toUpperCase();

            System.out.print("Enter the Doctor's Surname: ");
            String sName = scn.next().toUpperCase();

            System.out.print("Enter the Doctor's Date of Birth (YYYY-MM-DD): ");
            String dob = scn.next();

            System.out.print("Enter the Doctor's Mobile Number: ");
            String mob = scn.next();

            System.out.print("Enter the Doctor's Medical License Number: ");
            String licenseNo = scn.next();

            System.out.print("Enter the Doctor's Specialisation: ");
            String special = scn.next();

            System.out.println("Dr." + fName +" is added to Consultation Center Successfully!");

            doctorList.add(new Doctor(fName, sName, dob, mob, licenseNo, special));
        }
        else{
            System.out.println("No room for more Doctors! Doctors at the center is full!! ");
        }
        System.out.println("---------------------------------------------------\n");
    }

    //Method - Remove a Doctor from the center.
    public void deleteDoctor(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the License Number of the Doctor: ");
        String delDoctor = scn.next();
        boolean check = true;
        for (int x = 0; x < doctorList.size(); x++) {
            if (doctorList.get(x).getMedicalLicenseNumber().equalsIgnoreCase(delDoctor)) {

                System.out.println("Dr." + getDoctorList().get(x).getName() + " has been removed from the Consultation Center" +
                        "\n " + "\n Details Of Removed Doctor"+"\n"+ "\n Name: " + doctorList.get(x).getName() +
                        "\n Surname: " + doctorList.get(x).getSurname() +
                        "\n Date of Birth: " + doctorList.get(x).getDateOfBirth() +
                        "\n Mobile Number: " + doctorList.get(x).getMobileNumber() +
                        "\n Medical License Number: " + doctorList.get(x).getMedicalLicenseNumber() +
                        "\n Specialisation: " + doctorList.get(x).getSpecialisation() + "\n");
                doctorList.remove(x);
                System.out.println("\n Remaining number of Doctors: " +(doctorList.size()));
                check = false;
                System.out.println("---------------------------------------------------");
                break;
            }
        }
        if (check) {
            System.out.println("Couldn't find a Doctor with License Number " + delDoctor + ". Please Try Again!");
            System.out.println("--------------------------------------------------");
        }
    }

    //Method - Print the list of Doctors
    public void displayDoctorList() {

        Collections.sort(doctorList,Doctor.DocSurnameComparator );
        System.out.println("Total number of Doctors at Consultation Center: "+ doctorList.size());
        for (Doctor doctor : doctorList) {
            System.out.println("\n Name: " + doctor.getName() +
                    "\n Surname: " + doctor.getSurname() +
                    "\n Date of Birth: " + doctor.getDateOfBirth() +
                    "\n Mobile Number: " + doctor.getMobileNumber() +
                    "\n Medical License Number: " + doctor.getMedicalLicenseNumber() +
                    "\n Specialisation: " + doctor.getSpecialisation());
            System.out.println("--------------------------------------------------");
        }
    }

    //Method - Saving in a File
    public void serializingDocObject() {
        String file = "DocList2023.txt";
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(doctorList);
            System.out.println("Information saved to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public void deserializingDocObject() {
        String file = "DocList2023.txt";
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            doctorList = (LinkedList) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void serializingConObject() {
        String file = "ConList2023.txt";
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(consultationList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
    public void deserializingConObject() {
        String file2 = "ConList2023.txt";
        try {
            FileInputStream fileIn = new FileInputStream(file2);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            consultationList = (ArrayList) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void displayArranged() {

        Collections.sort(doctorList,Doctor.DocNameComparator );

        for (Doctor doctor : doctorList) {
            System.out.println("Name: " + doctor.getName() +
                    "\n Surname: " + doctor.getSurname() +
                    "\n Date of Birth: " + doctor.getDateOfBirth() +
                    "\n Mobile No: " + doctor.getMobileNumber() +
                    "\n Medical License No: " + doctor.getMedicalLicenseNumber() +
                    "\n Specialisation: " + doctor.getSpecialisation());
            System.out.println("....................");
        }
    }

    public static void main(String[] args) {
        s1.deserializingDocObject();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            String menuContent = ("""
                    Select an Option (Type in a number or a code) to perform an action.
                    
                        1 : Add a New Doctor to the consultation center
                        2 : Remove a doctor from the consultation center
                        3 : Print the list of Doctors
                        4 : Save information in a file
                        5 : Open Graphical User Interface
                        6 : Exit the Program""");
            System.out.println(menuContent);
            System.out.print("\nEnter the code or number: ");
            String inputCode = scanner.next().toUpperCase();


            switch (inputCode) {

                case "1":
                    System.out.println("Adding..");
                    s1.addDoctor();
                    break;

                case "2":
                    System.out.println("Deleting..");
                    s1.deleteDoctor();
                    break;

                case "3":
                    System.out.println("Printing..");
                    s1.displayDoctorList();
                    break;

                case "4":
                    System.out.println("Saving..");
                    s1.serializingDocObject();
                    break;

                case "5":
                    s1.serializingDocObject();
                    MainFrame mainFrame = new MainFrame();
                    break;

                case "6":
                    break label;
                default:
                    System.out.println("Incorrect Code. Please enter a valid code.\n");
                    break;
            }
        }

    }

}