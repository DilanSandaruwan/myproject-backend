package com.ousl.myproject.repositories;

import com.ousl.myproject.models.dto.ItemCodeDto;
import com.ousl.myproject.models.dto.StyleDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StylesRepository extends JpaRepository<StyleDto,Long>{

}
