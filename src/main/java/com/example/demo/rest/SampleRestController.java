package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Sample;
import com.example.demo.repo.SampleRepository;

@RequestMapping("/rest/samples")
@RestController
public class SampleRestController {
	@Autowired
	SampleRepository repository;
	
	@RequestMapping(value="", method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Sample>> getAllSamples() {
		List<Sample> samples = new ArrayList<>();
		
		repository.findAll().iterator().forEachRemaining(samples::add);

		return new ResponseEntity<List<Sample>>(samples, HttpStatus.OK);
	}	

	@RequestMapping(value="", method=RequestMethod.POST, 
			produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Sample> addSample(@RequestBody Sample sample) {
		if(repository.findById(sample.getId()).isPresent()) {
			return new ResponseEntity<Sample>(HttpStatus.CONFLICT);
		}
		
		repository.save(sample);
		
		return new ResponseEntity<Sample>(sample, HttpStatus.OK);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Sample> getById(@PathVariable("id") String id) {
		Optional<Sample> sample = repository.findById(id);
		
		if(sample.isPresent()) {
			return new ResponseEntity<Sample>(sample.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Sample>(HttpStatus.NOT_FOUND);
	}
	

}
