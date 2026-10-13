package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import edu.princeton.cs.algs4.In;

public class WordNet {
    public Map<String , ArrayList<Integer>> IDs = new TreeMap<>();
    public Map<Integer , ArrayList<String>> words = new HashMap<>();
    public Graph wordsGraph;
    
    public WordNet(String synsets , String hyponems ){
        In filewords = new In(synsets);
        In filegragh = new In(hyponems);
        while(!filewords.isEmpty()){
            String nextline = filewords.readLine();
            String[] linelist = nextline.split(",");
            Integer id = Integer.parseInt(linelist[0]);
            String[] wordsInline = linelist[1].split(" ");
            ArrayList<String> synsetwords = new ArrayList<>();
            for(String word: wordsInline){
                synsetwords.add(word);
                if(!IDs.containsKey(word)){
                    ArrayList<Integer> IDsynset = new ArrayList<>();
                    IDsynset.add(id);
                    IDs.put(word,IDsynset);
                }
                else{
                        IDs.get(word).add(id);
                }
            }
            words.put(id , synsetwords);
        }

        wordsGraph = new Graph(filegragh);
    }

    public ArrayList<Integer> getId(String word){
        if(!IDs.containsKey(word)){
            return new ArrayList<>();
        }
        ArrayList<Integer> wordsynsets = IDs.get(word);
        return wordsynsets;
    }

    public ArrayList<String> getwords(Integer id){
        return words.get(id);
    }
    

    public Set<String> findHyponyms(String word){
        Set<String> hyponems = new TreeSet<>();
        ArrayList<Integer> wordIds = getId(word);
        for(int id : wordIds){
            ArrayList<Integer> hyponymesIds = wordsGraph.DFS(id);
            for(int hypId : hyponymesIds){
                hyponems.addAll(getwords(hypId));
            }
        }
        return hyponems;
    }

     
}
