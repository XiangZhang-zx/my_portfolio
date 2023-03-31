/**
 * This program analyzes temperature and humidity data from weather files and answers questions about the data. 
 * The data is stored in a series of CSV files, with one file for each day of the year.
 * This project was completed as part of the Duke University Java Programming course.
 * 
 * @author Xiang Zhang
 * @author Duke Software Team 
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
    
    public CSVRecord coldestHourInFile(CSVParser parser) {
        // start with coldestSoFar as nothing
        CSVRecord coldestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            coldestSoFar = getSmallestOfTwo(currentRow, coldestSoFar);
        }
        //The coldestSoFar is the answer
        return coldestSoFar;
    }
    
    public void testColdestHourInFile() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") +
                   " at " + coldest.get("TimeEST"));
    }
    public CSVRecord getSmallestOfTwo (CSVRecord currentRow, CSVRecord smallestSoFar) {
        //If smallestSoFar is nothing
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            //Check if currentRow’s temperature < smallestSoFar’s
            if (currentTemp < smallestTemp) {
                //If so update smallestSoFar to currentRow
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    public String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        String fileWithColdestTemp = "";
        CSVRecord coldestSoFar = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            coldestSoFar = getSmallestOfTwo(currentRow, coldestSoFar);
            
            if (coldestSoFar.equals(currentRow)) {
                fileWithColdestTemp = f.getName();
            }
        }
        return fileWithColdestTemp;
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        // start with lowestSoFar as nothing
        CSVRecord lowestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            if (!currentRow.get("Humidity").equals("N/A")) {
                // use method to compare two records
                lowestSoFar = getSmallestOfTwo(currentRow, lowestSoFar);
            }
        }
        //The lowestSoFar is the answer
        return lowestSoFar;
    }
    
    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource("data/2015/weather-2015-01-22.csv");
        CSVRecord lowestHumidity = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("lowest humidity was " + lowestHumidity.get("Humidity") +
                   " at " + lowestHumidity.get("DateUTC"));
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            lowestSoFar = getSmallestOfTwo(currentRow, lowestSoFar);
        }
        //The lowestSoFar is the answer
        return lowestSoFar;
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemp = 0.0;
        int count = 0;
        for (CSVRecord record : parser) {
            double temp = Double.parseDouble(record.get("TemperatureF"));
            if (temp != -9999 && temp != -999) {
                totalTemp += temp;
                count++;
            }
        }
        if (count == 0) {
            return 0.0;
        }
        return totalTemp / count;
    }
}

