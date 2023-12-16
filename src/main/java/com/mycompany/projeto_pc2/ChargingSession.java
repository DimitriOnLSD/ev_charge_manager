package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingSession {
    ChargingStation chargingStation;
    Vehicle vehicle;
    Client client;
    protected int session_code, type_of_payment;
    protected Date start_time, finish_time, time_transaction;
    protected double energy_consumed, session_cost;
    protected String settlement_status;

    public ChargingSession(ChargingStation chargingStation,
                           Vehicle vehicle,
                           Client client,
                           int session_code,
                           Date start_time,
                           Date finish_time,
                           String settlement_status) {
        this.chargingStation = chargingStation;
        this.vehicle = vehicle;
        this.client = client;
        this.session_code = session_code;
        this.start_time = start_time;
        this.finish_time = finish_time;
        this.settlement_status = settlement_status;
    }

    public int getSessionCode()                               { return session_code; }
    public void setSessionCode(int session_code)              { this.session_code = session_code; }

    public Date getStartTime()                                { return start_time; }
    public void setStartTime(Date start_time)                 { this.start_time = start_time; }

    public Date getFinishTime()                               { return finish_time; }
    public void setFinishTime(Date finish_time)               { this.finish_time = finish_time; }

    public double getEnergyConsumed()                         { return energy_consumed; }
    public void setEnergyConsumed(double energy_consumed)     { this.energy_consumed = energy_consumed; }

    public double getSessionCost()                            { return session_cost; }
    public void setSessionCost(double session_cost)           { this.session_cost = session_cost; }

    public String getSettlementStatus()                       { return settlement_status; }
    public void setSettlementStatus(String settlement_status) { this.settlement_status = settlement_status; }

    public int getTypeOfPayment()                             { return type_of_payment; }
    public void setTypeOfPayment(int type_of_payment)         { this.type_of_payment = type_of_payment; }

    public Date getTimeOftransaction()                        { return time_transaction; }
    public void setTimeOftransaction(Date time_transaction)   { this.time_transaction = time_transaction; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Cliente a usar: " + client.getName() + " (NIF: " + client.getNIF() + ")\n");
        str.append("Veiculo a carregar: " + vehicle.getBrand() + " " + vehicle.getModel() + " (" + vehicle.getLicensePlate() + ")\n");
        str.append("Estacao a usar: " + chargingStation.getAddress() + " (Cod: " + chargingStation.getStationCode() + ")\n");
        str.append("Hora de inicio: " + start_time + "\n");
        str.append("Hora de termino: " + finish_time + "\n");
        str.append("Energia consumida: " + energy_consumed + "\n");
        str.append("Custo da sessao: " + session_cost + " euros\n");
        str.append("Estado de liquidacao: " + settlement_status + "\n");
        if (settlement_status.equals("Pago")) {
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
