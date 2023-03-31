# DNA Analysis and URL Finder

This project aims to analyze DNA sequences and find genes within them, as well as locating YouTube URLs within a webpage. The project consists of several parts, with each part demonstrating different functionalities.

## Part 1: Finding a Gene - Using the Simplified Algorithm

In this part, a simple algorithm is used to find genes in a DNA string. The `findSimpleGene` method searches for the start codon "ATG" and the stop codon "TAA". If both are present and the length of the substring between them is a multiple of 3, the substring is considered a gene and is returned. The `testSimpleGene` method is used to test the `findSimpleGene` method with various test cases.

## Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized

This part modifies the `findSimpleGene` method to accept additional parameters for start and stop codons. The method is also updated to handle DNA strings with either uppercase or lowercase letters.

## Part 3: Finding Web Links

This part aims to find YouTube URLs within a webpage. The method `findLinks` searches for the text "href="http://www.youtube.com" in a webpage and returns the URLs that follow it. The `testFindLinks` method is used to test the `findLinks` method with various test cases.

Overall, this project showcases various string manipulation techniques in Java and their applications in DNA analysis and web scraping.
