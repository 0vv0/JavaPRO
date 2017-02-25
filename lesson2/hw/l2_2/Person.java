package lesson2.hw.l2_2;

import java.util.List;

/**
 * Created by Oleksii.Sergiienko on 2/25/2017.
 */
public class Person {

    private String name;
    private String surname;
    private List<String> phones;
    private List<String> sites;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getSites() {
        return sites;
    }

    public void setSites(List<String> sites) {
        this.sites = sites;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{"
                + "\nname:" + name
                + "\nsurname:" + surname
                + "\nphones:" + phones
                + "\nsites:" + sites
                + "\naddress:" + address;
    }
}
