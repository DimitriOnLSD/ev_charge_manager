package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Classe que representa as sessões de carregamento com as suas principais e
 * custos associados para os clientes
 *
 * @author Paulo Sousa | João Domingos
 */
public class ChargingSession implements Serializable {
    ChargingStation chargingStation;
    Vehicle vehicle;
    Client client;
    private int session_code;
    private int type_of_payment;
    private double energy_consumed;
    private double session_cost;
    private boolean is_paid;
    private String settlement_status;
    private LocalDateTime start_time;
    private LocalDateTime finish_time;
    private LocalDateTime time_transaction;

    /**
     * Constroi a sessão de carregamento com os atributos dados
     * 
     * @param vehicle           veículo carregado na sessão
     * @param client            cliente que registou a sessão
     * @param session_code      código da sessão de carregamento
     * @param start_time        data de inicio da sessão de carregamento
     * @param finish_time       data de fim da sessão de carregamento
     * @param settlement_status Estado do pagamento da sessão de carregamento
     * @param energy_consumed   Energia consumida
     * @param session_cost      Custo da sessão de carregamento
     * @param is_paid           a sessão de carregamento foi paga
     */
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

    /**
     * Devolve o veiculo carregado na sessão
     * 
     * @return o veiculo
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Define o veiculo carregado na sessão
     * 
     * @param vehicle o novo veiculo
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Devolve o cliente que registou a sessão
     * 
     * @return o cliente
     */
    public Client getClient() {
        return client;
    }

    /**
     * Define o cliente que registou a sessão
     * 
     * @param client o novo cliente
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Devolve o codigo da sessão de carregamento
     * 
     * @return o codigo da sessão de carregamento
     */
    public int getSessionCode() {
        return session_code;
    }

    /**
     * Define o codigo da sessão de carregamento
     * 
     * @param session_code o novo codigo da sessão de carregamento
     */
    public void setSessionCode(int session_code) {
        this.session_code = session_code;
    }

    /**
     * Devolve o tempo de inicio da sessão de carregamento
     * 
     * @return o tempo de inicio da sessão de carregamento
     */
    public LocalDateTime getStartTime() {
        return start_time;
    }

    /**
     * Define o tempo de inicio da sessão de carregamento
     * 
     * @param start_time o novo tempo de inicio da sessão de carregamento
     */
    public void setStartTime(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    /**
     * Devolve o tempo de fim da sessão de carregamento
     * 
     * @return o tempo de fim da sessão de carregamento
     */
    public LocalDateTime getFinishTime() {
        return finish_time;
    }

    /**
     * Define o tempo de fim da sessão de carregamento
     * 
     * @param finish_time o novo tempo de fim da sessão de carregamento
     */
    public void setFinishTime(LocalDateTime finish_time) {
        this.finish_time = finish_time;
    }

    /**
     * Devolve a energia consumida na sessão de carregamento
     * 
     * @return a energia consumida
     */
    public double getEnergyConsumed() {
        return energy_consumed;
    }

    /**
     * Define a energia consumida na sessão de carregamento
     * 
     * @param energy_consumed a nova energia consumida
     */
    public void setEnergyConsumed(double energy_consumed) {
        this.energy_consumed = energy_consumed;
    }

    /**
     * Devolve o custo da sessão de carregamento
     * 
     * @return o custo da sessão de carregamento
     */
    public double getSessionCost() {
        return session_cost;
    }

    /**
     * Define o custo da sessão de carregamento
     * 
     * @param session_cost o novo custo da sessão de carregamento
     */
    public void setSessionCost(double session_cost) {
        this.session_cost = session_cost;
    }

    /**
     * Devolve o estado do pagamento
     * 
     * @return o estado do pagamento
     */
    public String getSettlementStatus() {
        return settlement_status;
    }

    /**
     * Define o estado do pagamento
     * 
     * @param settlement_status o novo estado do pagamento
     */
    public void setSettlementStatus(String settlement_status) {
        this.settlement_status = settlement_status;
    }

    /**
     * Devolve o tipo de pagamento
     * 
     * @return o tipo de pagamento
     */
    public int getTypeOfPayment() {
        return type_of_payment;
    }

    /**
     * Define o tipo de pagamento
     * 
     * @param type_of_payment o novo tipo de pagamento
     */
    public void setTypeOfPayment(int type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    /**
     * Devolve o tempo de quando a transação foi feita
     * 
     * @return o tempo de quando a transação foi feita
     */
    public LocalDateTime getTimeOftransaction() {
        return time_transaction;
    }

    /**
     * Define o tempo de quando a transação foi feita
     * 
     * @param time_transaction o novo tempo de quando a transação foi feita
     */
    public void setTimeOftransaction(LocalDateTime time_transaction) {
        this.time_transaction = time_transaction;
    }

    /**
     * Devolve se a sessão está paga
     * 
     * @return se a sessão está paga
     */
    public boolean getIsPaid() {
        return is_paid;
    }

    /**
     * Define se a sessão está paga
     * 
     * @param is_paid Define se a sessão está paga
     */
    public void setIsPaid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    /**
     * Verifica o periodo temporal entre todos os tempos de inicio e fim de
     * carregamento
     * 
     * @param newStartTime  tempo de inicio de carregamento
     * @param newFinishTime tempo de fim de carregamento
     * @return caso exista overlap, devolve "true"
     */
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
