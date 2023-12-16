package com.mycompany.projeto_pc2;

import java.util.Date;

/**
 *
 * @authors Paulo Sousa | João Domingos
 */
public class Client {
    protected String name;
    protected String address;
    protected String email;
    protected Date birth_date;
    protected int NIF;
    protected int contact;

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
    }

    public String getName()                       { return name; }
    public void setName(String name)              { this.name = name; }

    public String getAddress()                    { return address; }
    public void setAddress(String address)        { this.address = address; }

    public String getEmail()                      { return email; }
    public void setEmail(String email)            { this.email = email; }

    public int getNIF()                           { return NIF; }
    public void setNIF(int nIF)                   { NIF = nIF; }

    public int getContact()                       { return contact; }
    public void setContact(int contact)           { this.contact = contact; }

    public Date getBirthDate()                    { return birth_date; }
    public void setBirthDate(Date birth_date)     { this.birth_date = birth_date; }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nome: " + name + "\n");
        str.append("Data de nascimento: " + birth_date + "\n");
        str.append("Morada: " + address + "\n");
        str.append("Contacto telefonico: " + contact + "\n");
        str.append("Email: " + email + "\n");
        return str.toString();
    }
}
