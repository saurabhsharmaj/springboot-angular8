package com.sample.im.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.im.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
