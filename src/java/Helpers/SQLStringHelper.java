package Helpers;

import java.util.ArrayList;

/**
 * Created by mathias on 09/11/2016.
 */
public class SQLStringHelper {
    private StringBuilder queryBuilder;
    private StringBuilder valuesBuilder;
    private ArrayList<String[]> fields;

    public SQLStringHelper(String query, String values){
        queryBuilder = new StringBuilder(query);
        valuesBuilder = new StringBuilder(values);
        fields = new ArrayList<>();
    }

    public void addField(String fieldName, String type){
        if(fieldName == null || type == null){
            throw new IllegalArgumentException("The inputs can't be null");
        }
        queryBuilder.append(fieldName);
        queryBuilder.append(", ");

        char fieldNameChars[] = fieldName.toCharArray();
        fieldNameChars[0] = Character.toLowerCase(fieldNameChars[0]);

        String lowerCaseFieldName = new String(fieldNameChars);

        valuesBuilder.append(":");
        valuesBuilder.append(lowerCaseFieldName);
        valuesBuilder.append(", ");

        String fieldInput[] = {lowerCaseFieldName, fieldName, type};

        fields.add(fieldInput);
    }

    public String getCompleteString(){
        StringBuilder returnStringBuilder = new StringBuilder(queryBuilder.toString());
        returnStringBuilder.delete(returnStringBuilder.length()-2, returnStringBuilder.length());
        returnStringBuilder.append(")");
        returnStringBuilder.append(valuesBuilder.toString());
        returnStringBuilder.delete(returnStringBuilder.length()-2, returnStringBuilder.length());
        returnStringBuilder.append(");");


        return returnStringBuilder.toString();
    }

    public ArrayList<String[]> getFields() {
        return fields;
    }
}
