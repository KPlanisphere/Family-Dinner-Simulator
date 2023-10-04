## Family Dinner Simulation

This project simulates a family dinner scenario where a mother serves food to her children, including twins, triplets, quadruplets, and only children. The simulation demonstrates the use of Java threads to manage multiple concurrent actions, ensuring a realistic representation of the mother's task of serving food to her children.

### Description
The Family Dinner Simulation project uses Java's multithreading capabilities to simulate a mother serving food to her children. The main class, `LatinoamericaSimulator`, creates and manages threads for each child, with different priorities assigned to twins, triplets, quadruplets, and only children. The simulation ensures that each child is served in a synchronized and orderly manner.

### Features
- **Multithreading:** Utilizes Java's threading capabilities to manage concurrent tasks.
- **Synchronization:** Ensures that the mother serves food to one child at a time.
- **Simulation:** Creates a realistic scenario of a family dinner using print statements to represent the actions of the mother and children.

### File Structure
- **src/main/java/com/mycompany/latinoamericasimulator/**: Source directory containing Java source files.
  - **LatinoamericaSimulator.java**: Main Java source file for the project.

### Main Classes and Methods

#### LatinoamericaSimulator Class
This class is the entry point of the simulation. It creates threads for each child and manages their execution.

**Main Method:**
```java
public static void main(String[] args) {
    Madre madre = new Madre();

    Thread[] gemelos = new Thread[6];
    Thread[] trillizos = new Thread[4];
    Thread[] cuatrillizos = new Thread[3];
    Thread[] hijosUnicos = new Thread[9];

    for (int i = 0; i < 6; i++) {
        gemelos[i] = new Hijo("Gemelo " + (i + 1), madre);
        gemelos[i].setPriority(Thread.MAX_PRIORITY);
    }

    for (int i = 0; i < 4; i++) {
        trillizos[i] = new Hijo("Trillizo " + (i + 1), madre);
        trillizos[i].setPriority(Thread.NORM_PRIORITY);
    }

    for (int i = 0; i < 3; i++) {
        cuatrillizos[i] = new Hijo("Cuatrillizo " + (i + 1), madre);
        cuatrillizos[i].setPriority(Thread.MIN_PRIORITY);
    }

    for (int i = 0; i < 9; i++) {
        hijosUnicos[i] = new Hijo("Hijo Único " + (i + 1), madre);
        hijosUnicos[i].setPriority(Thread.MIN_PRIORITY);
    }

    // Start and manage threads for each group of children
}
```

#### Madre Class

This class simulates the mother serving food to her children. It uses a synchronized method to ensure only one child is served at a time.

**ServirComida Method:**

```java
public synchronized void servirComida(String nombre) {
    System.out.println("La madre sirve comida a " + nombre);
}
```

#### Hijo Class

This class represents a child in the simulation. Each child runs in its own thread and calls the mother's `servirComida` method.

**Run Method:**

```java
@Override
public void run() {
    madre.servirComida(getName());
}
```

### Getting Started

To run the simulation, compile the Java files and execute the `LatinoamericaSimulator` class.

### Requirements

-   Java Development Kit (JDK)
-   An IDE or text editor for Java development

### Usage

1.  Clone the repository.
2.  Navigate to the `src/main/java/com/mycompany/latinoamericasimulator` directory.
3.  Compile the Java files using `javac LatinoamericaSimulator.java`.
4.  Run the simulation using `java com.mycompany.latinoamericasimulator.LatinoamericaSimulator`.