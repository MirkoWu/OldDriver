package com.mirkowu.olddriver.bean;

import java.util.List;

/**
 * Created by MirkoWu on 2017/9/22 0022.
 */

public class LiveBean {

    /**
     * status_code : 0
     * data : [{"type":1,"rid":"201703112108510100030480291753B5","data":{"status":2,"user_count":460,"stats":{"money":540,"fan_ticket":108,"id":6396222601244445442,"total_user":1428,"id_str":"6396222601244445442"},"title":"35071926529","finish_time":1489237726,"enable_room_perspective":true,"share_url":"https://www.huoshan.com/share/room/6396222601244445442/","id":6396222601244445442,"stream_id":6396222601387051777,"create_time":1489236625,"cell_style":3,"id_str":"6396222601244445442","stream_url":{"rtmp_pull_url":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6396222601387051777.flv","provider":2,"id":6396222601387051777,"id_str":"6396222601387051777"},"dynamic_cover_low":null,"owner":{"avatar_large":{"url_list":["http://p3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp"],"uri":"1080x1080/123f0003b79889feafa6"},"signature":"","birthday_description":"未知年龄","birthday":0,"allow_others_download_video":true,"stats":{"record_count":46,"following_count":2,"total_duration":112387,"daily_income":0,"item_count":0,"daily_fan_ticket_count":0,"id_str":"55538074947","follower_count":967,"diamond_count":0,"id":55538074947,"diamond_consumed_count":0},"avatar_thumb":{"url_list":["http://p3.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/100x100/123f0003b79889feafa6.webp"],"uri":"100x100/123f0003b79889feafa6"},"constellation":"谜之星座","id":55538074947,"city":"上海","fan_ticket_count":39547,"verified":false,"follow_status":0,"short_id":82856196,"level":1,"push_comment_status":true,"nickname":"tansy甜","birthday_valid":false,"verified_reason":"","pay_grade":{"diamond_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aba3dd42e213","http://pb2.pstatp.com/obj/12400003aba3dd42e213","http://pb3.pstatp.com/obj/12400003aba3dd42e213"],"uri":"12400003aba3dd42e213"},"next_name":"树叶","total_diamond_count":9,"name":"暂无","now_diamond":9,"level":0,"screen_chat_type":1,"next_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aae89daccd69","http://pb2.pstatp.com/obj/12400003aae89daccd69","http://pb3.pstatp.com/obj/12400003aae89daccd69"],"uri":"12400003aae89daccd69"},"next_diamond":10000,"icon":{"url_list":["http://p3.pstatp.com/obj/f2100085e55a62833b1","http://pb2.pstatp.com/obj/f2100085e55a62833b1","http://pb3.pstatp.com/obj/f2100085e55a62833b1"],"uri":"f2100085e55a62833b1"}},"id_str":"55538074947","avatar_medium":{"url_list":["http://p3.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/720x720/123f0003b79889feafa6.webp"],"uri":"720x720/123f0003b79889feafa6"},"gender":0,"push_status":true},"stream_id_str":"6396222601387051777","dynamic_cover":null},"tags":[]}]
     * extra : {"min_time":0,"has_more":true,"now":1489237731702,"total":1,"max_time":1489237731702}
     */

    private int status_code;
    private ExtraBean extra;
    private List<DataBeanX> data;

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public ExtraBean getExtra() {
        return extra;
    }

