package com.ravindra.springbootiptracing.repo;

import com.ravindra.springbootiptracing.entity.IPLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPLocationRepo extends CrudRepository<IPLocation, Long> {
    void deleteByIp(String ip);

   // boolean existsByIp(String ip);

    Optional<IPLocation> findByIp(String ip);

    /*@Query(value = "delete from{h-shema}IP_LOCATION_TB where ip =:ip", nativeQuery = true)
    void deleteIpDetails(@Param("ip") String ip);

     */

}

