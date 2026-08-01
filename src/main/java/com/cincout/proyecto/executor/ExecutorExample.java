package com.cincout.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Ejemplo de uso de un ExecutorService para administrar
 * la ejecución de tareas mediante un grupo fijo de hilos.
 */
public class ExecutorExample {

    /**
     * Método principal del programa.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        // Crea un pool de dos hilos para ejecutar tareas.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Envía la primera tarea al pool de hilos.
        executor.execute(() ->
                System.out.println("Tarea A " + Thread.currentThread().getName())
        );

        // Envía la segunda tarea al pool de hilos.
        executor.execute(() ->
                System.out.println("Tarea B " + Thread.currentThread().getName())
        );

        // Envía la tercera tarea al pool de hilos.
        executor.execute(() ->
                System.out.println("Tarea C " + Thread.currentThread().getName())
        );

        // Finaliza el ExecutorService una vez que todas
        // las tareas enviadas hayan terminado de ejecutarse.
        executor.shutdown();
    }
}