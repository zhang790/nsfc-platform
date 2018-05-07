//package com.nsfc.common.util;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 统一返回结果处理  外部jar包无法解析路径  暂时先放在这里
// *
// * @author zhangjiayu zhangjiayu
// * @create 2018/4/17
// */
//public class ReturnData {
//
//    // 操作状态
//    private int retCode;
//
//    // 返回数据
//    private Object data;
//
//    // 错误提示信息
//    private String msg;
//
//    public int getRetCode() {
//        return retCode;
//    }
//
//    public void setRetCode(int retCode) {
//        this.retCode = retCode;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        setMsg(msg, null);
//    }
//
//    /**
//     * @param msg 信息.
//     * @Edit_Description:参数替换对应的错误信息。
//     */
//    public void setMsg(String msg, Object[] obj) {
//        String message = "";
//        try {
////            message = (String) CommonConstants.getMessage(msg);
////            if (StringUtil.isEmpty(message)) {
////                message = msg;
////            }
//            if (obj != null) {
//                String[] values = message.split("\\{");
//                for (int i = 0; i < values.length; i++) {
//                    message = message.replace("{" + String.valueOf(i) + "}",
//                            obj.length - 1 < i ? "" : obj[i].toString());
//                }
//            }
//        } catch (Exception ep) {
//            throw new RuntimeException("setMsg error" + msg + "--" + obj);
//        }
//        this.msg = message;
//    }
//
//    /**
//     * @Edit_Description 获取返回值.
//     */
//    public Map<String, Object> getReturnMap() {
//        Map<String, Object> dataMap = new HashMap<String, Object>();
//        dataMap.put("retCode", retCode);
//        dataMap.put("data", data);
//        dataMap.put("msg", msg);
//        return dataMap;
//    }
//
//    public ReturnData() {
//        super();
//    }
//
//    /**
//     * @Edit_Description 构造函数.
//     */
//    public ReturnData(int retCode, Object data, String msg) {
//        super();
//        this.retCode = retCode;
//        this.data = data;
//        this.msg = msg;
//    }
//
//    @Override
//    public String toString() {
//        return "ReturnData [retCode=" + retCode + ", data=" + data + "]";
//    }
//}
