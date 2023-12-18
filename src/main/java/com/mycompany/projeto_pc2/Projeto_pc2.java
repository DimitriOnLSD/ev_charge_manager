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

/*
 * Bugs: 
 * linha 150: valor do double nao esta a converter corretamente para string
 * linha 432: valor de hours e absurdo e causa valores altissimos em session cost
 */

/* 
 * To ask:
 * Os clientes so podem carregar os seus carros?
 * Ao consultar os clientes, deve aparecer os seus carros (matriculas)?
 * No registo de uma sessao, o programa guarda a hora de inicio e pergunta ao utilizador quanto tempo quer carregar o veiculo
 * 
 */

/*
 * To do list:
 * 2 casas decimais em chargingSession, para os kWh e euros (ex: 1.25€ 1.36 kW/h)
 * Checker do charging_now. Depois de terminar a hora de carregar um carro, esta variavel devia decrementar
 * Os carros devem estar associados aos clientes. Cada cliente pode ter multiplos carros. Talvez usar vetor ou lista nos clientes de veiculos
 * Uma funcao que devolve o tempo total de carregamento. Será usada para verificar quantos carros estao a usar a mesma estacao naquele periodo de tempo, o custo da sessao e energia consumida
 * O resto do codigo...
 */

/**
 *
 * @authors Paulo Sousa | João Domingos
 */
public class Projeto_pc2 {

    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Base base = new Base();
        int primary_option, secondary_option = 0;
        clearConsole();

        populateList(base);

        do {
            primary_option = menu();
            switch (primary_option) {
                case 1:
                    System.out.println("[1] Procurar veiculo");
                    System.out.println("[2] Registar veiculo");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 2);

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
                    System.out.println("[1] Procurar cliente");
                    System.out.println("[2] Registar cliente");
                    System.out.println("[3] Alterar dados do cliente");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 3);

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
                    System.out.println("[1] Consultar posto de carregamento");
                    System.out.println("[2] Registar posto de carregamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 2);

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
                    System.out.println("[1] Consultar sessao de carregamento");
                    System.out.println("[2] Registar sessao de carregamento");
                    System.out.println("[3] Registar pagamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 3);

                    if (secondary_option == 1 || secondary_option == 3) {
                        if (base.getTotalChargingSessions() > 0) {
                            if (secondary_option == 1) {
                                searchChargingSession(base);
                            } else {
                                addPayment(base);
                            }
                        } else {
                            System.err.println("\nNao existem sessoes registadas!\n");
                        }
                    } else if (secondary_option == 2) {
                        addChargingSession(base);
                    }
                    break;
                case 5:
                    System.out.println("[1] Lista dos 3 postos de carregamento com maior valor faturado");
                    System.out.println("[2] Lista de sessoes de carregamento com valor superior a X");
                    System.out.println("[3] Total de sessoes de carregamento realizadas por utilizador");
                    System.out.println("[4] Media de energia consumida por: posto de carregamento e tipo de veiculo");
                    System.out.println("[5] Lista de pagamentos por efetuar");
                    System.out.println("[6] Historico de sessoes de carregamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 6);

                    switch (secondary_option) {
                        case 1:
                            double[] result = base.searchStationRevenue();

                            String str1 = String.format("%.2f", result[0]);
                            String str2 = String.format("%.2f", result[1]);
                            String str3 = String.format("%.2f", result[2]);

                            System.out.println("1. Valor faturado: " + str1 + " euros, Codigo da estacao: " + (int) result[3]);
                            System.out.println("2. Valor faturado: " + str2 + " euros, Codigo da estacao: " + (int) result[4]);
                            System.out.println("3. Valor faturado: " + str3 + " euros, Codigo da estacao: " + (int) result[5]);
                            System.out.println();
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
                            System.out.println("Total de sessoes realizadas: " + base.getTotalChargingSessionsByUser(Consola.lerInt("Insira NIF: ", 0, 999999999)));
                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                    }
                    break;
            }
            if (primary_option != 0 && secondary_option != 0)
                holdConsole();
            clearConsole();
        } while (primary_option != 0);
    }

