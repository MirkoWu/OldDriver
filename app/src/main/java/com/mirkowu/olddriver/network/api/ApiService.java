package com.mirkowu.olddriver.network.api;


import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.bean.LiveBean;
import com.mirkowu.olddriver.bean.TypeBean;
import com.mirkowu.olddriver.constants.HostUrl;
import com.mirkowu.olddriver.network.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by MirkoWu on 2017/3/23 0023.
 */

public interface ApiService {


    @GET
    Observable<BaseBean<List<TypeBean>>> getTypeList(@Url String url);

    //目前推荐的是-101，视频的是-104，段友秀的是-301，图片的是-103，段子的是-102

    /**
     * @param content_type 目前推荐的是-101，视频的是-104，段友秀的是-301，图片的是-103，段子的是-102
     * @param count        返回数量
     * @param am_city      城市名，例如：北京市。可为空
     * @param min_time     上次更新时间的 Unix 时间戳，秒为单位
     * @param ac           网络环境，可取值 wifi
     * @return
     */
    @GET(HostUrl.URL_JOKE)
    Observable<BaseBean<JokeBean>> getJokeList(
            @Query("content_type") int content_type,
            @Query("count") int count,
            @Query("webp") int webp,
            @Query("am_city") String am_city,
            @Query("min_time") String min_time,
            @Query("ac") String ac
    );

    @GET
    Observable<LiveBean> getLiveList(@Url String url);


}
