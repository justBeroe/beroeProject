package bg.softuni.beroe.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "players")
public class PlayerEntity extends BaseEntity{


    String playerName;

    String position;

    public String getPlayerName() {
        return playerName;
    }

    public PlayerEntity setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public PlayerEntity setPosition(String position) {
        this.position = position;
        return this;
    }
}