    public static int menu() {
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

    public static void addVehicle(Base base) {
        String brand;
        String model;
        String license_plate;
        String electric_hybrid;
        String fuel_type = null;
        Date date_of_register = null;
        int horsepower;
        int range;
        int chargingSpeed;
        int engine_displacement = 0;
        int battery = 50;
        int pos;
        double battery_capacity;
        boolean isCharging = false;
        boolean isHybrid = false;
        boolean check_ev_type = true;
        boolean error = false;
        Pattern pattern = Pattern.compile("\\p{XDigit}{2}-\\p{XDigit}{2}-\\p{XDigit}{2}");

        do {
            license_plate = Consola.lerString("Insira a matricula: ");
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

        brand = Consola.lerString("Marca: ");
        model = Consola.lerString("Modelo: ");
        horsepower = Consola.lerInt("Potencia: ", 0, 99999);

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
            engine_displacement = Consola.lerInt("Cilindrada: ", 0, 99999);
            fuel_type = Consola.lerString("Tipo de combustivel: ");
        }
        battery_capacity = Consola.lerDouble("Capacidade da bateria: ", 0, 99999);
        range = Consola.lerInt("Autonomia: ", 0, 99999);
        chargingSpeed = Consola.lerInt("Velocidade de carregamento: ", 0, 99999);

        do {
            try {
                date_of_register = dateFormat.parse(Consola.lerString("Data de registo: "));
                error = false;
            } catch (Exception e) {
                System.out.println("Data invalida");
                error = true;
            }
        } while (error);

        Vehicle newVehicle = new Vehicle(brand, model, license_plate, electric_hybrid, fuel_type, date_of_register, horsepower, range, chargingSpeed, engine_displacement, battery, battery_capacity, isCharging);
        base.addVehicle(newVehicle);
    }

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
            NIF = Consola.lerInt("NIF: ", 0, 999999999);
            pos = base.searchClient(NIF);
            if (pos != -1) {
                System.err.println("Este cliente ja se encontra registado!");
            }
        } while (pos != -1);

        name = Consola.lerString("Nome: ");
        address = Consola.lerString("Morada: ");
        contact = Consola.lerInt("Contacto: ", 0, 999999999);
        email = Consola.lerString("E-mail: ");

        do {
            try {
                birth_date = dateFormat.parse(Consola.lerString("Data de nascimento: "));
                error = false;
            } catch (Exception e) {
                System.out.println("Data invalida");
                error = true;
            }
        } while (error);

