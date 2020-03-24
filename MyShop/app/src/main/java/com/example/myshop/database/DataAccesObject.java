package com.example.myshop.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataAccesObject {

    @Insert
    public void addProduct(Product product);

    @Query("Select * from products")
    public List<Product> getUsers();

}
