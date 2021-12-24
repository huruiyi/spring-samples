package com.enjoylearning.event.zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//zk连接器，用于监听配置节点的变化
public class ZookeeperConnector implements Runnable {

	private static final String CONF_PATH = "/configration";

	private static final String ZOOKEEPER_IP_PORT = "localhost:2181";

	// 初始化zk的连接
	private ZkClient client = new ZkClient(ZOOKEEPER_IP_PORT, 1000, 1000, new SerializableSerializer());

	private static Logger logger = LoggerFactory.getLogger(ZookeeperConnector.class);

	public void run() {
		// 读取初始配置
		String conf = client.readData(CONF_PATH);
		logger.info(Thread.currentThread().getName() + "获得配置信息：" + conf);

		// 定义一个监听器
		IZkDataListener listener = new IZkDataListener() {

			public void handleDataDeleted(String dataPath) throws Exception {

			}

			// 当配置节点发生变化时，客户端获取最新的配置信息
			public void handleDataChange(String dataPath, Object data) throws Exception {
				String conf = data.toString();
				logger.info(Thread.currentThread().getName() + "捕获配置变化事件，获取到最新的配置信息为：" + conf);
			}
		};

		// 给配置节点增加监听器
		client.subscribeDataChanges(CONF_PATH, listener);

	}

}
