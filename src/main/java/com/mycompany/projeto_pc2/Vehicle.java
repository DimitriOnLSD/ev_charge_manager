package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @authors Paulo Sousa | João Domingos
 */
public class Vehicle {
    ChargingStation chargingStation;
    protected String brand;
    protected String model;
    protected String license_plate;
    protected String electric_hybrid;
    protected String fuel_type;
    protected Date date_of_register;
    protected int horsepower;
    protected int range;
    protected int chargingSpeed;
    protected int engine_displacement;
    protected int battery;
    protected double battery_capacity;
    protected boolean isCharging = false;

    public Vehicle(String brand,
                   String model,
                   String license_plate,
                   String electric_hybrid,
                   String fuel_type,
                   Date date_of_register,
                   int horsepower,
                   int range,
                   int chargingSpeed,
                   int engine_displacement,
                   int battery,
                   double battery_capacity,
                   boolean isCharging) {
        this.brand = brand;
        this.model = model;
        this.license_plate = license_plate;
        this.electric_hybrid = electric_hybrid;
        this.fuel_type = fuel_type;
        this.date_of_register = date_of_register;
        this.horsepower = horsepower;
        this.range = range;
        this.chargingSpeed = chargingSpeed;
        this.engine_displacement = engine_displacement;
        this.battery_capacity = battery_capacity;
        this.isCharging = isCharging;
        this.battery = battery;
    }

    public ChargingStation getChargingStation()                     { return chargingStation; }
    public void setChargingStation(ChargingStation chargingStation) { this.chargingStation = chargingStation; }

    public String getBrand()                                        { return brand; }
    public void setBrand(String brand)                              { this.brand = brand; }

    public String getModel()                                        { return model; }
    public void setModel(String model)                              { this.model = model; }

    public String getLicensePlate()                                 { return license_plate; }
    public void setLicensePlate(String license_plate)               { this.license_plate = license_plate; }

    public int getEngineDsplacement()                               { return engine_displacement; }
    public void setEngineDisplacement(int engine_displacement)      { this.engine_displacement = engine_displacement; }

    public Date getDateOfRegister()                                 { return date_of_register; }
    public void setDateOfRegisterg(Date date_of_register)           { this.date_of_register = date_of_register; }

    public int getHorsepower()                                      { return horsepower; }
    public void setHorsepower(int horsepower)                       { this.horsepower = horsepower; }

    public double getBatteryCapacity()                              { return battery_capacity; }
    public void setBatteryCapacity(int battery_capacity)            { this.battery_capacity = battery_capacity; }

    public int getRange()                                           { return range; }
    public void setRange(int range)                                 { this.range = range; }

    public int getChargingSpeed()                                   { return chargingSpeed; }
    public void setChargingSpeed(int chargingSpeed)                 { this.chargingSpeed = chargingSpeed; }

    public String isEletricHybrid()                                 { return electric_hybrid; }
    public void setEletricHybrid(String electric_hybrid)            { this.electric_hybrid = electric_hybrid; }

    public String isFuelType()                                      { return fuel_type; }
    public void setFuelType(String fuel_type)                       { this.fuel_type = fuel_type; }

    public boolean isCharging()                                     { return isCharging; }
    public void setCharging(boolean isCharging)                     { this.isCharging = isCharging; }

    public int getBattery()                                         { return battery; }
    public void setBattery(int battery)                             { this.battery = battery; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Carro: " + brand + " " + model + "\n");
        str.append("Data de registo: " + date_of_register + "\n");
        str.append("Tipo: " + electric_hybrid + "\n");
        if (isEletricHybrid().equals("Hibrido")) {
            str.append("Combustivel: " + fuel_type + "\n");
            str.append("Cilindrada: " + engine_displacement + " cm^3\n");
        }
        str.append("Potencia: " + horsepower + " cv\n");
        str.append("Autonomia: " + range + " km\n");
        str.append("Capacidade de bateria: " + battery_capacity + " kW/h\n");
        str.append("Velocidade de carregamento: " + chargingSpeed + " kW\n");
        if (isCharging()) {
            str.append("Estado: A carregar (Cod. estacao: " + chargingStation.getStationCode() + ")\n");
        } else {
            str.append("Estado: A descarregar\n");
        }
        return str.toString();
    }
}
