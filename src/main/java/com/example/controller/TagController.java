package com.example.controller;

import com.example.model.Tag;
import com.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    @ResponseBody
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ResponseBody
    public Tag getTagById(@RequestParam(name = "id") Integer id) {
        return tagService.getTagById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ResponseBody
    public String deleteTag(@RequestParam(name = "id") Integer id) {
        return tagService.deleteTag(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseBody
    public String createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

}
