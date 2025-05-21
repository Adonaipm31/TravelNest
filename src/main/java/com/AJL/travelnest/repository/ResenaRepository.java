package com.AJL.travelnest.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.AJL.travelnest.entity.Resena;

@Repository
public interface ResenaRepository extends MongoRepository<Resena, String>{

}
