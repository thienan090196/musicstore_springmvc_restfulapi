package com.nashtech.musicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="album", schema = "musicstore")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumID", nullable = false)
    private Integer albumId;

    @Column(name = "GenreID", insertable = false, updatable = false)
    private Integer genreId;

    @ManyToOne
    @JoinColumn(name = "GenreID", nullable = false)
    private Genre genre;

    @Column(name = "ArtistID", insertable = false, updatable = false)
    private Integer artistId;

    @ManyToOne
    @JoinColumn(name = "ArtistID", nullable = false)
    private Artist artist;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "ImagePath", nullable = false)
    private String imagePath;

    @Column(name = "CreatedAt", nullable = false)
    private Timestamp createdAt;

    @Column(name = "ModifiedAt", nullable = false)
    private Timestamp modifiedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Transient
    private int quantity;
}
