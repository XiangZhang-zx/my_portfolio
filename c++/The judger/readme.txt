# A Game of Numbers

## Introduction
A game of numbers has the following rules: at the beginning, two distinct positive integers are given by the judge. Then each player in turn must give a number to the judge. The number must be the difference of two numbers that are previously given, and must not be duplicated to any of the existed numbers. The game will run for several rounds. The one who gives a duplicate number or even a wrong number will be kicked out. Your job is to write a judger program to judge the players' numbers and to determine the final winners.

## Approach
To solve this problem, we can use a set to store all the numbers that have been given so far. For each round, we iterate through all the players and check whether their number is valid (i.e., whether it can be expressed as the difference of two previously given numbers that are in the set). If a player's number is not valid, we kick them out by marking them as out of the game in an array. If multiple players are kicked out in the same round, we sort their indices and print them in increasing order.

After all the rounds have been played, we iterate through the array of players and find the ones who are still in the game. If there is at least one winner, we output their indices in increasing order. Otherwise, we output "No winner.".

## Input and Output Format
Each input file contains one test case. For each case, the first line gives two distinct positive integers to begin with. Both numbers are in [1,105]. In the second line, two numbers are given: N (2≤N≤10), the number of players, and M (2≤M≤103), the number of rounds. Then N lines follow, each contains M positive integers. The i-th line corresponds to the i-th player (i=1,⋯,N). The game is to start from the 1st player giving his/her 1st number, followed by everybody else giving their 1st numbers in the 1st round; then everyone give their 2nd numbers in the 2nd round, and so on so forth.

For each test case, the program outputs the following:

- For each round in which a player is kicked out, a line in the following format: "Round #k: i is out.", where k is the round number and i is the index of the kicked-out player.
- At the end of the game, a line in the following format: "Winner(s): W1 W2 ... Wn", where W1 ... Wn are the indices of the winners in increasing order. If there is no winner, output "No winner.".

## Requirements
This program is implemented in C++ and requires a C++ compiler such as GCC or Clang. The program can be run on any operating system that supports a C++ compiler.

## Usage
To run the program, compile the code and execute the resulting binary file. The program reads input from a file and writes output to the standard output. The input file should contain the input data in the format specified in the problem statement.
