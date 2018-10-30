package com.epam.se02.inheritance.example4;

public class Launcher {

    public static void main(String[] args) {
        MedicalStaff med = new Doctor();
        med.info();                      // Doctor
        med.prescriptionMedicine();      // prescriptionMedicine
        ((Doctor) med).createMedicine(); // createMedicine
        med.staticMedical();             // staticMedicalStaff

        Doctor doctor = new Doctor();
        doctor.info();                   // Doctor
        doctor.prescriptionMedicine();   // prescriptionMedicine
        doctor.createMedicine();         // createMedicine
        doctor.staticMedical();          // staticDoctor
    }
}

class MedicalStaff {

    public static void staticMedical(){
        System.out.println("staticMedicalStaff");
    }

    public void prescriptionMedicine(){
        System.out.println("prescriptionMedicine");
    }

    public void info() {
        System.out.println("MedicalStaff");
    }
}

class Doctor extends MedicalStaff {

    public static void staticMedical(){
        System.out.println("staticDoctor");
    }

    public void createMedicine(){
        System.out.println("createMedicine");
    }

    @Override
    public void info() {
        System.out.println("Doctor");
    }
}

