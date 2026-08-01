package com.cincout.proyecto.thread;

/**
 * Clase que demuestra el uso de hilos (Threads) en Java.
 * Hereda de la clase Thread para ejecutar tareas de forma concurrente.
 */
public class ThreadExample extends Thread {

    // Nombre que identifica al hilo o proceso.
    private String name;

    /**
     * Constructor que recibe el nombre del proceso.
     *
     * @param name Nombre que se mostrará durante la ejecución.
     */
    public ThreadExample(String name) {
        this.name = name;
    }

    /**
     * Método que contiene la lógica que ejecutará el hilo.
     * Se ejecuta automáticamente cuando se llama al método start().
     */
    @Override
    public void run() {

        // Repite la tarea cinco veces.
        for (int i = 1; i <= 5; i++) {

            // Muestra el nombre del proceso, el número de mensaje
            // y el nombre real del hilo que lo está ejecutando.
            System.out.println(
                    name + " Mensaje: " + i +
                            " Ejecutando en: " + Thread.currentThread().getName()
            );

            try {
                // Pausa la ejecución del hilo durante 2 segundos.
                Thread.sleep(2000);

            } catch (InterruptedException e) {

                // Se ejecuta si el hilo es interrumpido mientras está dormido.
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Punto de entrada del programa.
     */
    public static void main(String[] args) {

        // Muestra el nombre del hilo principal (main).
        System.out.println("Inicio: " + Thread.currentThread().getName());

        // Se crean dos hilos independientes.
        ThreadExample threadExample = new ThreadExample("Proceso A");
        ThreadExample threadExample2 = new ThreadExample("Proceso B");

        // Inicia ambos hilos.
        // Cada uno ejecutará el método run() de manera concurrente.
        threadExample.start();
        threadExample2.start();

        /*
         * Si se llamara a run() directamente:
         *
         * threadExample.run();
         * threadExample2.run();
         *
         * NO se crearían nuevos hilos.
         * Ambos métodos se ejecutarían secuencialmente
         * sobre el hilo principal (main).
         */

        // El hilo principal continúa su ejecución sin esperar
        // a que finalicen los otros hilos.
        System.out.println("Fin del hilo principal");
    }
}