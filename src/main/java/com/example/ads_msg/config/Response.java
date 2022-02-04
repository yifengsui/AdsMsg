package com.example.ads_msg.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Response<T> {
    /**
     * 调用是否成功
     */

    private boolean result = true;
    /**
     * 状态码
     */
    private String code = "200";
    /**
     * 结果消息
     */

    private String msg = "";
    /**
     * 响应数据
     */

    private T data;
    /**
     * <p>返回成功结果，无返回结果集</p> * * @return Response<T>
     */
    public static <T> Response<T> success() {return success();}

    public static <T> Response<T> success(String msg,T data) {
        return ((Response<T>) Response.builder().result(true).code("200").msg(msg).data(data).build());
    }

    public static <T> Response<T> successToJson(String msg,T data) {
        return ((Response<T>) Response.builder().result(true).code("200").msg(msg).data(JSON.toJSONString(data)).build());
    }

    public static <T> Response<T> successToJsonStringHavaNull(String msg,T data) {
        return ((Response<T>)Response.builder().result(true).code("200").msg(msg).data(JSON.toJSONString(
                data,SerializerFeature.WriteMapNullValue)).build());
    }




    /**
     * <p> 返回失败结果，无返回结果集 </p > * * @return Response<T>
     */
    public static <T> Response<T> error() {
        return error(null);
    }

    /**
     * <p> 返回失败结果，有返回结果集 </p > * * @return Response<T>
     */
    @SuppressWarnings("unchecked")
    public static <T> Response<T> error(T data) {
        return ((Response<T>) Response.builder().result(false).code("1000").msg(data.toString()).build());
    }

    public static <T> Response<T> error(String msg,T data) {
        return ((Response<T>) Response.builder().result(false).msg(msg).data(JSON.toJSONString(data)).build());
    }
    public static <T> Response<T> error(String msg,String code,T data){
        return ((Response<T>) Response.builder().result(false).code(code).msg(msg).data(JSON.toJSONString(data)).build());
    }
    public static <T> Response<T> errorData(String msg,String code,T data){
        return ((Response<T>) Response.builder().result(false).code(code).msg(msg).data(data).build());
    }
}
