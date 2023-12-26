package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Consola;

/**
 *
 * @authors Paulo Sousa | João Domingos
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

    public void addVehicle        (Vehicle         newVehicle)         { vehicles.add(newVehicle); }
    public void addClient         (Client          newClient)          { clients.add(newClient); }
    public void addChargingStation(ChargingStation newChargingStation) { chargingStations.add(newChargingStation); }
    public void addChargingSession(ChargingSession newChargingSession) { chargingSessions.add(newChargingSession); }

    public Vehicle         getVehicle        (int pos) { return vehicles.get(pos); }
    public Client          getClient         (int pos) { return clients.get(pos); }
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
        for (int i = 0; i < chargingSessions.size(); i++) {
            if (chargingSessions.get(i).getSessionCode() == session_code) {
                return i;
            }
        }
        return -1;
    }

    // public boolean canCharge(LocalDateTime start_time, LocalDateTime finish_time) {
    //     ChargingSession chargingSession = null;
    //     for (int i = 0; i < chargingSessions.size(); i++) {
    //         if (chargingSession.isOverlapping(start_time, finish_time)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public double[] searchStationRevenue() {
        double[] to_return = { 0.0, 0.0, 0.0, 0, 0, 0 };

        for (int i = 0; i < chargingStations.size(); i++) {
            double revenue = chargingStations.get(i).getTotalRevenue();

            if (revenue > to_return[0]) {
                to_return[2] = to_return[1];
                to_return[1] = to_return[0];
                to_return[0] = revenue;
                to_return[5] = to_return[4];
                to_return[4] = to_return[3];
                to_return[3] = chargingStations.get(i).getStationCode();
            } else if (revenue > to_return[1]) {
                to_return[2] = to_return[1];
                to_return[1] = revenue;
                to_return[5] = to_return[4];
                to_return[4] = chargingStations.get(i).getStationCode();
            } else if (revenue > to_return[2]) {
                to_return[2] = revenue;
                to_return[5] = chargingStations.get(i).getStationCode();
            }
        }
        return to_return;
    }
    public void searchSessionCostSuperiorToN(double n) {
        for (int i = 0; i < chargingSessions.size(); i++) {
            if (chargingSessions.get(i).getSessionCost() > n) {
                System.out.println("Codigo da sessao: " + chargingSessions.get(i).getSessionCode());
            }  
        }
    }
    public int getTotalChargingSessionsByUser(int nif) {
        Client client;
        int pos;
        int total;
        pos = searchClient(nif);
        if (pos == -1) {
            System.err.println("\nEste NIF nao se encontra registado!\n");
            total = pos;
        } else {
            client = getClient(pos);
            total = client.getTotalSessions();
        }
        return total;
    } 
    public double getAverageEnergyConsumedByStation() {
        // code
        return 1;
    }
    public double getAverageEnergyConsumedByEVType() {
        // code
        return 1;
    }
    public void getUnpaidSessionsByClient(int nif) {
        Client client;
        int pos = searchClient(nif);
        if (pos == -1) {
            System.err.println("Cliente nao existe!");
        } else {
            client = getClient(pos);
            List<ChargingSession> clientSessions = client.getChargingSessions();
            for (ChargingSession session : clientSessions) {
                if (!session.getIsPaid()) {
                    System.out.println("Cod. sessao: " + session.getSessionCode() + " Custo: " + session.getSessionCost() + " euros");
                }
            }
            System.out.println();
        }
    }
    public void getSessionHistoryByStation(int station_code) {
        ChargingStation chargingStation;
        int pos = searchChargingStation(station_code);
        if (pos == -1) {
            System.err.println("Estacao de carregamento nao existe!");
        } else {
            chargingStation = getChargingStation(pos);
            List<ChargingSession> sessionHistory = chargingStation.getChargingSessions();
            for (ChargingSession session : sessionHistory) {
                if (session.getSessionCode() > 0) {
                    System.out.println("Cod. sessao: " + session.getSessionCode());
                }
            }
            System.out.println();
        }
    }
}