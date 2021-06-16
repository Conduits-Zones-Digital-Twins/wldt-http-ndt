package it.unimore.dipi.iot.demo.cdt.model;

import it.unimore.dipi.iot.demo.cdt.worker.DigitalTwinDescriptor;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project conduits-zones-manager
 * @created 04/06/2021 - 12:04
 */
public class NetworkDigitalTwinDescriptor extends DigitalTwinDescriptor {

    public NetworkDigitalTwinDescriptor() {
    }

    public NetworkDigitalTwinDescriptor(String id, String type, boolean isRunning) {
        super(id, type);
    }
}
