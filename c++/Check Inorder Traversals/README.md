## Check Inorder Traversals

### Introduction

The Binary Tree Traversals project aims to verify whether a given set of inorder traversals is valid for a given binary tree represented by its postorder and preorder traversals. It is important to verify the inorder traversals to ensure that the binary tree is constructed correctly. For example, this project could be used in computer science courses to teach binary tree construction and traversal.

### Approach

To solve this problem, we use the following step-by-step approach:

1. Construct a binary tree from its preorder and postorder traversal sequences.
2. Check if the binary tree is a valid binary tree.
3. Check if the binary tree is identical to the given inorder traversal sequence.
4. Output the answers to the input inorder traversal sequences.

We use two arrays called 'pre' and 'post' to store the preorder and postorder traversal sequences of the binary tree, respectively. We also use an array called 'in' to store the given inorder traversal sequence.

To construct a binary tree from its preorder and postorder traversal sequences, we use a recursive algorithm. We start with the root of the tree, which is the first element in the preorder traversal sequence. We then find the index of the root in the postorder traversal sequence. We divide the remaining elements in the preorder and postorder traversal sequences into left and right subtrees and recursively construct the left and right subtrees.

To check if the binary tree is a valid binary tree, we use a recursive algorithm to check each subtree. We start with the root of the tree and check that all the elements in the left subtree are smaller than the root and all the elements in the right subtree are larger than the root. We then recursively check the left and right subtrees.

To check if the binary tree is identical to the given inorder traversal sequence, we use a recursive algorithm. We start with the root of the tree and find its index in the inorder traversal sequence. We then recursively check the left and right subtrees.

### Input and Output Format

Each input file contains one test case. For each case, the first line gives a positive integer N (≤ 30), the total number of nodes in the binary tree. The second line gives the preorder sequence and the third line gives the postorder sequence. Then another positive integer K (≤ 10) is given, followed by K lines of inorder traversal sequences. Each sequence consists of N positive integers. All the numbers in a line are separated by a space.

For each input inorder traversal sequence, the program outputs either "Yes" if it is a valid inorder traversal sequence of the binary tree, or "No" if it is not a valid inorder traversal sequence. If the given pre- and postorder traversal sequences cannot form any tree at all, the program outputs "Are you kidding me?" and attempts to construct a tree with the given preorder traversal sequence for each input inorder traversal sequence. If it is still impossible, the program outputs "You must be kidding me!".

### Requirements

This project is implemented in C++ and requires a C++ compiler such as GCC or Clang. The project can be run on any operating system that supports a C++ compiler.

### Usage

To run the Binary Tree Traversals project, compile the code and execute the resulting binary file. The program reads input from a file and writes output to a file. The input file should contain the input data in the format specified in the problem statement. The output file will contain the answers to the input inorder traversal sequences.
