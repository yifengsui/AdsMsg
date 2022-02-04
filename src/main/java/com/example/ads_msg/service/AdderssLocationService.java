package com.example.ads_msg.service;

import com.example.ads_msg.dao.po.AddressLocationPO;
import com.github.pagehelper.PageInfo;

public interface AdderssLocationService {
    Integer saveOrUpdateLocation(AddressLocationPO addressLocationPO);

    void delLocation(Integer id);

    AddressLocationPO queryLocationById(Integer id);

    PageInfo queryLocationList(int page, int pagesize, String addressName, String buildingLevel);

}


