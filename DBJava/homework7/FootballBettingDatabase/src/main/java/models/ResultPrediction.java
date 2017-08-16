package models;

import javax.persistence.*;

/**
 * Created by Todor Popov using Lenovo on 24.7.2017 г. at 19:19.
 */

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {

    private Long id;
    private String prediction;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
