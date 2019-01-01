package com.ziyin.message.thrift;

import com.ziyin.thrift.message.MessageService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author ziyin
 @create 2018-12-2018/12/29-23:09
 */
@Configuration
public class ThriftServer {

	@Value("${service.port}")
	private int servicePort;

	@Autowired
	private MessageService.Iface messageService;

	@PostConstruct
	public void startThriftServer() {

		TProcessor processor = new MessageService.Processor<>(messageService);

		TNonblockingServerSocket socket = null;
		try {
			socket = new TNonblockingServerSocket(servicePort);
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
		args.processor(processor);
		args.transportFactory(new TFramedTransport.Factory());
		args.protocolFactory(new TBinaryProtocol.Factory());

		TServer server = new TNonblockingServer(args);
		server.serve();
	}
}