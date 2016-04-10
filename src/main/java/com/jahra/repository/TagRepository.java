package com.jahra.repository;

import com.jahra.model.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * Created by Артём on 07.02.2016.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("select t.name from Tag t " +
            "join t.articles a " +
            "group by t.id order by count(a) DESC")
    List<String> getMostPopular(Pageable pageable);

    List<Tag> findByNameIn(Collection<String> tagNames);

    Tag findByName(String name);
}
