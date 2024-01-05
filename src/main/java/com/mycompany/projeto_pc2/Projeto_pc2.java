package com.mycompany.projeto_pc2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Consola;

/**
 * Classe principal do projeto que contem os menus e as funções pedidas
 *
 * @author Paulo Sousa | João Domingos
 */
public class Projeto_pc2 {

    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public static Scanner sc = new Scanner(System.in);

    /**
     * Função que executa o código
     * 
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        clearConsole();

        String vehiclesFile = "vehicles.dat";
        String clientsFile  = "clients.dat";
        String stationsFile = "stations.dat";
        String sessionsFile = "sessions.dat";
        int primary_option, secondary_option = 0;

        Base base = new Base();

        primary_option = firstRunMenu();
        switch (primary_option) {
            case 1:
                base.readFromFile(vehiclesFile, clientsFile, stationsFile, sessionsFile);
                holdConsole();
                break;
            case 2:
                populateList(base);
                break;
            default:
        }

        clearConsole();

        do {
            primary_option = primaryMenu();

            switch (primary_option) {
                case 1:
                    secondary_option = vehicleMenu();

                    if (secondary_option == 1) {
                        if (base.getTotalCars() > 0) {
                            searchVehicle(base);
                        } else {
                            System.err.println("\nNao existem veiculos registados!\n");
                        }
                    } else if (secondary_option == 2) {
                        addVehicle(base);
                    }
                    break;
                case 2:
                    secondary_option = clientMenu();

                    if (secondary_option == 1 || secondary_option == 3) {
                        if (base.getTotalClients() > 0) {
                            if (secondary_option == 1) {
                                searchClient(base);
                            } else {
                                changeClientData(base);
                            }
                        } else {
                            System.err.println("\nNao existem clientes registados!\n");
                        }
                    } else if (secondary_option == 2) {
                        addClient(base);
                    }
                    break;
                case 3:
                    secondary_option = chargingStationMenu();

                    if (secondary_option == 1) {
                        if (base.getTotalChargingStations() > 0) {
                            searchChargingStation(base);
                        } else {
                            System.err.println("\nNao existem estacoes de carregamento registadas!\n");
                        }
                    } else if (secondary_option == 2) {
                        addChargingStation(base);
                    }
                    break;
                case 4:
                    secondary_option = chargingSessionMenu();

                    if (secondary_option == 1 || secondary_option == 3) {
                        if (base.getTotalChargingSessions() > 0) {
                            if (secondary_option == 1) {
                                searchChargingSession(base);
                            } else {
                                addPayment(base);
                            }
                        } else {
                            System.err.println("\nNao existem sessoes de carregamento registadas!\n");
                        }
                    } else if (secondary_option == 2) {
                        addChargingSession(base);
                    }
                    break;
                case 5:
                    secondary_option = statisticsMenu();

                    switch (secondary_option) {
                        case 1:
                            if (base.getTotalChargingStations() > 0) {
                                double[] revenue = base.searchStationRevenue();

                                for (int i = 3; i < 6; i++) {
                                    if (revenue[i] != 0) {
                                        int station_code = (int) revenue[i];
                                        String format_revenue = String.format("%.2f", revenue[i - 3]);
                                        System.out.print((i - 2) + ". Valor faturado: " + format_revenue);
                                        System.out.println(" euros # Codigo da estacao: " + station_code);
                                    }
                                }
                                System.out.println();
                            } else {
                                System.err.println("\nNao existem estacoes de carregamento registadas!\n");
                            }
                            break;
                        case 2:
                            if (base.getTotalChargingSessions() > 0) {
                                double x = Consola.lerDouble("Custo das sessoes com valor superior a: ", 0, 999999999);
                                base.searchSessionCostSuperiorToN(x);
                                System.out.println();
                            } else {
                                System.err.println("\nNao existem sessoes registadas!\n");
                            }
                            break;
                        case 3:
                            if (base.getTotalClients() > 0) {
                                int nif = Consola.lerInt("Insira NIF: ", 0, 999999999);
                                int total = base.getTotalChargingSessionsByUser(nif);
                                System.out.println("Total de sessoes realizadas: " + total);
                                System.out.println();
                            } else {
                                System.err.println("\nNao existem clientes registados!\n");
                            }
                            break;
                        case 4:
                            if (base.getTotalChargingStations() > 0) {
                                int station = Consola.lerInt("Insira cod. da estacao: ", 0, 99999);
                                double[] average = base.getAverageEnergyConsumedByStation(station);

                                if (average[0] != -1) {
                                    String[] labels = { ": ", "(em Hibridos): ", "(em Eletricos): " };

                                    for (int i = 0; i < 3; i++) {
                                        String format_average = String.format("%.2f", average[i]);
                                        System.out.println("Media de energia consumida " + labels[i] + format_average + " kW/h");
                                    }
                                    System.out.println();
                                }
                            } else {
                                System.err.println("\nNao existem estacoes de carregamento registadas!\n");
                            }
                            break;
                        case 5:
                            if (base.getTotalClients() > 0) {
                                int nif = Consola.lerInt("NIF: ", 0, 999999999);
                                base.getUnpaidSessionsByClient(nif);
                                System.out.println();
                            } else {
                                System.err.println("\nNao existem clientes registados!\n");
                            }
                            break;
                        case 6:
                            if (base.getTotalChargingStations() > 0) {
                                int station = Consola.lerInt("Cod. da estacao: ", 0, 999999999);
                                base.getSessionHistoryByStation(station);
                                System.out.println();
                            } else {
                                System.err.println("\nNao existem estacoes de carregamento registadas!\n");
                            }
                            break;
                    }
                    break;
            }
            if (primary_option != 0 && secondary_option != 0)
                holdConsole();
            clearConsole();
        } while (primary_option != 0);

        primary_option = lastRunMenu();
        if (primary_option == 1) {
            base.writeToFile(vehiclesFile, clientsFile, stationsFile, sessionsFile);
        }
    }

    /**
     * Apresenta o menu de opção de populamento das classes. Devolve a escolha do
     * utilizador
     * 
     * @return a escolha do utilizador
     */
    public static int firstRunMenu() {
        System.out.println("[1] Carregar dados dos ficheiros");
        System.out.println("[2] Carregar dados da funcao populateList()");
        System.out.println("[3] Continuar sem dados");

        int option = Consola.lerInt("\nOpcao: ", 1, 3);
        return option;
    }

