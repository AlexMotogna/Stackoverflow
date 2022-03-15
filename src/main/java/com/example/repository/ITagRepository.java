package com.example.repository;

import com.example.model.Tag;
import org.springframework.data.repository.CrudRepository;

public interface ITagRepository extends CrudRepository<Tag, Integer> {
}
