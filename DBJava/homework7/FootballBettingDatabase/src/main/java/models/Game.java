package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Todor Popov using Lenovo on 23.7.2017 г. at 2:40.
 */

@Entity
@Table(name = "games")
public class Game {

    private Long id;
    private Team homeTeam;
    private Team awayTeam;
    private Integer homeTeamGoals;
    private Integer awayTeamGoals;
    private Date dateTime;
    private BigDecimal homeTeamWinBetRate;
    private BigDecimal awayTeamWinBetRate;
    private BigDecimal drawTeamBetRate;
    private Round round;
    private Competition competition;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne()
    @JoinColumn(name = "home_team",referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @OneToOne()
    @JoinColumn(name = "away_team",referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "away_team_goals")
    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column(name = "date_time")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "home_time_win_bet_rate")
    public BigDecimal getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }


    public void setHomeTeamWinBetRate(BigDecimal homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_time_win_bet_rate")
    public BigDecimal getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(BigDecimal awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_time_bet_rate")
    public BigDecimal getDrawTeamBetRate() {
        return drawTeamBetRate;
    }

    public void setDrawTeamBetRate(BigDecimal drawTeamBetRate) {
        this.drawTeamBetRate = drawTeamBetRate;
    }

    @ManyToOne
    @JoinColumn(name = "round_id",referencedColumnName = "id")
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne
    @JoinColumn(name = "competiton_id",referencedColumnName = "id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
