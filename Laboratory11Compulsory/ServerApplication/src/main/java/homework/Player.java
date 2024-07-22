package homework;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "players")
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @Column(name = "playerNumber")
    private int playerNumber;
    public Player(){
        this.name = null;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerNumber=" + playerNumber +
                '}';
    }
}
