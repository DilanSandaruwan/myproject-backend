package com.ousl.myproject.repositories;

import com.ousl.myproject.models.dto.CategoryDto;
import com.ousl.myproject.models.projection.CategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryDto,Long> {
//    List<CategoryProjection> findAllByValueAndLabel();
}
