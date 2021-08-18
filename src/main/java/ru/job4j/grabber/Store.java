package ru.job4j.grabber;

import java.time.LocalDateTime;
import java.util.List;

public interface Store {
    void save(Post post);

    List<Post> getAll();

    Post findById(int id);

    public LocalDateTime isMaxData();
}
