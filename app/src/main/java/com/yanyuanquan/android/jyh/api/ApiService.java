package com.yanyuanquan.android.jyh.api;

import com.yanyuanquan.android.jyh.entity.Main;
import com.yanyuanquan.android.jyh.entity.TrankList;


import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by apple on 16/3/14.
 */
public interface ApiService {

    //   国内列表
    @GET("api/getlist.php")
    Observable<Main> getList(@Query("count") String count, @Query("sinceid") String sinceid);

    // 国外列表
    @GET("api/getlist.php")
    Observable<Main> getGlobalList(@Query("country") String country, @Query("count") String count, @Query("sinceid") String sinceid);

    //小时热搜榜
    @GET("api/getranklist.php")
    Observable<TrankList> getTrankList();

    // 搜索接口
    @GET("api/getresult.php")
    Observable<TrankList> search();
}
