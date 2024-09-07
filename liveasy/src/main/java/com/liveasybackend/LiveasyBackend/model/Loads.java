package com.liveasybackend.LiveasyBackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loads {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String shipperId;

    @Column(nullable = false)
    String loadingPoint;

    @Column(nullable = false)
    String unloadingPoint;

    @Column(nullable = false)
    String productType;

    @Column(nullable = false)
    String truckType;

    @Column(nullable = false)
    String noOfTrucks;

    @Column(nullable = false)
    int weight;

    String Comment;
    String date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userDetails_Id")
    UserDetails userDetails;

}
