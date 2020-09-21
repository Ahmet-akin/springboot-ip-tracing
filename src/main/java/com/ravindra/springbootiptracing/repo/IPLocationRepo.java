package com.ravindra.springbootiptracing.repo;

import com.ravindra.springbootiptracing.entity.IPLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPLocationRepo extends CrudRepository<IPLocation, Long> {
}
