package com.jahra.service.impl;

import com.jahra.model.Tag;
import com.jahra.repository.TagRepository;
import com.jahra.service.TagService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author a.vorushenko
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> saveTags(List<String> tags) {
        List<Tag> alreadySavedTags = tagRepository.findByNameIn(tags);
        for (Tag tag : alreadySavedTags ) {
            tags.remove(tag.getName());
        }
        for (String tag : tags) {
            Tag toSave = new Tag();
            toSave.setName(tag);
            alreadySavedTags.add(tagRepository.save(toSave));
        }
        return alreadySavedTags;
    }

    @Override
    public List<Tag> getPopularTags(Pageable offset) {
        return null;
    }

    @Override
    @Transactional
    public Tag findByName(String name) {
        Tag tag =  tagRepository.findByName(name);
        Hibernate.initialize(tag.getArticles());
        return tag;
    }
}
