package bg.softuni.beroe.service.impl;

import bg.softuni.beroe.model.dto.AIDTO;

import bg.softuni.beroe.model.dto.ChoicesDTO;
import bg.softuni.beroe.model.dto.ResponseAIDTO;
import bg.softuni.beroe.service.AIService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AIServiceImpl implements AIService {

    private final RestClient restClient;

    private final WebClient webClient;

    public AIServiceImpl(@Qualifier("AIRestClient") RestClient restClient, WebClient webClient) {
        this.restClient = restClient;
        this.webClient = webClient;
    }

    @Override
    public ChoicesDTO fetchAIResponse() {
        // Create message list
        List<AIDTO.Message> messageList = new ArrayList<>();

        // Create system message /not needed/
        AIDTO.Message systemMessage = new AIDTO.Message();
        systemMessage.setRole("system");
        systemMessage.setContent("JSON");
        messageList.add(systemMessage);

        // Create user message
        AIDTO.Message userMessage = new AIDTO.Message();
        userMessage.setRole("user");
        userMessage.setContent("Please repeat only -- SAMO BEROE");
        messageList.add(userMessage);

        // Create and set request body
        AIDTO requestBody = new AIDTO();
        requestBody.setMessages(messageList);
        requestBody.setModel("llama3-70b-8192");
        requestBody.setTemperature(1);
        requestBody.setMax_tokens(1024);
        requestBody.setTop_p(1);
        requestBody.setStream(false);

        // Create ResponseFormat and set it
        AIDTO.ResponseFormat responseFormat = new AIDTO.ResponseFormat();
        responseFormat.setType("json_object");
        requestBody.setResponse_format(responseFormat);

        // Set stop to null (or another value if needed)
        requestBody.setStop(null);

        System.out.println();
        // Send POST request and retrieve response
        ChoicesDTO responseBody = restClient
                .post()
                .uri("https://api.groq.com/openai/v1/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer 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")
                .body(BodyInserters.fromValue(requestBody))  // Set the body using BodyInserters
                .retrieve()
                .body(ChoicesDTO.class); // Retrieve the response body as AIDTO in a Mono
                 // Block to get the response synchronously (or use subscribe for async)

        return responseBody;  // Return the response body
    }


    // Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(AIServiceImpl.class);

    public ChoicesDTO fetchChoices() {

        // Create message list
        List<AIDTO.Message> messageList = new ArrayList<>();

        // Create system message /not needed/
        AIDTO.Message systemMessage = new AIDTO.Message();
        systemMessage.setRole("system");
        systemMessage.setContent("JSON");
        messageList.add(systemMessage);

        // Create user message
        AIDTO.Message userMessage = new AIDTO.Message();
        userMessage.setRole("user");
        userMessage.setContent("Please repeat only -- SAMO BEROE");
        messageList.add(userMessage);

        // Create and set request body
        AIDTO requestBody = new AIDTO();
        requestBody.setMessages(messageList);
        requestBody.setModel("llama3-70b-8192");
        requestBody.setTemperature(1);
        requestBody.setMax_tokens(1024);
        requestBody.setTop_p(1);
        requestBody.setStream(false);

        // Create ResponseFormat and set it
        AIDTO.ResponseFormat responseFormat = new AIDTO.ResponseFormat();
        responseFormat.setType("json_object");
        requestBody.setResponse_format(responseFormat);

        // Set stop to null (or another value if needed)
        requestBody.setStop(null);

        System.out.println();
        // Perform the request and capture the raw response
        Mono<String> rawResponse = webClient
                .post()
                .uri("https://api.groq.com/openai/v1/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer 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")
                .bodyValue(requestBody)  // Set the body using bodyValue
                .retrieve()
                .bodyToMono(String.class) // Capture the raw response as a String
                .doOnNext(response -> System.out.println("Raw Response: " + response)) // Log the raw response
                .onErrorResume(e -> {
                    System.err.println("Error fetching choices: " + e.getMessage());
                    return Mono.empty();
                });
        // Convert the raw response to ChoicesDTO
        ChoicesDTO responseBody = rawResponse
                .map(response -> {
                    // Convert raw response to ChoicesDTO
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        return objectMapper.readValue(response, ChoicesDTO.class);
                    } catch (IOException e) {
                        logger.error("Error parsing response to ChoicesDTO", e);
                        throw new RuntimeException(e);
                    }
                })
                .block(); // Block to get the response synchronously

        return responseBody;  // Return the response body
}}
