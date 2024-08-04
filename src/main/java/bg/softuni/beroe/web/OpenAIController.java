package bg.softuni.beroe.web;

import okhttp3.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OpenAIController {

    @Value("${openai.api.key}")
    private String apiKey;

    private static final String API_URL = "https://api.openai.com/v1/completions";

    @GetMapping("/generate-text")
    public String generateText(@RequestParam String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Create the request body
        String json = new Gson().toJson(new RequestBodyData(prompt));

        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        // Create the request
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        // Execute the request
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Get the response body
            return response.body().string();
        }
    }

    // Inner class to define the request body structure
    static class RequestBodyData {
        String model = "text-davinci-003";
        String prompt;
        int max_tokens = 50;

        RequestBodyData(String prompt) {
            this.prompt = prompt;
        }
    }
}
