package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class Vehicle {
    protected String brand, model, license_plate, eletric_hybrid, fuel_type;
    protected Date date_of_register;
    protected int horsepower, range, chargingSpeed, engine_displacement;
    protected double battery_capacity;

    public Vehicle(String brand, 
                   String model, 
                   String license_plate, 
                   String eletric_hybrid, 
                   String fuel_type,
                   Date date_of_register, 
                   int horsepower, 
                   int range, 
                   int chargingSpeed, 
                   int engine_displacement,
                   double battery_capacity) {
        this.brand = brand;
        this.model = model;
        this.license_plate = license_plate;
        this.eletric_hybrid = eletric_hybrid;
        this.fuel_type = fuel_type;
        this.date_of_register = date_of_register;
        this.horsepower = horsepower;
        this.range = range;
        this.chargingSpeed = chargingSpeed;
        this.engine_displacement = engine_displacement;
        this.battery_capacity = battery_capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return license_plate;
    }

    public void setLicensePlate(String license_plate) {
        this.license_plate = license_plate;
    }

    public int getEngineDsplacement() {
        return engine_displacement;
    }

    public void setEngineDisplacement(int engine_displacement) {
        this.engine_displacement = engine_displacement;
    }

    public Date getDateOfRegister() {
        return date_of_register;
    }

    public void setDateOfRegisterg(Date date_of_register) {
        this.date_of_register = date_of_register;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getBatteryCapacity() {
        return battery_capacity;
    }

    public void setBatteryCapacity(int battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getChargingSpeed() {
        return chargingSpeed;
    }

    public void setChargingSpeed(int chargingSpeed) {
        this.chargingSpeed = chargingSpeed;
    }

    public String isEletricHybrid() {
        return eletric_hybrid;
    }

    public void setEletricHybrid(String eletric_hybrid) {
        this.eletric_hybrid = eletric_hybrid;
    }

    public String isFuelType() {
        return fuel_type;
    }

    public void setFuelType(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Carro: " + brand + " " + model + "\n");
        str.append("Data de registo: " + date_of_register + "\n");
        str.append("Informacoes: " + engine_displacement + " cm^3, " + horsepower + " cv, " + battery_capacity + " kWh, " + range + " km, " + chargingSpeed + "\n");
        str.append("Tipo: " + eletric_hybrid + " ," + fuel_type + "\n");
        return str.toString();
    }
}
