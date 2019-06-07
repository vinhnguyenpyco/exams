## Project environment:
- JDK 1.8.0_191
- Maven 3.5.4
- JUnit 4.12

## How to build and test it
- Use maven to build file jar : 
```
mvn clean install
```

## Complexity analysis
### Exercise 1:
- store: n is number element of list map, first loop is process list map to maps, m is key/value in map, second lopp is process for every element in map, complexity is O(n*m)
- load: n is array of split text by character \n, then loop array, m is array of split text by character ';', then loop for build map -> complexity : 0(n*m)
