# Weather Data Analysis
This project analyzes temperature and humidity data from weather files and answers questions about the data. The data is stored in a series of CSV files, with one file for each day of the year.

## Requirements
To run this program, you need to have Java installed and configured on your system. You can download and install Java from the [official website](https://www.java.com/en/download/).

## Data
The weather data is stored in a series of CSV files, with one file for each day of the year. The data contains information about the temperature and humidity for each hour of the day. You can download the example data files from the [Duke Learn to Program website](http://www.dukelearntoprogram.com/course2/data/nc_weather.zip).

## Methods
* coldestHourInFile(CSVParser parser): This method takes a CSVParser as a parameter and returns the CSVRecord with the coldest temperature in the file, including the hour of the coldest temperature. This method ignores bogus temperature values when calculating the lowest temperature. A tester method testColdestHourInFile() is also provided to test this method.
* fileWithColdestTemperature(): This method returns the name of the file from selected files that has the coldest temperature. This method calls the coldestHourInFile() method to determine the coldest temperature on that day. A tester method testFileWithColdestTemperature() is provided to test this method.
* lowestHumidityInFile(CSVParser parser): This method takes a CSVParser as a parameter and returns the CSVRecord that has the lowest humidity. If there is a tie, then return the first such record that was found. This method checks for bogus humidity values and uses the DateUTC field to get the date and time of a humidity reading. A tester method testLowestHumidityInFile() is provided to test this method.
* lowestHumidityInManyFiles(): This method returns a CSVRecord that has the lowest humidity over all the files. If there is a tie, then return the first such record that was found. A tester method testLowestHumidityInManyFiles() is provided to test this method.
* averageTemperatureInFile(CSVParser parser): This method takes a CSVParser as a parameter and returns a double that represents the average temperature in the file. A tester method testAverageTemperatureInFile() is provided to test this method.
* averageTemperatureWithHighHumidityInFile(CSVParser parser, int value): This method takes a CSVParser and an integer value as parameters and returns a double that represents the average temperature of only those temperatures when the humidity was greater than or equal to the given value. A tester method testAverageTemperatureWithHighHumidityInFile() is provided to test this method.

## Usage
To use this program, you need to compile and run the CSVMax.java file using a Java compiler, such as javac. You can use the following commands to compile and run the program:

```bash
$ javac CSVMax.java
$ java CSVMax

This will run the program and output the results of the tester methods.

## Credits

This project was completed as part of the Duke University Java Programming course.
