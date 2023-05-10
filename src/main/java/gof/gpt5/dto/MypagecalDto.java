package gof.gpt5.dto;

import java.io.Serializable;

public class MypagecalDto implements Serializable {
    private String email;
    private String event;
    private String dateandtime;

    public MypagecalDto(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(String dateandtime) {
        this.dateandtime = dateandtime;
    }

    @Override
    public String toString() {
        return "MypagecalDto{" +
                "email='" + email + '\'' +
                ", event='" + event + '\'' +
                ", dateandtime='" + dateandtime + '\'' +
                '}';
    }
}
