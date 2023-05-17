package gof.gpt5.dto;

import java.io.Serializable;

public class MypageDto implements Serializable {
    private String email;
    private String event;
    private String dateandtime;
    public MypageDto(){

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
        return "MypageDto{" +
                "email='" + email + '\'' +
                ", event='" + event + '\'' +
                ", dateandtime='" + dateandtime + '\'' +
                '}';
    }
}
