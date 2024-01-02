package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authors Paulo Sousa | João Domingos
 */
public class ChargingStation implements Serializable {
    Vehicle vehicle;
    private String address;
    private String station_type;
    private int station_code;
    private int simultaneous_ev_charging;
    private double charging_time;
    private double charging_cost;
    private double total_energy_consumed = 0;
    private double energy_consumed_by_ev = 0;
    private double energy_consumed_by_hybrid = 0;
    private double total_revenue = 0;
    private List<ChargingSession> chargingSessions;


    /**
     * Constroi a estação de carregamento com os atributos dados
     * 
     * @param simultaneous_ev_charging Carregamento de veículos em simultaneo 
     * @param address Morada da estação
     * @param station_type Tipo de estação
     * @param charging_time Tempo de carregamento
     * @param charging_cost Custo de carregamento
     */
    public ChargingStation(int station_code,
            int simultaneous_ev_charging,
            String address,
            String station_type,
            double charging_time,
            double charging_cost) {
        this.station_code = station_code;
        this.simultaneous_ev_charging = simultaneous_ev_charging;
        this.address = address;
        this.station_type = station_type;
        this.charging_time = charging_time;
        this.charging_cost = charging_cost;
        this.chargingSessions = new ArrayList<>();
    }

    /**
     * @return
     */
    public int getStationCode() {
        return station_code;
    }

    /**
     * @param station_code
     */
    public void setStationCode(int station_code) {
        this.station_code = station_code;
    }

    /**
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return
     */
    public String getStationType() {
        return station_type;
    }

    /**
     * @param station_type
     */
    public void setStationType(String station_type) {
        this.station_type = station_type;
    }

    /**
     * @return
     */
    public double getChargingTime() {
        return charging_time;
    }

    /**
     * @param charging_time
     */
    public void setChargingTime(double charging_time) {
        this.charging_time = charging_time;
    }

    /**
     * @return
     */
    public double getChargingCost() {
        return charging_cost;
    }

    /**
     * @param charging_cost
     */
    public void setChargingCost(double charging_cost) {
        this.charging_cost = charging_cost;
    }

    /**
     * @return
     */
    public int getSimultaneousEVCharging() {
        return simultaneous_ev_charging;
    }

    /**
     * @param simultaneous_ev_charging
     */
    public void setSimultaneousEVCharging(int simultaneous_ev_charging) {
        this.simultaneous_ev_charging = simultaneous_ev_charging;
    }

    /**
     * @return
     */
    public double getTotalEnergyConsumed() {
        return total_energy_consumed;
    }

    /**
     * @param total_energy_consumed
     */
    public void setTotalEnergyConsumed(double total_energy_consumed) {
        this.total_energy_consumed = total_energy_consumed;
    }

    /**
     * @param adder
     */
    public void addTotalEnergyConsumed(double adder) {
        this.total_energy_consumed += adder;
    }

    /**
     * @return
     */
    public double getTotalRevenue() {
        return total_revenue;
    }

    /**
     * @param total_revenue
     */
    public void setTotalRevenue(double total_revenue) {
        this.total_revenue = total_revenue;
    }

    /**
     * @param adder
     */
    public void addTotalRevenue(double adder) {
        this.total_revenue += adder;
    }

    /**
     * @return
     */
    public double getEnergyConsumedByEv() {
        return energy_consumed_by_ev;
    }

    /**
     * @param energy_consumed_by_ev
     */
    public void setEnergyConsumedByEv(double energy_consumed_by_ev) {
        this.energy_consumed_by_ev = energy_consumed_by_ev;
    }

    /**
     * @param adder
     */
    public void addEnergyConsumedByEv(double adder) {
        this.energy_consumed_by_ev += adder;
    }

    /**
     * @return
     */
    public double getEnergyConsumedByHybrid() {
        return energy_consumed_by_hybrid;
    }

    /**
     * @param energy_consumed_by_hybrid
     */
    public void setEnergyConsumedByHybrid(double energy_consumed_by_hybrid) {
        this.energy_consumed_by_hybrid = energy_consumed_by_hybrid;
    }

    /**
     * @param adder
     */
    public void adequadaEnergyConsumedByHybrid(double adder) {
        this.energy_consumed_by_hybrid += adder;
    }

    /**
     * @return
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * @param vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return
     */
    public List<ChargingSession> getChargingSessions() {
        return chargingSessions;
    }

    /**
     * @param session
     */
    public void addChargingSession(ChargingSession session) {
        chargingSessions.add(session);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Morada: " + address + "\n");
        str.append("Tipo de estacao: " + station_type + "\n");
        str.append("Custo: " + charging_cost + "euros/h\n");
        str.append("Tempo de carregamento: " + charging_time + "h\n");
        str.append("Limite carregamento em simultaneo: " + simultaneous_ev_charging + "\n");
        return str.toString();
    }
}
