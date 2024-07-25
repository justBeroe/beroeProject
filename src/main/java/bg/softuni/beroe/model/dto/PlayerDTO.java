package bg.softuni.beroe.model.dto;
import java.util.List;
import java.util.List;

public class PlayerDTO {
    public String get;
    public Parameters parameters;
    public List<String> errors;
    public int results;
    public Paging paging;
    public List<PlayerResponse> response;

    // Getters and setters


    public String getGet() {
        return get;
    }

    public PlayerDTO setGet(String get) {
        this.get = get;
        return this;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public PlayerDTO setParameters(Parameters parameters) {
        this.parameters = parameters;
        return this;
    }

    public List<String> getErrors() {
        return errors;
    }

    public PlayerDTO setErrors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public int getResults() {
        return results;
    }

    public PlayerDTO setResults(int results) {
        this.results = results;
        return this;
    }

    public Paging getPaging() {
        return paging;
    }

    public PlayerDTO setPaging(Paging paging) {
        this.paging = paging;
        return this;
    }

    public List<PlayerResponse> getResponse() {
        return response;
    }

    public PlayerDTO setResponse(List<PlayerResponse> response) {
        this.response = response;
        return this;
    }

    public static class Parameters {
        public String league;
        public String season;
        public String team;

        // Getters and setters


        public String getLeague() {
            return league;
        }

        public Parameters setLeague(String league) {
            this.league = league;
            return this;
        }

        public String getSeason() {
            return season;
        }

        public Parameters setSeason(String season) {
            this.season = season;
            return this;
        }

        public String getTeam() {
            return team;
        }

        public Parameters setTeam(String team) {
            this.team = team;
            return this;
        }
    }

    public static class Paging {
        public int current;
        public int total;

        // Getter and Setters


        public int getCurrent() {
            return current;
        }

        public Paging setCurrent(int current) {
            this.current = current;
            return this;
        }

        public int getTotal() {
            return total;
        }

        public Paging setTotal(int total) {
            this.total = total;
            return this;
        }
    }

    public static class PlayerResponse {
        public Player player;
        public List<Statistics> statistics;

        public Player getPlayer() {
            return player;
        }

        public PlayerResponse setPlayer(Player player) {
            this.player = player;
            return this;
        }

        public List<Statistics> getStatistics() {
            return statistics;
        }

        public PlayerResponse setStatistics(List<Statistics> statistics) {
            this.statistics = statistics;
            return this;
        }
    }

    public static class Player {
        public int id;
        public String name;
        public String firstname;
        public String lastname;
        public int age;
        public Birth birth;
        public String nationality;
        public String height;
        public String weight;
        public boolean injured;
        public String photo;

        // Getters and Setters


        public int getId() {
            return id;
        }

        public Player setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Player setName(String name) {
            this.name = name;
            return this;
        }

        public String getFirstname() {
            return firstname;
        }

        public Player setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public String getLastname() {
            return lastname;
        }

        public Player setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Player setAge(int age) {
            this.age = age;
            return this;
        }

        public Birth getBirth() {
            return birth;
        }

        public Player setBirth(Birth birth) {
            this.birth = birth;
            return this;
        }

        public String getNationality() {
            return nationality;
        }

        public Player setNationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public String getHeight() {
            return height;
        }

        public Player setHeight(String height) {
            this.height = height;
            return this;
        }

        public String getWeight() {
            return weight;
        }

        public Player setWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public boolean isInjured() {
            return injured;
        }

        public Player setInjured(boolean injured) {
            this.injured = injured;
            return this;
        }

        public String getPhoto() {
            return photo;
        }

        public Player setPhoto(String photo) {
            this.photo = photo;
            return this;
        }
    }

    public static class Birth {
        public String date;
        public String place;
        public String country;

        // Getters and Setters


        public String getDate() {
            return date;
        }

        public Birth setDate(String date) {
            this.date = date;
            return this;
        }

        public String getPlace() {
            return place;
        }

        public Birth setPlace(String place) {
            this.place = place;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public Birth setCountry(String country) {
            this.country = country;
            return this;
        }
    }

    public static class Statistics {
        public Team team;
        public League league;
        public Games games;
        public Substitutes substitutes;
        public Shots shots;
        public Goals goals;
        public Passes passes;
        public Tackles tackles;
        public Duels duels;
        public Dribbles dribbles;
        public Fouls fouls;
        public Cards cards;
        public Penalty penalty;

        // Getters and Setters


        public Team getTeam() {
            return team;
        }

        public Statistics setTeam(Team team) {
            this.team = team;
            return this;
        }

        public League getLeague() {
            return league;
        }

        public Statistics setLeague(League league) {
            this.league = league;
            return this;
        }

        public Games getGames() {
            return games;
        }

        public Statistics setGames(Games games) {
            this.games = games;
            return this;
        }

        public Substitutes getSubstitutes() {
            return substitutes;
        }

        public Statistics setSubstitutes(Substitutes substitutes) {
            this.substitutes = substitutes;
            return this;
        }

        public Shots getShots() {
            return shots;
        }

        public Statistics setShots(Shots shots) {
            this.shots = shots;
            return this;
        }

        public Goals getGoals() {
            return goals;
        }

        public Statistics setGoals(Goals goals) {
            this.goals = goals;
            return this;
        }

        public Passes getPasses() {
            return passes;
        }

        public Statistics setPasses(Passes passes) {
            this.passes = passes;
            return this;
        }

        public Tackles getTackles() {
            return tackles;
        }

        public Statistics setTackles(Tackles tackles) {
            this.tackles = tackles;
            return this;
        }

        public Duels getDuels() {
            return duels;
        }

        public Statistics setDuels(Duels duels) {
            this.duels = duels;
            return this;
        }

        public Dribbles getDribbles() {
            return dribbles;
        }

        public Statistics setDribbles(Dribbles dribbles) {
            this.dribbles = dribbles;
            return this;
        }

        public Fouls getFouls() {
            return fouls;
        }

        public Statistics setFouls(Fouls fouls) {
            this.fouls = fouls;
            return this;
        }

        public Cards getCards() {
            return cards;
        }

        public Statistics setCards(Cards cards) {
            this.cards = cards;
            return this;
        }

        public Penalty getPenalty() {
            return penalty;
        }

        public Statistics setPenalty(Penalty penalty) {
            this.penalty = penalty;
            return this;
        }

        public static class Team {
            public int id;
            public String name;
            public String logo;

            // Getters and Setters


            public int getId() {
                return id;
            }

            public Team setId(int id) {
                this.id = id;
                return this;
            }

            public String getName() {
                return name;
            }

            public Team setName(String name) {
                this.name = name;
                return this;
            }

            public String getLogo() {
                return logo;
            }

            public Team setLogo(String logo) {
                this.logo = logo;
                return this;
            }
        }

        public static class League {
            public int id;
            public String name;
            public String country;
            public String logo;
            public String flag;
            public int season;

            // Getters and Setters


            public int getId() {
                return id;
            }

            public League setId(int id) {
                this.id = id;
                return this;
            }

            public String getName() {
                return name;
            }

            public League setName(String name) {
                this.name = name;
                return this;
            }

            public String getCountry() {
                return country;
            }

            public League setCountry(String country) {
                this.country = country;
                return this;
            }

            public String getLogo() {
                return logo;
            }

            public League setLogo(String logo) {
                this.logo = logo;
                return this;
            }

            public String getFlag() {
                return flag;
            }

            public League setFlag(String flag) {
                this.flag = flag;
                return this;
            }

            public int getSeason() {
                return season;
            }

            public League setSeason(int season) {
                this.season = season;
                return this;
            }
        }

        public static class Games {
            public Integer appearences;
            public Integer lineups;
            public Integer minutes;
            public Integer number;
            public String position;
            public Float rating;
            public boolean captain;

            // Getters and Setters


            public Integer getAppearences() {
                return appearences;
            }

            public Games setAppearences(Integer appearences) {
                this.appearences = appearences;
                return this;
            }

            public Integer getLineups() {
                return lineups;
            }

            public Games setLineups(Integer lineups) {
                this.lineups = lineups;
                return this;
            }

            public Integer getMinutes() {
                return minutes;
            }

            public Games setMinutes(Integer minutes) {
                this.minutes = minutes;
                return this;
            }

            public Integer getNumber() {
                return number;
            }

            public Games setNumber(Integer number) {
                this.number = number;
                return this;
            }

            public String getPosition() {
                return position;
            }

            public Games setPosition(String position) {
                this.position = position;
                return this;
            }

            public Float getRating() {
                return rating;
            }

            public Games setRating(Float rating) {
                this.rating = rating;
                return this;
            }

            public boolean isCaptain() {
                return captain;
            }

            public Games setCaptain(boolean captain) {
                this.captain = captain;
                return this;
            }
        }

        public static class Substitutes {
            public Integer in;
            public Integer out;
            public Integer bench;

            // Getters and Setters


            public Integer getIn() {
                return in;
            }

            public Substitutes setIn(Integer in) {
                this.in = in;
                return this;
            }

            public Integer getOut() {
                return out;
            }

            public Substitutes setOut(Integer out) {
                this.out = out;
                return this;
            }

            public Integer getBench() {
                return bench;
            }

            public Substitutes setBench(Integer bench) {
                this.bench = bench;
                return this;
            }
        }

        public static class Shots {
            public Integer total;
            public Integer on;

            // Getters and Setters


            public Integer getTotal() {
                return total;
            }

            public Shots setTotal(Integer total) {
                this.total = total;
                return this;
            }

            public Integer getOn() {
                return on;
            }

            public Shots setOn(Integer on) {
                this.on = on;
                return this;
            }
        }

        public static class Goals {
            public Integer total;
            public Integer conceded;
            public Integer assists;
            public Integer saves;

            // Getters and Setters


            public Integer getTotal() {
                return total;
            }

            public Goals setTotal(Integer total) {
                this.total = total;
                return this;
            }

            public Integer getConceded() {
                return conceded;
            }

            public Goals setConceded(Integer conceded) {
                this.conceded = conceded;
                return this;
            }

            public Integer getAssists() {
                return assists;
            }

            public Goals setAssists(Integer assists) {
                this.assists = assists;
                return this;
            }

            public Integer getSaves() {
                return saves;
            }

            public Goals setSaves(Integer saves) {
                this.saves = saves;
                return this;
            }
        }

        public static class Passes {
            public Integer total;
            public Integer key;
            public Integer accuracy;

            // Getters and Setters


            public Integer getTotal() {
                return total;
            }

            public Passes setTotal(Integer total) {
                this.total = total;
                return this;
            }

            public Integer getKey() {
                return key;
            }

            public Passes setKey(Integer key) {
                this.key = key;
                return this;
            }

            public Integer getAccuracy() {
                return accuracy;
            }

            public Passes setAccuracy(Integer accuracy) {
                this.accuracy = accuracy;
                return this;
            }
        }

        public static class Tackles {
            public Integer total;
            public Integer blocks;
            public Integer interceptions;

            // Getters and Setters


            public Integer getTotal() {
                return total;
            }

            public Tackles setTotal(Integer total) {
                this.total = total;
                return this;
            }

            public Integer getBlocks() {
                return blocks;
            }

            public Tackles setBlocks(Integer blocks) {
                this.blocks = blocks;
                return this;
            }

            public Integer getInterceptions() {
                return interceptions;
            }

            public Tackles setInterceptions(Integer interceptions) {
                this.interceptions = interceptions;
                return this;
            }
        }

        public static class Duels {
            public Integer total;
            public Integer won;

            // Getters and Setters


            public Integer getTotal() {
                return total;
            }

            public Duels setTotal(Integer total) {
                this.total = total;
                return this;
            }

            public Integer getWon() {
                return won;
            }

            public Duels setWon(Integer won) {
                this.won = won;
                return this;
            }
        }

        public static class Dribbles {
            public Integer attempts;
            public Integer success;
            public Integer past;

            // Getters and Setters


            public Integer getAttempts() {
                return attempts;
            }

            public Dribbles setAttempts(Integer attempts) {
                this.attempts = attempts;
                return this;
            }

            public Integer getSuccess() {
                return success;
            }

            public Dribbles setSuccess(Integer success) {
                this.success = success;
                return this;
            }

            public Integer getPast() {
                return past;
            }

            public Dribbles setPast(Integer past) {
                this.past = past;
                return this;
            }
        }

        public static class Fouls {
            public Integer drawn;
            public Integer committed;

            // Getters and Setters

            public Integer getDrawn() {
                return drawn;
            }

            public Fouls setDrawn(Integer drawn) {
                this.drawn = drawn;
                return this;
            }

            public Integer getCommitted() {
                return committed;
            }

            public Fouls setCommitted(Integer committed) {
                this.committed = committed;
                return this;
            }
        }

        public static class Cards {
            public Integer yellow;
            public Integer yellowred;
            public Integer red;

            // Getters and Setters


            public Integer getYellow() {
                return yellow;
            }

            public Cards setYellow(Integer yellow) {
                this.yellow = yellow;
                return this;
            }

            public Integer getYellowred() {
                return yellowred;
            }

            public Cards setYellowred(Integer yellowred) {
                this.yellowred = yellowred;
                return this;
            }

            public Integer getRed() {
                return red;
            }

            public Cards setRed(Integer red) {
                this.red = red;
                return this;
            }
        }

        public static class Penalty {
            public Integer won;
            public Integer committed;
            public Integer scored;
            public Integer missed;
            public Integer saved;

            // Getters and Setters


            public Integer getWon() {
                return won;
            }

            public Penalty setWon(Integer won) {
                this.won = won;
                return this;
            }

            public Integer getCommitted() {
                return committed;
            }

            public Penalty setCommitted(Integer committed) {
                this.committed = committed;
                return this;
            }

            public Integer getScored() {
                return scored;
            }

            public Penalty setScored(Integer scored) {
                this.scored = scored;
                return this;
            }

            public Integer getMissed() {
                return missed;
            }

            public Penalty setMissed(Integer missed) {
                this.missed = missed;
                return this;
            }

            public Integer getSaved() {
                return saved;
            }

            public Penalty setSaved(Integer saved) {
                this.saved = saved;
                return this;
            }


        }

    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "get='" + get + '\'' +
                ", parameters=" + parameters +
                ", errors=" + errors +
                ", results=" + results +
                ", paging=" + paging +
                ", response=" + response +
                '}';
    }
}
