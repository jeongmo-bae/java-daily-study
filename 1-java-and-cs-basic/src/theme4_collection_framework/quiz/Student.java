package theme4_collection_framework.quiz;

import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<String> license = new ArrayList<>();

    Student (){
        this("",new ArrayList<String>());
    }
    Student(String name, ArrayList<String> licenses){
        this.name = name;
        for (String license : licenses){
            this.setLicense(license);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLicense() {
        return license;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLicense(String license) {

        if (!this.license.contains(license.toLowerCase())){
            this.license.add(license.toLowerCase());
        }
    }
    public void setLicense(String[] licenses){
        for (String license : licenses){
            this.setLicense(license);
        }
    }
}
