package com.example.dao;



import com.example.entity.users.Provider;

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

}
