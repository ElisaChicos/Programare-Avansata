package com.company;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws SQLException, IOException {
        try {

            var continents = new ContinentDao();
            Database.getConnection().commit();
            var countries = new CountryDao();
            CitiesDao cities1 = new CitiesDao();

            File file = new File("concap.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int index = 0;
            int indexContinents = 0;
            List<String> continentList = new ArrayList<>();

            while ((line = br.readLine()) != null) {

                //parts[0] = Country name, parts[1] = Capital name, parts[2]=cap lat
                //parts[3] = cap long, parts[4] = country code, parts[5] = continent name

                String[] parts = line.split(",");

                if (!continentList.contains(parts[5])) {
                    Continent new_continent = new Continent(indexContinents, parts[5]);
                    continentList.add(parts[5]);
                    indexContinents++;
                    continents.create(new_continent);
                    Database.getConnection().commit();
                }

                Country new_country = new Country(index, parts[0], parts[4], parts[5]);
                Cities new_city = new Cities(index, parts[0], parts[1], 1, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                index++;
                countries.create(new_country);
                Database.getConnection().commit();
                cities1.create(new_city);
                Database.getConnection().commit();

            }
            String city1 = cities1.findById(1);
            String city2 = cities1.findById(2);
            Double longitute1 = cities1.findLong(1);
            Double longitute2 = cities1.findLong(2);
            Double latitude1 = cities1.findLat(1);
            Double latitude2 = cities1.findLat(2);
            System.out.println("Distance between: " + city1 + " and " + city2 + " is: " + cities1.distance(latitude1, longitute1, latitude2, longitute2));

            city1 = cities1.findById(5);
            city2 = cities1.findById(8);
            longitute1 = cities1.findLong(5);
            longitute2 = cities1.findLong(8);
            latitude1 = cities1.findLat(5);
            latitude2 = cities1.findLat(8);
            System.out.println("Distance between: " + city1 + " and " + city2 + " is: " + cities1.distance(latitude1, longitute1, latitude2, longitute2));

            city1 = cities1.findById(11);
            city2 = cities1.findById(20);
            longitute1 = cities1.findLong(11);
            longitute2 = cities1.findLong(20);
            latitude1 = cities1.findLat(11);
            latitude2 = cities1.findLat(20);
            System.out.println("Distance between: " + city1 + " and " + city2 + " is: " + cities1.distance(latitude1, longitute1, latitude2, longitute2));

            city1 = cities1.findById(110);
            city2 = cities1.findById(80);
            longitute1 = cities1.findLong(110);
            longitute2 = cities1.findLong(80);
            latitude1 = cities1.findLat(110);
            latitude2 = cities1.findLat(80);
            System.out.println("Distance between: " + city1 + " and " + city2 + " is: " + cities1.distance(latitude1, longitute1, latitude2, longitute2));


            Database.getConnection().close();
        } catch (SQLException | FileNotFoundException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
