package com.jahra.service;

import com.jahra.model.Tag;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Артём on 01.03.2016.
 */
public interface TagService {
    List<Tag> saveTags(List<String> tags);
    List<Tag> getPopularTags(Pageable offset);
    Tag findByName(String name);
}
