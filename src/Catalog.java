import model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Catalog {
    List<City> cityList = new ArrayList<>();

    public Catalog() {
        readCityListFromFile();
    }

    private void readCityListFromFile() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/files/Задача ВС Java Сбер.csv"));
        } catch(FileNotFoundException ignored) {}

        while(Objects.requireNonNull(scanner).hasNextLine()) {
            String line = scanner.nextLine();   //Reading line from file

            String[] strArr = line.split(";");  //Splitting line

            String name = strArr[1];    //Getting name from line
            String region = strArr[2];
            String district = strArr[3];
            int population = Integer.parseInt(strArr[4]);
            String foundation;

            try {
                foundation = strArr[5]; //If found year not presented, then null
            } catch (Exception e) {
                foundation = null;
            }

            cityList.add(new City(name, region, district, population, foundation));     //Add city to list
        }
    }

    public void printUnorderedCityList() {
        for (City city :
                cityList) {
            System.out.println(city.toString());    //print city list
        }
    }
}
