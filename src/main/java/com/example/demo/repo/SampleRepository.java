package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Sample;

@RepositoryRestController
public interface SampleRepository extends CrudRepository<Sample, String>{

}
