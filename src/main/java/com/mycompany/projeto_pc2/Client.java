package com.mycompany.projeto_pc2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa o cliente com propriedades basicas de identificacao,
 * posse de veiculos registados ao mesmo e sessoes realizadas por este
 *
 * @author Paulo Sousa | João Domingos
 */
public class Client implements Serializable {
    private String name;
    private String address;
    private String email;
    private Date birth_date;
    private int NIF;
    private int contact;
    private List<ChargingSession> chargingSessions;
    private List<Vehicle> vehicles;

    /**
     * Constroi o cliente com os atributos dados
     * 
     * @param name       Nome do cliente
     * @param address    Morada do cliente
     * @param email      E-mail do cliente
     * @param nIF        Numero de Identificação fiscal do cliente
     * @param contact    Contacto telefónico do cliente
     * @param birth_date Data de nascimento do cliente
     */
    public Client(String name,
            String address,
            String email,
            int nIF,
            int contact,
            Date birth_date) {
        this.name = name;
        this.address = address;
        this.email = email;
        NIF = nIF;
        this.contact = contact;
        this.birth_date = birth_date;
        this.chargingSessions = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    /**
     * Devolve o nome do cliente
     * 
     * @return O nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do cliente
     * 
     * @param nome O novo nome a ser atribuído ao cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devolve o endereço do cliente
     * 
     * @return O endereço do cliente
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define o endereço do cliente
     * 
     * @param address O novo endereço a ser atribuído ao cliente.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Devolve o email do cliente
     * 
     * @return o email do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente
     * 
     * @param email o novo email a ser definido ao cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devolve o Numero de Identificação Fiscal do cliente
     * 
     * @return O Numero de Identificação Fiscal do cliente
     */
    public int getNIF() {
        return NIF;
    }

    /**
     * Define o Numero de Identificação Fiscal do cliente
     * 
     * @param nIF O novo Numero de Identificação Fiscal a ser definido do cliente
     */
    public void setNIF(int nIF) {
        NIF = nIF;
    }

    /**
     * Devolve o contacto telefónico do cliente
     * 
     * @return O contacto telefónico do cliente
     */
    public int getContact() {
        return contact;
    }

    /**
     * Define o contacto telefónico do cliente
     * 
     * @param contact O novo contacto telefónico definido ao cliente
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     * Devolve a data de nascimento do cliente
     * 
     * @return A data de nascimento do cliente
     */
    public Date getBirthDate() {
        return birth_date;
    }

    /**
     * Define a data de nascimento do cliente
     * 
     * @param birth_date A nova data de nascimento definida ao cliente
     */
    public void setBirthDate(Date birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * Devolve a lista de sessões de carregamento do cliente. É usada para saber
     * quais estão pagas e quantas foram realizadas
     * 
     * @return A lista de sessôes de carregamento do cliente
     */
    public List<ChargingSession> getChargingSessions() {
        return chargingSessions;
    }

    /**
     * Adiciona uma sessão de carregamento na lista como elemento. É chamada quando
     * é registada uma sessão
     * 
     * @param session Define uma nova sessão de carregamento na lista
     */
    public void addChargingSession(ChargingSession session) {
        chargingSessions.add(session);
    }

    /**
     * Devolve os veículos do cliente
     * 
     * @return Os veículos do cliente
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Adiciona o veículo ao cliente no momento de regsitar um veículo
     * 
     * @param vehicle um novo veículo é definido ao cliente
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nome: " + name + "\n");
        str.append("Data de nascimento: " + Projeto_pc2.dateFormat.format(birth_date) + "\n");
        str.append("Morada: " + address + "\n");
        str.append("Contacto telefonico: " + contact + "\n");
        str.append("Email: " + email + "\n");
        if (vehicles.size() > 0) {
            str.append("\nVeiculos deste cliente:\n");
            for (int i = 0; i < vehicles.size(); i++) {
                str.append(vehicles.get(i).getBrand());
                str.append(" ");
                str.append(vehicles.get(i).getModel());
                str.append(" (" + vehicles.get(i).getLicensePlate() + ")\n");
            }
        } else {
            str.append("Este cliente nao possui veículos registados em seu nome.\n");
        }
        return str.toString();
    }
}
