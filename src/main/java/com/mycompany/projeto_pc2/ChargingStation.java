package com.mycompany.projeto_pc2;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingStation {
    protected String address, station_type;
    protected int station_code, simultaneous_ev_charging;
    protected float charging_time, charging_cost;

    // station_type
    // Posto de Carregamento Normal (PCN) 
    // Posto de Carregamento Rápido (PCR)
    // Posto de Carregamento Ultrarrápido (PCUR)

    public ChargingStation(int station_code, 
                           int simultaneous_ev_charging, 
                           String address,
                           String station_type, 
                           float charging_time, 
                           float charging_cost) {
        this.station_code = station_code;
        this.simultaneous_ev_charging = simultaneous_ev_charging;
        this.address = address;
        this.station_type = station_type;
        this.charging_time = charging_time;
        this.charging_cost = charging_cost;
    }

    public int getStationCode() {
        return station_code;
    }

    public void setStationCode(int station_code) {
        this.station_code = station_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStationType() {
        return station_type;
    }

    public void setStationType(String station_type) {
        this.station_type = station_type;
    }

    public float getChargingTime() {
        return charging_time;
    }

    public void setChargingTime(float charging_time) {
        this.charging_time = charging_time;
    }

    public float getChargingCost() {
        return charging_cost;
    }

    public void setChargingCost(float charging_cost) {
        this.charging_cost = charging_cost;
    }

    public int getSimultaneousEVCharging() {
        return simultaneous_ev_charging;
    }

    public void setSimultaneousEVCharging(int simultaneous_ev_charging) {
        this.simultaneous_ev_charging = simultaneous_ev_charging;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Morada: " + address + "\n");
        str.append("Tipo de estacao: " + station_type + "\n");
        str.append("Informacoes sobre carregamento: ");
        str.append(charging_cost + "\u20ac/h, " + charging_time + "h, " + simultaneous_ev_charging + " num. maximo de veiculos" + "\n");
        return str.toString();
    }
}
