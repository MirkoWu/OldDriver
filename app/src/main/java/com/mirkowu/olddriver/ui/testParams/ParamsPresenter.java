package com.mirkowu.olddriver.ui.testParams;

import com.google.gson.Gson;
import com.mirkowu.olddriver.network.NetworkTransformerHelper;
import com.mirkowu.olddriver.network.RetrofitManager;
import com.softgarden.baselibrary.base.BasePresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public class ParamsPresenter extends BasePresenter<ParamsContract.Display> implements ParamsContract.Presenter {


    @Override
    public void orderAdd() {

        String buys = "1562,1,0,0|1684,1,0,0";
        String address_id = "38";
        String remark = "{\"8\":\"留言88888jsonsjsons\",\"1\":\"留言11111111jsonsjsons\"}";
        String token = "06c2247b70683161dc170bd91c8e0869";
        String user_id = "21";
        String url = "http://guocai.test2.ruanjiekeji.com/App/Order/orderAdd";

        HashMap<String, String> remarkMap = new HashMap<String, String>();
        remarkMap.put("1", "留言第11212");
        remarkMap.put("8", "留言88888");

        //       Map<String, RequestBody> data = new HashMap<>();
//        data.put("buys", RequestBody.create(null,remarkMap));
//        data.put("address_id", address_id);
//        data.put("remark", remarkMap.toString());
//        data.put("token", token);
//        data.put("user_id", user_id);

        SubmitBean submitBean = new SubmitBean(user_id, token, buys, address_id, remarkMap);
        Gson gson = new Gson();
        String data = gson.toJson(submitBean);


        RetrofitManager.getApiService()
                // .orderAdd(url, data,MD5Util.ToMD5(Constants.MD5_KEY, data))
               //  .orderAdd(url,token,user_id, buys,address_id,new JSONObject(remarkMap))
               // .orderAdd(url, token, user_id, buys, address_id, remark)
                .orderAdd(url,submitBean)
                .compose(new NetworkTransformerHelper<>(mView))
                .subscribe(mView::orderAdd, mView::showError);

    }

    public static class PostBean {
        public String data;
        public String apisign;

        public PostBean(String data, String apisign) {
            this.data = data;
            this.apisign = apisign;
        }


    }

    public static class SubmitBean {
        public String user_id;
        public String token;
        public String buys;
        public String address_id;
        public Map<String, String> remark;

        public SubmitBean(String user_id, String token, String buys, String address_id, Map<String, String> remark) {
            this.user_id = user_id;
            this.token = token;
            this.buys = buys;
            this.address_id = address_id;
            this.remark = remark;
        }
    }
}
