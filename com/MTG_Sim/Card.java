package com.MTG_Sim;

public class Card {

    String name;
    String type;
    String supertype;
    int cmc;
    int power;
    int toughness;
    String rulestext;
    String keywords;

    public Card(String name, String supertype, String type, int cmc, int power, int toughness, String rulestext, String keywords) {
        this.name = name;
        this.type = type;
        this.supertype = supertype;
        this.cmc = cmc; //converted Mana cost
        this.power = power;
        this.toughness = toughness;
        this.rulestext = rulestext;
        this.keywords = keywords;
    }

    // simple method to print out the data of any card
    public static void cardReadout(Card card) {

        System.out.println("Name: " + card.getName());

        if (card.getSupertype().equals("")){
            //System.out.println("Supertype: " + "None");
        } else{
            System.out.println("Supertype: " + card.getSupertype());
        }

        System.out.println("Type: " + card.getType());
        System.out.println("CMC: " + card.getCmc());
        System.out.println("Power: " + card.getPower());
        System.out.println("Toughness: " + card.getToughness());
        System.out.println("Rules Text: " + card.getRulestext());
        System.out.println("Keywords: " + card.getKeywords());

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSupertype() {
        return supertype;
    }

    public int getCmc() {
        return cmc;
    }

    public int getPower() {
        return power;
    }
    public int getToughness() {
        return toughness;
    }

    public String getRulestext() {
        return rulestext;
    }

    public String getKeywords() {
        return keywords;
    }

    public void cardReadout() {
    }
}
