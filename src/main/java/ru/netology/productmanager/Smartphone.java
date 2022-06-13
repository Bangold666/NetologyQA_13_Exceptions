package ru.netology.productmanager;


public class Smartphone extends Product {
    private final String manufacturer;

    public Smartphone(int smartphoneId, String smartphoneName, String smartphoneManufacturer) {
        super.id = smartphoneId;
        super.name = smartphoneName;
        this.manufacturer = smartphoneManufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return this.manufacturer.contains(search);
    }
}
