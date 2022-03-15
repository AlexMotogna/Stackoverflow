package com.example.service;

import com.example.model.Tag;
import com.example.model.User;
import com.example.repository.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    ITagRepository iTagRepository;

    public String createTag(Tag tag) {
        try {
            iTagRepository.save(tag);
            return "Creation success.";
        } catch (Exception e) {
            return "Creation failed.";
        }
    }

    public List<Tag> getAllTags()  {
        return (List<Tag>) iTagRepository.findAll();
    }

    public Tag getTagById(Integer id)  {
        return iTagRepository.findById(id).orElse(null);
    }

    public String deleteTag(Integer id) {
        try {
            iTagRepository.delete(this.getTagById(id));
            return "Delete success.";
        } catch (Exception e) {
            return "Delete failed.";
        }
    }

}
