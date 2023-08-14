import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import java.util.*;

class Patient {
    private String name;
    private int age;
    // can add more patient details as needed

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters for patient details
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}




class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Getters for doctor details
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Patient> getPatients() {
        return patients;
    }    

    public void displayPatients() {
        for (Patient patient : patients) {
            System.out.println("Patient: " + patient.getName() + ", Age: " + patient.getAge());
            // Display other patient details as needed
        }
    }
}




class Hospital {
    private String name;
    private Map<String, Doctor> doctors;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new HashMap<>();
    }

    // Getters for hospital details
    public String getName() {
        return name;
    }

    public Map<String, Doctor> getDoctors() {
        return doctors;
    }

    public Doctor getDoctorByName(String name) {
        return doctors.get(name);
    }

    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.getName(), doctor);
    }
}




public class DAS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a hospital
        Hospital hospital = new Hospital("Ricky's Hospital");

        // Create doctors and add them to the hospital
        Doctor doctor1 = new Doctor("Dr. Arijit Bhattacharjee", "Cardiologist");
        Doctor doctor2 = new Doctor("Dr. Rohan Kumar", "Pediatrician");
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        while (true) {            //to make it loop unlimited times we can give it true
            System.out.println("Welcome to " + hospital.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. View doctor's patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();   //consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter your age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();

                    Patient patient = new Patient(patientName, patientAge);
                    System.out.println("Choose a doctor:");
                    System.out.println("1. " + doctor1.getName());
                    System.out.println("2. " + doctor2.getName());
                    System.out.print("Enter your choice: ");
                    int doctorChoice = scanner.nextInt();
                    scanner.nextLine();

                    Doctor selectedDoctor = doctorChoice == 1 ? doctor1 : doctor2;
                    selectedDoctor.addPatient(patient);
                    System.out.println("Appointment booked with " + selectedDoctor.getName());
                    break;

                case 2:
                    System.out.println("Enter doctor's name to view patients:");
                    String docName = scanner.nextLine();
                    Doctor doctor = hospital.getDoctorByName(docName);
                    if (doctor != null) {
                        System.out.println("Patients of " + doctor.getName() + ":");
                        doctor.displayPatients();
                    } else {
                        System.out.println("Doctor not found!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
