package ua.rozborsky.desktopTracker;

import java.text.SimpleDateFormat;

public class TimeManager {
    /**
     * @return current month and day
     */
    public String getDate() {
        return getTime("MM dd");
    }

    /**
     * @return current hour und minute
     */
    public String getTimeHhMm() {
        return getTime("HH mm");
    }

    /**
     * @param format    pattern for returned value
     * @return          current time
     */
    private String getTime(String format) {
        SimpleDateFormat time_formatter = new SimpleDateFormat(format);
        return time_formatter.format(System.currentTimeMillis());
    }
}
