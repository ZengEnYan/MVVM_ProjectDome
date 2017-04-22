package com.MVVM.test.event;

import android.text.Editable;
import android.text.TextWatcher;

import com.MVVM.test.bean.UserEntity;

/**
 * name:Mr.Yan or Mr.TianChen
 * Data: 2017/4/21
 * 备注
 */

public class EventButton {

    public UserEntity mUser;

    public EventButton(UserEntity user){
        mUser = user;
    }

    public TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mUser.userName = s.toString();
            mUser.passWord = s.toString();
        }
    };

}
