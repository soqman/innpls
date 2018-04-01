package ru.innopolis.vasiliev.lesson5_hw;

public class Seconds {
    private long seconds;

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public void addSeconds() {
        this.seconds++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seconds seconds1 = (Seconds) o;

        return seconds == seconds1.seconds;
    }

    @Override
    public int hashCode() {
        return (int) (seconds ^ (seconds >>> 32));
    }

    @Override
    public String toString() {
        return String.valueOf(seconds);
    }
}
