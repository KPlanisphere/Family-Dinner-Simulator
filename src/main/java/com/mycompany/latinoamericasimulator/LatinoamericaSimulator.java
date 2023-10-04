/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.latinoamericasimulator;

import java.util.logging.Level;
import java.util.logging.Logger;

class LatinoamericaSimulator {
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

        // Iniciar los hilos de los gemelos
        for (Thread hijo : gemelos) {
            hijo.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LatinoamericaSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        // Esperar a que todos los gemelos terminen antes de continuar
        for (Thread hijo : gemelos) {
            try {
                hijo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Iniciar los hilos de los trillizos
        for (Thread hijo : trillizos) {
            hijo.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LatinoamericaSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Esperar a que todos los trillizos terminen antes de continuar
        for (Thread hijo : trillizos) {
            try {
                hijo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Repetir el proceso para cuatrillizos y hijos únicos
        for (Thread hijo : cuatrillizos) {
            hijo.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LatinoamericaSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (Thread hijo : cuatrillizos) {
            try {
                hijo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread hijo : hijosUnicos) {
            hijo.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LatinoamericaSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (Thread hijo : hijosUnicos) {
            try {
                hijo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Madre {
    public synchronized void servirComida(String nombre) {
        System.out.println("La madre sirve comida a " + nombre);
    }
}

class Hijo extends Thread {
    private Madre madre;

    public Hijo(String nombre, Madre madre) {
        super(nombre);
        this.madre = madre;
    }

    @Override
    public void run() {
        madre.servirComida(getName());
    }
}

