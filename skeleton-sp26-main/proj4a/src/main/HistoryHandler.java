package main;

import java.util.ArrayList;
import java.util.List;

import org.knowm.xchart.XYChart;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;
import browser.Plotter;

public class HistoryHandler extends NgordnetQueryHandler{
    private NGramMap ngm;
    public HistoryHandler(NGramMap map){
        ngm = map;
    }
    @Override
    public String handle(NgordnetQuery q) {
       List<String> words = q.words();
       int startyear = q.startYear();
       int endyear = q.endYear();
        ArrayList<TimeSeries> lts = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();


       for(String word : words){
            lts.add(new TimeSeries(ngm.weightHistory(word) , startyear , endyear));
            labels.add(word);
        }

        XYChart chart = Plotter.generateTimeSeriesChart(labels, lts);
        String encodedImage = Plotter.encodeChartAsString(chart);

        return encodedImage;
    }
    
}
