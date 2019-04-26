package business;

public class Item {

    private String name;
    private String reference;
    private String location;
    private float quantity;

    public Item(String name, String reference, String location, float quantity) {
        this.name = name;
        this.reference = reference;
        this.location = location;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}