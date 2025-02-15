package Geoglyphs;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private List<Geoglyph> geoglyphs;

    public Location(String name) {
        this.name = name;
        this.geoglyphs = new ArrayList<>();
    }
    public String addGeoglyph(Geoglyph geoglyph){
        if (this.geoglyphs.contains(geoglyph)){
            throw new IllegalArgumentException("This geoglyph exists in the location!");
        }else{
            this.geoglyphs.add(geoglyph);
            return String.format("%s added to %s", geoglyph.getName(), this.name);
        }
    }
    public boolean removeGeoglyph(String name){
        for (Geoglyph geoglyph : this.geoglyphs) {
            if (geoglyph.getName().equals(name)){
                geoglyphs.remove(geoglyph);
                return true;
            }
        }
        return false;
    }
    public String getGeoglyphsByConstructionTechnique(String constructionTechnique){
        List<Geoglyph> geoglyphList = new ArrayList<>();

        for (Geoglyph geoglyph : this.geoglyphs) {
            if (geoglyph.getConstructionTechnique().equals(constructionTechnique)){
                geoglyphList.add(geoglyph);
            }
        }
        if (geoglyphList.isEmpty()){
            return String.format("There are no geoglyphs made by %s in this location.", constructionTechnique);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Geoglyphs made by %s: ", constructionTechnique));

        for (Geoglyph geoglyph : geoglyphList) {
            stringBuilder.append(geoglyph.getName()).append(", ");
        }
        return stringBuilder.toString();
    }
    public String getLargestGeoglyph(){
        int biggestSize = 0;
        Geoglyph biggestGeoglyph = null;

        for (Geoglyph geoglyph : this.geoglyphs) {
            if (geoglyph.getSize() > biggestSize){
                biggestGeoglyph = geoglyph;
                biggestSize = geoglyph.getSize();
            }
        }
        return String.format("The largest geoglyph is %s with a length of %d meters.", biggestGeoglyph.getName(), biggestSize);
    }
    public Geoglyph getGeoglyphByName(String name){
        for (Geoglyph geoglyph : this.geoglyphs) {
            if (geoglyph.getName().equals(name)){
                return geoglyph;
            }
        }
        return null;
    }
    public int getCount(){
        return this.geoglyphs.size();
    }
    public String getStatistics(){

        if (geoglyphs.isEmpty()){
            return String.format("No geoglyphs have yet been discovered in %s.", this.name);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Geoglyphs located in %s:%n", this.name));

        for (Geoglyph geoglyph : this.geoglyphs) {
            stringBuilder.append(String.format("* %s %n", geoglyph.getName()));
        }
        return stringBuilder.toString();
    }
}
