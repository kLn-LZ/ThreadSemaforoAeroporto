package View;

import Controller.ThreadAeroporto;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int permissao = 2;

        Semaphore semaforo = new Semaphore(permissao);

        for(int i = 1; i <= 12; i++) {
            Thread tAeroporto = new ThreadAeroporto(i, semaforo);
            tAeroporto.start();

        }
    }
}
