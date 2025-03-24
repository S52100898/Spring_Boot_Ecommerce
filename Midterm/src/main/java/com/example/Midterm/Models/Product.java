package com.example.Midterm.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.NonNull;

@Entity
@Table(name = "products")
@Data
@ToString
@NoArgsConstructor
public class Product {
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String color;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Brand brand;

    @Builder
    public Product(@NonNull Category category, Long id, @NonNull String name, @NonNull Double price, @NonNull Brand brand, @NonNull String color) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
    }

    public String getCategoryName() {
        return this.category.getName();
    }

    public String getBrandName() {
        return this.brand.getName();
    }
}