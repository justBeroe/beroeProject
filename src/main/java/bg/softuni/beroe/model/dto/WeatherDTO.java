package bg.softuni.beroe.model.dto;

public class WeatherDTO {
    private CurrentWeather current;

    // Getters and Setters

    public CurrentWeather getCurrent() {
        return current;
    }

     public WeatherDTO setCurrent(CurrentWeather current) {
        this.current = current;
        return this;
    }

    /////

    public static class CurrentWeather {
        private long last_updated_epoch;
        private String last_updated;
        private double temp_c;
        private double temp_f;
        private int is_day;
        private Condition condition;

        // Getters and Setters

        public long getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public CurrentWeather setLast_updated_epoch(long last_updated_epoch) {
            this.last_updated_epoch = last_updated_epoch;
            return this;
        }

        public String getLast_updated() {
            return last_updated;
        }

        public CurrentWeather setLast_updated(String last_updated) {
            this.last_updated = last_updated;
            return this;
        }

        public double getTemp_c() {
            return temp_c;
        }

        public CurrentWeather setTemp_c(double temp_c) {
            this.temp_c = temp_c;
            return this;
        }

        public double getTemp_f() {
            return temp_f;
        }

        public CurrentWeather setTemp_f(double temp_f) {
            this.temp_f = temp_f;
            return this;
        }

        public int getIs_day() {
            return is_day;
        }

        public CurrentWeather setIs_day(int is_day) {
            this.is_day = is_day;
            return this;
        }

        public Condition getCondition() {
            return condition;
        }

        public CurrentWeather setCondition(Condition condition) {
            this.condition = condition;
            return this;
        }


        ////

        public static class Condition {
            private String text;
            private String icon;
            private int code;

            // Getters and Setters

            public String getText() {
                return text;
            }

            public Condition setText(String text) {
                this.text = text;
                return this;
            }

            public String getIcon() {
                return icon;
            }

            public Condition setIcon(String icon) {
                this.icon = icon;
                return this;
            }

            public int getCode() {
                return code;
            }

            public Condition setCode(int code) {
                this.code = code;
                return this;
            }

            ////
        }
    }
}
