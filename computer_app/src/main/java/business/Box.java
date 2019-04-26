package business;

import java.util.HashSet;
import java.util.Set;

public class Box {
    private Set<String> contents;

    public Box(){
        this.contents = new HashSet<>();
    }

    public void addContent(String s){
        contents.add(s);
    }

    public Set<String> getContents() {
        return contents;
    }

    public void setContents(Set<String> contents) {
        this.contents = contents;
    }
}
