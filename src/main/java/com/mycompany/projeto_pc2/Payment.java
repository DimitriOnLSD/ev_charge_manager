package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class Payment extends ChargingSession{
    private String type_of_payment;
    private Date time_of_transaction;

    public Payment(int station_code, int simultaneous_ev_charging, int session_code, String address,
            String station_type, String type_of_payment, float charging_time, float charging_cost,
            float energy_consumed, float session_cost, boolean settlement_status, Date start_time, Date finish_time,
            Date time_of_transaction, String type_of_payment2, Date time_of_transaction2) {
        super(station_code, simultaneous_ev_charging, session_code, address, station_type, type_of_payment,
                charging_time, charging_cost, energy_consumed, session_cost, settlement_status, start_time, finish_time,
                time_of_transaction);
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
