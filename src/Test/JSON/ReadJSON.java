package Test.JSON;


import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class ReadJSON {
    public static void main(String[] args) {
        String myJSONString = "[{'test': '100.00'},{'test': '100.00'},{'test': '100.00'},{'test': '100.00'}]";
        JsonArray jobj = new Gson().fromJson(myJSONString, JsonArray.class);

//        String result = jobj.get("test").toString();

        System.out.println(jobj);

    }
}
