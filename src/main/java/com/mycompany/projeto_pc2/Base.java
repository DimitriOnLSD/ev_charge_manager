package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class Base implements Serializable {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Client> clients;
    private ArrayList<ChargingStation> chargingStations;
    private ArrayList<ChargingSession> chargingSessions;

    public Base() {
        vehicles         = new ArrayList<>();
        clients          = new ArrayList<>();
        chargingStations = new ArrayList<>();
        chargingSessions = new ArrayList<>();
    }

    public int getTotalCars()             { return vehicles.size(); }
    public int getTotalClients()          { return clients.size(); }
    public int getTotalChargingStations() { return chargingStations.size(); }
    public int getTotalChargingSessions() { return chargingSessions.size(); }

    public void addVehicle(Vehicle newVehicle)                         { vehicles.add(newVehicle); }
    public void addClient(Client newClient)                            { clients.add(newClient); }
    public void addChargingStation(ChargingStation newChargingStation) { chargingStations.add(newChargingStation); }
    public void addChargingSession(ChargingSession newChargingSession) { chargingSessions.add(newChargingSession); }

    public Vehicle getVehicle(int pos)                 { return vehicles.get(pos); }
    public Client getClient(int pos)                   { return clients.get(pos); }
    public ChargingStation getChargingStation(int pos) { return chargingStations.get(pos); }
    public ChargingSession getChargingSession(int pos) { return chargingSessions.get(pos); }

    public int searchVehicle(String license_plate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getLicensePlate().equals(license_plate)) {
                return i;
            }
        }
        return -1;
    }
    public int searchClient(int nif) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNIF() == nif) {
                return i;
            }
        }
        return -1;
    }
    public int searchChargingStation(int station_code) {
        for (int i = 0; i < chargingStations.size(); i++) {
            if (chargingStations.get(i).getStationCode() == station_code) {
                return i;
            }
        }
        return -1;
    }
    public int searchChargingSession(int session_code) {
        for (int i = 0; i < chargingStations.size(); i++) {
            if (chargingSessions.get(i).getSessionCode() == session_code) {
                return i;
            }
        }
        return -1;
    }
}

/*
 * public void show3most() {
 * if (numContas == 0) {
 * System.out.println("Nao existem contas");
 * 
 * } else {
 * System.out.
 * println("____________________Todas as contas: ____________________");
 * System.out.println("Numero - \tSaldo - \tNumero Cliente");
 * for (int i = 0; i < numContas; i++) {
 * System.out.println(
 * contas[i].getNumContas() +
 * "\t" + contas[i].getSaldo() +
 * "\t" + contas[i].getNumCliente());
 * }
 * }
 * }
 */
