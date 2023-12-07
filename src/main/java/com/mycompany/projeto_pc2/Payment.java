package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class Payment extends ChargingSession{
    private String type_of_payment;
    private Date time_of_transaction;

    public Payment(int totalChargingStations, int totalCars, int totalClients, String name, String address, int NIF,
            int contact, Date birth_date, int station_code, int charging_ev_cost, String address2, String station_type,
            float charging_time, float charging_cost, int session_code, Date start_time, Date finish_time,
            float energy_consumed, float session_cost, boolean settlement_status, String type_of_payment,
            Date time_of_transaction, String type_of_payment2, Date time_of_transaction2) {
        super(totalChargingStations, totalCars, totalClients, name, address, NIF, contact, birth_date, station_code,
                charging_ev_cost, address2, station_type, charging_time, charging_cost, session_code, start_time,
                finish_time, energy_consumed, session_cost, settlement_status, type_of_payment, time_of_transaction);
        type_of_payment = type_of_payment2;
        time_of_transaction = time_of_transaction2;
    }

    public String getTypeOfPayment() {
        return type_of_payment;
    }

    public void setTypeOfPayment(String type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    public Date getTimeOfTransaction() {
        return time_of_transaction;
    }

    public void setTimeOfTransaction(Date time_of_transaction) {
        this.time_of_transaction = time_of_transaction;
    }

}