        Client newClient = new Client(name, address, email, NIF, contact, birth_date);
        base.addClient(newClient);
    }

    public static void addChargingStation(Base base) {
        String address;
        String station_type;
        int station_code;
        int simultaneous_ev_charging;
        int pos;
        int charging_now = 0;
        double charging_time;
        double charging_cost;
        boolean check_station_type = true;

        do {
            station_code = Consola.lerInt("Codigo da estacao: ", 0, 999999999);
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

        address = Consola.lerString("Morada: ");
        charging_cost = Consola.lerFloat("Custo de carregamento: ", 0, 999999999);
        charging_time = Consola.lerFloat("Tempo de carregamento: ", 0, 168);
        simultaneous_ev_charging = Consola.lerInt("Carregamento em simultaneo: ", 0, 50);

        ChargingStation newChargingStation = new ChargingStation(station_code, simultaneous_ev_charging, charging_now, address, station_type, charging_time, charging_cost);
        base.addChargingStation(newChargingStation);
    }

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
        boolean error = false;

        do {
            NIF = Consola.lerInt("NIF do cliente a usar estacao: ", 0, 999999999);
            pos = base.searchClient(NIF);
            if (pos == -1) {
                System.err.println("Este cliente nao existe!");
                error = true;
            } else {
                client = base.getClient(pos);
                error = false;
            }
        } while (error);

        do {
            license_plate = Consola.lerString("Matricula do carro a carregar: ");
            pos = base.searchVehicle(license_plate);
            if (pos == -1) {
                System.err.println("Esta matricula nao existe!");
                error = true;
            } else {
                vehicle = base.getVehicle(pos);
                if (vehicle.isCharging()) {
                    System.err.println("Carro esta a carregar de momento!");
                    error = true;
                } else if (vehicle.getBattery() == 100) {
                    System.err.println("A bateria deste carro encontra-se carregada.");
                } else {
                    error = false;
                }
            }
        } while (error);

        do {
            station_code = Consola.lerInt("Codigo da estacao que pretende usar: ", 0, 999999999);
            pos = base.searchChargingStation(station_code);
            if (pos == -1) {
                System.err.println("Este posto de carregamento nao existe!");
                error = true;
            } else {
                chargingStation = base.getChargingStation(pos);
                if (chargingStation.getChargingNow() == chargingStation.getSimultaneousEVCharging()) {
                    System.err.println("Esta estacao nao consegue carregar mais veiculos em simultaneo!");
                    error = true;
                } else {
                    error = false;
                }
            }
        } while (error);

        do {
            try {
                start_time = LocalDateTime.parse(Consola.lerString("Data e hora de inicio (HH:mm dd-MM-yyyy): "), formatter);
                finish_time = LocalDateTime.parse(Consola.lerString("Data e hora de fim (HH:mm dd-MM-yyyy): "), formatter);
                error = false;
            } catch (Exception e) {
                System.err.println("Foramto da data ou hora esta errado.");
                error = true;
            }
        } while (error);

        time_charging = Duration.between(start_time, finish_time);
        hours = time_charging.toMinutes() / 60;

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

        energy_consumed = Math.min(vehicle.getChargingSpeed(), max_charge) * hours;
        session_cost = energy_consumed * chargingStation.getChargingCost();

        chargingStation.total_energy_consumed += energy_consumed;
        chargingStation.total_revenue += session_cost;
        client.total_sessions++;

        vehicle.setCharging(true);
        settlement_status = "Por pagar";
        do {
            session_code = generateRandomSessionCode();
        } while (base.searchChargingSession(session_code) != -1);
        
        // comentado, pois vai existir outra forma de verificar se um carro esta a ser carregado naquele periodo de tempo. talvez com listas
        // chargingStation.charging_now++;

        System.out.println("Codigo da sessao gerado: " + session_code);
        vehicle.setChargingStation(chargingStation);
        ChargingSession newChargingSession = new ChargingSession(chargingStation, vehicle, client, session_code, start_time, finish_time, settlement_status, energy_consumed, session_cost);
        base.addChargingSession(newChargingSession);
    }

    public static void addPayment(Base base) {
        ChargingSession chargingSession = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        LocalDateTime time_transaction = null;
        int session_code = 0;
        int pos;
        int type_of_payment;
        boolean error = false;

        do {
            session_code = Consola.lerInt("Codigo da sessao: ", 0, 999999999);
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
        chargingSession.setTypeOfPayment(type_of_payment);
        chargingSession.setTimeOftransaction(time_transaction);
    }

    public static void searchVehicle(Base base) {
        Vehicle vehicle;
        String license_plate;
        int pos;

        license_plate = Consola.lerString("Matricula: ");
        pos = base.searchVehicle(license_plate);

        if (pos == -1) {
            System.err.println("Matricula nao existe!");
        } else {
            vehicle = base.getVehicle(pos);
            System.out.println(vehicle.toString());
        }
    }

    public static void searchClient(Base base) {
        Client client;
        int nif;
        int pos;

        nif = Consola.lerInt("NIF: ", 0, 999999999);
        pos = base.searchClient(nif);

        if (pos == -1) {
            System.err.println("Cliente nao existe!");
        } else {
            client = base.getClient(pos);
            System.out.println(client.toString());
        }
    }

    public static void searchChargingStation(Base base) {
        ChargingStation chargingStation;
        int station_code;
        int pos;

        station_code = Consola.lerInt("Codigo da estacao: ", 0, 999999999);
        pos = base.searchChargingStation(station_code);

        if (pos == -1) {
            System.err.println("Estacao de carregamento nao existe!");
        } else {
            chargingStation = base.getChargingStation(pos);
            System.out.println(chargingStation.toString());
        }
    }

    public static void searchChargingSession(Base base) {
        ChargingSession chargingSession;
        int session_code;
        int pos;

        session_code = Consola.lerInt("Codigo da sessao: ", 0, 999999999);
        pos = base.searchChargingSession(session_code);

        if (pos == -1) {
            System.err.println("Sessao de carregamento nao existe!");
        } else {
            chargingSession = base.getChargingSession(pos);
            System.out.println(chargingSession.toString());
        }
    }

    public static void changeClientData(Base base) {
        Client client;
        String name;
        String address;
        String email;
        Date birth_date = null;
        int nif;
        int contact;
        int pos;

        nif = Consola.lerInt("NIF: ", 1, 999999999);
        pos = base.searchClient(nif);

        if (pos == -1)
            System.err.println("Cliente nao existe!");
        else {
            client = base.getClient(pos);

            System.out.println("-Dados atuais-\n");
            System.out.println(client.toString());

            System.out.println("\n-Novos dados-\n");
            name = Consola.lerString("Nome: ");
            address = Consola.lerString("Morada: ");
            contact = Consola.lerInt("Contacto: ", 0, 999999999);
            email = Consola.lerString("E-mail: ");

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

    public static void populateList(Base base) {
        Vehicle volvoxc40 = new Vehicle(
                "Volvo",
                "XC40 Recharge T5",
                "69-04-AF",
                "Hibrido",
                "Gasolina",
                null,
                178,
                50,
                11,
                1477,
                50,
                10.7,
                false);

        Vehicle fiat500 = new Vehicle(
                "Fiat",
                "500 2021 500e",
                "24-NF-01",
                "Eletrico",
                null,
                null,
                116,
                320,
                85,
                0,
                50,
                42,
                false);

        Vehicle mercedesbenzeqs = new Vehicle(
                "Mercedes-Benz",
                "EQS 350",
                "37-61-MX",
                "Eletrico",
                null,
                null,
                284,
                617,
                170,
                0,
                50,
                100,
                false);

        Client c1 = new Client(
                "Paulo Sousa",
                "Torres Novas",
                "2222031@my.ipleiria.pt",
                257287914,
                969096163,
                null);

        Client c2 = new Client(
                "Joao Domingos",
                "Leiria",
                "2222035@my.ipleiria.pt",
                123456789,
                123456789,
                null);

        ChargingStation cs1 = new ChargingStation(
                1,
                4,
                0,
                "Av. Paulo Seixo",
                "PCN",
                10,
                0.2);

        ChargingStation cs2 = new ChargingStation(
                2,
                3,
                0,
                "Av. Joao Pecado",
                "PCR",
                6,
                2.5);

        ChargingStation cs3 = new ChargingStation(
                3,
                2,
                0,
                "Av. D. Perdu",
                "PCUR",
                4,
                4);
        
        ChargingStation cs4 = new ChargingStation(
                4,
                2,
                0,
                "Rua nao sei",
                "PCR",
                4,
                2.2);
        
        ChargingStation cs5 = new ChargingStation(
                5,
                2,
                0,
                "Av. Qualquer coisa",
                "PCR",
                4,
                2.25);
        
        ChargingStation cs6 = new ChargingStation(
                6,
                1,
                0,
                "Praça Existente",
                "PCUR",
                4,
                5);

        base.addVehicle(volvoxc40);
        base.addVehicle(fiat500);
        base.addVehicle(mercedesbenzeqs);
        base.addClient(c1);
        base.addClient(c2);
        base.addChargingStation(cs1);
        base.addChargingStation(cs2);
        base.addChargingStation(cs3);
        base.addChargingStation(cs4);
        base.addChargingStation(cs5);
        base.addChargingStation(cs6);
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void holdConsole() {
        System.out.println("Pressione enter para continuar...");
        sc.nextLine();
    }

    public static int generateRandomSessionCode() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
}
