package com.mirkowu.olddriver.network.api;


import com.mirkowu.olddriver.bean.JokeBean;
import com.mirkowu.olddriver.bean.LiveBean;
import com.mirkowu.olddriver.bean.TypeBean;
import com.mirkowu.olddriver.constants.Constants;
import com.mirkowu.olddriver.network.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by MirkoWu on 2017/3/23 0023.
 */

public interface ApiService {


    @GET
    Observable<BaseBean<List<TypeBean>>> getTypeList(@Url String url);

    @GET(Constants.URL_JOKE)
    Observable<BaseBean<JokeBean>> getJokeList();

    @GET
    Observable<LiveBean> getLiveList(@Url String url);


}
