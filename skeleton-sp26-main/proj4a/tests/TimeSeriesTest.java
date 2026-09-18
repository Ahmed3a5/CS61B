import main.TimeSeries;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

/** Unit Tests for the TimeSeries class.
 *  @author Josh Hug
 */
public class TimeSeriesTest {
    @Test
    public void testFromSpec() {
        TimeSeries catPopulation = new TimeSeries();
        catPopulation.put(1991, 0.0);
        catPopulation.put(1992, 100.0);
        catPopulation.put(1994, 200.0);

        TimeSeries dogPopulation = new TimeSeries();
        dogPopulation.put(1994, 400.0);
        dogPopulation.put(1995, 500.0);

        TimeSeries totalPopulation = catPopulation.plus(dogPopulation);
        // expected: 1991: 0,
        //           1992: 100
        //           1994: 600
        //           1995: 500

        List<Integer> expectedYears = new ArrayList<>();
        expectedYears.add(1991);
        expectedYears.add(1992);
        expectedYears.add(1994);
        expectedYears.add(1995);

        assertThat(totalPopulation.years()).isEqualTo(expectedYears);

        List<Double> expectedTotal = new ArrayList<>();
        expectedTotal.add(0.0);
        expectedTotal.add(100.0);
        expectedTotal.add(600.0);
        expectedTotal.add(500.0);

        for (int i = 0; i < expectedTotal.size(); i += 1) {
            assertThat(totalPopulation.data().get(i)).isWithin(1E-10).of(expectedTotal.get(i));
        }
    }

    @Test
    public void testEmptyBasic() {
        TimeSeries catPopulation = new TimeSeries();
        TimeSeries dogPopulation = new TimeSeries();

        assertThat(catPopulation.years()).isEmpty();
        assertThat(catPopulation.data()).isEmpty();

        TimeSeries totalPopulation = catPopulation.plus(dogPopulation);

        assertThat(totalPopulation.years()).isEmpty();
        assertThat(totalPopulation.data()).isEmpty();
    }

    @Test 
    public void TestYears(){
        // ordered ts 
        TimeSeries ts = new TimeSeries();
        ts.put(1991, 0.0);
        ts.put(1992, 100.0);
        ts.put(1994, 200.0);

        List lst1 = new ArrayList<>();
        lst1.add(1991);
        lst1.add(1992);
        lst1.add(1994);

        assertThat(ts.years()).isEqualTo(lst1);

        // empty ts 
        TimeSeries ts2 = new TimeSeries();
        
        assertThat(ts2.years()).isEqualTo(List.of());

        // undorderd ts 
        TimeSeries ts3 = new TimeSeries();
        ts3.put(1994, 0.0);
        ts3.put(1992, 100.0);
        ts3.put(1991, 200.0);

        List lst2 = new ArrayList<>();
        lst2.add(1991);
        lst2.add(1992);
        lst2.add(1994);
        assertThat(ts3.years()).isEqualTo(lst2);
    }

    @Test
    public void testData(){
        // ordered ts 
        TimeSeries ts = new TimeSeries();
        ts.put(1991, 0.0);
        ts.put(1992, 100.0);
        ts.put(1994, 200.0);

        List lst1 = new ArrayList<>();
        lst1.add(0.0);
        lst1.add(100.0);
        lst1.add(200.0);

        assertThat(ts.data()).isEqualTo(lst1);

        // empty ts 
        TimeSeries ts2 = new TimeSeries();
        
        assertThat(ts2.data()).isEqualTo(List.of());

        // undorderd ts 
        TimeSeries ts3 = new TimeSeries();
        ts3.put(1994, 0.0);
        ts3.put(1992, 100.0);
        ts3.put(1991, 200.0);

        List lst2 = new ArrayList<>();
        lst2.add(200.0);
        lst2.add(100.0);
        lst2.add(0.0);
        assertThat(ts3.data()).isEqualTo(lst2);
    }

    @Test 
    public void TestPlus(){
        // the 2 timesereies have the same years 
        TimeSeries ts1 = new TimeSeries();
        ts1.put(1991, 0.0);
        ts1.put(1992, 100.0);
        ts1.put(1994, 200.0);

        TimeSeries ts2 = new TimeSeries();
        ts2.put(1991 , 100.0);
        ts2.put(1992 , 100.0);
        ts2.put(1994 , 100.0);

        TimeSeries fTs1 = new TimeSeries();
        fTs1.put(1991 , 100.0);
        fTs1.put(1992 , 200.0);
        fTs1.put(1994 , 300.0);

        assertThat(ts1.plus(ts2)).isEqualTo(fTs1);

        // one is empty and other is have items

        TimeSeries ts3 = new TimeSeries();
        ts3.put(1991, 0.0);
        ts3.put(1992, 100.0);
        ts3.put(1994, 200.0);

        TimeSeries ts4 = new TimeSeries();

        TimeSeries fTs2 = new TimeSeries();
        fTs2.put(1991 , 0.0);
        fTs2.put(1992 , 100.0);
        fTs2.put(1994 , 200.0);

        assertThat(ts3.plus(ts4)).isEqualTo(fTs2);

        TimeSeries ts5 = new TimeSeries();
        ts5.put(1991, 0.0);
        ts5.put(1992, 100.0);
        ts5.put(1994, 200.0);

        TimeSeries ts6 = new TimeSeries();
        ts6.put(1991, 100.0);
        ts6.put(1992, 100.0);
        ts6.put(1996, 100.0);

        TimeSeries fTs3 = new TimeSeries();
        fTs3.put(1991 , 100.0);
        fTs3.put(1992 , 200.0);
        fTs3.put(1994 , 200.0);
        fTs3.put(1996, 100.0);


        assertThat(ts5.plus(ts6)).isEqualTo(fTs3);
    }


    @Test 
    public void TestdivideBy(){
                // the 2 timesereies have the same years 
        TimeSeries ts1 = new TimeSeries();
        ts1.put(1991, 0.0);
        ts1.put(1992, 100.0);
        ts1.put(1994, 200.0);

        TimeSeries ts2 = new TimeSeries();
        ts2.put(1991 , 1.0);
        ts2.put(1992 , 5.0);
        ts2.put(1994 , 10.0);

        TimeSeries fTs1 = new TimeSeries();
        fTs1.put(1991 , 0.0);
        fTs1.put(1992 , 20.0);
        fTs1.put(1994 , 20.0);

        assertThat(ts1.dividedBy(ts2)).isEqualTo(fTs1);

        // one is empty and other is have items

        TimeSeries ts3 = new TimeSeries();
        ts3.put(1991, 0.0);
        ts3.put(1992, 100.0);
        ts3.put(1994, 200.0);

        TimeSeries ts4 = new TimeSeries();

        
        assertThrows(IllegalArgumentException.class , () ->{ts3.dividedBy(ts4);});

        TimeSeries ts5 = new TimeSeries();
        ts5.put(1991, 0.0);
        ts5.put(1992, 100.0);
        ts5.put(1994, 200.0);

        TimeSeries ts6 = new TimeSeries();
        ts6.put(1991, 1.0);
        ts6.put(1992, 100.0);
        ts6.put(1994, 100.0);
        ts6.put(1996, 100.0);


        TimeSeries fTs3 = new TimeSeries();
        fTs3.put(1991 , 0.0);
        fTs3.put(1992 , 1.0);
        fTs3.put(1994 , 2.0);

        assertThat(ts5.dividedBy(ts6)).isEqualTo(fTs3);
    }

} 