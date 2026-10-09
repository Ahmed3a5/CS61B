package main;

import java.sql.Time;
import java.util.List;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;

public class HistoryTextHandler extends NgordnetQueryHandler{
    private NGramMap ngm;

    public HistoryTextHandler(NGramMap map){
        ngm = map;
    }
    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startyear = q.startYear();
        int endyear = q.endYear();
        String responce = "";
        for(String word : words){
            TimeSeries wordyears = new TimeSeries(ngm.weightHistory(word) , startyear , endyear);
            responce += word + ": " + "{" + wordyears + "}\n";
        }

        return responce;
    }
}