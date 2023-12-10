package com.mycompany.projeto_pc2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import util.Consola;

/*
 * Bugs: 
 * - Apenas dá para inicializar as dates com "null" no populateList()
 * - Nao da pra pesquisar a matricula do Fiat 500, por alguma razao...
 * - A função populateList() não tá a fazer nada aparentemente, o programa diz que nao existem veiculos/clientes/postos. Mas se metermos o conteudo dessa função na main, magicamente funciona.
 * - Ao registar algo, errar a data uma vez, fica preso nessa parte
 */

/*
 * To do list:
 * Os carros devem estar associados aos clientes. Cada cliente pode ter multiplos carros. Talvez usar vetor ou lista nos clientes de veiculos
 * O resto do codigo...
 */

/**
 *
 * @author Paulo Sousa | João Domingos
 */
public class Projeto_pc2 {

    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Base base = new Base();
        int primary_option, secondary_option = 0;
        clearConsole();

        populateList();

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
                            System.err.println("\nNao existem veiculos registados!");
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
                        if (base.getTotalClients() > 0)
                            if (secondary_option == 1)
                                searchClient(base);
                            else
                                changeClientData(base);
                        else
                            System.err.println("\nNao existem clientes registados!");
                    }
                    else if (secondary_option == 2) {
                        addClient(base);
                    }
                    break;
                case 3:
                    System.out.println("[1] Consultar posto de carregamento");
                    System.out.println("[2] Registar posto de carregamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 2);

                    if (secondary_option == 1) {
                        if (base.getTotalChargingStations() > 0)
                            searchChargingStation(base);
                        else
                            System.err.println("\nNao existem estacoes de carregamento registadas!");
                    } else if (secondary_option == 2) {
                        addChargingStation(base);
                    }
                    break;
                case 4:
                    System.out.println("[1] Registar sessao de carregamento");
                    System.out.println("[2] Consultar sessao de carregamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 2);

                    if (secondary_option == 1) {
                        // Registar sessao de carregamento
                    } else if (secondary_option == 2) {
                        // Consultar sessao de carregamento
                    } else {
                        // Voltar
                    }
                    break;
                case 5:
                    System.out.println("[1] Registar pagamento");
                    System.out.println("[2] Consultar pagamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 2);

                    if (secondary_option == 1) {
                        // Registar pagamento
                    } else if (secondary_option == 2) {
                        // Consultar pagamento
                    } else {
                        // Voltar
                    }
                    break;
                case 6:
                    System.out.println("[1] Lista dos 3 postos de carregamento com maior valor faturado");
                    System.out.println("[2] Lista de sessoes de carregamento com valor superior a x");
                    System.out.println("[3] Total de sessoes de carregamento realizadas");
                    System.out.println("[4] Media de energia consumida por posto de carregamento e por tipo de veiculo");
                    System.out.println("[5] Lista de pagamentos por efetuar");
                    System.out.println("[6] Historico de sessoes de carregamento");
                    System.out.println("[0] Voltar");

                    secondary_option = Consola.lerInt("\nOpcao: ", 0, 6);
                    clearConsole();

                    switch (secondary_option) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

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
        System.out.println("[5] Estado do pagamento");
        System.out.println("[6] Estatisticas");
        System.out.println("[0] Sair");

        int option = Consola.lerInt("\nOpcao: ", 0, 6);
        clearConsole();
        return option;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void holdConsole() {
        System.out.println("\nPressione qualquer tecla para continuar...");
        sc.nextLine();
    }

    public static void addVehicle(Base base) {
        String brand, model, license_plate, eletric_hybrid, fuel_type = null;
        Date date_of_register = null;
        int horsepower, range, chargingSpeed, engine_displacement = 0, pos;
        double battery_capacity;
        boolean isHybrid = false;

        do {
            license_plate = Consola.lerString("Insira a matricula: ");
            pos = base.searchVehicle(license_plate);
            if (pos != -1) {
                System.err.println("Esta matricula ja se encontra registada!");
            }
        } while (pos != -1);

        brand      = Consola.lerString("Marca: ");
        model      = Consola.lerString("Modelo: ");
        horsepower = Consola.lerInt   ("Potencia: ", 0, 99999);

        boolean check_ev_type = true;
        do {
            eletric_hybrid = Consola.lerString("Eletrico ou Hibrido: ");
            if (eletric_hybrid.equals("Hibrido")) {
                isHybrid = true;
                check_ev_type = false;
            } else if (eletric_hybrid.equals("Eletrico"))
                check_ev_type = false;
            else
                System.err.println(eletric_hybrid + " nao existe. Tente novamente...");
        } while (check_ev_type);

        if (isHybrid) {
            engine_displacement = Consola.lerInt   ("Cilindrada: ", 0, 99999);
            fuel_type           = Consola.lerString("Tipo de combustivel: ");
        }
        battery_capacity = Consola.lerDouble("Capacidade da bateria: ", 0, 99999);
        range            = Consola.lerInt   ("Autonomia: ", 0, 99999);
        chargingSpeed    = Consola.lerInt   ("Velocidade de carregamento: ", 0, 99999);

        boolean error = false;
        do {
            try {
                date_of_register = dateFormat.parse(Consola.lerString("Data de registo: "));
            } catch (Exception e) {
                System.out.println("Data invalida");
                error = true;
            }
        } while (error);

        Vehicle newVehicle = new Vehicle(brand, model, license_plate, eletric_hybrid, fuel_type, date_of_register,
                horsepower, range, chargingSpeed, engine_displacement, battery_capacity);
        base.addVehicle(newVehicle);
    }

    public static void addClient(Base base) {
        String name, address, email;
        Date birth_date = null;
        int NIF, contact, pos;

        do {
            NIF = Consola.lerInt("NIF: ", 0, 999999999);
            pos = base.searchClient(NIF);
            if (pos != -1) {
                System.err.println("Este cliente ja se encontra registado!");
            }
        } while (pos != -1);

        name    = Consola.lerString("Nome: ");
        address = Consola.lerString("Morada: ");
        contact = Consola.lerInt   ("Contacto: ", 0, 999999999);
        email   = Consola.lerString("E-mail: ");

        boolean error = false;
        do {
            try {
                birth_date = dateFormat.parse(Consola.lerString("Data de nascimento: "));
            } catch (Exception e) {
                System.out.println("Data invalida");
                error = true;
            }
        } while (error);

        Client newClient = new Client(name, address, email, NIF, contact, birth_date);
        base.addClient(newClient);
    }

    public static void addChargingStation(Base base) {
        String address, station_type;
        int station_code, simultaneous_ev_charging, pos;
        float charging_time, charging_cost;

        do {
            station_code = Consola.lerInt("Codigo da estacao: ", 0, 999999999);
            pos = base.searchChargingStation(station_code);
            if (pos != -1) {
                System.err.println("Esta estacao de carregamento ja se encontra registada!");
            }
        } while (pos != -1);

        // Acredito que seja algo perto disto mas eu sou burro e não sei como fazer
       /*  do {
            station_type = Consola.lerString("Tipo de estação");
            pos = ChargingStation.searchChargingStation(station_type);
            if (pos == (user_string.equals("PCN") || user_string.equals("PCR") || user_string.equals("PCUR"))) {
                System.err.println("Esta estacao de carregamento ja se encontra registada!");
            }
        } while (pos != -1); */

        address    = Consola.lerString("Morada: ");
        station_type = Consola.lerString("Tipo de estacao: ");
        charging_cost = Consola.lerFloat("Custo de carregamento: ", 0, 999999999);
        charging_time = Consola.lerFloat("Tempo de carregamento: ", 0, 168);
        simultaneous_ev_charging = Consola.lerInt   ("Carregamento em simultaneo: ", 0, 50);

        ChargingStation newChargingStation = new ChargingStation(station_code, simultaneous_ev_charging, address,
                station_type, charging_time, charging_cost);
        base.addChargingStation(newChargingStation);
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
        int nif, pos;

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
        int station_code, pos;

        station_code = Consola.lerInt("Codigo da estacao: ", 0, 999999999);
        pos = base.searchChargingStation(station_code);

        if (pos == -1) {
            System.err.println("Estacao de carregamento nao existe!");
        } else {
            chargingStation = base.getChargingStation(pos);
            System.out.println(chargingStation.toString());
        }
    }

    public static void changeClientData(Base base) {
        Client client;
        String name, address, email;
        Date birth_date = null;
        int nif, contact, pos;

        nif = Consola.lerInt("NIF: ", 1, 999999999);
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
            contact = Consola.lerInt   ("Contacto: ", 0, 999999999);
            email   = Consola.lerString("E-mail: ");

            boolean error = false;
            do {
                try {
                    birth_date = dateFormat.parse(Consola.lerString("Data de nascimento: "));
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

    public static void populateList() {
        Base base = new Base();

        Vehicle volvoxc40 = new Vehicle(
                "Volvo",
                "XC40 Recharge T5",
                "69-04-AF",
                "Hibrido",
                "Gasolina",
                null,
                178,
                50,
                1,
                1477,
                10.7);

        Vehicle fiat500 = new Vehicle(
                "Fiat",
                "500 2021 500e",
                "24-NF-01",
                "Eletrico",
                null,
                null,
                94,
                190,
                1,
                0,
                23.8);

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
                100);

        Client c1 = new Client(
                "Paulo Sousa",
                "Torres Novas",
                "2222031@my.ipleiria.pt",
                257287914,
                969096163,
                null);

        ChargingStation cs1 = new ChargingStation(
                1,
                5,
                "Avenida Paulo Seixo",
                "PCN",
                7,
                2);

        base.addVehicle(volvoxc40);
        base.addVehicle(fiat500);
        base.addVehicle(mercedesbenzeqs);
        base.addClient(c1);
        base.addChargingStation(cs1);
    }
}
