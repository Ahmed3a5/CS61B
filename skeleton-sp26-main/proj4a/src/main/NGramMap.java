package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.In;


import static main.TimeSeries.MAX_YEAR;
import static main.TimeSeries.MIN_YEAR;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 *
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
public class NGramMap {

    private Map<String , TimeSeries> wordsHistory = new HashMap<>();
    private Map<Integer , Double> yearsTotalwords = new HashMap<>();

    /**
     * Constructs an NGramMap from WORDHISTORYFILENAME and YEARHISTORYFILENAME.
     */
    public NGramMap(String wordHistoryFilename, String yearHistoryFilename) {

        In words = new In(wordHistoryFilename);
        In years = new In(yearHistoryFilename);
        while(!words.isEmpty()){
            String nextline = words.readLine();
            String[] linewords = nextline.split("\\s+");
            if(!wordsHistory.containsKey(linewords[0])){
                wordsHistory.put(linewords[0] , new TimeSeries());
            }
            wordsHistory.get(linewords[0]).put(Integer.parseInt(linewords[1]) , Double.parseDouble(linewords[2]));
        }

        while(!years.isEmpty()){
            String nextline = years.readLine();
            String[] linewords = nextline.split(",");
            yearsTotalwords.put(Integer.parseInt(linewords[0]) , Double.parseDouble(linewords[1]));
        }
    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other
     * words, changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy". If the word is not in the data files,
     * returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {

        TimeSeries allwordHistory = countHistory(word);
        TimeSeries targetyearswordhistory = new TimeSeries(allwordHistory , startYear , endYear);
        return targetyearswordhistory;
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy, not a link to this
     * NGramMap's TimeSeries. In other words, changes made to the object returned by this function
     * should not also affect the NGramMap. This is also known as a "defensive copy". If the word
     * is not in the data files, returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word) {
        TimeSeries singleWordHistory = new TimeSeries();
        if(wordsHistory.containsKey(word)){
            Map<Integer , Double> years = wordsHistory.get(word);
            for(Integer y : years.keySet()){
                singleWordHistory.put(y , years.get(y));
            }
        }
        return singleWordHistory;
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        TimeSeries totalcounthistory = new TimeSeries();
        for(Integer year : yearsTotalwords.keySet()){
            totalcounthistory.put(year , yearsTotalwords.get(year));
        }
        return totalcounthistory;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        TimeSeries weighthistory = weightHistory(word);
        TimeSeries targetweighthistory = new TimeSeries(weighthistory , startYear , endYear);
        return targetweighthistory;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to all
     * words recorded in that year. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word) {
        TimeSeries weightHistory = new TimeSeries();
        TimeSeries wordCounthistory = countHistory(word);
        TimeSeries totalcountHistory = totalCountHistory();

        weightHistory = wordCounthistory.dividedBy(totalcountHistory);

        return weightHistory;
    }

    /**
     * Provides the summed relative frequency per year of all words in WORDS between STARTYEAR and
     * ENDYEAR, inclusive of both ends. If a word does not exist in this time frame, ignore it
     * rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words,int startYear, int endYear) {
        TimeSeries summweighthistory = summedWeightHistory(words);
        TimeSeries targetsummweighthistory = new TimeSeries(summweighthistory , startYear , endYear);
        return targetsummweighthistory;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS. If a word does not
     * exist in this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        TimeSeries summweighthistory = new TimeSeries();
        TimeSeries TotalcountHistory = totalCountHistory();
        for(String word : words){
            summweighthistory = summweighthistory.plus(countHistory(word));
        }
        summweighthistory = summweighthistory.dividedBy(TotalcountHistory);
        return summweighthistory;
    }
}
