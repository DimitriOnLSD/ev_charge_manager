package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingStation {
    protected int station_code, charging_ev_cost;
    protected String address, station_type;
    protected float charging_time, charging_cost;

    public ChargingStation(int totalChargingStations, int totalCars, int totalClients, String name, String address,
            int NIF, int contact,
            Date birth_date, int station_code, int charging_ev_cost, String address2, String station_type,
            float charging_time, float charging_cost) {
        this.station_code = station_code;
        this.charging_ev_cost = charging_ev_cost;
        address = address2;
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

    public int getChargingEVCost() {
        return charging_ev_cost;
    }

    public void setChargingEVCost(int charging_ev_cost) {
        this.charging_ev_cost = charging_ev_cost;
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
}
