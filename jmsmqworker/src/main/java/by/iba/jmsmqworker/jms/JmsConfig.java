package by.iba.jmsmqworker.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ibm.disthub2.client.Listener;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;

import by.iba.jmsmqworker.services.jms.listener.ListenerMQ;


@Configuration
@EnableTransactionManagement
public class JmsConfig {
    /*@Value("${project.mq.host}")
    private String host;
    @Value("${project.mq.port}")
    private Integer port;
    @Value("${project.mq.queue-manager}")
    private String queueManager;
    @Value("${project.mq.channel}")
    private String channel;
    @Value("${project.mq.username}")
    private String username;
    @Value("${project.mq.password}")
    private String password;
    @Value("${project.mq.queue}")
    private String queue;
    @Value("${project.mq.receive-timeout}")
    private long receiveTimeout;*/
	
	@Autowired
	private ListenerMQ listenerMQ;

    @Bean
    public MQQueueConnectionFactory mqQueueConnectionFactory() {
        MQQueueConnectionFactory mqQueueConnectionFactory = new MQQueueConnectionFactory();
        mqQueueConnectionFactory.setHostName("172.20.2.116");
        try {
            mqQueueConnectionFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);
           // mqQueueConnectionFactory.setCCSID(1047);
            mqQueueConnectionFactory.setChannel("SYSTEM.ADMIN.SVRCONN");
            mqQueueConnectionFactory.setPort(1414);
            mqQueueConnectionFactory.setQueueManager("CSQ8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mqQueueConnectionFactory;
    }

    @Bean
    UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter(MQQueueConnectionFactory mqQueueConnectionFactory) {
        UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter = new UserCredentialsConnectionFactoryAdapter();
        userCredentialsConnectionFactoryAdapter.setUsername("");
        userCredentialsConnectionFactoryAdapter.setPassword("");
        userCredentialsConnectionFactoryAdapter.setTargetConnectionFactory(mqQueueConnectionFactory);
        return userCredentialsConnectionFactoryAdapter;
    }

    @Bean
    @Primary
    public CachingConnectionFactory cachingConnectionFactory(UserCredentialsConnectionFactoryAdapter userCredentialsConnectionFactoryAdapter) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(userCredentialsConnectionFactoryAdapter);
        cachingConnectionFactory.setSessionCacheSize(500);
        cachingConnectionFactory.setReconnectOnException(true);
        return cachingConnectionFactory;
    }

    @Bean
    public PlatformTransactionManager jmsTransactionManager(CachingConnectionFactory cachingConnectionFactory) {
        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
        jmsTransactionManager.setConnectionFactory(cachingConnectionFactory);
        return jmsTransactionManager;
    }

   @Bean
   public DefaultMessageListenerContainer appMessageListenerContainer(CachingConnectionFactory cachingConnectionFactory)
   {
	   DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
	   container.setConnectionFactory(cachingConnectionFactory);
	   container.setDestinationName("TRIG.TEST.USER01A");
	   container.setMessageListener(listenerMQ);
	   //container.setMaxConcurrentConsumers(3);
	   container.setSessionTransacted(true);
	   return container;
   }
    
    @Bean
    public JmsOperations jmsOperations(CachingConnectionFactory cachingConnectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
        jmsTemplate.setReceiveTimeout(2000);
        return jmsTemplate;
    }
}