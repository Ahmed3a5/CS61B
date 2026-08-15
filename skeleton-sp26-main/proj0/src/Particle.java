import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Map;

public class Particle {
    public ParticleFlavor flavor;
    public int lifespan;

    public static final int PLANT_LIFESPAN = 150;
    public static final int FLOWER_LIFESPAN = 75;
    public static final int FIRE_LIFESPAN = 10;
    public static final Map<ParticleFlavor, Integer> LIFESPANS =
            Map.of(ParticleFlavor.FLOWER, FLOWER_LIFESPAN,
                   ParticleFlavor.PLANT, PLANT_LIFESPAN,
                   ParticleFlavor.FIRE, FIRE_LIFESPAN);

    public Particle(ParticleFlavor flavor) {
        this.flavor = flavor;

        if(this.flavor == ParticleFlavor.FIRE){
            this.lifespan = LIFESPANS.get(ParticleFlavor.FIRE);
        }
        else if(this.flavor == ParticleFlavor.PLANT){
            this.lifespan = LIFESPANS.get(ParticleFlavor.PLANT);
        }
        else if(this.flavor == ParticleFlavor.FLOWER){
            this.lifespan = LIFESPANS.get(ParticleFlavor.FLOWER);
        }
        else{
            this.lifespan = -1;
        }
    }

    public Color color() {
        if (flavor == ParticleFlavor.SAND) {
            return Color.YELLOW;
        }
        else if(flavor == ParticleFlavor.BARRIER){
            return Color.GRAY;
        }
        else if(flavor == ParticleFlavor.WATER){
            return Color.BLUE;
        }
        else if(flavor == ParticleFlavor.FOUNTAIN){
            return Color.CYAN;
        }
        else if(flavor == ParticleFlavor.PLANT){
            double ratio = (double) Math.max(0, Math.min(lifespan, PLANT_LIFESPAN)) / PLANT_LIFESPAN;
            int g = 120 + (int) Math.round((255 - 120) * ratio);
            return new Color(0, g, 0);
        }  
        else if(flavor == ParticleFlavor.FIRE){
            double ratio = (double) Math.max(0, Math.min(lifespan, FIRE_LIFESPAN)) / FIRE_LIFESPAN;
            int r = (int) Math.round(255 * ratio);
            return new Color(r, 0, 0);
        }  
        else if(flavor == ParticleFlavor.FLOWER){
            double ratio = (double) Math.max(0, Math.min(lifespan, FLOWER_LIFESPAN)) / FLOWER_LIFESPAN;
            int r = 120 + (int) Math.round((255 - 120) * ratio);
            int g = 70 + (int) Math.round((141 - 70) * ratio);
            int b = 80 + (int) Math.round((161 - 80) * ratio);
            return new Color(r, g, b);
        }  
        return Color.BLACK;
    }

    public void moveInto(Particle other) {
        other.flavor = this.flavor;
        other.lifespan = this.lifespan;

        this.flavor = ParticleFlavor.EMPTY;
        this.lifespan =-1 ;
    }

    public void fall(Map<Direction, Particle> neighbors) {

        Particle p = neighbors.get(Direction.DOWN);
        if(p.flavor == ParticleFlavor.EMPTY){
            this.moveInto(p);
        }
    }

    public void flow(Map<Direction, Particle> neighbors) {
        int choose = StdRandom.uniformInt(3);
        if(choose == 0){

            if(neighbors.get(Direction.LEFT).flavor == ParticleFlavor.EMPTY){
                this.moveInto(neighbors.get(Direction.LEFT));
            }
        
        }
        else if(choose == 1){

            if(neighbors.get(Direction.RIGHT).flavor == ParticleFlavor.EMPTY){
                this.moveInto(neighbors.get(Direction.RIGHT));
            }
        }
        else{

            return;
        }
        
    }

    public void grow(Map<Direction, Particle> neighbors) {
        int choose = StdRandom.uniformInt(10);
        if(choose == 0){
            if(neighbors.get(Direction.UP).flavor == ParticleFlavor.EMPTY){
                neighbors.get(Direction.UP).flavor = this.flavor;
                neighbors.get(Direction.UP).lifespan = LIFESPANS.get(this.flavor);

            }

        }
        else if(choose == 1){
            if(neighbors.get(Direction.LEFT).flavor == ParticleFlavor.EMPTY){
                neighbors.get(Direction.LEFT).flavor = this.flavor;
                neighbors.get(Direction.LEFT).lifespan = LIFESPANS.get(this.flavor);

            }

        }
        else if(choose == 2){
             if(neighbors.get(Direction.RIGHT).flavor == ParticleFlavor.EMPTY){
                neighbors.get(Direction.RIGHT).flavor = this.flavor;
                neighbors.get(Direction.RIGHT).lifespan = LIFESPANS.get(this.flavor);

            }

        }
        else{
            return;
        }
    }

    public void burn(Map<Direction, Particle> neighbors) {
        
        if(neighbors.get(Direction.RIGHT).flavor == ParticleFlavor.PLANT || neighbors.get(Direction.RIGHT).flavor == ParticleFlavor.FLOWER){
            int choose = StdRandom.uniformInt(10);  
            if(choose < 4 ){

                    neighbors.get(Direction.RIGHT).flavor = ParticleFlavor.FIRE;
                    neighbors.get(Direction.RIGHT).lifespan = LIFESPANS.get(ParticleFlavor.FIRE);
            }
                
       }
        if(neighbors.get(Direction.LEFT).flavor == ParticleFlavor.PLANT || neighbors.get(Direction.LEFT).flavor == ParticleFlavor.FLOWER){
            int choose = StdRandom.uniformInt(10);
            if(choose < 4 ){
                neighbors.get(Direction.LEFT).flavor = ParticleFlavor.FIRE;
                neighbors.get(Direction.LEFT).lifespan = LIFESPANS.get(ParticleFlavor.FIRE);
            }

        }

        
    }
    
    public void action(Map<Direction, Particle> neighbors) {
        if(this.flavor == ParticleFlavor.EMPTY){
            return;
        }
        if(this.flavor != ParticleFlavor.BARRIER){
            this.fall(neighbors);
        }
        if(this.flavor == ParticleFlavor.WATER){
            this.flow(neighbors);
        }
        if(this.flavor == ParticleFlavor.FLOWER || this.flavor == ParticleFlavor.PLANT){
            this.grow(neighbors);
        }
        if(this.flavor == ParticleFlavor.FIRE){
            this.burn(neighbors);
        }
    }

    public void decrementLifespan(){
        if(this.lifespan > 0){
            this.lifespan--;

        }
        if(this.lifespan == 0){
            this.flavor = ParticleFlavor.EMPTY;
            this.lifespan = -1;
        }
    }
}