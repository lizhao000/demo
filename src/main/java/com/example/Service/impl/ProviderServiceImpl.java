package com.example.Service.impl;

import com.example.Service.ProviderService;
import com.example.dao.ProviderMapper;
import com.example.entity.users.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{
    @Autowired
    ProviderMapper providerMapper;
    @Override
    public List<Provider> getProviders(Provider provider) {
        return providerMapper.getProviders(provider);
    }

    @Override
    public Provider getProviderByPid(Integer pid) {
        return providerMapper.getProviderByPid(pid);
    }

    @Override
    public int addProvider(Provider provider) {
        int i = providerMapper.addProvider(provider);
        return i;

    }

    @Override
    public int deleteProviderByPid(Integer pid) {
        providerMapper.deleteProviderByPid(pid);
        return 0;
    }

    @Override
    public int updateProvider(Provider provider) {
        int i = providerMapper.updateProvider(provider);
        return i;
    }
    @Override
    public int batchDelete(List<Long> ids){
        return providerMapper.batchDelete(ids);
    }

}
