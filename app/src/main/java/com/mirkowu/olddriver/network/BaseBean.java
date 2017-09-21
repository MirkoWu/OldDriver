package com.mirkowu.olddriver.network;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class BaseBean<T> {
   public String message;
   public T data;

   public boolean isSuccess(){
      return "success".equals(message);
   }
}
