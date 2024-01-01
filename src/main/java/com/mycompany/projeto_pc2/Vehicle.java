package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.util.Date;

/**
 * Classe que representa o veículo com propriedades basicas de identificacao e
 * caracteristicas do mesmo
 *
 * @authors Paulo Sousa | João Domingos
 */
public class Vehicle implements Serializable {
    ChargingStation chargingStation;
    Client client;
    private String brand;
    private String model;
    private String license_plate;
    private String electric_hybrid;
    private String fuel_type;
    private Date date_of_register;
    private int horsepower;
    private int range;
    private int engine_displacement;
    private double chargingSpeed;
    private double battery_capacity;



    /**
     * Constroi o veículo com os atributos dados
     * 
     * @param brand Marca do veículo
     * @param model Modelo do veículo
     * @param license_plate Matricula do veículo
     * @param electric_hybrid Veículo eletrico ou hibrido
     * @param fuel_type Tipo de combustivel do veículo
     * @param date_of_register Data de registo do veículo
     * @param horsepower Potencia do veículo
     * @param range Número de kilometros que uma carga completa conssegue fazer
     * @param engine_displacement Cilindrada do mor do veículo
     * @param chargingSpeed Velocidade de carregamento do veículo
     * @param battery_capacity Capacidade da bateria do veículo em kWh
     */
    public Vehicle(Client client,
            String brand,
            String model,
            String license_plate,
            String electric_hybrid,
            String fuel_type,
            Date date_of_register,
            int horsepower,
            int range,
            int engine_displacement,
            int battery,
            double chargingSpeed,
            double battery_capacity) {
        this.client = client;
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
    }

    public ChargingStation getChargingStation() {
        return chargingStation;
    }

    public void setChargingStation(ChargingStation chargingStation) {
        this.chargingStation = chargingStation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public double getChargingSpeed() {
        return chargingSpeed;
    }

    public void setChargingSpeed(double chargingSpeed) {
        this.chargingSpeed = chargingSpeed;
    }

    public String isEletricHybrid() {
        return electric_hybrid;
    }

    public void setEletricHybrid(String electric_hybrid) {
        this.electric_hybrid = electric_hybrid;
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
        str.append("Data de registo: " + Projeto_pc2.dateFormat.format(date_of_register) + "\n");
        str.append("Registado a: " + client.getName() + " (NIF: " + client.getNIF() + ")\n");
        str.append("Tipo: " + electric_hybrid + "\n");
        if (isEletricHybrid().equals("Hibrido")) {
            str.append("Combustivel: " + fuel_type + "\n");
            str.append("Cilindrada: " + engine_displacement + " cm^3\n");
        }
        str.append("Potencia: " + horsepower + " cv\n");
        str.append("Autonomia: " + range + " km\n");
        str.append("Capacidade de bateria: " + battery_capacity + " kW/h\n");
        str.append("Velocidade de carregamento: " + chargingSpeed + " kW\n");
        return str.toString();
    }
}
