package com.lxy.spring_boot_hello_01.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
    private @Value("${rabbitmq.concurrency}") int concurrency;
    
	private @Value("${rabbitmq.exchangeName}") String exchanger;
	//
	private @Value("${rabbitmq.queueName}") String queue;
	private @Value("${rabbitmq.routingKey}") String routingKey;

	@Bean
	Queue queue() {
		return new Queue(queue, true);
	}
	
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchanger);
	}

	@Bean
	Binding bindingQueue(DirectExchange exchange) {
		return BindingBuilder.bind(queue()).to(exchange).with(routingKey);
	}
    
	@Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
    
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean("simpleRabbitListenerContainerFactory")
    public SimpleRabbitListenerContainerFactory pointTaskContainerFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();
        // 设置并发消费者的数量
        factory.setConcurrentConsumers(concurrency);
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    
    public int getConcurrency() {
        return concurrency;
    }
    
    public void setConcurrency(int concurrency) {
        this.concurrency = concurrency;
    }

}
