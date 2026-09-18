package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * An object for mapping a year number (e.g. 1996) to numerical data. Provides
 * utility methods useful for data analysis.
 *
 * @author Josh Hug
 */
public class TimeSeries extends TreeMap<Integer, Double>{

    /** If it helps speed up your code, you can assume year arguments to your NGramMap
     * are between 1400 and 2100. We've stored these values as the constants
     * MIN_YEAR and MAX_YEAR here. */
    public static final int MIN_YEAR = 1400;
    public static final int MAX_YEAR = 2100;

    /**
     * Constructs a new empty TimeSeries.
     */
    public TimeSeries() {
        super();
    }

    /**
     * Creates a copy of TS, but only between STARTYEAR and ENDYEAR,
     * inclusive of both end points.
     */
    public TimeSeries(TimeSeries ts, int startYear, int endYear) {
        super();
        TimeSeries copy = new TimeSeries();
        for(int key : ts.keySet()){
            if(key >= startYear && key <= endYear){
                copy.put(key , ts.get(key));
            }
        }
        
        ts = copy;
    }

    /**
     *  Returns all years for this time series in ascending order.
     */
    public List<Integer> years() {
        List<Integer> lst = new ArrayList<>();

        if(!this.isEmpty()){
            for(int key : this.keySet()){
                lst.add(key);
            }
        }
        return lst;
    }

    /**
     *  Returns all data for this time series. Must correspond to the
     *  order of years().
     */
    public List<Double> data() {
        List<Double> dbl = new ArrayList<>();

        if(!this.isEmpty()){
            List<Integer> years = this.years();
            for(int year : years){
                dbl.add(this.get(year));
            }

        }
        return dbl;
    }

    /**
     * Returns the year-wise sum of this TimeSeries with the given TS. In other words, for
     * each year, sum the data from this TimeSeries with the data from TS. Should return a
     * new TimeSeries (does not modify this TimeSeries).
     *
     * If both TimeSeries don't contain any years, return an empty TimeSeries.
     * If one TimeSeries contains a year that the other one doesn't, the returned TimeSeries
     * should store the value from the TimeSeries that contains that year.
     */
    public TimeSeries plus(TimeSeries ts) {
        TimeSeries fTs = new TimeSeries();
        if(ts.isEmpty()){
            fTs = this;
            return fTs;
        }
        else if(this.isEmpty()){
            fTs = ts;
            return fTs;
        }
        else{
            for(int year : this.years()){
                if(ts.containsKey(year)){
                    double sum = ts.get(year) + this.get(year);
                    fTs.put(year , sum);
                }
                else{
                    fTs.put(year , this.get(year));
                }
            }
        }

        for(int year : ts.years()){
            if(!fTs.containsKey(year)){
                fTs.put(year , ts.get(year));
            }
        }

        return fTs;
    }

    /**
     * Returns the quotient of the value for each year this TimeSeries divided by the
     * value for the same year in TS. Should return a new TimeSeries (does not modify this
     * TimeSeries).
     *
     * If TS is missing a year that exists in this TimeSeries, throw an
     * IllegalArgumentException.
     * If TS has a year that is not in this TimeSeries, ignore it.
     */
    public TimeSeries dividedBy(TimeSeries ts) {
        TimeSeries fTs = new TimeSeries();
        if(ts.isEmpty()){
            throw new IllegalArgumentException("the ts is empty");
        }
        for(int year : this.years()){
            if(!ts.containsKey(year)){
                throw new IllegalArgumentException("the year is missed");
            }
            double divide = this.get(year) / ts.get(year);
            fTs.put(year , divide);
        }
        return fTs;
    }

}
