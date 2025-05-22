package ru.yandex.practicum.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Item {
    @Id
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "url")
    private String url;
}
