package framework.engine;

import com.jayway.jsonpath.JsonPath;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.jayway.jsonpath.PathNotFoundException;


import java.io.FileReader;
import java.io.IOException;

public class JsonFileManager {
    String jsonReader;
    String jsonFilePath;

    public JsonFileManager(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        try {
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(jsonFilePath));
            jsonReader = data.toJSONString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    public String getTestData(String jsonPath) {
        String testData = "";
        try {
            testData = JsonPath.read(jsonReader, jsonPath);
        } catch (PathNotFoundException e) {
            e.printStackTrace();
            Assert.fail("No results for json path: '" + jsonPath + "' in the json file: '" + this.jsonFilePath + "'");
        }
        return testData;
    }

}
