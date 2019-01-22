package uk.ac.core.backendTest.model;

import java.util.HashMap;
import java.util.*;
import java.util.stream.*;

public class CoreSubjects {

    private HashMap<String, Integer> subjects;

    @Override
    public String toString(){

        String result = subjects.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining(", "));
        return result;

    }

    public static CoreSubjects parseFromMap(Map map){
        CoreSubjects coreSubjects = null;
        Map aggs = (Map)map.get("aggregations");
        Map sub = (Map)aggs.get("sub");
        List buckets =(List)sub.get("buckets");

        buckets.forEach((value) -> {
            Map keyValue = (Map)value;
            String key = (String)keyValue.get("key");
            Integer count = (Integer)keyValue.get("count");
            coreSubjects.getSubjects().put(key, count);
        });
        return coreSubjects;
    }

    public HashMap<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<String, Integer> subjects) {
        this.subjects = subjects;
    }
}