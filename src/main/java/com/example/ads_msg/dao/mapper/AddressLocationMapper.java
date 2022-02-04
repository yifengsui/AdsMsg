package com.example.ads_msg.dao.mapper;

import com.example.ads_msg.dao.po.AddressLocationPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper

public interface AddressLocationMapper {
    AddressLocationPO selectByPrimaryKey(Integer id);

    List<AddressLocationPO> queryAddressLocationMapperByAddressName(@Param("page") int page,@Param("pageSize") int pageSize,
            @Param("addressName") String addressName, @Param("buildingLevel") String buildingLevel);

    int delByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddressLocationPO record);

    int updateByPrimaryKey(AddressLocationPO record);

    int insert(AddressLocationPO record);

    int insertSelective(AddressLocationPO record);

}
