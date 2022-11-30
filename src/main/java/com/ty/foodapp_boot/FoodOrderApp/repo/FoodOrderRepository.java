package com.ty.foodapp_boot.FoodOrderApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp_boot.FoodOrderApp.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}
