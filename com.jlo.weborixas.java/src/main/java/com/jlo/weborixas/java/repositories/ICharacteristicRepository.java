package com.jlo.weborixas.java.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.jlo.weborixas.java.models.Characteristic;


@EnableScan
public interface ICharacteristicRepository extends CrudRepository<Characteristic, String> {

	List<Characteristic> findById(String id);
}
