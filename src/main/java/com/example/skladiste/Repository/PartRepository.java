package com.example.skladiste.Repository;

import com.example.skladiste.Model.CarBrand;
import com.example.skladiste.Model.CarModel;
import com.example.skladiste.Model.Category;
import com.example.skladiste.Model.Parts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartRepository extends JpaRepository<Parts,Long> {

    @Query("SELECT p FROM Parts p LEFT JOIN p.carModel m LEFT JOIN m.carBrand b WHERE p.category = :category AND m = :model AND b = :brand")
    public Page<Parts> findPartsBySearch(@Param("brand") CarBrand brand,@Param("model") CarModel model, @Param("category") Category category, Pageable pageable);

    @Query("SELECT p FROM Parts p INNER JOIN p.carModel m INNER JOIN m.carBrand b " +
            "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "OR LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%'))" +
            "OR LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    public Page<Parts> searchByName(@Param("name") String name,Pageable pageable);


}
