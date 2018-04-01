package ru.innopolis.vasiliev.lesson5_hw;

class Chronometer implements Runnable {

    private Seconds seconds;
    private boolean isCounting;

    public Chronometer(Seconds seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        isCounting = true;
        while (isCounting) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            seconds.addSeconds();
            Main.checkSeconds();
        }
    }

    public void stopCounting() {
        isCounting = false;
    }
}
