package com.enjoylearning.event;

import java.util.Date;

import javax.annotation.Resource;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.enjoylearning.event.entity.THotelOrder;
import com.enjoylearning.event.services.HotelOrderService;
import com.enjoylearning.event.zk.ZookeeperConnector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ZookeeperEventTest {
	
	private static final String CONF_PATH="/configration";
	
	private static final String ZOOKEEPER_IP_PORT ="localhost:2181";
	
	
	@Resource
	private HotelOrderService hos;

	@Before
	public void init(){
//		ZkClient client = new ZkClient(ZOOKEEPER_IP_PORT, 1000, 1000, new SerializableSerializer());
//		if(client.exists(CONF_PATH)){
//			client.delete(CONF_PATH);
//		}
//		client.createPersistent(CONF_PATH);
//		client.writeData(CONF_PATH, "192.168.1.1");
	}
	
	//模拟分布式环境，有五个应用要读取配置中心的配置信息
	@Test
	public void zkEeventTest(){
		Thread t1 = new Thread(new ZookeeperConnector());
		Thread t2 = new Thread(new ZookeeperConnector());
		Thread t3 = new Thread(new ZookeeperConnector());
		Thread t4 = new Thread(new ZookeeperConnector());
		Thread t5 = new Thread(new ZookeeperConnector());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		try {
			Thread.currentThread().join();//主线程等待子线程结束
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void zkDataChange(){
		ZkClient client = new ZkClient(ZOOKEEPER_IP_PORT, 1000, 1000, new SerializableSerializer());
		client.writeData(CONF_PATH, "192.168.1.2");
	}
	
	@Test
	@Transactional
	@Commit
	public void testHotelOrder() throws InterruptedException{
		THotelOrder order = new THotelOrder(1, "u00001", "seven", new Date());
		hos.addHotealOrder(order);
		Thread.currentThread().sleep(500);
	}
	
	
	


}
