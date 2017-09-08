package chor;

public class LoggerFacade {

    private static Logger info = new InfoLogger();
    private static Logger debug = new DebugLogger();
    private static Logger error = new ErrorLogger();


    static {
        info.setNextLogger(debug);
        debug.setNextLogger(error);
    }


    public static void log(LogLevel level, String message){
        info.logMessage(level, message);
    }
}
