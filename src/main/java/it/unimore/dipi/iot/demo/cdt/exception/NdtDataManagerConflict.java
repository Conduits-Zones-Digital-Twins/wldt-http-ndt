package it.unimore.dipi.iot.demo.cdt.exception;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project http-iot-api-demo
 * @created 05/10/2020 - 12:59
 */
public class NdtDataManagerConflict extends Exception {

    public NdtDataManagerConflict(String errorMessage){
        super(errorMessage);
    }

}
