Overview
This program is a simulation of a car parking lot. It records the time that cars enter and leave the parking lot, and can also calculate the number of cars in the parking lot at a given time. Additionally, the program can find the longest parked car in the parking lot.

Functionality
Record the time when a car enters or leaves the parking lot, and store the record in a hash table.
Calculate the number of cars in the parking lot at a given time.
Find the car(s) with the longest parking time in the parking lot.
Input and Output
The input consists of two integers n and k, where n is the number of records and k is the number of queries. The following n lines describe the records. Each record has the format:
car_id hh:mm:ss in/out
where car_id is a string representing the car's ID, hh:mm:ss is the time when the car enters or leaves the parking lot, and in/out indicates whether the car is entering or leaving the parking lot.

The queries are given as k lines, each containing a time in the format hh:mm:ss. For each query, the program should output the number of cars in the parking lot at that time.

The program should also output the car(s) with the longest parking time in the parking lot, as well as the length of their parking time. If there are multiple cars with the same longest parking time, the program should output them in ascending order of their IDs.

The output should be formatted as follows:

For each query, output the number of cars in the parking lot at the given time.
Output the car(s) with the longest parking time in the parking lot, followed by their parking time in the format hh:mm:ss.