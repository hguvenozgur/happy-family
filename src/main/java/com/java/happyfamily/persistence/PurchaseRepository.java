package com.java.happyfamily.persistence;

import com.java.happyfamily.model.orms.PurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseModel, Integer> {
}
