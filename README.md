# CS-476-Final-Project: Impact of Sleep on Memory

## Introduction
Memory is essential for daily life and success in academic and professional settings. Poor sleep quality can impair memory consolidation, affecting performance on memory-related tasks. Understanding this relationship can also have implications for public health, as sleep disturbances are linked to cognitive decline and other health problems. Investigating the mechanisms underlying sleep-related memory consolidation can improve our understanding of human cognition and lead to strategies to enhance memory performance and overall quality of life.

## Dataset
Stepan, M.E. (Michigan State University) (2015): Sleep and Eyewitness Memory. DANS. https://doi.org/10.17026/dans-x8e-m8cm

Participants watched a video of a mock-crime and attempted to identify the perpetrator from a simultaneous lineup after a 12-hour retention interval that either spanned a waking day or night of sleep. In Experiment 1, they used a target-present lineup and, in Experiment 2, they used a target-absent lineup in order to investigate correct and false identifications, respectively. 

The dataset has 18 fields and 436 records. The input dataset is in /source_data directory named “Data.csv”.

## Directory Structure
```
|   ...
├── data_ingest # Codes and commands used to ingest data by HDFS and Hive
├── etl_code # Codes in Java used for MR jobs to clean data
├── profiling_code # SQL and commands used to do data profiling by Hive and Presto
├── screenshots # All the results and process to implement commands or code in previous directories can be seen in screenshots in this directory
|   ...
```



