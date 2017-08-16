package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 19:20.
 */

@Entity
@IdClass(value = BetGame.BetGameId.class)
@Table(name = "bet_games")
public class BetGame {
    private Long gameId;
    private Long betId;


    private Game game;
    private Bet bet;

    private ResultPrediction resultPrediction;


    @Id
    @Column(name = "game_id")
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    @Id
    @Column(name = "bet_id")
    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
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

    @MapsId("bet_id")
    @ManyToOne
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }


    @ManyToOne
    @JoinColumn(name = "result_prediction",referencedColumnName = "id")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }

    static class BetGameId implements Serializable {
        private Long gameId;
        private Long betId;


        public BetGameId() {
        }

        public BetGameId(Long gameId, Long betId) {
            this.gameId = gameId;
            this.betId = betId;
        }

        public Long getGameId() {
            return gameId;
        }

        public void setGameId(Long gameId) {
            this.gameId = gameId;
        }

        public Long getBetId() {
            return betId;
        }

        public void setBetId(Long betId) {
            this.betId = betId;
        }
    }

}
