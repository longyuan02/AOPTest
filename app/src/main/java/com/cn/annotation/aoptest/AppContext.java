//package com.cn.annotation.aoptest;
//
//import android.content.Context;
//
//import com.cn.annotation.aoptest.aop2.ILogin;
//import com.cn.annotation.aoptest.aop2.LoginSDK;
//
//public class AppContext {
//    private static final String TAG = AppContext.class.getSimpleName();
//    public AppContext() {
//    }
//
//    @Override
//    public void attachBaseContext(Context base) {
//    }
//
//    @Override
//    public void injectAppLifecycle(Context context, List<IAppLife> lifeList) {
//        lifeList.add(this);
//    }
//
//    @Override
//    public void onCreate(BaseApplication application) {
//        LoginSDK.getInstance().init(application, login);
//    }
//
//
//    private ILogin login = new ILogin() {
//        @Override
//        public void login(Context context, int actionDefine) {
//            switch (actionDefine) {
//                case 0:
//                    ToastHelper.showMessage(R.string.login_required);
//                    IntentUtils.actionWeChatLogin(AppManager.currentActivity(), IReturnType.Mine);
//                    break;
//                case 1:
//                    ToastHelper.showMessage(R.string.login_required);
//                    break;
//            }
//        }
//
//        @Override
//        public boolean isLogin(Context context) {
//            return component().userManager().hasUser();
//        }
//    };
//}