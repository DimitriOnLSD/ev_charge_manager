package com.mycompany.projeto_pc2;

import java.time.LocalDateTime;

/**
 *
 * @authors Paulo Sousa | João Domingos
 */
public class ChargingSession {
    protected int session_code;
    protected int client_ID;
    protected int type_of_payment;
    protected double energy_consumed;
    protected double session_cost;
    protected boolean is_paid;
    protected String settlement_status;
    protected LocalDateTime start_time;
    protected LocalDateTime finish_time;
    protected LocalDateTime time_transaction;
    ChargingStation chargingStation;
    Vehicle vehicle;
    Client client;

    public ChargingSession(ChargingStation chargingStation,
            Vehicle vehicle,
            Client client,
            int session_code,
            LocalDateTime start_time,
            LocalDateTime finish_time,
            String settlement_status,
            double energy_consumed,
            double session_cost,
            boolean is_paid) {
        this.chargingStation = chargingStation;
        this.vehicle = vehicle;
        this.client = client;
        this.session_code = session_code;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.settlement_status = settlement_status;
        this.energy_consumed = energy_consumed;
        this.session_cost = session_cost;
        this.is_paid = is_paid;
    }

    public int getSessionCode() {
        return session_code;
    }

    public void setSessionCode(int session_code) {
        this.session_code = session_code;
    }

    public LocalDateTime getStartTime() {
        return start_time;
    }

    public void setStartTime(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getFinishTime() {
        return finish_time;
    }

    public void setFinishTime(LocalDateTime finish_time) {
        this.finish_time = finish_time;
    }

    public double getEnergyConsumed() {
        return energy_consumed;
    }

    public void setEnergyConsumed(double energy_consumed) {
        this.energy_consumed = energy_consumed;
    }

    public double getSessionCost() {
        return session_cost;
    }

    public void setSessionCost(double session_cost) {
        this.session_cost = session_cost;
    }

    public String getSettlementStatus() {
        return settlement_status;
    }

    public void setSettlementStatus(String settlement_status) {
        this.settlement_status = settlement_status;
    }

    public int getTypeOfPayment() {
        return type_of_payment;
    }

    public void setTypeOfPayment(int type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    public LocalDateTime getTimeOftransaction() {
        return time_transaction;
    }

    public void setTimeOftransaction(LocalDateTime time_transaction) {
        this.time_transaction = time_transaction;
    }

    public int getClientID() {
        return client_ID;
    }

    public void setClientID(int client_ID) {
        this.client_ID = client_ID;
    }

    public boolean getIsPaid() {
        return is_paid;
    }

    public void setIsPaid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public boolean isOverlapping(LocalDateTime newStartTime, LocalDateTime newFinishTime) {
        return (newStartTime.isBefore(finish_time) || newStartTime.isEqual(finish_time)) &&
                (newFinishTime.isAfter(start_time) || newFinishTime.isEqual(start_time));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String str1 = String.format("%.2f", energy_consumed);
        String str2 = String.format("%.2f", session_cost);
        str.append("Cliente a usar: " + client.getName() + " (NIF: " + client.getNIF() + ")\n");
        str.append("Veiculo a carregar: " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getLicensePlate() + ")\n");
        str.append("Estacao a usar: " + chargingStation.getAddress() + " (Cod: " + chargingStation.getStationCode() + ")\n");
        str.append("Hora de inicio: " + start_time + "\n");
        str.append("Hora de termino: " + finish_time + "\n");
        str.append("Energia consumida: " + str1 + " kW/h\n");
        str.append("Custo da sessao: " + str2 + " euros\n");
        str.append("Estado de liquidacao: " + settlement_status + "\n");
        if (getSettlementStatus().equals("Pago")) {
            switch (type_of_payment) {
                case 1:
                    str.append("Tipo de pagamento: MB WAY\n");
                    break;
                case 2:
                    str.append("Tipo de pagamento: Debito Direto\n");
                    break;
                case 3:
                    str.append("Tipo de pagamento: Transferencia Bancaria\n");
                    break;
            }
            str.append("Data e hora da transacao: " + time_transaction + "\n");
        }
        return str.toString();
    }
}
