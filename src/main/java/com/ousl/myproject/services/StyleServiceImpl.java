package com.ousl.myproject.services;

import com.ousl.myproject.models.dto.StyleDto;
import com.ousl.myproject.models.enumModels.StatusCodes;
import com.ousl.myproject.models.requestResponse.Response;
import com.ousl.myproject.models.requestResponse.ResponseBody;
import com.ousl.myproject.models.requestResponse.ResponseHeader;
import com.ousl.myproject.repositories.StylesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService{

    @Autowired
    private StylesRepository stylesRepository;

    @Override
    public Response getAllStyles(){
        Response response = new Response();
        ResponseHeader responseHeader = new ResponseHeader();
        ResponseBody responseBody = new ResponseBody();

        try{
            List<StyleDto> all = this.stylesRepository.findAll();

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
        }catch(Exception e){
            responseHeader.setResultCode(StatusCodes.INTERNAL_ERROR.value);
            responseHeader.setResultDescription(StatusCodes.INTERNAL_ERROR.toString());
        }
        response.setResponseHeader(responseHeader);
        return response;
    }

    @Override
    public Response createStyle(StyleDto[] newStyle){
        Response response = new Response();
        ResponseHeader responseHeader = new ResponseHeader();

        try{
            if(newStyle.length > 0){
                for (StyleDto dto: newStyle) {
                    if(dto != null){
                        this.stylesRepository.save(dto);
                        responseHeader.setResultCode(StatusCodes.SUCCESS.value);
                        responseHeader.setResultDescription(StatusCodes.SUCCESS.toString());
                    }
                }
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

    @Override
    public Response deleteStyle(StyleDto styleDto){
        Response response = new Response();
        ResponseHeader responseHeader = new ResponseHeader();

        try{
            if(styleDto.getId() != null){
                this.stylesRepository.deleteById(styleDto.getId());
                responseHeader.setResultCode(StatusCodes.SUCCESS.value);
                responseHeader.setResultDescription(StatusCodes.SUCCESS.toString());
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
