package com.hemebiotech.analytics;

public class Item implements Comparable<Item> {

    protected String symptom;
    protected int quantity;

    protected Item(String symptom, int quantity) {
        // System.out.println("La méthode Item a été déclenchée");
        // System.out.println(quantity + " symptom(s) créé(s) de type : " + symptom);
        this.symptom = symptom;
        this.quantity = quantity;
    }

    // Guetters et setters
    public String getSymptom() {
        return symptom;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Item o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.symptom, o.getSymptom());
    }
}

//public class SortedItem implements Comparable<Item> {


