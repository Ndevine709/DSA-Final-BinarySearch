package com.dsa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeStructureRepository extends JpaRepository<TreeStructure, Long> {
}
