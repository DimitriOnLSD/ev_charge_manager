package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class Payment {
    ChargingSession chargingSession;
    private String type_of_payment;
    private Date time_transaction;

    public Payment(String type_of_payment,
                   Date time_transaction) {
        this.type_of_payment = type_of_payment;
        this.time_transaction = time_transaction;
    }

    public String getTypeOfPayment() {
        return type_of_payment;
    }

    public void setTypeOfPayment(String type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    public Date getTime_transaction() {
        return time_transaction;
    }

    public void setTime_transaction(Date time_transaction) {
        this.time_transaction = time_transaction;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Tipo de pagamento: " + type_of_payment + "\n");
        str.append("Data e hora da transacao: " + time_transaction + "\n");
        return str.toString();
    }

}
