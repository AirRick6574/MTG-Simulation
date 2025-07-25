package com.MTG_Sim;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

//Import Statements For Read text file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;
import java.nio.Buffer;

import static com.MTG_Sim.Card.cardReadout;

public class Biblioplex {

    public static Card cardPull(String cardName) {

        // this is the file path of the database relative to this class
        String filePath = "allCardsTrimmed.csv";
        int lineNumber = 1;

        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord csvRecord : csvParser) {
                // Check cardName in the 37th column (index 36)
                String value = csvRecord.get(36);
                if (value.equalsIgnoreCase(cardName)) {
                    // Storing the data pulled from the spreadsheet
                    String name = csvRecord.get(36);
                    String supertype = csvRecord.get(56);
                    String type = csvRecord.get(55);
                    int cmc = Integer.parseInt(csvRecord.get(35));
                    int power = Integer.parseInt(csvRecord.get(35));
                    int toughness = Integer.parseInt(csvRecord.get(35));
                    String rulestext = csvRecord.get(40);
                    String keywords = csvRecord.get(27);

                    // Creating a card object with all the pulled data
                    Card card = new Card(name, supertype, type, cmc, power, toughness, rulestext, keywords);

                    return card;
                }

                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Card not found
    }

    public static void txtFileCardReader(){
        String filePath = "TestDeck.txt"; //Current File Path

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String cardString;

            System.out.println("\nText Importing: Card Readout\n");
            while ((cardString = reader.readLine()) != null) { //While cardString is not empty
                //Skip empty lines
                if (cardString.trim().isEmpty()) { //If cardString.trim() (Will remove spaces) is empty
                    continue;
                }

                String[] splitParts = cardString.trim().split(" ", 2);
                //Trims to remove spacing and then splits into array of 2, containing count and card name

                if (splitParts.length == 2) { //check if correct format
                    int count = Integer.parseInt(splitParts[0]); //convert string into Integer Data
                    String cardName = splitParts[1];

                    System.out.println("Count: " + count + ", Card: " + cardName);
                    System.out.println("\nCard information: ");
                    callCardDetails(cardName);
                    System.out.println("\n");
                } else {
                    System.out.println("Invalid line format: " + cardString);
                }
            }

        } catch (IOException e) { //if error occurs, jump here (no file found)
            e.printStackTrace(); //print error
        }


    }

    public static void callCardDetails(String card) {
        Card currentCard = cardPull(card);
        if (currentCard == null) {
            return;
        }
        cardReadout(currentCard);
    }

    public static void main(String[] args) {
        //or (int i = 0; i < )
        txtFileCardReader();

        /*
        Card Brudiclad_Telchor_Engineer = cardPull("Brudiclad, Telchor Engineer");
        cardReadout(Brudiclad_Telchor_Engineer);

        System.out.println();

        Card Ashnods_Altar = cardPull("Ashnod's Altar");
        cardReadout(Ashnods_Altar);

        */


    }
}