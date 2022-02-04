package com.example.ads_msg.serviceImpl;

import com.example.ads_msg.config.CommonlyUsedParameter;
import com.example.ads_msg.dao.mapper.AddressLocationMapper;
import com.example.ads_msg.dao.po.AddressLocationPO;
import com.example.ads_msg.service.AdderssLocationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Slf4j

public class AddressLocationServiceImpl implements AdderssLocationService {

    @Autowired
    AddressLocationMapper addressLocationMapper;
    @Override
    public AddressLocationPO queryLocationById(Integer id){

        return addressLocationMapper.selectByPrimaryKey(id);
    }


    @Override
    public PageInfo queryLocationList(int page, int pageSize, String addressName, String buildingLevel){
        PageHelper.startPage(page,pageSize);
        List<AddressLocationPO> queryLocationList = addressLocationMapper.queryAddressLocationMapperByAddressName(
                page,pageSize,addressName,buildingLevel);
        log.info("查询成功");
        return new PageInfo(queryLocationList);
    }



    @Override
    public Integer saveOrUpdateLocation(AddressLocationPO addressLocationPO){
        Date date =new Date();
        if(addressLocationPO.getId()!=0) {
            addressLocationPO.setGmtModified(date);
            return addressLocationMapper.updateByPrimaryKeySelective(addressLocationPO);
        }else {
            addressLocationPO.setGmtCreate(date);
            addressLocationPO.setIsValid(CommonlyUsedParameter.IS_VALID);
            return addressLocationMapper.insertSelective(addressLocationPO);
        }
    }


    @Override
    public void delLocation(Integer id){
        Date date =new Date();
        AddressLocationPO po= addressLocationMapper.selectByPrimaryKey(id);
        if(po !=null){
            po.setIsValid(CommonlyUsedParameter.NOT_VALID);
            po.setGmtModified(date);
            addressLocationMapper.updateByPrimaryKey(po);
        }
    }



}
