package com.ziyin.message.service;

import com.ziyin.thrift.message.MessageService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * @author ziyin
 @create 2018-12-2018/12/29-22:12
 */
@Service
public class MessageServiceImpl implements MessageService.Iface {


	@Override
	public boolean sendMobileMessage(String mobile, String message) throws TException {
		System.out.println("sendMobileMessage, mobile:"+mobile+", message:"+message);
		return true;
	}

	@Override
	public boolean sendEmailMessage(String email, String message) throws TException {
		System.out.println("sendMobileMessage, mobile:"+email+", message:"+message);
		return true;
	}
}
