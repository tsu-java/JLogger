# JLogger
A simple logging library for Java.

## Features
* Logging level
* Message Formatter

## Implementations
* Console Logger

## Usage Example
```java
public class MyClass {
    private static final Logger log = new ConsoleLogger(MyClass.class);
    
    public static void main(String[] args) {
        log.info("My application now has a logger :)");
        log.debug("Some secret information: %d", 14);
    }    
}
```