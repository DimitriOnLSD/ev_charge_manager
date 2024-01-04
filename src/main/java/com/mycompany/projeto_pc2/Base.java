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
 * Classe que gere o comportamento das listas e das classes
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
     * @param vehicles         lista de veículos
     * @param clients          lista dos clientes
     * @param chargingStations lista estações de carregamento
     * @param chargingSessions lista de sessões de carregamento
     */
    public Base() {
        vehicles = new ArrayList<>();
        clients = new ArrayList<>();
        chargingStations = new ArrayList<>();
        chargingSessions = new ArrayList<>();
    }

    /**
     * Devolve o numero de elementos da lista "vehicles"
     * 
     * @return O numero de elementos da lista "vehicles"
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Define a lista parametrizada para a lista "vehicles"
     * 
     * @param vehicles A lista "vehicles"
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Devolve o numero de elementos da lista "clients"
     * 
     * @return O numero de elementos da lista "clients"
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    /**
     * Define a lista parametrizada para a lista "clients"
     * 
     * @param clients A lista "clients"
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     * Devolve o numero de elementos da lista "chargingStations"
     * 
     * @return O numero de elementos da lista "chargingStations"
     */
    public ArrayList<ChargingStation> getChargingStations() {
        return chargingStations;
    }

    /**
     * Define a lista parametrizada para a lista "chargingStations"
     * 
     * @param chargingStations A lista "chargingStations"
     */
    public void setChargingStations(ArrayList<ChargingStation> chargingStations) {
        this.chargingStations = chargingStations;
    }

    /**
     * Devolve o numero de elementos da lista "chargingSessions"
     * 
     * @return O numero de elementos da lista "chargingSessions"
     */
    public ArrayList<ChargingSession> getChargingSessions() {
        return chargingSessions;
    }

    /**
     * Define a lista parametrizada para a lista "chargingSessions"
     * 
     * @param chargingSessions A lista "chargingSessions"
     */
    public void setChargingSessions(ArrayList<ChargingSession> chargingSessions) {
        this.chargingSessions = chargingSessions;
    }

    /**
     * Devolve o numero total de carros
     * 
     * @return o numero total de carros
     */
    public int getTotalCars() {
        return vehicles.size();
    }

    /**
     * Devolve o numero total de clientes
     * 
     * @return o numero total de clientes
     */
    public int getTotalClients() {
        return clients.size();
    }

    /**
     * Devolve o numero total de estações de carregamento
     * 
     * @return o numero total de estações de carregamento
     */
    public int getTotalChargingStations() {
        return chargingStations.size();
    }

    /**
     * Devolve o numero total de sessões de carregamento
     * 
     * @return o numero total de sessões de carregamento
     */
    public int getTotalChargingSessions() {
        return chargingSessions.size();
    }

    /**
     * Adiciona o valor parametrizado para a lista "vehicles"
     * 
     * @param newVehicle o valor parametrizado
     */
    public void addVehicle(Vehicle newVehicle) {
        vehicles.add(newVehicle);
    }

    /**
     * Adiciona o valor parametrizado para a lista "clients"
     * 
     * @param newClient
     */
    public void addClient(Client newClient) {
        clients.add(newClient);
    }

    /**
     * Adiciona o valor parametrizado para a lista "chargingStations"
     * 
     * @param newChargingStation
     */
    public void addChargingStation(ChargingStation newChargingStation) {
        chargingStations.add(newChargingStation);
    }

    /**
     * Adiciona o valor parametrizado para a lista "chargingSessions"
     * 
     * @param newChargingSession
     */
    public void addChargingSession(ChargingSession newChargingSession) {
        chargingSessions.add(newChargingSession);
    }

    /**
     * Devolve o veiculo com a posição parametrizada da lista "vehicles"
     * 
     * @param pos posição do elemento
     * @return o veiculo especifico
     */
    public Vehicle getVehicle(int pos) {
        return vehicles.get(pos);
    }

    /**
     * Devolve o cliente com a posição parametrizada da lista "clients"
     * 
     * @param pos posição do elemento
     * @return o cliente especifico
     */
    public Client getClient(int pos) {
        return clients.get(pos);
    }

    /**
     * Devolve a estação de carregamento com a posição parametrizada da lista
     * "chargingStations"
     * 
     * @param pos posição do elemento
     * @return a estação de carregamento especifica
     */
    public ChargingStation getChargingStation(int pos) {
        return chargingStations.get(pos);
    }

    /**
     * Devolve a sessão de carregamento com a posição parametrizada da lista
     * "chargingSessions"
     * 
     * @param pos posição do elemento
     * @return a sessão de carregamento especifica
     */
    public ChargingSession getChargingSession(int pos) {
        return chargingSessions.get(pos);
    }

    /**
     * Pesquisa o veiculo a partir da matricula inserida
     * 
     * @param license_plate matricula inserida
     * @return o elemento na lista "vehicles". Caso não exista devolve -1
     */
    public int searchVehicle(String license_plate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getLicensePlate().equals(license_plate)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Pesquisa o cliente a partir do nif
     * 
     * @param nif nif inserido
     * @return o elemento na lista "clients". Caso não exista devolve -1
     */
    public int searchClient(int nif) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getNIF() == nif) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Pesquisa a estação de carregamento a partir do seu codigo
     * 
     * @param station_code codigo da estação
     * @return o elemento na lista "chargingStations". Caso não exista devolve -1
     */
    public int searchChargingStation(int station_code) {
        for (int i = 0; i < chargingStations.size(); i++) {
            if (chargingStations.get(i).getStationCode() == station_code) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Pesquisa a sessão de carregamento a partir do seu codigo
     * 
     * @param session_code codigo da sessão
     * @return o elemento na lista "chargingSessions". Caso não exista devolve -1
     */
    public int searchChargingSession(int session_code) {
        for (int i = 0; i < chargingSessions.size(); i++) {
            if (chargingSessions.get(i).getSessionCode() == session_code) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica se o carro pode ser carregado na estação de carregamento
     * 
     * @param chargingStation estação de carregamento inserida
     * @param vehicle         veiculo que pretendemos carregar
     * @param start_time      data de inico do carregamento
     * @param finish_time     data de fim do carregamento
     * @return 1 se num certo periodo de tempo o veiculo está a carregar numa das
     *         estações. 2 se a estação tiver atingido o seu limite de capacidade
     *         num certo limite temporal. 0 pode carregar
     */
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

    /**
     * Verifica quais as 3 estações mais rentaveis
     * 
     * @return o codigo das 3 estações mais rentaveis e o respetivo valor faturado
     *         de cada uma
     */
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

    /**
     * Verifica quais as sessões de carregamento que são superiores ao numero
     * inserido
     * 
     * @param n numero inserido
     */
    public void searchSessionCostSuperiorToN(double n) {
        boolean found = false;
        for (int i = 0; i < chargingSessions.size(); i++) {
            if (chargingSessions.get(i).getSessionCost() > n) {
                found = true;
                System.out.print("Codigo da sessao: " + chargingSessions.get(i).getSessionCode());
                String cost = String.format("%.2f", chargingSessions.get(i).getSessionCost());
                System.out.println(" # Custo: " + cost + " euros");
            }
        }
        if (!found) {
            System.out.println("Nao foram encontradas sessoes cujo valor supera " + n + " euros.");
        }
    }

    /**
     * Verifica quantas sessões de carregamento o utilizador fez
     * 
     * @param nif nif inserido
     * @return numero de sessões de carregamento efetuadas
     */
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

    /**
     * Devolve a media da energia consumida num posto de carregamento, media de
     * energia consumida por veiculos hibridos e eletricos
     * 
     * @param station_code codigo da estação inserida
     * @return a media da energia consumida num posto de carregamento, media de
     *         energia consumida por veiculos hibridos e eletricos
     */
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
                average[0] = -1;
            }
        }
        return average;
    }

    /**
     * Verifica as sessões que teem o pagamento pendente para um certo utilizador
     * 
     * @param nif nif inserido
     */
    public void getUnpaidSessionsByClient(int nif) {
        Client client;
        boolean nice = true;
        int pos = searchClient(nif);
        if (pos == -1) {
            System.err.println("Cliente nao existe!");
        } else {
            client = getClient(pos);
            if (client.getChargingSessions().size() == 0) {
                System.err.println("Este cliente ainda nao efetuou nenhuma sessao.");
            } else {
                List<ChargingSession> clientSessions = client.getChargingSessions();
                for (ChargingSession session : clientSessions) {
                    if (!session.getIsPaid()) {
                        nice = false;
                        String cost = String.format("%.2f", session.getSessionCost());
                        System.out.print("Codigo da sessao: " + session.getSessionCode());
                        System.out.println(" # Custo: " + cost + " euros");
                    }
                }
                if (nice) {
                    System.out.println("Todas as sessoes deste cliente encontram-se pagas.");
                }
            }
        }
    }

    /**
     * Apresenta o historico de sessões numa estação
     * 
     * @param station_code codigo da estação inserida
     */
    public void getSessionHistoryByStation(int station_code) {
        ChargingStation chargingStation;
        int pos = searchChargingStation(station_code);
        if (pos == -1) {
            System.err.println("Estacao de carregamento nao existe!");
        } else {
            chargingStation = getChargingStation(pos);
            if (chargingStation.getChargingSessions().size() == 0) {
                System.err.println("Ainda nao foram realizadas sessoes neste posto.");
            } else {
                List<ChargingSession> sessionHistory = chargingStation.getChargingSessions();
                for (ChargingSession session : sessionHistory) {
                    if (session.getSessionCode() > 0) {
                        System.out.print("Codigo da sessao: " + session.getSessionCode());
                        System.out.println(" # Realizada por (NIF): " + session.getClient().getNIF());
                    }
                }
            }
        }
    }

    /**
     * Escreve para um ficheiro apenas
     * 
     * @param objectToWrite a lista dada
     * @param filename      nome do ficheiro
     */
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

    /**
     * Lê um ficheiro apenas
     * 
     * @param <T>      parametro generico da lista
     * @param filename nome do ficheiro a ler
     * @return elementos lidos para a lista
     */
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

    /**
     * Função que guarda as classes em ficheiros
     * 
     * @param vehiclesFile ficheiro de veiculos
     * @param clientsFile  ficheiro de clientes
     * @param stationsFile ficheiro de estações
     * @param sessionsFile ficheiro de sessões
     */
    public void writeToFile(String vehiclesFile, String clientsFile, String stationsFile, String sessionsFile) {
        writeArrayListToFile(getVehicles(), vehiclesFile);
        writeArrayListToFile(getClients(), clientsFile);
        writeArrayListToFile(getChargingStations(), stationsFile);
        writeArrayListToFile(getChargingSessions(), sessionsFile);
    }

    /**
     * Função que lê os ficheiros e guarda em classes
     * 
     * @param vehiclesFile ficheiro de veiculos
     * @param clientsFile  ficheiro de clientes
     * @param stationsFile ficheiro de estações
     * @param sessionsFile ficheiro de sessões
     */
    public void readFromFile(String vehiclesFile, String clientsFile, String stationsFile, String sessionsFile) {
        setVehicles(readArrayListFromFile(vehiclesFile));
        setClients(readArrayListFromFile(clientsFile));
        setChargingStations(readArrayListFromFile(stationsFile));
        setChargingSessions(readArrayListFromFile(sessionsFile));
    }
}