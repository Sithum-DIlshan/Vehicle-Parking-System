package controller;

import java.util.ArrayList;

public class Vehicle {
    private String vehicleNUmber = null;
    private String vehicleType = null;
    private int maximumWeight = 0;
    private int numOfPassengers = 0;
    private String driverNic = null;
    private String parkedSlot = null;
    private String date;
    private String driverName;

    public Vehicle(String vehicleNUmber, String vehicleType, String date, String driverName) {
        this.vehicleNUmber = vehicleNUmber;
        this.vehicleType = vehicleType;
        this.date = date;
        this.driverName = driverName;
    }

    public Vehicle(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic) {
        this.vehicleNUmber = vehicleNUmber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
        this.driverNic = driverNic;
    }

    public Vehicle(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic, String parkedSlot, String date) {
        this.vehicleNUmber = vehicleNUmber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.numOfPassengers = numOfPassengers;
        this.driverNic = driverNic;
        this.parkedSlot = parkedSlot;
        this.date = date;
    }

    static ArrayList<Vehicle> vehicleArrayList = new ArrayList();
    static ArrayList<Vehicle> parkedVehicles = new ArrayList();
    static ArrayList<Vehicle> onShiftVehicles = new ArrayList();

    static {
        vehicleArrayList.add(new Bus("NA-3434", "Bus", 3500, 60, "7835348345V"));
        vehicleArrayList.add(new Van("KA-4563", "Van", 1000, 7, "8826253734V"));
        vehicleArrayList.add(new Van("58-3567", "Van", 1500, 4, "9283289272V"));
        vehicleArrayList.add(new Van("GF-4358", "Van", 800, 4, "9425245373V"));
        vehicleArrayList.add(new Van("CCB-3568", "Van", 1800, 8, "8976544373V"));
        vehicleArrayList.add(new Van("LM-6679", "Van", 1500, 4, "7835348345V"));
        vehicleArrayList.add(new Van("QA-3369", "Van", 1800, 6, "9173537839V"));
        vehicleArrayList.add(new CargoLorry("KB-3668", "CargoLorry", 2500, 2, "9573536833V"));
        vehicleArrayList.add(new CargoLorry("JJ-9878", "CargoLorry", 3000, 2, "9362426738V"));
        vehicleArrayList.add(new CargoLorry("GH-5772", "CargoLorry", 4000, 3, "9162353436V"));
        vehicleArrayList.add(new CargoLorry("XY-4456", "CargoLorry", 3500, 2, "9255556343V"));
        vehicleArrayList.add(new CargoLorry("YQ-3536", "CargoLorry", 2000, 2, "8735354355V"));
        vehicleArrayList.add(new CargoLorry("CBB-3566", "CargoLorry", 2500, 2, "9026344373V"));
        vehicleArrayList.add(new CargoLorry("QH-3444", "CargoLorry", 5000, 4, "9692653338V"));
    }


    @Override
    public String toString() {
        return vehicleNUmber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVehicleNUmber() {
        return vehicleNUmber;
    }

    public void setVehicleNUmber(String vehicleNUmber) {
        this.vehicleNUmber = vehicleNUmber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public String getDriverNic() {
        return driverNic;
    }

    public void setDriverNic(String driverNic) {
        this.driverNic = driverNic;
    }

    public String getParkedSlot() {
        return parkedSlot;
    }

    public void setParkedSlot(String parkedSlot) {
        this.parkedSlot = parkedSlot;
    }
}

class Van extends Vehicle {
    public Van(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic) {
        super(vehicleNUmber, vehicleType, maximumWeight, numOfPassengers, driverNic);
    }

    public Van(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic, String parkedSlot, String date) {
        super(vehicleNUmber, vehicleType, maximumWeight, numOfPassengers, driverNic, parkedSlot, date);
    }

    public Van(String vehicleNUmber, String vehicleType, String date, String driverName) {
        super(vehicleNUmber, vehicleType, date, driverName);
    }
}

class Bus extends Vehicle {
    public Bus(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic) {
        super(vehicleNUmber, vehicleType, maximumWeight, numOfPassengers, driverNic);
    }

    public Bus(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic, String parkedSlot, String date) {
        super(vehicleNUmber, vehicleType, maximumWeight, numOfPassengers, driverNic, parkedSlot, date);
    }

    public Bus(String vehicleNUmber, String vehicleType, String date, String driverName) {
        super(vehicleNUmber, vehicleType, date, driverName);
    }
}

class CargoLorry extends Vehicle {
    public CargoLorry(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic) {
        super(vehicleNUmber, vehicleType, maximumWeight, numOfPassengers, driverNic);
    }

    public CargoLorry(String vehicleNUmber, String vehicleType, int maximumWeight, int numOfPassengers, String driverNic, String parkedSlot, String date) {
        super(vehicleNUmber, vehicleType, maximumWeight, numOfPassengers, driverNic, parkedSlot, date);
    }

    public CargoLorry(String vehicleNUmber, String vehicleType, String date, String driverName) {
        super(vehicleNUmber, vehicleType, date, driverName);
    }
}
