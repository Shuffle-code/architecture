package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table (name = "count")
public class CountGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name ="seq-gen",sequenceName="MY_SEQ_GEN", initialValue=205, allocationSize=12)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "set")
    private int set;
    @Column(name = "rating")
    private double rating;
    @Column(name = "delta")
    private double delta;
    @Column(name = "place")
    private int place;
}


