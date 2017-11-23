package thread.daemon;

import java.util.Date;

/**
 * Created by Peng.lv on 2017/11/23.
 */
public class Event {

    private Date date;

    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
