package bg.softuni.beroe.model.dto;

import java.util.List;

public class AIDTO {

    private List<Message> messages;
    private String model;
    private int temperature;
    private int max_tokens;
    private int top_p;
    private boolean stream;
    private ResponseFormat response_format;
    private Object stop;  // Can be null or different types

    // Getters and Setters

    public static class Message {
        private String role;
        private String content;

        // Getters and Setters

        public String getRole() {
            return role;
        }

        public Message setRole(String role) {
            this.role = role;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Message setContent(String content) {
            this.content = content;
            return this;
        }
    }

    public static class ResponseFormat {
        private String type;

        // Getters and Setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public AIDTO setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public double getTop_p() {
        return top_p;
    }

    public void setTop_p(int top_p) {
        this.top_p = top_p;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public ResponseFormat getResponse_format() {
        return response_format;
    }

    public void setResponse_format(ResponseFormat response_format) {
        this.response_format = response_format;
    }

    public Object getStop() {
        return stop;
    }

    public void setStop(Object stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "AIDTO{" +
                "messages=" + messages +
                ", model='" + model + '\'' +
                ", temperature=" + temperature +
                ", max_tokens=" + max_tokens +
                ", top_p=" + top_p +
                ", stream=" + stream +
                ", response_format=" + response_format +
                ", stop=" + stop +
                '}';
    }
}
