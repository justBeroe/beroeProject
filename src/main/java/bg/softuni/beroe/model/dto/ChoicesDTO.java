package bg.softuni.beroe.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

// Define the main DTO class for choices
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoicesDTO {

    @JsonProperty("choices")
    private List<Choice> choices;

    // Getters and setters
    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    // Inner class for Choice
    public static class Choice {

        @JsonProperty("index")
        private int index;

        @JsonProperty("message")
        private Message message;

        @JsonProperty("logprobs")
        private Object logprobs; // Can be null

        @JsonProperty("finish_reason")
        private String finishReason;

        // Getters and setters
        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public Object getLogprobs() {
            return logprobs;
        }

        public void setLogprobs(Object logprobs) {
            this.logprobs = logprobs;
        }

        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

        // Inner class for Message
        public static class Message {

            @JsonProperty("role")
            private String role;

            @JsonProperty("content")
            private String content;

            // Getters and setters
            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
