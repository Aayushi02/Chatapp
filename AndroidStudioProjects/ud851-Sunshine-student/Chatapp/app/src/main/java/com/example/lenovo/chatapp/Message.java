package com.example.lenovo.chatapp;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Lenovo on 22-12-2017.
 */

public class Message {
    private String content;
    private String username;
private Date ctime;
    public Message(){

    }
    public Message(String content,String username){
        this.content = content;
        this.username = username;
        ctime = Calendar.getInstance().getTime();

    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

//public void setTime(){
    //this.ctime = Calendar.getInstance().getTime();}

//public Date getTime(){
  //  return ctime;
//}
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
}
