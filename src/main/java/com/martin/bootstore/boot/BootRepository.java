package com.martin.bootstore.boot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootRepository extends JpaRepository<Boot, Long> {

}
