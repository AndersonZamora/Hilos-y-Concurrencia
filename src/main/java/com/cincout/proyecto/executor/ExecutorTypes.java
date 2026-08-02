package com.cincout.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplo que muestra el uso de diferentes tipos de ExecutorService
 * para ejecutar tareas concurrentes.
 */
public class ExecutorTypes {

    /**
     * Método principal del programa.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        // Define una tarea reutilizable que será ejecutada por los diferentes pools.
        Runnable task = () -> {

            // Muestra el hilo que está ejecutando la tarea.
            System.out.println("Ejecutando la tarea " + Thread.currentThread().getName());

            try {

                // Simula el tiempo de ejecución de la tarea.
                Thread.sleep(1500);

            } catch (InterruptedException e) {

                // Maneja la interrupción del hilo.
                System.out.println(e.getMessage());
            }

            // Indica que la tarea ha finalizado.
            System.out.println("Tarea completada en el hilo " + Thread.currentThread().getName());
        };

        // Ejemplo utilizando un pool fijo de dos hilos.
        System.out.println("Ejecutando newFixedThreadPool");

        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        // Envía cuatro tareas al pool fijo.
        for (int i = 1; i < 5; i++) {
            fixedPool.execute(task);
        }

        // Finaliza el pool cuando todas las tareas hayan concluido.
        fixedPool.shutdown();

        // Ejemplo utilizando un pool dinámico de hilos.
        System.out.println("Ejecutando newCachedThreadPool");

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        // Envía cuatro tareas al pool dinámico.
        for (int i = 1; i < 5; i++) {
            cachedPool.execute(task);
        }

        // Finaliza el pool cuando todas las tareas hayan concluido.
        cachedPool.shutdown();

        // Ejemplo utilizando un único hilo de ejecución.
        System.out.println("Ejecutando newSingleThreadExecutor");

        ExecutorService single = Executors.newSingleThreadExecutor();

        // Envía cuatro tareas que se ejecutarán de forma secuencial.
        for (int i = 1; i < 5; i++) {
            single.execute(task);
        }

        // Finaliza el ejecutor.
        single.shutdown();
    }
}