package Helpers;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static Helpers.GeneralHelper.getDateAsString;
import static javax.json.Json.createObjectBuilder;

/**
 * Created by mathias on 27/04/16.
 */
public class JsonHelper {

    private StringWriter stringWriter = new StringWriter();
    private JsonWriter jsonWriter = null;
    private JsonObjectBuilder objectBuilder = null;


    /**
     * Constructor sets up the json writer with parameters
     */
    public JsonHelper() {
        Map<String, Object> properties = new HashMap<>(1);
        properties.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory factory = Json.createWriterFactory(properties);
        jsonWriter = factory.createWriter(stringWriter);

        objectBuilder = createObjectBuilder();
    }

    /**
     * @param jsonArray to be converted to a String
     * @return String formatted as a json array
     */
    public String jsonArrayToString(JsonArray jsonArray) {
        jsonWriter.writeArray(jsonArray);

        String output = stringWriter.toString();

        return output;
    }

    /**
     * @param jsonObject to be converted to a String
     * @return String formatted as a json object
     */
    public String jsonObjectToString(JsonObject jsonObject) {
        jsonWriter.writeObject(jsonObject);

        String output = stringWriter.toString();

        return output;
    }

    public JsonObject getJsonObject() {
        return objectBuilder.build();
    }

    public String getJsonObjectAsString() {
        return jsonObjectToString(objectBuilder.build());
    }

    /**
     * This method adds a String value to the json object
     *
     * @param key   the string key to be added to the json object
     * @param value the String value to be added to the json object
     * @return this object
     * @throws IllegalArgumentException thrown if key is null
     */
    public JsonHelper add(String key, String value) throws IllegalArgumentException {
        if (key == null)
            throw new IllegalArgumentException("KEY CANT BE NULL");

        if (value == null)
            objectBuilder.addNull(key);
        else
            objectBuilder.add(key, value);

        return this;
    }

    /**
     * This method adds an int value to the json object, if the int is 0 null is added
     *
     * @param key   the string key to be added to the json object
     * @param value the int value to be added to the json object
     * @return this object
     * @throws IllegalArgumentException thrown if key is null
     */
    public JsonHelper add(String key, int value) throws IllegalArgumentException {
        if (key == null)
            throw new IllegalArgumentException("KEY CANT BE NULL");

        if (value == 0)
            objectBuilder.addNull(key);
        else
            objectBuilder.add(key, value);

        return this;
    }

    /**
     * This method adds a date to the json object, if the date is null nothing is added - not even a null field
     *
     * @param key   the string key to be added to the json object
     * @param value the date value to be added to the json object
     * @return this object
     * @throws IllegalArgumentException thrown if key is null
     */
    public JsonHelper add(String key, Date value) throws IllegalArgumentException {
        if (key == null)
            throw new IllegalArgumentException("KEY CANT BE NULL");

        if (value != null)
            objectBuilder.add(key, getDateAsString(value));

        return this;
    }

    public JsonObjectBuilder getObjectBuilder() {
        return objectBuilder;
    }

    public void setObjectBuilder(JsonObjectBuilder objectBuilder) {
        this.objectBuilder = objectBuilder;
    }
}