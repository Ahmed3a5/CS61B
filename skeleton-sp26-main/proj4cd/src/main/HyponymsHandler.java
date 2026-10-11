package main;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;

public class HyponymsHandler extends NgordnetQueryHandler {
    public WordNet ngm;

    public HyponymsHandler(WordNet map){
        ngm = map;
    }
    @Override
    public String handle(NgordnetQuery q) {
        Set<String> hyponems = new TreeSet<>();
        List<String> words = q.words();
        for(String word : words){
            hyponems = ngm.findHyponyms(word);
        }
        return hyponems.toString();
    }
}
