package com.example.Service;

import com.example.entity.users.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getProviders(Provider provider);

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);
}
