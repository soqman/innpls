package ru.innopolis.vasiliev.lesson5_hw;

class SevenSecondsThread extends Thread {
    private Seconds seconds;

    public SevenSecondsThread(Seconds seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (seconds) {
                try {
                    seconds.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (seconds.getSeconds() % 7 == 0) {
                    System.out.println("7 seconds passed. By " + Thread.currentThread().getName());
                }
            }
        }

    }
}
