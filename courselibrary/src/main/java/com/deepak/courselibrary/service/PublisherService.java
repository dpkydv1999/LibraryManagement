package com.deepak.courselibrary.service;


import com.deepak.courselibrary.entity.Publisher;
import com.deepak.courselibrary.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }
    public Publisher findPublisherById(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() ->new RuntimeException("Publisher Not Found"));
        return publisher;
    }
    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }
    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }
    public void deletePublisher(Long id){
        Publisher publisher = publisherRepository.findById(id).orElseThrow(() ->new RuntimeException("Publisher Not Found"));
        publisherRepository.deleteById(publisher.getId());
    }


}
