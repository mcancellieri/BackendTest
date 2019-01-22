package uk.ac.core.backendTest.util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class JsonParser {

    private ScriptEngine engine;

    public JsonParser() {
        ScriptEngineManager sem = new ScriptEngineManager();
        this.engine = sem.getEngineByName("javascript");
    }

    public Map<String, String> parseJson(String jsonFile) throws IOException, ScriptException {
        String json = new String(Files.readAllBytes(Paths.get(jsonFile)));
        String script = "Java.asJSONCompatible(" + json + ")";
        Object result = this.engine.eval(script);
        Map contents = (Map) result;


        return contents;
    }
}