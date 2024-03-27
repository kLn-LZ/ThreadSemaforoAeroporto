package Controller;

import java.util.concurrent.Semaphore;

public class ThreadAeroporto extends Thread {

    private int idAviao;
    private Semaphore semaforo;
    public ThreadAeroporto(int idAviao, Semaphore semaforo ) {
        this.idAviao = idAviao;
        this.semaforo = semaforo;
    }

    public void run() {
        manobra();
        taxiar();

        try {
            semaforo.acquire();
            decolagem();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            semaforo.release();
        }

        afastamento();

    }

    private void manobra() {
        int tempo = (int) (Math.random() * 701) + 300;
        System.out.println("o avião #" + idAviao + " está manobrando");
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("o avião #" + idAviao + " precisou de " + tempo + " ms para manobrar");

    }
    private void taxiar() {
        int tempo = (int) (Math.random() * 1001) + 500;
        System.out.println("o avião #" + idAviao + " está taxiando");
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("o avião #" + idAviao + " precisou de " + tempo + " ms para taxiar");

    }

    private void decolagem() {
        int tempo = (int) (Math.random() * 801) + 600;

        if (tempo % 2 == 0) {
            System.out.println("O avião #" + idAviao + " está decolando pela pista norte");
        }
        else {
            System.out.println("O avião #" + idAviao + " está decolando pela pista sul");
        }

        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("o avião #" + idAviao + " precisou de " + tempo + " ms para decolar");

    }


    private void afastamento() {
        int tempo = (int) (Math.random() * 801) + 300;
        System.out.println("o avião #" + idAviao + " está se afastando");
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("o avião #" + idAviao + " precisou de " + tempo + " ms para se afastar");
    }








}
