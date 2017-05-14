package com.yidiantong.bean;

/**
 * Created by wujw on 17/4/28.
 */
public class WXeventbean {
    String tousername;
    String fromusername;
    String createtime;
    String msgtype;
    String event;
    String eventkey;

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername;
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventkey() {
        return eventkey;
    }

    public void setEventkey(String eventkey) {
        this.eventkey = eventkey;
    }

    @Override
    public String toString() {
        return "WXeventbean{" +
                "tousername='" + tousername + '\'' +
                ", fromusername='" + fromusername + '\'' +
                ", createtime='" + createtime + '\'' +
                ", msgtype='" + msgtype + '\'' +
                ", event='" + event + '\'' +
                ", eventkey='" + eventkey + '\'' +
                '}';
    }
}
