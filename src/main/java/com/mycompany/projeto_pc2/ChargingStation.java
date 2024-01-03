package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a estação de carregamento com propriedades de identificacao,
 * de niveis de consumo e os ganhos da mesma
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
     * Devolve o codigo da estação de carregamento
     * 
     * @return o codigo da estação de carregamento
     */
    public int getStationCode() {
        return station_code;
    }

    /**
     * Define o codigo da estação de carregamento
     * 
     * @param station_code o novo codigo da estação de carregamento
     */
    public void setStationCode(int station_code) {
        this.station_code = station_code;
    }

    /**
     * Devolve a morada da estação de carregamento
     * 
     * @return a morada da estação de carregamento
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define a morada da estação de carregamento
     * 
     * @param address a  nova morada da estação de carregamento
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Devolve o tipo de estação de carregamento (hibrido ou eletrico)
     * 
     * @return o tipo de estação de carregamento (hibrido ou eletrico)
     */
    public String getStationType() {
        return station_type;
    }

    /**
     * Define o tipo de estação de carregamento (hibrido ou eletrico)
     * 
     * @param station_type o novo tipo de estação de carregamento (hibrido ou eletrico)
     */
    public void setStationType(String station_type) {
        this.station_type = station_type;
    }

    /**
     * Devolve o tempo de carregamento de um veiculo numa estação de carregamento
     * 
     * @return o tempo de carregamento de um veiculo numa estação de carregamento
     */
    public double getChargingTime() {
        return charging_time;
    }

    /**
     * Define o tempo de carregamento de um veiculo numa estação de carregamento
     *
     * @param charging_time o novo tempo de carregamento de um veiculo numa estação de carregamento
     */
    public void setChargingTime(double charging_time) {
        this.charging_time = charging_time;
    }

    /**
     * Devolve o custo de carregamento para um veiculo na estação de carregamento 
     * 
     * @return o custo de carregamento para um veiculo na estação de carregamento 
     */
    public double getChargingCost() {
        return charging_cost;
    }

    /**
     * Define o custo de carregamento para um veiculo na estação de carregamento 
     * 
     * @param charging_costo o novo custo de carregamento para um veiculo na estação de carregamento 
     */
    public void setChargingCost(double charging_cost) {
        this.charging_cost = charging_cost;
    }

    /**
     * Devolve se existem varios veiculos a carregar ao mesmo tempo 
     * 
     * @return a existencia de varios veiculos a carregar ao mesmo tempo 
     */
    public int getSimultaneousEVCharging() {
        return simultaneous_ev_charging;
    }

    /**
     * Define se existem varios veiculos a carregar ao mesmo tempo
     * 
     * @param simultaneous_ev_charging a existencia de varios veiculos a carregar ao mesmo tempo 
     */
    public void setSimultaneousEVCharging(int simultaneous_ev_charging) {
        this.simultaneous_ev_charging = simultaneous_ev_charging;
    }

    /**
     * Devolve o total de energia consumida 
     * 
     * @return o total de energia consumida 
     */
    public double getTotalEnergyConsumed() {
        return total_energy_consumed;
    }

    /**
     * Define o total de energia consumida
     * 
     * @param total_energy_consumed o novo total de energia consumida
     */
    public void setTotalEnergyConsumed(double total_energy_consumed) {
        this.total_energy_consumed = total_energy_consumed;
    }

    /**
     * Adiciona o total de energia consumida 
     * 
     * @param adder adiciona o total de energia consumida
     */
    public void addTotalEnergyConsumed(double adder) {
        this.total_energy_consumed += adder;
    }

    /**
     * Devolve o valor total faturado numa estação de carregamento
     * 
     * @return o valor total faturado numa estação de carregamento
     */
    public double getTotalRevenue() {
        return total_revenue;
    }

    /**
     * Define o valor total faturado numa estação de carregamento
     * 
     * @param total_revenue o novo valor total faturado numa estação de carregamento
     */
    public void setTotalRevenue(double total_revenue) {
        this.total_revenue = total_revenue;
    }

    /**
     * Adiciona o valor total faturado numa estação de carregamento
     * 
     * @param adder Adiciona o valor total faturado numa estação de carregamento
     */
    public void addTotalRevenue(double adder) {
        this.total_revenue += adder;
    }

    /**
     * Devolve a energia consumida por veiculos eletricos
     * 
     * @return a energia consumida por veiculos eletricos
     */
    public double getEnergyConsumedByEv() {
        return energy_consumed_by_ev;
    }

    /**
     * Define a energia consumida por veiculos eletricos
     * 
     * @param energy_consumed_by_ev a nova energia consumida por veiculos eletricos
     */
    public void setEnergyConsumedByEv(double energy_consumed_by_ev) {
        this.energy_consumed_by_ev = energy_consumed_by_ev;
    }

    /**
     * Adiciona a energia consumida por veiculos eletricos
     * 
     * @param adder Adiciona a energia consumida por veiculos eletricos
     */
    public void addEnergyConsumedByEv(double adder) {
        this.energy_consumed_by_ev += adder;
    }

    /**
     * Devolve a energia consumida por veiculos hibridos
     * 
     * @return a energia consumida por veiculos hibridos
     */
    public double getEnergyConsumedByHybrid() {
        return energy_consumed_by_hybrid;
    }

    /**
     * Define a energia consumida por veiculos hibridos
     * 
     * @param energy_consumed_by_hybrid a nova energia consumida por veiculos hibridos
     */
    public void setEnergyConsumedByHybrid(double energy_consumed_by_hybrid) {
        this.energy_consumed_by_hybrid = energy_consumed_by_hybrid;
    }

    /**
     * Adiciona a energia consumida por veiculos hibridos
     * 
     * @param adder Adiciona a energia consumida por veiculos hibridos
     */
    public void adequadaEnergyConsumedByHybrid(double adder) {
        this.energy_consumed_by_hybrid += adder;
    }

    /**
     * Devolve o veiculo que está na estação de carregamento
     * 
     * @return o veiculo que está na estação de carregamento
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Define o veiculo que está na estação de carregamento
     * 
     * @param vehicle o novo veiculo que está na estação de carregamento
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Devolve a sessão de carregamento da estação 
     * 
     * @return a sessão de carregamento da estação 
     */
    public List<ChargingSession> getChargingSessions() {
        return chargingSessions;
    }

    /**
     * Adiciona uma sessão de carregamento para a estação
     * 
     * @param session Adiciona uma sessão de carregamento para a estação
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
