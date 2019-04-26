package business;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class SistemaGestaoStock {

    private HashMap<String,Item> items; //By reference
    private HashMap<String,Box> boxes; //By reference
    private HashMap<String,User> users;
    private QRCodeGenerator qrcg;

    public SistemaGestaoStock(){
        this.items = new HashMap<>();
        this.boxes = new HashMap<>();
        this.qrcg = new QRCodeGenerator(350,350);
    }

    public Set<Item> getItemsByName(String substring){
        return items.values().stream().filter(s -> s.getName().contains(substring)).collect(Collectors.toSet());
    }

    public Set<Item> getItemsByReference(String substring){
        return items.values().stream().filter(s -> s.getReference().contains(substring)).collect(Collectors.toSet());
    }

    public static void main(String[] args){
        SistemaGestaoStock sgs = new SistemaGestaoStock();


    }
}
