# 📄 File Analyser

## Goal

Create a utility class for analyzing text files and extracting useful information from them using functional programming.

## Skills

- Consolidate knowledge of functional programming.
- Use lambda expressions to convey functionality in a concise manner.
- Apply stream operations effectively to achieve desired outcomes.
- Strengthen your algorithmic thinking by solving various text-processing tasks.
- Deepen your comprehension of Java I/O operations and proficiently handle exceptions during file handling.

## Instructions

It is required to create a utility class that analyzes text files and extracts various pieces of information from them. This project will involve creating methods that leverage Java's functional programming features, such as lambda expressions and stream operations.

## Files

To complete this exercise, include at least two text files in your `src/main/resources` folder. You are free to add any additional TXT files for testing purposes.

## Expected Functionalities

Implement the following functionalities using Java stream operations:

1. **Count lines in a file.**
2. **Count words in a file.**
3. **Count non-empty lines in a file.**
4. **Count unique words in a file.**
5. **Count how many times a specific word is mentioned in a file.**  
   _* You should account for case insensitivity._
6. **Find lines which contain a specific word.**  
   _* You should account for case insensitivity._
7. **Calculate the average line length.**
8. **Calculate the average word length.**
9. **Find the shortest line in a file.**
10. **Find the longest line in a file.**
11. **Find the top n longest words in a file.**
12. **Get the first word with more than n characters.**
13. **Find common words between two files.**
14. **Find the frequency with which every word appears in the file.**
15. **Find lines that contain numbers in a file.**
16. **Find lines that match a regex pattern.**
17. **Find palindromic words in a file.**

## Package

To package the project into a JAR file using Maven, follow these steps:

1. Ensure you have configured your `pom.xml` with the necessary dependencies and plugins.
2. Run the Maven package command:
   
   ```bash
   mvn clean package

This will create a JAR file in the target directory, which you can then execute to perform file analysis.

## Requirements

- Java Development Kit (JDK) 17 or above.
- Apache Maven.
- A Java IDE like IntelliJ IDEA, or any other of your choice.

## Installation

Clone the repository and navigate to the folder.

```bash
git clone <repository-url>
cd <repository-folder>
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Suggested Future Improvements

- Enhance performance by optimizing file reading and processing for large files.
- Introduce multithreading to handle large files more efficiently.
- Create a graphical user interface (GUI) to make the tool more user-friendly.

## Contributors

-  Daniel Magalhães - [@Housecold](https://github.com/Housecold)
-  Omid Pournejati - [@TheOmidious](https://github.com/TheOmidious)
