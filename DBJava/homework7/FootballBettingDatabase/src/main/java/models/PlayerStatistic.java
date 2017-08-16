package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 20:23.
 */

@Entity
@IdClass(value = PlayerStatistic.PlayerStatisticId.class)
@Table(name = "player_statistics")
public class PlayerStatistic {

    private Long gameId;
    private Long playerId;


    private Game game;
    private Player player;

    private Integer scoredGoals;
    private Integer playerAssists;
    private Integer playedMinutes;

    @Id
    @Column(name = "game_id")
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Id
    @Column(name = "player_id")
    public Long getPlayerId() {
        return playerId;
    }


    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    @MapsId("game_id")
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @MapsId("player_id")
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes")
    public Integer getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(Integer playedMinutes) {
        this.playedMinutes = playedMinutes;
    }



    static class PlayerStatisticId implements Serializable {
        private Long gameId;        //same type as the Id in the GAME class
        private Long playerId;      //same type as the Id in the GAME class

        public PlayerStatisticId() {
        }

        public PlayerStatisticId(Long gameId, Long playerId) {
            this.gameId = gameId;
            this.playerId = playerId;
        }

        public Long getGameId() {
            return gameId;
        }

        public void setGameId(Long gameId) {
            this.gameId = gameId;
        }

        public Long getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Long playerId) {
            this.playerId = playerId;
        }
    }
}