    /**
     * Apresenta o menu de opção de salvamento dos dados das classes. Devolve a
     * escolha do utilizador
     * 
     * @return o ultimo menu
     */
    public static int lastRunMenu() {
        System.out.println("[1] Guardar dados e sair");
        System.out.println("[2] Sair sem guardar dados");

        int option = Consola.lerInt("\nOpcao: ", 1, 2);
        return option;
    }

    /**
     * Apresenta o menu principal. Devolve a opção do utilizador
     * 
     * @return a opção do utilizador
     */
    public static int primaryMenu() {
        System.out.println("[1] Veiculos registados");
        System.out.println("[2] Clientes registados");
        System.out.println("[3] Postos de carregamento");
        System.out.println("[4] Sessao de carregamento");
        System.out.println("[5] Estatisticas");
        System.out.println("[0] Sair");

        int option = Consola.lerInt("\nOpcao: ", 0, 5);
        clearConsole();
        return option;
    }

    /**
     * Apresenta o menu dos veículos. Devolve a opção do utilizador
     * 
     * @return a opção do utilizador
     */
    public static int vehicleMenu() {
        System.out.println("[1] Procurar veiculo");
        System.out.println("[2] Registar veiculo");
        System.out.println("[0] Voltar");

        int option = Consola.lerInt("\nOpcao: ", 0, 2);
        return option;
    }

    /**
     * Apresenta o menu dos clientes. Devolve a opção do utilizador
     * 
     * @return a opção do utilizador
     */
    public static int clientMenu() {
        System.out.println("[1] Procurar cliente");
        System.out.println("[2] Registar cliente");
        System.out.println("[3] Alterar dados do cliente");
        System.out.println("[0] Voltar");

        int option = Consola.lerInt("\nOpcao: ", 0, 3);
        return option;
    }

    /**
     * Apresenta o menu dos postos de carregamento. Devolve a opção do utilizador
     * 
     * @return a opção do utilizador
     */
    public static int chargingStationMenu() {
        System.out.println("[1] Consultar posto de carregamento");
        System.out.println("[2] Registar posto de carregamento");
        System.out.println("[0] Voltar");

        int option = Consola.lerInt("\nOpcao: ", 0, 2);
        return option;
    }

