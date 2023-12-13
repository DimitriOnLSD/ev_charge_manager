package com.mycompany.projeto_pc2;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingStation {
    protected String address, station_type;
    protected int station_code, simultaneous_ev_charging, charging_now = 0;
    protected double charging_time, charging_cost;

    public ChargingStation(int station_code, 
                           int simultaneous_ev_charging, 
                           int charging_now,
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
        this.charging_now = charging_now;
    }

    public int getStationCode()                                         { return station_code; }
    public void setStationCode(int station_code)                        { this.station_code = station_code; }

    public String getAddress()                                          { return address; }
    public void setAddress(String address)                              { this.address = address; }

    public String getStationType()                                      { return station_type; }
    public void setStationType(String station_type)                     { this.station_type = station_type; }

    public double getChargingTime()                                     { return charging_time; }
    public void setChargingTime(double charging_time)                    { this.charging_time = charging_time; }

    public double getChargingCost()                                     { return charging_cost; }
    public void setChargingCost(double charging_cost)                    { this.charging_cost = charging_cost; }

    public int getSimultaneousEVCharging()                              { return simultaneous_ev_charging; }
    public void setSimultaneousEVCharging(int simultaneous_ev_charging) { this.simultaneous_ev_charging = simultaneous_ev_charging; }

    public int getChargingNow()                                         { return charging_now; }
    public void setChargingNow(int charging_now)                        { this.charging_now = charging_now; }

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
