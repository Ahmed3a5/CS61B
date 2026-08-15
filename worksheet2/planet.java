package worksheet2;
import java.lang.Math;


public class planet {
    double x ;
    double y; 
    double mass; 

    public planet (double a, double b , double m ){
        x = a;
        y = b;
        mass = m;
    }   

    public double distance_to(planet other){    
        double num = Math.pow((other.x - this.x) , 2) + Math.pow((other.y - this.y) , 2);

        return Math.sqrt(num);
    }

    public static double total_mass(planet[] planets){
        double total = 0;
        for(int i =0 ; i < planets.length ; i++){
            total = total + planets[i].mass;
        }
        return total;

    }

    public static void main(String[] args ){
        planet p1 = new planet(5 , 10 , 100);
        planet p2 = new planet(1 , 2 , 100);

        p1.distance_to(p2);
        planet[] planets = new planet[]{p1 , p2};
        planet.total_mass(planets);
    }
}
