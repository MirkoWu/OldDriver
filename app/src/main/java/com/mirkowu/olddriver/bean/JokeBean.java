package com.mirkowu.olddriver.bean;

import android.databinding.BaseObservable;

import java.util.List;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public class JokeBean extends BaseObservable {


    private List<DataBean> data;


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends BaseObservable {
        /**
         * group : {"text":"男票喝醉了，朋友给我打电话，让我去照顾他。他神智不清，满口酒话，刚弄到床上，就趴下睡着了。一会，他突然坐了起来，拿起手机，急忙忙地打了几个字，又呼呼睡去\u2026\u2026我的手机消息通知响了，我看到了\u201c晚安\u201d两个字。。。","dislike_reason":[{"type":1,"id":303,"title":"情侣夫妻"},{"type":1,"id":302,"title":"糗人糗事"},{"type":2,"id":1,"title":"吧:内涵段子"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":66655781798,"title":"作者:不闻不舞rg"}],"create_time":1504058593,"id":67676050648,"favorite_count":4560,"go_detail_count":877160,"category_activity_schema_url":"","user_favorite":0,"share_type":0,"category_activity_text":"","user":{"user_id":66655781798,"name":"不闻不舞rg","followings":0,"user_verified":false,"ugc_count":65,"avatar_url":"http://p1.pstatp.com/medium/382b00032b5ddeb4b6e6","followers":401,"is_following":false,"is_pro_user":false,"medals":[]},"is_can_share":1,"category_type":1,"share_url":"http://m.neihanshequ.com/share/group/67676050648/?iid=0&app=joke_essay","label":1,"content":"男票喝醉了，朋友给我打电话，让我去照顾他。他神智不清，满口酒话，刚弄到床上，就趴下睡着了。一会，他突然坐了起来，拿起手机，急忙忙地打了几个字，又呼呼睡去\u2026\u2026我的手机消息通知响了，我看到了\u201c晚安\u201d两个字。。。","comment_count":2471,"id_str":"67676050648","media_type":0,"share_count":2320,"type":3,"status":112,"has_comments":1,"user_bury":0,"status_desc":"热门投稿","category_activity_end_time":0,"display_type":0,"user_digg":0,"online_time":1504058593,"category_name":"内涵段子","category_visible":true,"bury_count":4149,"is_anonymous":false,"repin_count":4560,"digg_count":140477,"has_hot_comments":0,"category_show_ranking":0,"category_activity_start_time":0,"category_is_activity":0,"user_repin":0,"activity":{},"group_id":67676050648,"allow_dislike":true,"category_id":1}
         * comments : [{"text":"嫁了吧","create_time":1504060057,"user_verified":false,"user_bury":0,"user_id":6319978382,"bury_count":0,"share_url":"http://m.neihanshequ.com/share/group/67676050648/?comment_id=1577121278132301","id":1577121278132301,"platform":"feifei","is_digg":0,"user_name":"活泼的路人","user_profile_image_url":"http://wx.qlogo.cn/mmopen/4elbQCnSaLKkKWxFHwxAztCqHbE1hh0Vw6sF9PjWr7MwHr9uHTpayeTEAKTGeLmcHrJ9icrsb4icYpZ4Z45vKdw9qgUvlQotKD/64","medals":[],"status":5,"description":"","comment_id":1577121278132301,"user_digg":0,"user_profile_url":"","share_type":2,"digg_count":166797,"is_pro_user":false,"platform_id":"feifei","avatar_url":"http://wx.qlogo.cn/mmopen/4elbQCnSaLKkKWxFHwxAztCqHbE1hh0Vw6sF9PjWr7MwHr9uHTpayeTEAKTGeLmcHrJ9icrsb4icYpZ4Z45vKdw9qgUvlQotKD/64","group_id":67676050648}]
         * type : 1
         * display_time : 1506017853
         * online_time : 1506017853
         */

        private GroupBean group;

        public GroupBean getGroup() {
            return group;
        }

        public void setGroup(GroupBean group) {
            this.group = group;
        }


        public static class GroupBean extends BaseObservable {

            private UserBean user;


            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }


            public static class UserBean extends BaseObservable {

                /**
                 * user_id : 66655781798
                 * name : 不闻不舞rg
                 * followings : 0
                 * user_verified : false
                 * ugc_count : 65
                 * avatar_url : http://p1.pstatp.com/medium/382b00032b5ddeb4b6e6
                 * followers : 401
                 * is_following : false
                 * is_pro_user : false
                 * medals : []
                 */

                private long user_id;
                private String name;
                private int followings;
                private boolean user_verified;
                private int ugc_count;
                private String avatar_url;
                private int followers;
                private boolean is_following;
                private boolean is_pro_user;

                public long getUser_id() {
                    return user_id;
                }

                public void setUser_id(long user_id) {
                    this.user_id = user_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getFollowings() {
                    return followings;
                }

                public void setFollowings(int followings) {
                    this.followings = followings;
                }

                public boolean isUser_verified() {
                    return user_verified;
                }

                public void setUser_verified(boolean user_verified) {
                    this.user_verified = user_verified;
                }

                public int getUgc_count() {
                    return ugc_count;
                }

                public void setUgc_count(int ugc_count) {
                    this.ugc_count = ugc_count;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public int getFollowers() {
                    return followers;
                }

                public void setFollowers(int followers) {
                    this.followers = followers;
                }

                public boolean isIs_following() {
                    return is_following;
                }

                public void setIs_following(boolean is_following) {
                    this.is_following = is_following;
                }

                public boolean isIs_pro_user() {
                    return is_pro_user;
                }

                public void setIs_pro_user(boolean is_pro_user) {
                    this.is_pro_user = is_pro_user;
                }


            }


        }
    }
}