    /**
     * Apresenta o menu das sessões de carregamento. Devolve a opção do utilizador
     * 
     * @return a opção do utilizador
     */
    public static int chargingSessionMenu() {
        System.out.println("[1] Consultar sessao de carregamento");
        System.out.println("[2] Registar sessao de carregamento");
        System.out.println("[3] Registar pagamento");
        System.out.println("[0] Voltar");

        int option = Consola.lerInt("\nOpcao: ", 0, 3);
        return option;
    }

    /**
     * Apresenta o menu das estatisticas. Devolve a opção do utilizador
     * 
     * @return a opção do utilizador
     */
    public static int statisticsMenu() {
        System.out.println("[1] Lista dos 3 postos de carregamento com maior valor faturado");
        System.out.println("[2] Lista de sessoes de carregamento com valor superior a X");
        System.out.println("[3] Total de sessoes de carregamento realizadas por utilizador");
        System.out.println("[4] Media de energia consumida por: posto de carregamento e tipo de veiculo");
        System.out.println("[5] Lista de pagamentos pendentes por cliente");
        System.out.println("[6] Historico de sessoes de carregamento");
        System.out.println("[0] Voltar");

        int option = Consola.lerInt("\nOpcao: ", 0, 6);
        return option;
    }

    /**
     * Função que adiciona um novo elemento, neste caso um veículo, na lista dos
     * veículos, onde requisita a informação ao utilizador. Também regista o veículo
     * a um cliente existente
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void addVehicle(Base base) {
        Client client = null;
        String[] labels = { "0", "O", "voltar", "0 para voltar", "NAO", "NAO QUERO", "QUERO VOLTAR POR FAVOR",
                "epah, enganei-me", "Nao tenho carro", "O meu carro e importado", "matricula?",
                "O meu carro nao tem matricula, mas é azul", "matricula de mota tambem serve?",
                "oh manel, como e pra ir ao feiceboque?" };
        String[] fuel_types = { "Gasolina", "gasolina", "Gasoleo", "gasoleo", "gasóleo", "oleo fula", "óleo fula" };
        String brand;
        String model;
        String license_plate;
        String electric_hybrid;
        String fuel_type = null;
        Date date_of_register = null;
        int labels_array_size = labels.length;
        int fuel_types_array_size = fuel_types.length;
        int horsepower;
        int range;
        int chargingSpeed;
        int engine_displacement = 0;
        int nif;
        int pos;
        double battery_capacity;
        boolean isHybrid = false;
        boolean check_ev_type = true;
        boolean error = false;
        Pattern pattern = Pattern.compile("[A-Z0-9]{2}-[A-Z0-9]{2}-[A-Z0-9]{2}");

        do {
            license_plate = Consola.lerString("Insira a matricula [0 para voltar]: ");

            for (int i = 0; i < labels_array_size; i++) {
                if (license_plate.equals(labels[i])) {
                    return;
                }
            }
            pos = base.searchVehicle(license_plate);

            if (pos != -1) {
                System.err.println("Esta matricula ja se encontra registada!");
                error = true;
            } else {
                Matcher matcher = pattern.matcher(license_plate);
                if (!matcher.matches()) {
                    System.err.println("Matricula invalida. Formato certo deve ser XX-XX-XX");
                    error = true;
                } else {
                    error = false;
                }
            }
        } while (error);

        do {
            nif = Consola.lerInt("Registar o veiculo a (NIF) [0 para voltar]: ", 0, 999999999);
            if (nif == 0) {
                return;
            }
            pos = base.searchClient(nif);

            if (pos == -1) {
                System.err.println("Cliente nao existe!");
                error = true;
            } else {
                client = base.getClient(pos);
                error = false;
            }
        } while (error);

        brand      = Consola.lerString("Marca: ");
        model      = Consola.lerString("Modelo: ");
        horsepower = Consola.lerInt("Potencia [cv]: ", 1, 99999);

        do {
            electric_hybrid = Consola.lerString("Eletrico ou Hibrido: ");
            if (electric_hybrid.equals("Hibrido")) {
                isHybrid = true;
                check_ev_type = false;
            } else if (electric_hybrid.equals("Eletrico"))
                check_ev_type = false;
            else
                System.err.println(electric_hybrid + " nao existe. Tente novamente...");
        } while (check_ev_type);

        if (isHybrid) {
            error = true;
            do {
                fuel_type = Consola.lerString("Tipo de combustivel: ");
                for (int i = 0; i < fuel_types_array_size; i++) {
                    if (fuel_type.equals(fuel_types[i])) {
                        error = false;
                    }
                }
                if (error) {
                    System.err.println("Insira um tipo de combustivel aceite.");
                    System.err.println("Exemplo: " + fuel_types[0] + " ou " + fuel_types[2]);
                }
            } while (error);
            engine_displacement = Consola.lerInt("Cilindrada [cm^3]: ", 1, 99999);
        }
        battery_capacity = Consola.lerDouble("Capacidade da bateria [kW]: ", 1, 99999);
        range            = Consola.lerInt("Autonomia [km]: ", 1, 99999);
        chargingSpeed    = Consola.lerInt("Velocidade de carregamento [kW/h]: ", 1, 99999);

        do {
            try {
                date_of_register = dateFormat.parse(Consola.lerString("Data de registo: "));
                error = false;
            } catch (Exception e) {
                System.err.println("Data invalida.");
                error = true;
            }
        } while (error);

        Vehicle newVehicle = new Vehicle(client, brand, model, license_plate, electric_hybrid, fuel_type,
                date_of_register, horsepower, range, chargingSpeed, engine_displacement, battery_capacity);
        base.addVehicle(newVehicle);
        client.addVehicle(newVehicle);
    }

    /**
     * Função que adiciona um novo elemento, neste caso um cliente, na lista dos
     * clientes, onde requisita a informação ao utilizador
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void addClient(Base base) {
        String name;
        String address;
        String email;
        Date birth_date = null;
        int NIF;
        int pos;
        int contact;
        boolean error = false;

        do {
            NIF = Consola.lerInt("NIF [0 para voltar]: ", 0, 999999999);
            if (NIF == 0) {
                return;
            }
            pos = base.searchClient(NIF);
            if (pos != -1) {
                System.err.println("Este cliente ja se encontra registado!");
            }
        } while (pos != -1);

        name    = Consola.lerString("Nome: ");
        address = Consola.lerString("Morada: ");
        contact = Consola.lerInt("Contacto: ", 0, 999999999);
        email   = Consola.lerString("E-mail: ");

        do {
            try {
                birth_date = dateFormat.parse(Consola.lerString("Data de nascimento: "));
                error = false;
            } catch (Exception e) {
                System.out.println("Data invalida.");
                error = true;
            }
        } while (error);

        Client newClient = new Client(name, address, email, NIF, contact, birth_date);
        base.addClient(newClient);
    }

    /**
     * Função que adiciona um novo elemento, neste caso um posto de carregamento, na
     * lista dos postos de carregamento, onde requisita a informação ao utilizador
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void addChargingStation(Base base) {
        String address;
        String station_type;
        int station_code;
        int simultaneous_ev_charging;
        int pos;
        double charging_time;
        double charging_cost;
        boolean check_station_type = true;

        do {
            station_code = Consola.lerInt("Codigo da estacao [0 para voltar]: ", 0, 999999999);
            if (station_code == 0) {
                return;
            }
            pos = base.searchChargingStation(station_code);
            if (pos != -1) {
                System.err.println("Esta estacao de carregamento ja se encontra registada!");
            }
        } while (pos != -1);

        do {
            station_type = Consola.lerString("Tipo de estacao [PCN PCR PCUR]: ");
            if (station_type.equals("PCN") || station_type.equals("PCR") || station_type.equals("PCUR"))
                check_station_type = false;
            else
                System.err.println("Este tipo de estacao nao existe! Tente novamente...");
        } while (check_station_type);

        address                  = Consola.lerString("Morada: ");
        charging_cost            = Consola.lerDouble("Custo de carregamento: ", 0, 999999999);
        charging_time            = Consola.lerDouble("Tempo de carregamento: ", 0, 168);
        simultaneous_ev_charging = Consola.lerInt("Carregamento em simultaneo: ", 0, 50);

        ChargingStation newChargingStation = new ChargingStation(station_code, simultaneous_ev_charging, address,
                station_type, charging_time, charging_cost);
        base.addChargingStation(newChargingStation);
    }

    /**
     * Função que adiciona um novo elemento, neste caso uma sessão de carregamento,
     * na lista dos clientes, onde requisita a informação ao utilizador.
     * Adicionamos a sessão de carregamento ao cliente e ao posto
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void addChargingSession(Base base) {
        ChargingStation chargingStation = null;
        Vehicle vehicle = null;
        Client client = null;
        LocalDateTime start_time = null;
        LocalDateTime finish_time = null;
        Duration time_charging = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        String settlement_status;
        String license_plate;
        int session_code = 0;
        int NIF;
        int pos;
        int station_code;
        int max_charge = 0;
        double energy_consumed;
        double session_cost;
        double hours;
        boolean is_paid;
        boolean error = false;

        // Aqui vamos buscar o cliente que esta a registar a sessao
        do {
            NIF = Consola.lerInt("NIF do cliente a usar estacao [0 para voltar]: ", 0, 999999999);
            if (NIF == 0) {
                return;
            }
            pos = base.searchClient(NIF);
            if (pos == -1) {
                System.err.println("Este cliente nao existe!");
                error = true;
            } else {
                client = base.getClient(pos);
                error = false;
            }
        } while (error);

        // O veiculo que o cliente pretende carregar
        do {
            license_plate = Consola.lerString("Matricula do carro a carregar: ");
            pos = base.searchVehicle(license_plate);
            if (pos == -1) {
                System.err.println("Esta matricula nao existe!");
                error = true;
            } else {
                vehicle = base.getVehicle(pos);
                error = false;
            }
        } while (error);

        // A estacao que pretende usar
        do {
            station_code = Consola.lerInt("Codigo da estacao que pretende usar: ", 0, 999999999);
            pos = base.searchChargingStation(station_code);
            if (pos == -1) {
                System.err.println("Este posto de carregamento nao existe!");
                error = true;
            } else {
                chargingStation = base.getChargingStation(pos);
                error = false;
            }
        } while (error);

        // A hora e data (inicio e fim) do carregamento. É verificado aqui se existem
        // veiculos a carregar neste periodo temporal
        do {
            try {
                start_time = LocalDateTime.parse(Consola.lerString("Data e hora de inicio (HH:mm dd-MM-yyyy): "), formatter);
                finish_time = LocalDateTime.parse(Consola.lerString("Data e hora de fim (HH:mm dd-MM-yyyy): "), formatter);
                error = false;
            } catch (Exception e) {
                System.err.println("Formato da data ou hora esta errado.");
                error = true;
            }
            int check_if_can_charge = base.canCharge(chargingStation, vehicle, start_time, finish_time);
            if (check_if_can_charge == 2) {
                System.err.println("Esta estacao nao consegue carregar mais veiculos em simultaneo neste periodo temporal! Maximo = " + chargingStation.getSimultaneousEVCharging());
                error = true;
            } else if (check_if_can_charge == 1) {
                System.err.println("Esta carro ja se encontra a carregar numa estacao neste periodo temporal!");
                error = true;
            }
        } while (error);

        time_charging = Duration.between(start_time, finish_time); // time_charging vai guardar o tempo que o veiculo
                                                                   // esteve a carregar
        hours = (double) time_charging.toMinutes() / 60; // e aqui converte para horas em tipo double

        // Aqui vamos ver que tipo de estacao selecionamos. Se o nosso carro possuir um
        // charge power de 75, e escolher uma estacao PCR, ele carrega um maximo de 50
        // kW/h
        switch (chargingStation.getStationType()) {
            case "PCN":
                max_charge = 22;
                break;
            case "PCR":
                max_charge = 50;
                break;
            case "PCUR":
                max_charge = 160;
                break;
        }

        energy_consumed = Math.min(vehicle.getChargingSpeed(), max_charge) * hours; // A energia consumida é: os kW
                                                                                    // consumidos multiplicados pela
                                                                                    // duracao da carga (em horas)
        session_cost = energy_consumed * chargingStation.getChargingCost(); // Custo da sessao é: energia consumida (kW)
                                                                            // multiplicado pelo custo da sessao que vem
                                                                            // em euros/kW

        // Aqui verificamos qual o tipo do veiculo e guardamos na variavel adequada.
        // Apos isso, incrementamos o total de energia consumida e o valor faturado
        if (vehicle.isEletricHybrid().equals("Hibrido")) {
            chargingStation.adequadaEnergyConsumedByHybrid(energy_consumed);
        } else {
            chargingStation.addEnergyConsumedByEv(energy_consumed);
        }
        chargingStation.addTotalEnergyConsumed(energy_consumed);
        chargingStation.addTotalRevenue(session_cost);

        // Aqui dizemos que a sessao ainda nao esta paga
        settlement_status = "Por pagar";
        is_paid = false;

        do {
            session_code = generateRandomSessionCode(); // Gerar um codigo aleatorio
        } while (base.searchChargingSession(session_code) != -1); // Verificar se este codigo existe na base de dados
        System.out.println("Codigo da sessao gerado: " + session_code);

        // Aqui definimos os atributos para o construtor da classe, e tambem criamos
        // elementos de listas
        ChargingSession newChargingSession = new ChargingSession(chargingStation, vehicle, client, session_code,
                start_time, finish_time, settlement_status, energy_consumed, session_cost, is_paid);
        vehicle.setChargingStation(chargingStation); // Seria usada para saber qual posto o veículo está a usar em tempo
                                                     // real
        client.addChargingSession(newChargingSession);
        chargingStation.addChargingSession(newChargingSession);
        chargingStation.setVehicle(vehicle); // Seria usada para saber qual veículo o posto está a carregar em tempo
                                             // real
        base.addChargingSession(newChargingSession);
    }

    /**
     * Função que regista um pagamento efetuado para uma sessão de carregamento
     * existente.
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void addPayment(Base base) {
        ChargingSession chargingSession = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        LocalDateTime time_transaction = null;
        int session_code = 0;
        int pos;
        int type_of_payment;
        boolean error = false;

        do {
            session_code = Consola.lerInt("Codigo da sessao [0 para voltar]: ", 0, 999999999);
            if (session_code == 0) {
                return;
            }
            pos = base.searchChargingSession(session_code);
            if (pos == -1) {
                System.err.println("Esta sessao nao existe!");
                error = true;
            } else {
                chargingSession = base.getChargingSession(pos);
                error = false;
            }
        } while (error);

        System.out.println("Metodo de pagamento:");
        System.out.println("[1] MB WAY");
        System.out.println("[2] Debito Direto");
        System.out.println("[3] Transferencia Bancaria");
        type_of_payment = Consola.lerInt("Opcao: ", 1, 3);

        do {
            try {
                time_transaction = LocalDateTime
                        .parse(Consola.lerString("Data e hora de transacao (HH:mm dd-MM-yyyy): "), formatter);
                error = false;
            } catch (Exception e) {
                System.out.println("Foramto da data ou hora esta errado.");
                error = true;
            }
        } while (error);

        chargingSession.setSettlementStatus("Pago");
        chargingSession.setIsPaid(true);
        chargingSession.setTypeOfPayment(type_of_payment);
        chargingSession.setTimeOftransaction(time_transaction);
    }

    /**
     * Pesquisa um veículo na lista de veiculos
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void searchVehicle(Base base) {
        Vehicle vehicle;
        String license_plate;
        int pos;

        license_plate = Consola.lerString("Matricula [0 para voltar]: ");
        String[] labels = { "0", "O", "voltar", "0 para voltar", "NAO", "NAO QUERO", "QUERO VOLTAR POR FAVOR",
                "epah, enganei-me", "Ainda nao fui ver a matricula do carro", "Quero ver o carro do costa",
                "Quantas eguas tem o partido socialista?" };
        int array_size = labels.length;
        for (int i = 0; i < array_size; i++) {
            if (license_plate.equals(labels[i])) {
                return;
            }
        }
        pos = base.searchVehicle(license_plate);

        if (pos == -1) {
            System.err.println("Matricula nao existe!");
        } else {
            vehicle = base.getVehicle(pos);
            System.out.println(vehicle.toString());
        }
    }

    /**
     * Pesquisa um cliente na lista de clientes
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void searchClient(Base base) {
        Client client;
        int nif;
        int pos;

        nif = Consola.lerInt("NIF [0 para voltar]: ", 0, 999999999);
        if (nif == 0) {
            return;
        }
        pos = base.searchClient(nif);

        if (pos == -1) {
            System.err.println("Cliente nao existe!");
        } else {
            client = base.getClient(pos);
            System.out.println(client.toString());
        }
    }

    /**
     * Pesquisa um posto de carregamento na lista de postos de carregamento
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void searchChargingStation(Base base) {
        ChargingStation chargingStation;
        int station_code;
        int pos;

        station_code = Consola.lerInt("Codigo da estacao [0 para voltar]: ", 0, 999999999);
        if (station_code == 0) {
            return;
        }
        pos = base.searchChargingStation(station_code);

        if (pos == -1) {
            System.err.println("Estacao de carregamento nao existe!");
        } else {
            chargingStation = base.getChargingStation(pos);
            System.out.println(chargingStation.toString());
        }
    }

    /**
     * Pesquisa uma sessão de carregamento na lista de sessões de carregamento
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void searchChargingSession(Base base) {
        ChargingSession chargingSession;
        int session_code;
        int pos;

        session_code = Consola.lerInt("Codigo da sessao [0 para voltar]: ", 0, 999999999);
        if (session_code == 0) {
            return;
        }
        pos = base.searchChargingSession(session_code);

        if (pos == -1) {
            System.err.println("Sessao de carregamento nao existe!");
        } else {
            chargingSession = base.getChargingSession(pos);
            System.out.println(chargingSession.toString());
        }
    }

    /**
     * Altera os dados de um cliente existente na lista
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     */
    public static void changeClientData(Base base) {
        Client client;
        String name;
        String address;
        String email;
        Date birth_date = null;
        int nif;
        int contact;
        int pos;

        nif = Consola.lerInt("NIF [0 para voltar]: ", 1, 999999999);
        if (nif == 0) {
            return;
        }
        pos = base.searchClient(nif);

        if (pos == -1)
            System.err.println("Cliente nao existe!");
        else {
            client = base.getClient(pos);

            System.out.println("-Dados atuais-\n");
            System.out.println(client.toString());

            System.out.println("\n-Novos dados-\n");
            name    = Consola.lerString("Nome: ");
            address = Consola.lerString("Morada: ");
            contact = Consola.lerInt("Contacto: ", 0, 999999999);
            email   = Consola.lerString("E-mail: ");

            boolean error = false;
            do {
                try {
                    birth_date = dateFormat.parse(Consola.lerString("Data de nascimento: "));
                    error = false;
                } catch (Exception e) {
                    System.out.println("Data invalida");
                    error = true;
                }
            } while (error);

            client.setName(name);
            client.setAddress(address);
            client.setContact(contact);
            client.setEmail(email);
            client.setBirthDate(birth_date);
        }
    }

