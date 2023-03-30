This code implements the replacement selection algorithm for external sorting when the input is too large to fit into memory. It generates sorted records (runs) with limited internal memory.

How it Works
Read records into memory, sort them internally, and write the resulting run back to tape.
Use Knuth's Replacement Selection sorting algorithm to determine runs.
The input records are divided into runs. Each run is read into memory and sorted. If a run is too large to fit into memory, the replacement selection algorithm is used to sort it.
The sorted runs are then merged to produce the final sorted output.
Code Explanation
N and K are constants defined for this code.

v[N] is a priority queue storing the values of each run.

ana[N] is a priority queue storing the sorted values of each run.

ifs[N] is a boolean array storing whether each run is still active or not.

ne[N] is an unordered map used to store the index of the next value in each run.

maxrun stores the maximum number of runs used.

add(int r, int run) is a recursive function that adds values to the corresponding run using the replacement selection algorithm.

main() reads input values, calls the add function to add them to the corresponding run, and then prints the sorted runs.