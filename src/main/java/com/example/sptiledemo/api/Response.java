package com.example.sptiledemo.api;

import com.alibaba.fastjson.JSON;

public final class Response<T> {

	private T data;//返回的json数据
	private int code;//状态码，200成功，
	private long count;//如果是一个对象数组，则应返回总数组长度
	private String msg;//自定义消息

	public Response(T data, long count){
		this.data = (T) JSON.toJSON(data);
		this.count = count;
		if(count==0){
			this.code=0;
			this.msg="no";
		}else {
			this.code=200;
			this.msg="ok";
		}
	}

	@Override
	public String toString() {
		return "Response{" +
				"data=" + data +
				", code=" + code +
				", count=" + count +
				", msg='" + msg + '\'' +
				'}';
	}

	public T getData() {
		return data;
	}

	public int getCode() {
		return code;
	}


	public long getCount() {
		return count;
	}


	public String getMsg() {
		return msg;
	}

}
