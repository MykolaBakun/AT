package practice.serialization;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


public class SerializationJson {

    public static void main(String[] args) throws IOException {


        // json init
        JSONObject json1= new JSONObject();
        json1.put("name","Misha");
        json1.put("age",33);
        json1.put("address",new JSONObject());
        json1.getJSONObject("address").put("country","Ukraine");
        Integer age=json1.getInt("age");
        json1.getJSONObject("address").put("city","Lviv");

        // json to object POJO
        ObjectMapper objectMapper = new ObjectMapper();
        Student student=objectMapper.readValue(json1.toString(),Student.class);
        System.out.println(student);

        //object to json
        JSONObject json2=new JSONObject(student);
        System.out.println(json2);

        // text to json
        JSONObject json3=new JSONObject("{\"address\":{\"country\":\"Ukraine\"" +
                ",\"city\":\"Lviv\"},\"name\":\"Misha\",\"age\":33}");
        System.out.println(json3);

        //json to file
        String filePath="target"+ File.separator+"result.json";
        FileWriter fw=new FileWriter(filePath);
        fw.write(json3.toString());
        fw.flush();
        fw.close();

        // file to json
        JSONObject json4=new JSONObject(Files.readString(new File(filePath).toPath()));
        System.out.println("json4 " +json4);

        // json navigation (array, get, keySet)
        JSONObject json5= new JSONObject();
        json5.put("arrayField",new JSONArray());
        json5.getJSONArray("arrayField")
                .put(new JSONObject("{\"name\":[\"qwe\",\"qwe2\"]}"));

        json1.keySet().forEach(k->{
            System.out.println(json1.get(k));
            if(k.equals("address")){
            JSONObject jsonKK=json1.getJSONObject("address");
            jsonKK.keySet().forEach(kk->{
                System.out.println("\t"+jsonKK.get(kk));
            });}
        });

        System.out.println(json5
                .getJSONArray("arrayField")
                .getJSONObject(0)
                .getJSONArray("name")
                .get(0));

// json to map
        System.out.println(json5.toMap());

// map to json
        Map<String,Map<String,String> > map=new HashMap<>();
        map.put("name",new HashMap<>());
        map.get("name").put("firstName","Misha");
        map.get("name").put("secondName","Mikus");
        JSONObject json6= new JSONObject(map);
        System.out.println(json6);

    }

}
