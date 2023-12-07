package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingSession extends ChargingStation {
    protected int session_code;
    protected Date start_time, finish_time;
    protected float energy_consumed, session_cost;
    protected boolean settlement_status;
    protected String type_of_payment;
    protected Date time_of_transaction;

    /*
     * settlement_status ( pending = 0 | paid = 1 )
     */

    public ChargingSession(int totalChargingStations, int totalCars, int totalClients, String name, String address,
            int NIF, int contact, Date birth_date, int station_code, int charging_ev_cost, String address2,
            String station_type, float charging_time, float charging_cost, int session_code, Date start_time,
            Date finish_time, float energy_consumed, float session_cost, boolean settlement_status,
            String type_of_payment, Date time_of_transaction) {
        super(totalChargingStations, totalCars, totalClients, name, address, NIF, contact, birth_date, station_code,
                charging_ev_cost, address2, station_type, charging_time, charging_cost);
        this.session_code = session_code;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.energy_consumed = energy_consumed;
        this.session_cost = session_cost;
        this.settlement_status = settlement_status;
        this.type_of_payment = type_of_payment;
        this.time_of_transaction = time_of_transaction;
    }

    public int getSessionCode() {
        return session_code;
    }

    public void setSessionCode(int session_code) {
        this.session_code = session_code;
    }

    public Date getStartTime() {
        return start_time;
    }

    public void setStartTime(Date start_time) {
        this.start_time = start_time;
    }

    public Date getFinishTime() {
        return finish_time;
    }

    public void setFinishTime(Date finish_time) {
        this.finish_time = finish_time;
    }

    public float getEnergyConsumed() {
        return energy_consumed;
    }

    public void setEnergyConsumed(float energy_consumed) {
        this.energy_consumed = energy_consumed;
    }

    public float getSessionCost() {
        return session_cost;
    }

    public void setSessionCost(float session_cost) {
        this.session_cost = session_cost;
    }

    public boolean isSettlementStatus() {
        return settlement_status;
    }

    public void setSettlementStatus(boolean settlement_status) {
        this.settlement_status = settlement_status;
    }
}
