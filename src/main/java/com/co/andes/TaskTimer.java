package com.co.andes;

import java.util.TimerTask;
import org.apache.log4j.Logger;
public class TaskTimer extends TimerTask {

    final static Logger logger = Logger.getLogger(TaskTimer.class);

    @Override
    public void run() {
        try {
            GetRequest getRequest = new GetRequest();
            if(getRequest.doRequest() == null ){
                logger.error("Se tiene problemas con el servicio");
            }
        } catch (Exception e) {
          logger.error("Se han presentado problemas con el health check",e);
        }
    }

}