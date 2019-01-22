package uk.ac.core.backendTest;


import uk.ac.core.backendTest.model.CoreSubjects;
import uk.ac.core.backendTest.util.Downloader;
import uk.ac.core.backendTest.util.JsonParser;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Downloader downloader = new Downloader();
        boolean result = downloader.downloadFile("https://gist.github.com/mcancellieri/4b34782468d779ac937deb5d0ee7fcad/raw/4b0803fd36641913b996abf85bc71ea816280623/Subject%2520types%2520of%2520CORE", "core_subjects.json");

        JsonParser jsonParser = new JsonParser();
        CoreSubjects coreSubjects = null;
        try {
            Map parsed = jsonParser.parseJson("core_subjects.json");
            coreSubjects= CoreSubjects.parseFromMap(parsed);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(coreSubjects);

    }
}
