package it.unimore.dipi.iot.demo.cdt.worker;

import it.unimore.dipi.iot.demo.cdt.exception.NdtDataManagerException;
import it.unimore.dipi.iot.demo.cdt.model.ZoneDigitalTwinDescriptor;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project http-iot-api-demo
 * @created 05/10/2020 - 11:44
 */
public interface INdtDataManager {

    public ZoneDigitalTwinDescriptor getZoneDescriptor() throws NdtDataManagerException;

    public ZoneDigitalTwinDescriptor updateZoneDescriptor(ZoneDigitalTwinDescriptor zoneDigitalTwinDescriptor) throws NdtDataManagerException;
}
