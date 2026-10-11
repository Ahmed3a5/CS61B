package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        Map<String , Set<String>> hyponemsmap = new HashMap<>();
        List<String> words = q.words();
        for(String word : words){
            Set<String> wordhypnems = ngm.findHyponyms(word);
            hyponemsmap.put(word , wordhypnems);
        }
        Set<String> hyponems = null;
        for(Set<String> wordset : hyponemsmap.values()){
            if(hyponems == null){
                hyponems = new TreeSet<>(wordset);
            }
            else{
                hyponems.retainAll(wordset);
            }
        }

        return hyponems.toString();
    }
}
