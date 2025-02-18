package com.dreamshopbackend.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long image_id;
        private String file_name;
        private String file_type;
        List<String> download_url;
        private Blob image;

        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;
}
