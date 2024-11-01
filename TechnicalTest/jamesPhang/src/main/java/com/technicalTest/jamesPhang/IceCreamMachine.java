package com.technicalTest.jamesPhang;

import java.util.List;
import java.util.ArrayList;

public class IceCreamMachine {

    public String[] colours;
    public String[] shapes;

    public static class Art {
        public String colour;
        public String shape;

        public Art(String colour, String shape) {
            this.colour = colour;
            this.shape = shape;
        }
    }
    


    public IceCreamMachine(String[] colours, String[] shapes) {
        this.colours = colours;
        this.shapes = shapes;
        }
        


    public List<Art > mix() {
        // throw new UnsupportedOperationException("Waiting to be implemented");
        List<Art> mixes = new ArrayList<>();
        for (String colour : colours) {
            for (String shape : shapes) {
                mixes.add(new Art(colour, shape));
            }
        }
        return mixes;
    }

    public static void main(String[] args) {

        IceCreamMachine draw = new IceCreamMachine (new String[]{"red", "blue"}, new String[]{"circle"});
        
        List<Art> mixes= draw.mix();

        /*
        * Should print:
        * red, circle
        * blue, circle
        */
        for (Art art: mixes) {
        System.out.println(art.colour + ", " + art.shape);
        }
    }
}
