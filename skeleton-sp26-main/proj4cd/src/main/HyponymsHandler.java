package main;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import browser.NgordnetQuery;
import browser.NgordnetQueryHandler;

public class HyponymsHandler extends NgordnetQueryHandler {
    public WordNet wordnet;
    public NGramMap ngm;

    public HyponymsHandler(WordNet map , NGramMap m){
        wordnet = map;
        ngm = m;
    }
    @Override
    public String handle(NgordnetQuery q) {
        List<String> words = q.words();
        int startyear = q.startYear();
        int endyear = q.endYear();
        int k = q.k();
        
        Set<String> hyponems = null;

        for(String word : words){
            Set<String> wordhypnems = wordnet.findHyponyms(word);
            if(hyponems == null){
                hyponems = new TreeSet<>();
                hyponems.addAll(wordhypnems);
            }
            else{
                hyponems.retainAll(wordhypnems);
            }
        }

        if(k == 0){return hyponems.toString();}
        else{
            Map<String , Double> hyponemscores = new TreeMap<>();
            for(String word : hyponems){
                double score = countthewordscore(ngm.countHistory(word, startyear ,endyear));
                hyponemscores.put(word , score);
            }
            Set<String> fhyponems = new TreeSet<>();
            while(k > 0){
                double max = 0;
                String word = null;
                for(Map.Entry<String , Double> entry : hyponemscores.entrySet()){
                    if(entry.getValue() > max){
                        max = entry.getValue();
                        word = entry.getKey();

                    }
                }
                if(word == null){break;}
                fhyponems.add(word);
                hyponemscores.remove(word);
                k--;
            }
            return fhyponems.toString();
        } 
    }

    public double countthewordscore(Map<Integer , Double> map){
        double sum = 0;
        for(Double num : map.values()){
            sum+=num;
        }
        return sum;
    }
}
