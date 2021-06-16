package it.unimore.dipi.iot.demo.cdt.model;

import it.unimore.dipi.iot.demo.cdt.worker.DigitalTwinDescriptor;

import java.util.List;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project conduits-zones-manager
 * @created 04/06/2021 - 12:01
 */
public class ZoneDigitalTwinDescriptor extends DigitalTwinDescriptor {

    public static final String ZONE_DT_TYPE = "zone_dt";

    private String zoneId;

    //List of the AssetDigitalTwin associated to the target Zone
    private List<String> assetDigitalTwinList;

    private List<String> borderRouterDigitalTwinList;

    public ZoneDigitalTwinDescriptor() {
    }

    public ZoneDigitalTwinDescriptor(String id, String type) {
        super(id, type);
    }

    public ZoneDigitalTwinDescriptor(String id, String category, String type) {
        super(id, category, type);
    }

    public ZoneDigitalTwinDescriptor(String zoneId, List<String> assetDigitalTwinList, List<String> borderRouterDigitalTwinList) {
        this.zoneId = zoneId;
        this.assetDigitalTwinList = assetDigitalTwinList;
        this.borderRouterDigitalTwinList = borderRouterDigitalTwinList;
    }

    public ZoneDigitalTwinDescriptor(String id, String type, String zoneId, List<String> assetDigitalTwinList, List<String> borderRouterDigitalTwinList) {
        super(id, type);
        this.zoneId = zoneId;
        this.assetDigitalTwinList = assetDigitalTwinList;
        this.borderRouterDigitalTwinList = borderRouterDigitalTwinList;
    }

    public ZoneDigitalTwinDescriptor(String id, String category, String type, String zoneId, List<String> assetDigitalTwinList, List<String> borderRouterDigitalTwinList) {
        super(id, category, type);
        this.zoneId = zoneId;
        this.assetDigitalTwinList = assetDigitalTwinList;
        this.borderRouterDigitalTwinList = borderRouterDigitalTwinList;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public List<String> getAssetDigitalTwinList() {
        return assetDigitalTwinList;
    }

    public void setAssetDigitalTwinList(List<String> assetDigitalTwinList) {
        this.assetDigitalTwinList = assetDigitalTwinList;
    }

    public List<String> getBorderRouterDigitalTwinList() {
        return borderRouterDigitalTwinList;
    }

    public void setBorderRouterDigitalTwinList(List<String> borderRouterDigitalTwinList) {
        this.borderRouterDigitalTwinList = borderRouterDigitalTwinList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ZoneDigitalTwinDescriptor{");
        sb.append("zoneId='").append(zoneId).append('\'');
        sb.append(", assetDigitalTwinList=").append(assetDigitalTwinList);
        sb.append(", borderRouterDigitalTwinList=").append(borderRouterDigitalTwinList);
        sb.append('}');
        return sb.toString();
    }
}
