package com.mycompany.projeto_pc2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa 
 *
 * @authors Paulo Sousa | João Domingos
 */
public class Base implements Serializable {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Client> clients;
    private ArrayList<ChargingStation> chargingStations;
    private ArrayList<ChargingSession> chargingSessions;


    /**
     * Constroi a base com os atributos dados
     * 
     * @param vehicles lista de veículos
     * @param clients lista dos clientes
     * @param chargingStations lista estações de carregamento
     * @param chargingSessions lista de sessões de carregamento
     */
    public Base() {
        vehicles = new ArrayList<>();
        clients = new ArrayList<>();
        chargingStations = new ArrayList<>();
        chargingSessions = new ArrayList<>();
    }



    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }


    /**
     * Define um veículo a um cliente
     * 
     * @param vehicles um novo veículo ao cliente
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<ChargingStation> getChargingStations() {
        return chargingStations;
    }

    public void setChargingStations(ArrayList<ChargingStation> chargingStations) {
        this.chargingStations = chargingStations;
    }

    public ArrayList<ChargingSession> getChargingSessions() {
        return chargingSessions;
    }

    public void setChargingSessions(ArrayList<ChargingSession> chargingSessions) {
        this.chargingSessions = chargingSessions;
    }

    public int getTotalCars() {
        return vehicles.size();
    }

    public int getTotalClients() {
        return clients.size();
    }

    public int getTotalChargingStations() {
        return chargingStations.size();
    }

    public int getTotalChargingSessions() {
        return chargingSessions.size();
    }

    public void addVehicle(Vehicle newVehicle) {
        vehicles.add(newVehicle);
    }

    public void addClient(Client newClient) {
        clients.add(newClient);
    }

    public void addChargingStation(ChargingStation newChargingStation) {
        chargingStations.add(newChargingStation);
    }

    public void addChargingSession(ChargingSession newChargingSession) {
        chargingSessions.add(newChargingSession);
    }

    public Vehicle getVehicle(int pos) {
        return vehicles.get(pos);
    }

    public Client getClient(int pos) {
        return clients.get(pos);
    }

    public ChargingStation getChargingStation(int pos) {
        return chargingStations.get(pos);
    }

    public ChargingSession getChargingSession(int pos) {
        return chargingSessions.get(pos);
    }

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

    public int canCharge(ChargingStation chargingStation, Vehicle vehicle, LocalDateTime start_time,
            LocalDateTime finish_time) {
        int simultaneous_ev_charging_counter = 0;
        for (int i = 0; i < chargingSessions.size(); i++) {
            if (chargingSessions.get(i).isOverlapping(start_time, finish_time)) {
                simultaneous_ev_charging_counter++;
                for (int j = 0; i < chargingStations.size(); i++) {
                    if (chargingStations.get(j).getVehicle() == vehicle) {
                        return 1;
                    }
                }
            }
            if (simultaneous_ev_charging_counter == chargingStation.getSimultaneousEVCharging()) {
                return 2;
            }
        }
        return 0;
    }

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
                System.out.print("Codigo da sessao: " + chargingSessions.get(i).getSessionCode());
                String cost = String.format("%.2f", chargingSessions.get(i).getSessionCost());
                System.out.println(" # Custo: " + cost + " euros");
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
            total = client.getChargingSessions().size();
        }
        return total;
    }

    public double[] getAverageEnergyConsumedByStation(int station_code) {
        ChargingStation chargingStation;
        int pos;
        double[] average = { 0.0, 0.0, 0.0 }; // Index n1 = Media energia consumida. Index n2 e n3 = Media energia
                                              // consumida de veiculos hibridos e eletricos
        pos = searchChargingStation(station_code);
        if (pos == -1) {
            System.err.println("\nEsta estacao de carregamento nao existe!\n");
            average[0] = pos;
        } else {
            chargingStation = getChargingStation(pos);
            if (chargingStation.getChargingSessions().size() > 0) {
                double energy_consumed = chargingStation.getTotalEnergyConsumed();
                double energy_consumed_hybrid = chargingStation.getEnergyConsumedByHybrid();
                double energy_consumed_by_ev = chargingStation.getEnergyConsumedByEv();
                int total_sessions = chargingStation.getChargingSessions().size();
                average[0] = total_sessions > 0 ? energy_consumed / total_sessions : 0.0;
                average[1] = total_sessions > 0 ? energy_consumed_hybrid / total_sessions : 0.0;
                average[2] = total_sessions > 0 ? energy_consumed_by_ev / total_sessions : 0.0;
            } else {
                System.err.println("\nEsta estacao de carregamento nao tem sessoes registadas!\n");
            }
        }   
        return average;
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
                    String cost = String.format("%.2f", session.getSessionCost());
                    System.out.println("Codigo da sessao: " + session.getSessionCode() + " # Custo: " + cost + " euros");
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
                    System.out.print("Codigo da sessao: " + session.getSessionCode());
                    System.out.println(" # Realizada por (NIF): " + session.getClient().getNIF());
                }
            }
            System.out.println();
        }
    }   

    public static void writeArrayListToFile(ArrayList<?> objectToWrite, String filename) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(objectToWrite);
            out.close();
            System.out.println("Dados guardados no finheiro " + filename + " com sucesso!");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar no ficheiro: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> readArrayListFromFile(String filename) {
        ArrayList<T> objectList = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
            objectList = (ArrayList<T>) inputStream.readObject();
            inputStream.close();
            System.out.println("Ficheiro " + filename + " lido com sucesso!");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao ler ficheiro: " + ex.getMessage());
        }
        return objectList;
    }

    public void writeToFile(String vehiclesFile, String clientsFile, String stationsFile, String sessionsFile) {
        writeArrayListToFile(getVehicles(), vehiclesFile);
        writeArrayListToFile(getClients(), clientsFile);
        writeArrayListToFile(getChargingStations(), stationsFile);
        writeArrayListToFile(getChargingSessions(), sessionsFile);
    }

    public void readFromFile(String vehiclesFile, String clientsFile, String stationsFile, String sessionsFile) {
        setVehicles(readArrayListFromFile(vehiclesFile));
        setClients(readArrayListFromFile(clientsFile));
        setChargingStations(readArrayListFromFile(stationsFile));
        setChargingSessions(readArrayListFromFile(sessionsFile));
    }
}