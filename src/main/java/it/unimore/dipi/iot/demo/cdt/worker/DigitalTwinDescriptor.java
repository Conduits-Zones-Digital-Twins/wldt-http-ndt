package it.unimore.dipi.iot.demo.cdt.worker;

public class DigitalTwinDescriptor {

    public static final String DEFAULT_CATEGORY = "default";

    private String id;

    private String category = DEFAULT_CATEGORY;

    private String type; //MQTT or COAP digital twin

    public DigitalTwinDescriptor() {
    }

    public DigitalTwinDescriptor(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public DigitalTwinDescriptor(String id, String category, String type) {
        this.id = id;
        this.category = category;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DigitalTwinDescriptor{");
        sb.append("id='").append(id).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
