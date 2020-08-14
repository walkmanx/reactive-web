package com.example.reactiveweb.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * <p>Copyright: Copyright (c) 2016</p>
 * @description 
 * @author hx
 * @date  2019年3月7日 
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String errorCode;

		public ServiceException(){
			super();
		}
		
		public ServiceException(String message){
			super(message);
		}
		
		public ServiceException(Throwable cause){
			super(cause);
		}
		
		public ServiceException(String message,Throwable cause){
			super(message,cause);
		}
		
		public ServiceException(String message,Throwable cause,Boolean enableSuppression,Boolean writableStackTrace){
			super(message,cause,enableSuppression,writableStackTrace);
		}
}
