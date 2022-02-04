package com.example.ads_msg.controller;

import com.example.ads_msg.config.Response;
import com.example.ads_msg.dao.po.AddressLocationPO;
import com.example.ads_msg.service.AdderssLocationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/addresslocation")
@Slf4j
@RestController
@CrossOrigin

public class AddressLocationController {
    @Autowired
    AdderssLocationService addressLocationService;

    @PostMapping("/saveOrUpdateLocation")
    @ApiOperation(value = "新增或修改",notes = "新增或修改")
    public Response saveOrUpdataLocation(@RequestBody AddressLocationPO addressLocationPO){
        Integer id = addressLocationPO.getId();
        if(id == null){
            return  Response.error("id参数为空",
                    "",id);
        }

        try {
            addressLocationService.saveOrUpdateLocation(addressLocationPO);
            return Response.success("操作成功",addressLocationPO.getId());
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("操作失败"+e.toString(),null);
        }
    }


    @GetMapping("/delLocation")
    @ApiOperation(value = "删除",notes = "删除")
    public Response delLocation(@RequestParam Integer id){
        if(id == null){
            return  Response.error("id参数为空",
                    "",id);
        }
        try {
            addressLocationService.delLocation(id);
            return Response.successToJson("操作成功",id);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("操作失败"+e.toString(),null);
        }
    }


    @GetMapping("/queryLocationById")
    @ApiOperation(value = "查询详情",notes = "查询详情")
    public Response queryLocationById(@RequestParam Integer id){
        if(id == null){
            return  Response.error("id参数为空",
                    "",id);
        }
        try {
            addressLocationService.queryLocationById(id);
            return Response.successToJson("操作成功",id);
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("操作失败"+e.toString(),null);
        }
    }


    @GetMapping("/queryLocationList")
    @ApiOperation(value = "多参数查询",notes = "多参数查询")

    public Response queryLocationList(
            @RequestParam("page") int page, @RequestParam("pageSize") int pageSize,
            @RequestParam(required = false) String addressName,@RequestParam(required = false) String buildingLevel) {
        try {
            return Response.success("执行成功",addressLocationService.queryLocationList(page,pageSize,addressName,buildingLevel));
        }catch (Exception e){
            e.printStackTrace();
            return Response.error("操作失败"+e.toString(),null);
        }
    }





}
