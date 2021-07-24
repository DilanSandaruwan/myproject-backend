package com.ousl.myproject.services;

import com.ousl.myproject.models.dto.CategoryDto;
import com.ousl.myproject.models.enumModels.StatusCodes;
import com.ousl.myproject.models.projection.CategoryProjection;
import com.ousl.myproject.models.requestResponse.Response;
import com.ousl.myproject.models.requestResponse.ResponseBody;
import com.ousl.myproject.models.requestResponse.ResponseHeader;
import com.ousl.myproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Response getCategories(){
        Response response = new Response();
        ResponseHeader responseHeader = new ResponseHeader();
        ResponseBody responseBody = new ResponseBody();
        try {
            List<CategoryDto> all = this.categoryRepository.findAll();

            if(!all.isEmpty()){
                responseHeader.setResultCode(StatusCodes.SUCCESS.value);
                responseHeader.setResultDescription(StatusCodes.SUCCESS.toString());
                responseBody.setBody(all);
                response.setResponseBody(responseBody);
                System.out.println(all);
            }else{
                responseHeader.setResultCode(StatusCodes.NOT_FOUND.value);
                responseHeader.setResultDescription(StatusCodes.NOT_FOUND.toString());
            }

        }catch (Exception e){
            responseHeader.setResultCode(StatusCodes.INTERNAL_ERROR.value);
            responseHeader.setResultDescription(StatusCodes.INTERNAL_ERROR.toString());
        }
        response.setResponseHeader(responseHeader);
        return response;

    }
}
