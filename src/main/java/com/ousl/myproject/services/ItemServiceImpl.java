package com.ousl.myproject.services;

import com.ousl.myproject.models.dto.ItemCodeDto;
import com.ousl.myproject.models.enumModels.StatusCodes;
import com.ousl.myproject.models.projection.ItemProjection;
import com.ousl.myproject.models.requestResponse.Response;
import com.ousl.myproject.models.requestResponse.ResponseBody;
import com.ousl.myproject.models.requestResponse.ResponseHeader;
import com.ousl.myproject.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Response getItems(){
        Response response = new Response();
        ResponseHeader responseHeader = new ResponseHeader();
        ResponseBody responseBody = new ResponseBody();
        try {
            List<ItemCodeDto> all = this.itemRepository.findAll();

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
