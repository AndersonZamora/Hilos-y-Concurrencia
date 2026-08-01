package com.cincout.proyecto.runnable;

/**
 * Clase que demuestra el uso de la interfaz Runnable en Java.
 * Implementar Runnable es una de las formas recomendadas para crear tareas
 * que serán ejecutadas por un hilo.
 */
public class RunnableExample implements Runnable {

    // Nombre que identifica la tarea.
    private String name;

    /**
     * Constructor que recibe el nombre de la tarea.
     *
     * @param name Nombre que se mostrará durante la ejecución.
     */
    public RunnableExample(String name) {
        this.name = name;
    }

    /**
     * Método que contiene la lógica de la tarea.
     * Será ejecutado por un objeto Thread cuando se invoque start().
     */
    @Override
    public void run() {

        // Repite la tarea cinco veces.
        for (int i = 1; i <= 5; i++) {

            // Muestra el nombre de la tarea, el número del mensaje
            // y el nombre del hilo que la está ejecutando.
            System.out.println(
                    name + " Mensaje: " + i +
                            " Ejecutando en: " + Thread.currentThread().getName()
            );

            try {

                // Pausa la ejecución del hilo durante 2 segundos.
                Thread.sleep(2000);

            } catch (InterruptedException e) {

                // Se ejecuta si el hilo es interrumpido.
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Punto de entrada del programa.
     */
    public static void main(String[] args) {

        // Se crean dos objetos Thread que ejecutarán tareas Runnable.
        Thread thread = new Thread(new RunnableExample("Tarea A"));
        Thread thread2 = new Thread(new RunnableExample("Tarea B"));

        // Se inician ambos hilos.
        thread.start();
        thread2.start();

        // El hilo principal continúa ejecutándose sin esperar
        // a que terminen las tareas.
        System.out.println("Fin del hilo principal");
    }
}