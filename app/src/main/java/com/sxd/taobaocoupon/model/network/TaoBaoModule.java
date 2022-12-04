package com.sxd.taobaocoupon.model.network;

import com.sxd.taobaocoupon.util.ConstantsUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TaoBaoModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ConstantsUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ITaoBaoAPI provideTaoBaoCall(Retrofit retrofit) {
        return retrofit.create(ITaoBaoAPI.class);
    }
}
