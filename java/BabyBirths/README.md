# Baby Name Data Analysis

This project aims to analyze data on baby names from the United States by answering questions like finding the rank, name, and average rank of a given name and gender in different years as well as calculating the total births and births ranked higher than a given name in a specific year.

## Requirements

To run this project, you need to have Java environment installed and configured on your machine.

## Data

The data files give information on the first names of people born in a particular year from 1880 through 2014 on both boys and girls names. The zip folder with all the baby name data can be downloaded [here](http://www.dukelearntoprogram.com/course2/data/us_babynames.zip). Since these data files are quite large, there are three small files with fake data for testing. They can be downloaded [here](https://www.dukelearntoprogram.com//course2/data/us_babynames_small.zip).

## Methods

### Method 1: `totalBirths()`

This method calculates the total number of births, total number of boys, total number of girls, and total number of names in a file.

### Method 2: `getRank()`

This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned.

### Method 3: `getName()`

This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME” is returned.

### Method 4: `whatIsNameInYear()`

This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, it determines the rank of name in the year they were born, and then prints the name born in `newYear` that is at the same rank and same gender.

### Method 5: `yearOfHighestRank()`

This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. If the name and gender are not in any of the selected files, it returns -1.

### Method 6: `getAverageRank()`

This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. It returns -1.0 if the name is not ranked in any of the selected files.

### Method 7: `getTotalBirthsRankedHigher()`

This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than `name`.

## Usage

To use this project, you can run the BabyNames class in an IDE or from the command line. You can provide input data to the methods by specifying the required parameters. Examples of usage can be found in the comments of the code.

