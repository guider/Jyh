package com.yanyuanquan.android.jyh.api;

import com.yanyuanquan.android.jyh.entity.Main;


import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by apple on 16/3/14.
 */
public interface ApiService {


    @GET("api/{num}")
    Observable<Main> getList(@Path("num") String id);
    @GET("api/getlist.php?markid={id}&country=us")
    Observable<Main> getGlobalList(@Path("id") String id);


}
