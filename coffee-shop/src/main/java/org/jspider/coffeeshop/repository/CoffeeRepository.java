package org.jspider.coffeeshop.repository;

import org.jspider.coffeeshop.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee,Integer> {

}
