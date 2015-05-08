# Scala-Big-Data-Project
Given a stream of N data points (score, category), I find the top k points with highest scores, calculate their rank and statistical significance. 

Calculating_HGD class takes two maps: map with big K and category name (population map), small k and category name (sample map).
We loop through Big K Map, if the element appears in sample map, then we take its small k to calculate hypergeometric distribution. Otherwise, we set small k to 0 and perform the hypergeometric distribution.
First, our hypergeometric distribution class receives 4 parameters: N, n K, k. 
Then We separate the formula into three parts: K choose k, N- K choose n - k, N choose n.
For each part, we apply binomial distribution formula with tail recursive method to prevent stack overflow.
Each calculation will return as an object, and put into a list which will contain all categories with its result of hypergeometric distribution eventually.
We sort this list by merge sort and print it in descending order after sorting.


TO COMPILE - scalac Big_Data_Project1.scala CalculatingHGD.scala Heapsort.scala HGDistribution.scala Merge_sort.scala

TO RUN - Big_Data_Project1
