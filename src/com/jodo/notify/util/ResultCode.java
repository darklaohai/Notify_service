package com.jodo.notify.util;

public class ResultCode {

    /**
     * Err -999: 未定义
     */
    public static final int ERR_UNDEFINE = -999;

    /**
     * 操作成功
     */
    public static final int OK = 0;

    /**
     * Err -1: 账户未登录，遇到此错误时一般情况下需要进行登录操作
     */
    public final static int ERR_BEFORE_REQ_UNLOGIN = -1;

    /**
     * Err -2: 错误的参数
     */
    public final static int ERR_BEFORE_REQ_PARAMS_ERROR = -2;

    /**
     * Err -3:
     * 连接失败，可能是网络原因，或服务器原因，遇到此接口一般是提示网络处理(逻辑调用方先检查一下网络情况如果有问题再提示用户进行网络设置)，
     * 然后稍等片刻再请求
     */
    public final static int ERR_REQ_CONNECTION_FAILED = -3;

    /**
     * Err -4:无法解决的异常
     */
    public final static int ERR_REQ_EXCEPTION = -4;
    
    /**
     * Err -5:解析返回的obj错误
     */
    public final static int ERR_PARSE_RESP_OBJ = -5;
    
    /**
     * Err 110: 游戏appkey 不合法
     */
    public static final int ERR_110_MP_ERR_APPKEY = 110;
    /**
     * Err 112: 请求数据被非法修改
     */
    public static final int ERR_112_MP_ERR_HASH = 112;
    
    /**
     * Err 201: 查询积分余额失败
     */
    public static final int ERR_201_POINTS_QUERY_FAILED = 201;

    /**
     * Err 202: 积分余额不足
     */
    public static final int ERR_202_POINTS_INSUFFICIENT = 202;

    /**
     * Err 203: 奖励积分失败
     */
    public static final int ERR_203_POINTS_AWARD_FAILED = 203;

    /**
     * Err 204: 消费积分失败
     */
    public static final int ERR_204_POINTS_SPEND_FAILED = 204;
    
    /**
     * Err 205: 虚拟货币编号无效
     */
    public static final int ERR_205_POINTS_VID_INVALID = 205;

    /**
     * Err 250: 内部错误 连接用户模块失败
     */
    public static final int ERR_250_ACCOUNT_USER_CONNECT = 250;
    /**
     * Err 251: 账号名已经存在，不可重复注册 
     */
    public static final int ERR_251_ACCOUNT_USER_REGISTERED = 251;

    /**
     * Err 252: 账户不存在
     */
    public static final int ERR_252_ACCOUNT_USER_NOT_EXIST = 252;

    /**
     * Err 253: 密码错误
     */
    public static final int ERR_253_ACCOUNT_USER_PASSWORD = 253;
    /**
     * Err 254: 内部错误 ，连接登录态失败
     */
    public static final int ERR_254_ACCOUNT_SESS_CONNECT = 254;

    /**
     * Err 255: 登录会话失效
     */
    public static final int ERR_255_ACCOUNT_SESSION_INVAILED = 255;
    /**
     * Err 256  内部错误 登录动作失败，设置登录态错误
     */
    public static final int ERR_256_MP_SESS_SET = 256;
    /**
     * Err 257  内部错误 登录态出错
     */
    public static final int ERR_257_MP_SESS_ERROR = 257;
    /**
     * ERR_MP_USER_VISITOR_BINDED : 游客帐号已经绑定
     * */
    public static final int ERR_259_MP_USER_VISITOR_BINDED = 259;

    /**
     * Err 260: 注册失败，密码过于简单
     */
    public static final int ERR_260_ACCOUNT_USER_PASSWORD_TO_SIMPLE = 260;

    
    /**@Fields ERR_271_ACCOUNT_NICK_REGISTERED : 昵称已存在*/
    public static final int ERR_271_ACCOUNT_NICK_REGISTERED = 271;
    
    /**@Fields ERR_272_ACCOUNT_USER_INVALIDE : 密码不合法*/
    public static final int ERR_272_ACCOUNT_PSW_ILLEAGE = 272;
    
    /**
     * Err 310: 帐号名不合法
     */
    public static final int ERR_301_ACCOUNT_USER_NAME_ILLEAGE = 301;
    /**
     * Err 310: 要兑换的appkey不存在
     */
    public static final int ERR_310_MP_APP_NOT_EXIST = 310;
    
    public static final int FAIL = 1000;
    
    public static final int ERR_1001_CP_NOT_FOUND = 1001;
    
    public static final int ERR_1002_SIGN_NOT_MATCH = 1002;
    
  //账号不存在或密码错误 
    public static final int ERR_1003_NOT_FOUND_OR_NOTMATCH = 1003;
    
    public static final int ERR_1004_LOGINNAME_LENGTH = 1004;
    
   //facebook 验证失败
    public static final int ERR_1005_FB_VALID_FAIL = 1005;

    //訂單已經被處理過了
    public static final int ERR_1006_CPAY_COMPLETED = 1006;
    
    
}