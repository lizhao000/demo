package com.example.dao;



import com.example.entity.users.Provider;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * @Auther: 梦学谷
 */
//@Mapper 或 @MapperScan("com.mengxuegu.springboot.mapper")
public interface ProviderMapper {

    List<Provider> getProviders(Provider provider);

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);

    int batchDelete(@Param("list") List<Long> ids);

    List<Provider> getProvideris(@Param("isDeleted")String isDeleted);

}
