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
     * @param brand               Marca do veículo
     * @param model               Modelo do veículo
     * @param license_plate       Matricula do veículo
     * @param electric_hybrid     Veículo eletrico ou hibrido
     * @param fuel_type           Tipo de combustivel do veículo
     * @param date_of_register    Data de registo do veículo
     * @param horsepower          Potencia do veículo
     * @param range               Autonomia do veiculo
     * @param engine_displacement Cilindrada do motor do veículo
     * @param chargingSpeed       Velocidade de carregamento do veículo
     * @param battery_capacity    Capacidade da bateria do veículo em kWh
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

    /**
     * Devolve a estação de carregamento que o veiculo estiver a usar num periodo
     * temporal
     * 
     * @return A estação de carregamento
     */
    public ChargingStation getChargingStation() {
        return chargingStation;
    }

    /**
     * Define a estação de carregamento associada ao veículo
     * 
     * @param chargingStation A nova estação de carregamento a ser definida
     */
    public void setChargingStation(ChargingStation chargingStation) {
        this.chargingStation = chargingStation;
    }

    /**
     * Devolve o cliente a que o veiculo se encontra registado
     * 
     * @return O cliente ao qual pertence o veículo
     */
    public Client getClient() {
        return client;
    }

    /**
     * Define o cliente a que o veiculo se encontra registado
     * 
     * @param client O cliente a qual o veículo vai pertencer
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Devolve a marca do veículo
     * 
     * @return A marca do veículo
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Define a marca do veículo
     * 
     * @param brand A nova marca para o veículo
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Devolve o modelo do veículo
     * 
     * @return O modelo do veículo
     */
    public String getModel() {
        return model;
    }

    /**
     * Define o modelo do veículo
     * 
     * @param model O novo modelo para o veículo
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Devolve a matricula do veículo
     * 
     * @return A matricula do veículo
     */
    public String getLicensePlate() {
        return license_plate;
    }

    /**
     * Define a matricula do veículo
     * 
     * @param license_plate A nova matricula para o veículo
     */
    public void setLicensePlate(String license_plate) {
        this.license_plate = license_plate;
    }

    /**
     * Devolve a cilindrada do motor do veículo
     * 
     * @return A cilindrada do motor do veículo
     */
    public int getEngineDsplacement() {
        return engine_displacement;
    }

    /**
     * Define a cilindrada do motor do veículo
     * 
     * @param engine_displacement A nova cilindrada do motor para o veículo
     */
    public void setEngineDisplacement(int engine_displacement) {
        this.engine_displacement = engine_displacement;
    }

    /**
     * Devolve a data de registo do veículo
     * 
     * @return A data de registo do veículo
     */
    public Date getDateOfRegister() {
        return date_of_register;
    }

    /**
     * Define a data de registo do veículo
     * 
     * @param date_of_register A nova data de registo para o veículo
     */
    public void setDateOfRegisterg(Date date_of_register) {
        this.date_of_register = date_of_register;
    }

    /**
     * Devolve a potencia do veículo
     * 
     * @return A potencia do veículo
     */
    public int getHorsepower() {
        return horsepower;
    }

    /**
     * Define a potencia do veículo
     * 
     * @param horsepower A nova potencia para o veículo
     */
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    /**
     * Devolve a capacidade da bateria do veículo
     * 
     * @return A capacidade da bateria do veículo
     */
    public double getBatteryCapacity() {
        return battery_capacity;
    }

    /**
     * Define a capacidade da bateria do veículo
     * 
     * @param battery_capacity A nova capacidade da bateria para o veículo
     */
    public void setBatteryCapacity(int battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    /**
     * Devolve a autonomia do veiculo
     * 
     * @return A autonomia do veiculo
     */
    public int getRange() {
        return range;
    }

    /**
     * Define a autonomia do veiculo
     * 
     * @param range A nova autonomia do veiculo
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Devolve a velocidade de carregamento do veículo
     * 
     * @return A velocidade de carregamento do veículo
     */
    public double getChargingSpeed() {
        return chargingSpeed;
    }

    /**
     * Define a velocidade de carregamento do veículo
     * 
     * @param chargingSpeed A nova velocidade de carregamento do veículo
     */
    public void setChargingSpeed(double chargingSpeed) {
        this.chargingSpeed = chargingSpeed;
    }

    /**
     * Devolve se o veículo é eletrico ou hibrido
     * 
     * @return Se o veículo é eletrico ou hibrido
     */
    public String isEletricHybrid() {
        return electric_hybrid;
    }

    /**
     * Define se o veículo é eletrico ou hibrido
     * 
     * @param electric_hybrid O novo tipo de veículo
     */
    public void setEletricHybrid(String electric_hybrid) {
        this.electric_hybrid = electric_hybrid;
    }

    /**
     * Devolve o tipo de combustivel do veículo
     * 
     * @return O tipo de combustivel do veículo
     */
    public String isFuelType() {
        return fuel_type;
    }

    /**
     * Define o tipo de combustivel do veículo
     * 
     * @param fuel_type O novo tipo de combustivel do veículo
     */
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
