package com.java.happyfamily.persistence;

import com.java.happyfamily.model.orms.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
