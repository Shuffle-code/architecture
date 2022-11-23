package interview.lesson4.hw4;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
@Builder
@Getter
@Setter
public class Seance {
    private String title;
    private int lasting;
    private Time timeStart;
    private Time timeStartNext;
    private int pause;
}
