package bg.softuni.beroe.model.dto;

import java.util.List;

public class ResponseAIDTO {

    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
    private String system_fingerprint;
    private XGroq x_groq;

    // Getters and setters


    public String getId() {
        return id;
    }

    public ResponseAIDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getObject() {
        return object;
    }

    public ResponseAIDTO setObject(String object) {
        this.object = object;
        return this;
    }

    public long getCreated() {
        return created;
    }

    public ResponseAIDTO setCreated(long created) {
        this.created = created;
        return this;
    }

    public String getModel() {
        return model;
    }

    public ResponseAIDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public ResponseAIDTO setChoices(List<Choice> choices) {
        this.choices = choices;
        return this;
    }

    public Usage getUsage() {
        return usage;
    }

    public ResponseAIDTO setUsage(Usage usage) {
        this.usage = usage;
        return this;
    }

    public String getSystem_fingerprint() {
        return system_fingerprint;
    }

    public ResponseAIDTO setSystem_fingerprint(String system_fingerprint) {
        this.system_fingerprint = system_fingerprint;
        return this;
    }

    public XGroq getX_groq() {
        return x_groq;
    }

    public ResponseAIDTO setX_groq(XGroq x_groq) {
        this.x_groq = x_groq;
        return this;
    }

    public static class Choice {
        private int index;
        private Message message;
        private Object logprobs; // Can be null
        private String finish_reason;

        // Getters and setters


        public int getIndex() {
            return index;
        }

        public Choice setIndex(int index) {
            this.index = index;
            return this;
        }

        public Message getMessage() {
            return message;
        }

        public Choice setMessage(Message message) {
            this.message = message;
            return this;
        }

        public Object getLogprobs() {
            return logprobs;
        }

        public Choice setLogprobs(Object logprobs) {
            this.logprobs = logprobs;
            return this;
        }

        public String getFinish_reason() {
            return finish_reason;
        }

        public Choice setFinish_reason(String finish_reason) {
            this.finish_reason = finish_reason;
            return this;
        }

        public static class Message {
            private String role;
            private String content;

            // Getters and setters

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
    }

    public static class Usage {
        private int prompt_tokens;
        private double prompt_time;
        private int completion_tokens;
        private double completion_time;
        private int total_tokens;
        private double total_time;

        // Getters and setters

        public int getPrompt_tokens() {
            return prompt_tokens;
        }

        public Usage setPrompt_tokens(int prompt_tokens) {
            this.prompt_tokens = prompt_tokens;
            return this;
        }

        public double getPrompt_time() {
            return prompt_time;
        }

        public Usage setPrompt_time(double prompt_time) {
            this.prompt_time = prompt_time;
            return this;
        }

        public int getCompletion_tokens() {
            return completion_tokens;
        }

        public Usage setCompletion_tokens(int completion_tokens) {
            this.completion_tokens = completion_tokens;
            return this;
        }

        public double getCompletion_time() {
            return completion_time;
        }

        public Usage setCompletion_time(double completion_time) {
            this.completion_time = completion_time;
            return this;
        }

        public int getTotal_tokens() {
            return total_tokens;
        }

        public Usage setTotal_tokens(int total_tokens) {
            this.total_tokens = total_tokens;
            return this;
        }

        public double getTotal_time() {
            return total_time;
        }

        public Usage setTotal_time(double total_time) {
            this.total_time = total_time;
            return this;
        }
    }

    public static class XGroq {
        private String id;

        // Getters and setters

        public String getId() {
            return id;
        }

        public XGroq setId(String id) {
            this.id = id;
            return this;
        }
    }
}
