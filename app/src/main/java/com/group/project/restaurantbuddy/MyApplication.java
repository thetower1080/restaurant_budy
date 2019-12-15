package com.group.project.restaurantbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;

public class MyApplication extends Application {

        private String _id;
        public String getId(){
            return _id;
        }
        public void setId(String id){
            this._id = id;
        }
        private  String order_title;
        public String getOrder(){
            return order_title;
        }
        public void setOrder(String order_title){
            this.order_title = order_title;
        }


}
