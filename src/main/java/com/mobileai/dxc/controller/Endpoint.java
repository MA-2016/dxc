package com.mobileai.dxc.controller;
import org.apache.ibatis.annotations.Param;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@ServerEndpoint("/server")
public class Endpoint {
    private Session session;
    public static  int count;
    private static HashMap<String,Endpoint> endPointMap=new HashMap();
    private String name;
    @OnOpen
    public void open(@Param(value = "name") String name, Session session,EndpointConfig config){
        endPointMap.put(name,this);
        this.name=name;
        this.session=session;

    }

    @OnClose
    public void close(@Param(value = "name") String name){
        endPointMap.remove(name);

    }


    @OnMessage
    public void onMessage(String message){


    }
    public static void sendOne(String name,String text){


        Endpoint point=endPointMap.get(name);

        point.session.getAsyncRemote().sendText(text);
    }

    public  void broadcast(String message){

        for(Endpoint point:endPointMap.values()){
            point.session.getAsyncRemote().sendText(message);
        }
    }
    public  void sendMessage(String message) {
        this.session.getAsyncRemote().sendText(message);
    }

    public static String getTime(){
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);

    }

}
