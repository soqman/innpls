package ru.innopolis.vasiliev.lesson5_hw;

class Main {
    private static Seconds seconds = new Seconds();
    private static Chronometer chronometer = new Chronometer(seconds);
    private static Thread chronometerThread = new Thread(chronometer);
    private static FiveSeconds fiveSeconds = new FiveSeconds(seconds);
    private static Thread sevenSecondsThread = new SevenSecondsThread(seconds);
    private static final long SECONDS_TO_STOP = 15;


    public static void main(String[] args) {
        chronometerThread.start();
        sevenSecondsThread.setName("SevenSecThread");
        sevenSecondsThread.start();
    }

    public static void checkSeconds() {
        System.out.println("seconds = " + seconds.getSeconds());
        Thread fiveSecondsThread = new Thread(fiveSeconds);
        fiveSecondsThread.setName("FiveSecThread");
        fiveSecondsThread.start();
        /*for(int i=0;i<50;i++){
            Thread fiveSecondsThreadClone=new Thread(fiveSeconds);
            fiveSecondsThreadClone.setName("FiveSecThreadClone"+i);
            fiveSecondsThreadClone.start();
        }*/
        synchronized (seconds) {
            seconds.notifyAll();
        }
        if (seconds.getSeconds() == SECONDS_TO_STOP) {
            chronometer.stopCounting();
            sevenSecondsThread.interrupt();
            fiveSecondsThread.interrupt();
            //каким образом завершить исполнение?
        }
    }
}
