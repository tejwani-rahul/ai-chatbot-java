//the code through bot id generating answers

package Bot;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatGPT {
    String input;
    public static String chatGPTResponse(String text) throws Exception {
        String url = "https://api.openai.com/v1/completions";  // or https://api.openai.com/v1/chat/completions
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Your API Key Here"); // Replace with your actual API key

        JSONObject data = new JSONObject();
        data.put("model", "gpt-3.5-turbo-0613");
        data.put("prompt", text);
        data.put("max_tokens", 500);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();
        System.out.println(output);
        System.out.println(output.getClass().getName());

//        Gson gson = new Gson();
//        Map<Object,Object> attributes = gson.fromJson(gson.toJson(output),Map.class);
//
//        JSONObject jsonObject = new JSONObject(attributes);
//        JSONArray choicesArray = jsonObject.getJSONArray("choices");
//        String result = choicesArray.getJSONObject(0).getString("text");
//        System.out.println(result);

//        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));

        JSONParser parser = new JSONParser();
        try {
            JSONObject responseJson = (JSONObject) parser.parse(output);
            JSONArray choicesArray = (JSONArray) responseJson.get("choices");
            JSONObject choiceObject = (JSONObject) choicesArray.get(0);
            String choiceText = (String) choiceObject.get("text");

            System.out.println(choiceText);
            System.out.println(choiceText.getClass().getName());
            return choiceText.replace("\n\n", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }

    public static void main(String[] args) throws Exception {
        String res = chatGPTResponse("what is philosophy ? ");
        System.out.println("Response: "+res);
    }
}


