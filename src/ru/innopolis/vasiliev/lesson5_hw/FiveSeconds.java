package ru.innopolis.vasiliev.lesson5_hw;

class FiveSeconds implements Runnable {
    Seconds seconds;

    public FiveSeconds(Seconds seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        if (seconds.getSeconds() % 5 == 0) {
            System.out.println("5 seconds passed. By: " + Thread.currentThread().getName());
        }
    }
}
