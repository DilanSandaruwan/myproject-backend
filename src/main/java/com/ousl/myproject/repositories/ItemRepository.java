package com.ousl.myproject.repositories;

import com.ousl.myproject.models.dto.ItemCodeDto;
import com.ousl.myproject.models.projection.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemCodeDto,Long> {

    //List<ItemProjection> findAllByValueAndLabel();
}
