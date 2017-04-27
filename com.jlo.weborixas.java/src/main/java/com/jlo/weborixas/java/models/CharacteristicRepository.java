package com.jlo.weborixas.java.models;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface CharacteristicRepository extends CrudRepository<Characteristic, String> {

	List<Characteristic> findById(String id);
}
