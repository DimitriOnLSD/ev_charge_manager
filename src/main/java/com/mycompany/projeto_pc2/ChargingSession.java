package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingSession {
    Vehicle vehicle;
    Client client;
    protected int session_code;
    protected Date start_time, finish_time;
    protected float energy_consumed, session_cost;
    protected String settlement_status;

    public ChargingSession(int session_code,
                           String settlement_status, 
                           Date start_time, 
                           Date finish_time) {
        this.session_code = session_code;
        this.settlement_status = settlement_status;
        this.start_time = start_time;
        this.finish_time = finish_time;
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

    public String getSettlementStatus() {
        return settlement_status;
    }

    public void setSettlementStatus(String settlement_status) {
        this.settlement_status = settlement_status;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Cliente a usar: " + client.getName() + "(" + client.getNIF() + ")" +  "\n");
        str.append("Veiculo a carregar: " + vehicle.getLicensePlate() + "\n");
        str.append("Hora de inicio: " + start_time + "\n");
        str.append("Hora de termino: " + finish_time + "\n");
        str.append("Energia consumida: " + energy_consumed + "\n");
        str.append("Custo da sessao: " + session_cost + " euros" + "\n");
        str.append("Estado de liquidacao: " + settlement_status + "\n");
        return str.toString();
    }
}