    public void setExtra(ExtraBean extra) {
        this.extra = extra;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class ExtraBean {
        /**
         * min_time : 0
         * has_more : true
         * now : 1489237731702
         * total : 1
         * max_time : 1489237731702
         */

        private int min_time;
        private boolean has_more;
        private long now;
        private int total;
        private long max_time;

        public int getMin_time() {
            return min_time;
        }

        public void setMin_time(int min_time) {
            this.min_time = min_time;
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public long getNow() {
            return now;
        }

        public void setNow(long now) {
            this.now = now;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public long getMax_time() {
            return max_time;
        }

        public void setMax_time(long max_time) {
            this.max_time = max_time;
        }
    }

    public static class DataBeanX {
        /**
         * type : 1
         * rid : 201703112108510100030480291753B5
         * data : {"status":2,"user_count":460,"stats":{"money":540,"fan_ticket":108,"id":6396222601244445442,"total_user":1428,"id_str":"6396222601244445442"},"title":"35071926529","finish_time":1489237726,"enable_room_perspective":true,"share_url":"https://www.huoshan.com/share/room/6396222601244445442/","id":6396222601244445442,"stream_id":6396222601387051777,"create_time":1489236625,"cell_style":3,"id_str":"6396222601244445442","stream_url":{"rtmp_pull_url":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6396222601387051777.flv","provider":2,"id":6396222601387051777,"id_str":"6396222601387051777"},"dynamic_cover_low":null,"owner":{"avatar_large":{"url_list":["http://p3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp"],"uri":"1080x1080/123f0003b79889feafa6"},"signature":"","birthday_description":"未知年龄","birthday":0,"allow_others_download_video":true,"stats":{"record_count":46,"following_count":2,"total_duration":112387,"daily_income":0,"item_count":0,"daily_fan_ticket_count":0,"id_str":"55538074947","follower_count":967,"diamond_count":0,"id":55538074947,"diamond_consumed_count":0},"avatar_thumb":{"url_list":["http://p3.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/100x100/123f0003b79889feafa6.webp"],"uri":"100x100/123f0003b79889feafa6"},"constellation":"谜之星座","id":55538074947,"city":"上海","fan_ticket_count":39547,"verified":false,"follow_status":0,"short_id":82856196,"level":1,"push_comment_status":true,"nickname":"tansy甜","birthday_valid":false,"verified_reason":"","pay_grade":{"diamond_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aba3dd42e213","http://pb2.pstatp.com/obj/12400003aba3dd42e213","http://pb3.pstatp.com/obj/12400003aba3dd42e213"],"uri":"12400003aba3dd42e213"},"next_name":"树叶","total_diamond_count":9,"name":"暂无","now_diamond":9,"level":0,"screen_chat_type":1,"next_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aae89daccd69","http://pb2.pstatp.com/obj/12400003aae89daccd69","http://pb3.pstatp.com/obj/12400003aae89daccd69"],"uri":"12400003aae89daccd69"},"next_diamond":10000,"icon":{"url_list":["http://p3.pstatp.com/obj/f2100085e55a62833b1","http://pb2.pstatp.com/obj/f2100085e55a62833b1","http://pb3.pstatp.com/obj/f2100085e55a62833b1"],"uri":"f2100085e55a62833b1"}},"id_str":"55538074947","avatar_medium":{"url_list":["http://p3.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/720x720/123f0003b79889feafa6.webp"],"uri":"720x720/123f0003b79889feafa6"},"gender":0,"push_status":true},"stream_id_str":"6396222601387051777","dynamic_cover":null}
         * tags : []
         */

        private int type;
        private String rid;
        private DataBean data;
        private List<?> tags;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class DataBean {
            /**
             * status : 2
             * user_count : 460
             * stats : {"money":540,"fan_ticket":108,"id":6396222601244445442,"total_user":1428,"id_str":"6396222601244445442"}
             * title : 35071926529
             * finish_time : 1489237726
             * enable_room_perspective : true
             * share_url : https://www.huoshan.com/share/room/6396222601244445442/
             * id : 6396222601244445442
             * stream_id : 6396222601387051777
             * create_time : 1489236625
             * cell_style : 3
             * id_str : 6396222601244445442
             * stream_url : {"rtmp_pull_url":"http://pull-flv-l1-hs.pstatp.com/hudong/stream-6396222601387051777.flv","provider":2,"id":6396222601387051777,"id_str":"6396222601387051777"}
             * dynamic_cover_low : null
             * owner : {"avatar_large":{"url_list":["http://p3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp"],"uri":"1080x1080/123f0003b79889feafa6"},"signature":"","birthday_description":"未知年龄","birthday":0,"allow_others_download_video":true,"stats":{"record_count":46,"following_count":2,"total_duration":112387,"daily_income":0,"item_count":0,"daily_fan_ticket_count":0,"id_str":"55538074947","follower_count":967,"diamond_count":0,"id":55538074947,"diamond_consumed_count":0},"avatar_thumb":{"url_list":["http://p3.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/100x100/123f0003b79889feafa6.webp"],"uri":"100x100/123f0003b79889feafa6"},"constellation":"谜之星座","id":55538074947,"city":"上海","fan_ticket_count":39547,"verified":false,"follow_status":0,"short_id":82856196,"level":1,"push_comment_status":true,"nickname":"tansy甜","birthday_valid":false,"verified_reason":"","pay_grade":{"diamond_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aba3dd42e213","http://pb2.pstatp.com/obj/12400003aba3dd42e213","http://pb3.pstatp.com/obj/12400003aba3dd42e213"],"uri":"12400003aba3dd42e213"},"next_name":"树叶","total_diamond_count":9,"name":"暂无","now_diamond":9,"level":0,"screen_chat_type":1,"next_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aae89daccd69","http://pb2.pstatp.com/obj/12400003aae89daccd69","http://pb3.pstatp.com/obj/12400003aae89daccd69"],"uri":"12400003aae89daccd69"},"next_diamond":10000,"icon":{"url_list":["http://p3.pstatp.com/obj/f2100085e55a62833b1","http://pb2.pstatp.com/obj/f2100085e55a62833b1","http://pb3.pstatp.com/obj/f2100085e55a62833b1"],"uri":"f2100085e55a62833b1"}},"id_str":"55538074947","avatar_medium":{"url_list":["http://p3.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/720x720/123f0003b79889feafa6.webp"],"uri":"720x720/123f0003b79889feafa6"},"gender":0,"push_status":true}
             * stream_id_str : 6396222601387051777
             * dynamic_cover : null
             */

            private int status;
            private int user_count;
            private StatsBean stats;
            private String title;
            private int finish_time;
            private boolean enable_room_perspective;
            private String share_url;
            private long id;
            private long stream_id;
            private int create_time;
            private int cell_style;
            private String id_str;
            private StreamUrlBean stream_url;
            private Object dynamic_cover_low;
            private OwnerBean owner;
            private String stream_id_str;
            private Object dynamic_cover;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getUser_count() {
                return user_count;
            }

            public void setUser_count(int user_count) {
                this.user_count = user_count;
            }

            public StatsBean getStats() {
                return stats;
            }

            public void setStats(StatsBean stats) {
                this.stats = stats;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getFinish_time() {
                return finish_time;
            }

            public void setFinish_time(int finish_time) {
                this.finish_time = finish_time;
            }

            public boolean isEnable_room_perspective() {
                return enable_room_perspective;
            }

            public void setEnable_room_perspective(boolean enable_room_perspective) {
                this.enable_room_perspective = enable_room_perspective;
            }

            public String getShare_url() {
                return share_url;
            }

            public void setShare_url(String share_url) {
                this.share_url = share_url;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public long getStream_id() {
                return stream_id;
            }

            public void setStream_id(long stream_id) {
                this.stream_id = stream_id;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public int getCell_style() {
                return cell_style;
            }

            public void setCell_style(int cell_style) {
                this.cell_style = cell_style;
            }

            public String getId_str() {
                return id_str;
            }

            public void setId_str(String id_str) {
                this.id_str = id_str;
            }

            public StreamUrlBean getStream_url() {
                return stream_url;
            }

            public void setStream_url(StreamUrlBean stream_url) {
                this.stream_url = stream_url;
            }

            public Object getDynamic_cover_low() {
                return dynamic_cover_low;
            }

            public void setDynamic_cover_low(Object dynamic_cover_low) {
                this.dynamic_cover_low = dynamic_cover_low;
            }

            public OwnerBean getOwner() {
                return owner;
            }

            public void setOwner(OwnerBean owner) {
                this.owner = owner;
            }

            public String getStream_id_str() {
                return stream_id_str;
            }

            public void setStream_id_str(String stream_id_str) {
                this.stream_id_str = stream_id_str;
            }

            public Object getDynamic_cover() {
                return dynamic_cover;
            }

            public void setDynamic_cover(Object dynamic_cover) {
                this.dynamic_cover = dynamic_cover;
            }

            public static class StatsBean {
                /**
                 * money : 540
                 * fan_ticket : 108
                 * id : 6396222601244445442
                 * total_user : 1428
                 * id_str : 6396222601244445442
                 */

                private int money;
                private int fan_ticket;
                private long id;
                private int total_user;
                private String id_str;

                public int getMoney() {
                    return money;
                }

                public void setMoney(int money) {
                    this.money = money;
                }

                public int getFan_ticket() {
                    return fan_ticket;
                }

                public void setFan_ticket(int fan_ticket) {
                    this.fan_ticket = fan_ticket;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getTotal_user() {
                    return total_user;
                }

                public void setTotal_user(int total_user) {
                    this.total_user = total_user;
                }

                public String getId_str() {
                    return id_str;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }
            }

            public static class StreamUrlBean {
                /**
                 * rtmp_pull_url : http://pull-flv-l1-hs.pstatp.com/hudong/stream-6396222601387051777.flv
                 * provider : 2
                 * id : 6396222601387051777
                 * id_str : 6396222601387051777
                 */

                private String rtmp_pull_url;
                private int provider;
                private long id;
                private String id_str;

                public String getRtmp_pull_url() {
                    return rtmp_pull_url;
                }

                public void setRtmp_pull_url(String rtmp_pull_url) {
                    this.rtmp_pull_url = rtmp_pull_url;
                }

                public int getProvider() {
                    return provider;
                }

                public void setProvider(int provider) {
                    this.provider = provider;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getId_str() {
                    return id_str;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }
            }

            public static class OwnerBean {
                /**
                 * avatar_large : {"url_list":["http://p3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp"],"uri":"1080x1080/123f0003b79889feafa6"}
                 * signature :
                 * birthday_description : 未知年龄
                 * birthday : 0
                 * allow_others_download_video : true
                 * stats : {"record_count":46,"following_count":2,"total_duration":112387,"daily_income":0,"item_count":0,"daily_fan_ticket_count":0,"id_str":"55538074947","follower_count":967,"diamond_count":0,"id":55538074947,"diamond_consumed_count":0}
                 * avatar_thumb : {"url_list":["http://p3.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/100x100/123f0003b79889feafa6.webp"],"uri":"100x100/123f0003b79889feafa6"}
                 * constellation : 谜之星座
                 * id : 55538074947
                 * city : 上海
                 * fan_ticket_count : 39547
                 * verified : false
                 * follow_status : 0
                 * short_id : 82856196
                 * level : 1
                 * push_comment_status : true
                 * nickname : tansy甜
                 * birthday_valid : false
                 * verified_reason :
                 * pay_grade : {"diamond_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aba3dd42e213","http://pb2.pstatp.com/obj/12400003aba3dd42e213","http://pb3.pstatp.com/obj/12400003aba3dd42e213"],"uri":"12400003aba3dd42e213"},"next_name":"树叶","total_diamond_count":9,"name":"暂无","now_diamond":9,"level":0,"screen_chat_type":1,"next_icon":{"url_list":["http://p3.pstatp.com/obj/12400003aae89daccd69","http://pb2.pstatp.com/obj/12400003aae89daccd69","http://pb3.pstatp.com/obj/12400003aae89daccd69"],"uri":"12400003aae89daccd69"},"next_diamond":10000,"icon":{"url_list":["http://p3.pstatp.com/obj/f2100085e55a62833b1","http://pb2.pstatp.com/obj/f2100085e55a62833b1","http://pb3.pstatp.com/obj/f2100085e55a62833b1"],"uri":"f2100085e55a62833b1"}}
                 * id_str : 55538074947
                 * avatar_medium : {"url_list":["http://p3.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/720x720/123f0003b79889feafa6.webp"],"uri":"720x720/123f0003b79889feafa6"}
                 * gender : 0
                 * push_status : true
                 */

                private AvatarLargeBean avatar_large;
                private String signature;
                private String birthday_description;
                private int birthday;
                private boolean allow_others_download_video;
                private StatsBeanX stats;
                private AvatarThumbBean avatar_thumb;
                private String constellation;
                private long id;
                private String city;
                private int fan_ticket_count;
                private boolean verified;
                private int follow_status;
                private int short_id;
                private int level;
                private boolean push_comment_status;
                private String nickname;
                private boolean birthday_valid;
                private String verified_reason;
                private PayGradeBean pay_grade;
                private String id_str;
                private AvatarMediumBean avatar_medium;
                private int gender;
                private boolean push_status;

                public AvatarLargeBean getAvatar_large() {
                    return avatar_large;
                }

                public void setAvatar_large(AvatarLargeBean avatar_large) {
                    this.avatar_large = avatar_large;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }

                public String getBirthday_description() {
                    return birthday_description;
                }

                public void setBirthday_description(String birthday_description) {
                    this.birthday_description = birthday_description;
                }

                public int getBirthday() {
                    return birthday;
                }

                public void setBirthday(int birthday) {
                    this.birthday = birthday;
                }

                public boolean isAllow_others_download_video() {
                    return allow_others_download_video;
                }

                public void setAllow_others_download_video(boolean allow_others_download_video) {
                    this.allow_others_download_video = allow_others_download_video;
                }

                public StatsBeanX getStats() {
                    return stats;
                }

                public void setStats(StatsBeanX stats) {
                    this.stats = stats;
                }

                public AvatarThumbBean getAvatar_thumb() {
                    return avatar_thumb;
                }

                public void setAvatar_thumb(AvatarThumbBean avatar_thumb) {
                    this.avatar_thumb = avatar_thumb;
                }

                public String getConstellation() {
                    return constellation;
                }

                public void setConstellation(String constellation) {
                    this.constellation = constellation;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public int getFan_ticket_count() {
                    return fan_ticket_count;
                }

                public void setFan_ticket_count(int fan_ticket_count) {
                    this.fan_ticket_count = fan_ticket_count;
                }

                public boolean isVerified() {
                    return verified;
                }

                public void setVerified(boolean verified) {
                    this.verified = verified;
                }

                public int getFollow_status() {
                    return follow_status;
                }

                public void setFollow_status(int follow_status) {
                    this.follow_status = follow_status;
                }

                public int getShort_id() {
                    return short_id;
                }

                public void setShort_id(int short_id) {
                    this.short_id = short_id;
                }

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public boolean isPush_comment_status() {
                    return push_comment_status;
                }

                public void setPush_comment_status(boolean push_comment_status) {
                    this.push_comment_status = push_comment_status;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public boolean isBirthday_valid() {
                    return birthday_valid;
                }

                public void setBirthday_valid(boolean birthday_valid) {
                    this.birthday_valid = birthday_valid;
                }

                public String getVerified_reason() {
                    return verified_reason;
                }

                public void setVerified_reason(String verified_reason) {
                    this.verified_reason = verified_reason;
                }

                public PayGradeBean getPay_grade() {
                    return pay_grade;
                }

                public void setPay_grade(PayGradeBean pay_grade) {
                    this.pay_grade = pay_grade;
                }

                public String getId_str() {
                    return id_str;
                }

                public void setId_str(String id_str) {
                    this.id_str = id_str;
                }

                public AvatarMediumBean getAvatar_medium() {
                    return avatar_medium;
                }

                public void setAvatar_medium(AvatarMediumBean avatar_medium) {
                    this.avatar_medium = avatar_medium;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public boolean isPush_status() {
                    return push_status;
                }

                public void setPush_status(boolean push_status) {
                    this.push_status = push_status;
                }

                public static class AvatarLargeBean {
                    /**
                     * url_list : ["http://p3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/1080x1080/123f0003b79889feafa6.webp"]
                     * uri : 1080x1080/123f0003b79889feafa6
                     */

                    private String uri;
                    private List<String> url_list;

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public List<String> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<String> url_list) {
                        this.url_list = url_list;
                    }
                }

                public static class StatsBeanX {
                    /**
                     * record_count : 46
                     * following_count : 2
                     * total_duration : 112387
                     * daily_income : 0
                     * item_count : 0
                     * daily_fan_ticket_count : 0
                     * id_str : 55538074947
                     * follower_count : 967
                     * diamond_count : 0
                     * id : 55538074947
                     * diamond_consumed_count : 0
                     */

                    private int record_count;
                    private int following_count;
                    private int total_duration;
                    private int daily_income;
                    private int item_count;
                    private int daily_fan_ticket_count;
                    private String id_str;
                    private int follower_count;
                    private int diamond_count;
                    private long id;
                    private int diamond_consumed_count;

                    public int getRecord_count() {
                        return record_count;
                    }

                    public void setRecord_count(int record_count) {
                        this.record_count = record_count;
                    }

                    public int getFollowing_count() {
                        return following_count;
                    }

                    public void setFollowing_count(int following_count) {
                        this.following_count = following_count;
                    }

                    public int getTotal_duration() {
                        return total_duration;
                    }

                    public void setTotal_duration(int total_duration) {
                        this.total_duration = total_duration;
                    }

                    public int getDaily_income() {
                        return daily_income;
                    }

                    public void setDaily_income(int daily_income) {
                        this.daily_income = daily_income;
                    }

                    public int getItem_count() {
                        return item_count;
                    }

                    public void setItem_count(int item_count) {
                        this.item_count = item_count;
                    }

                    public int getDaily_fan_ticket_count() {
                        return daily_fan_ticket_count;
                    }

                    public void setDaily_fan_ticket_count(int daily_fan_ticket_count) {
                        this.daily_fan_ticket_count = daily_fan_ticket_count;
                    }

                    public String getId_str() {
                        return id_str;
                    }

                    public void setId_str(String id_str) {
                        this.id_str = id_str;
                    }

                    public int getFollower_count() {
                        return follower_count;
                    }

                    public void setFollower_count(int follower_count) {
                        this.follower_count = follower_count;
                    }

                    public int getDiamond_count() {
                        return diamond_count;
                    }

                    public void setDiamond_count(int diamond_count) {
                        this.diamond_count = diamond_count;
                    }

                    public long getId() {
                        return id;
                    }

                    public void setId(long id) {
                        this.id = id;
                    }

                    public int getDiamond_consumed_count() {
                        return diamond_consumed_count;
                    }

                    public void setDiamond_consumed_count(int diamond_consumed_count) {
                        this.diamond_consumed_count = diamond_consumed_count;
                    }
                }

                public static class AvatarThumbBean {
                    /**
                     * url_list : ["http://p3.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/100x100/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/100x100/123f0003b79889feafa6.webp"]
                     * uri : 100x100/123f0003b79889feafa6
                     */

                    private String uri;
                    private List<String> url_list;

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public List<String> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<String> url_list) {
                        this.url_list = url_list;
                    }
                }

                public static class PayGradeBean {
                    /**
                     * diamond_icon : {"url_list":["http://p3.pstatp.com/obj/12400003aba3dd42e213","http://pb2.pstatp.com/obj/12400003aba3dd42e213","http://pb3.pstatp.com/obj/12400003aba3dd42e213"],"uri":"12400003aba3dd42e213"}
                     * next_name : 树叶
                     * total_diamond_count : 9
                     * name : 暂无
                     * now_diamond : 9
                     * level : 0
                     * screen_chat_type : 1
                     * next_icon : {"url_list":["http://p3.pstatp.com/obj/12400003aae89daccd69","http://pb2.pstatp.com/obj/12400003aae89daccd69","http://pb3.pstatp.com/obj/12400003aae89daccd69"],"uri":"12400003aae89daccd69"}
                     * next_diamond : 10000
                     * icon : {"url_list":["http://p3.pstatp.com/obj/f2100085e55a62833b1","http://pb2.pstatp.com/obj/f2100085e55a62833b1","http://pb3.pstatp.com/obj/f2100085e55a62833b1"],"uri":"f2100085e55a62833b1"}
                     */

                    private DiamondIconBean diamond_icon;
                    private String next_name;
                    private int total_diamond_count;
                    private String name;
                    private int now_diamond;
                    private int level;
                    private int screen_chat_type;
                    private NextIconBean next_icon;
                    private int next_diamond;
                    private IconBean icon;

                    public DiamondIconBean getDiamond_icon() {
                        return diamond_icon;
                    }

                    public void setDiamond_icon(DiamondIconBean diamond_icon) {
                        this.diamond_icon = diamond_icon;
                    }

                    public String getNext_name() {
                        return next_name;
                    }

                    public void setNext_name(String next_name) {
                        this.next_name = next_name;
                    }

                    public int getTotal_diamond_count() {
                        return total_diamond_count;
                    }

                    public void setTotal_diamond_count(int total_diamond_count) {
                        this.total_diamond_count = total_diamond_count;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getNow_diamond() {
                        return now_diamond;
                    }

                    public void setNow_diamond(int now_diamond) {
                        this.now_diamond = now_diamond;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public int getScreen_chat_type() {
                        return screen_chat_type;
                    }

                    public void setScreen_chat_type(int screen_chat_type) {
                        this.screen_chat_type = screen_chat_type;
                    }

                    public NextIconBean getNext_icon() {
                        return next_icon;
                    }

                    public void setNext_icon(NextIconBean next_icon) {
                        this.next_icon = next_icon;
                    }

                    public int getNext_diamond() {
                        return next_diamond;
                    }

                    public void setNext_diamond(int next_diamond) {
                        this.next_diamond = next_diamond;
                    }

                    public IconBean getIcon() {
                        return icon;
                    }

                    public void setIcon(IconBean icon) {
                        this.icon = icon;
                    }

                    public static class DiamondIconBean {
                        /**
                         * url_list : ["http://p3.pstatp.com/obj/12400003aba3dd42e213","http://pb2.pstatp.com/obj/12400003aba3dd42e213","http://pb3.pstatp.com/obj/12400003aba3dd42e213"]
                         * uri : 12400003aba3dd42e213
                         */

                        private String uri;
                        private List<String> url_list;

                        public String getUri() {
                            return uri;
                        }

                        public void setUri(String uri) {
                            this.uri = uri;
                        }

                        public List<String> getUrl_list() {
                            return url_list;
                        }

                        public void setUrl_list(List<String> url_list) {
                            this.url_list = url_list;
                        }
                    }

                    public static class NextIconBean {
                        /**
                         * url_list : ["http://p3.pstatp.com/obj/12400003aae89daccd69","http://pb2.pstatp.com/obj/12400003aae89daccd69","http://pb3.pstatp.com/obj/12400003aae89daccd69"]
                         * uri : 12400003aae89daccd69
                         */

                        private String uri;
                        private List<String> url_list;

                        public String getUri() {
                            return uri;
                        }

                        public void setUri(String uri) {
                            this.uri = uri;
                        }

                        public List<String> getUrl_list() {
                            return url_list;
                        }

                        public void setUrl_list(List<String> url_list) {
                            this.url_list = url_list;
                        }
                    }

                    public static class IconBean {
                        /**
                         * url_list : ["http://p3.pstatp.com/obj/f2100085e55a62833b1","http://pb2.pstatp.com/obj/f2100085e55a62833b1","http://pb3.pstatp.com/obj/f2100085e55a62833b1"]
                         * uri : f2100085e55a62833b1
                         */

                        private String uri;
                        private List<String> url_list;

                        public String getUri() {
                            return uri;
                        }

                        public void setUri(String uri) {
                            this.uri = uri;
                        }

                        public List<String> getUrl_list() {
                            return url_list;
                        }

                        public void setUrl_list(List<String> url_list) {
                            this.url_list = url_list;
                        }
                    }
                }

                public static class AvatarMediumBean {
                    /**
                     * url_list : ["http://p3.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb2.pstatp.com/live/720x720/123f0003b79889feafa6.webp","http://pb3.pstatp.com/live/720x720/123f0003b79889feafa6.webp"]
                     * uri : 720x720/123f0003b79889feafa6
                     */

                    private String uri;
                    private List<String> url_list;

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                    public List<String> getUrl_list() {
                        return url_list;
                    }

                    public void setUrl_list(List<String> url_list) {
                        this.url_list = url_list;
                    }
                }
            }
        }
    }
}
