package chor;

public abstract class Logger {

    protected LogLevel logLevel;
    protected Logger nextLogger;


    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

//    do poniżesz metody wstawic booliana i zobaczyc kiedy chor nie jest obsluzony
    public void logMessage(LogLevel logLevel, String message){
        if(this.logLevel.ordinal() >= logLevel.ordinal()){
            write(message);
        }
        else if(nextLogger!=null) {
            nextLogger.logMessage(logLevel, message);
        }
        else {
            System.out.println("Zadanie nie obsluzone");
        }
    }

    protected abstract void write(String message);
}
