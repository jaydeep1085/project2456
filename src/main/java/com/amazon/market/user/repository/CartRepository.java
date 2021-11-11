package com.amazon.market.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.market.user.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String>{

}