    /**
     * Adiciona elementos às classes (debugging e testing)
     * 
     * @param base Recebe a classe Base de forma a aceder ás funções e listas
     * @throws ParseException
     */
    public static void populateList(Base base) throws ParseException {
        Client c1 = new Client(
                "Paulo Sousa",
                "Torres Novas",
                "2222031@my.ipleiria.pt",
                257287914,
                969096163,
                dateFormat.parse("31-01-2000"));

        Client c2 = new Client(
                "Joao Domingos",
                "Leiria",
                "2222034@my.ipleiria.pt",
                244685673,
                967655031,
                dateFormat.parse("06-08-2002"));

        Client c3 = new Client(
                "Bernardo Gordo",
                "Sacristia",
                "2222033@my.ipleiria.pt",
                251986730,
                911139898,
                dateFormat.parse("29-06-2002"));

        Client c4 = new Client(
                "Perdu Ferreira",
                "FerMar",
                "2222035@my.ipleiria.pt",
                111111111,
                916849913,
                dateFormat.parse("13-05-2001"));

        Client c5 = new Client(
                "Cravo Morcela",
                "Morcela",
                "2222030@my.ipleiria.pt",
                222222222,
                918402249,
                dateFormat.parse("17-05-2001"));

        Vehicle volvoxc40 = new Vehicle(
                c1,
                "Volvo",
                "XC40 Recharge T5",
                "69-04-AF",
                "Hibrido",
                "Gasolina",
                dateFormat.parse("19-01-2021"),
                178,
                11,
                1477,
                50,
                10.7);

        Vehicle fiat500 = new Vehicle(
                c5,
                "Fiat",
                "500 2021 500e",
                "24-NF-01",
                "Eletrico",
                null,
                dateFormat.parse("05-04-2020"),
                116,
                320,
                0,
                85,
                42);

        Vehicle mercedesbenzeqs = new Vehicle(
                c3,
                "Mercedes-Benz",
                "EQS 350",
                "37-61-MX",
                "Eletrico",
                null,
                dateFormat.parse("30-11-2023"),
                284,
                617,
                0,
                170,
                100);

        Vehicle peugeote208 = new Vehicle(
                c2,
                "Peugeot",
                "e-208",
                "06-08-AG",
                "Eletrico",
                null,
                dateFormat.parse("01-06-2020"),
                134,
                340,
                0,
                7.4,
                50);

        Vehicle bmwi4m50 = new Vehicle(
                c4,
                "BMW",
                "I4 M50",
                "01-01-AA",
                "Eletrico",
                null,
                dateFormat.parse("18-12-2023"),
                537,
                510,
                0,
                207,
                83.9);

        Vehicle teslamodel3 = new Vehicle(
                c1,
                "Tesla",
                "Model 3",
                "02-01-AB",
                "Eletrico",
                null,
                dateFormat.parse("10-05-2021"),
                506,
                567,
                0,
                250,
                82.0);

        Vehicle porschetaycanturbos = new Vehicle(
                c1,
                "Porsche",
                "Taycan Turbo S",
                "99-99-ZZ",
                "Eletrico",
                null,
                dateFormat.parse("31-01-2023"),
                751,
                412,
                0,
                350,
                93.4);

        ChargingStation cs1 = new ChargingStation(
                1,
                3,
                "Av. Paulo Seixo",
                "PCN",
                10,
                0.2);

        ChargingStation cs2 = new ChargingStation(
                2,
                2,
                "Av. Joao Pecado",
                "PCR",
                6,
                2.5);

        ChargingStation cs3 = new ChargingStation(
                3,
                1,
                "Av. D. Perdu",
                "PCUR",
                4,
                4);

        ChargingStation cs4 = new ChargingStation(
                4,
                3,
                "Rua nao sei",
                "PCR",
                4,
                2.2);

        ChargingStation cs5 = new ChargingStation(
                5,
                1,
                "Av. Qualquer coisa",
                "PCR",
                4,
                2);

        ChargingStation cs6 = new ChargingStation(
                6,
                1,
                "Praca Existente",
                "PCUR",
                4,
                5);

        base.addClient(c1);
        base.addClient(c2);
        base.addClient(c3);
        base.addClient(c4);
        base.addClient(c5);
        base.addVehicle(volvoxc40);
        base.addVehicle(fiat500);
        base.addVehicle(mercedesbenzeqs);
        base.addVehicle(peugeote208);
        base.addVehicle(bmwi4m50);
        base.addVehicle(teslamodel3);
        base.addVehicle(porschetaycanturbos);
        c1.addVehicle(volvoxc40);
        c1.addVehicle(teslamodel3);
        c1.addVehicle(porschetaycanturbos);
        c2.addVehicle(peugeote208);
        c3.addVehicle(mercedesbenzeqs);
        c4.addVehicle(bmwi4m50);
        c5.addVehicle(fiat500);
        base.addChargingStation(cs1);
        base.addChargingStation(cs2);
        base.addChargingStation(cs3);
        base.addChargingStation(cs4);
        base.addChargingStation(cs5);
        base.addChargingStation(cs6);
    }

    /**
     * Limpa a consola (Pode não funcionar no NetBeans, mas funciona no Visual
     * Studio Code). Tipo: UTF-8
     * 
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Função serve para "parar" o código ao esperar um unser input, que seria o
     * enter. Serve para visualizar melhor o funcionamento do programa
     * 
     */
    public static void holdConsole() {
        System.out.println("Pressione enter para continuar...");
        sc.nextLine();
    }

    /**
     * Gera um codigo aleatorio para a sessão
     * 
     * @return o codigo aleatorio
     */
    public static int generateRandomSessionCode() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
}
