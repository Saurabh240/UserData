package com.geeks.course.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.geeks.course.model.Topic;

@Service
public class TopicService {
	       
           private List<Topic> topics = new ArrayList(Arrays.asList( 
				new Topic("java","Core Java", "Core Java Features"),
				new Topic("spring","SpringBoot", "Spring Boot Starter"),
				new Topic("sql","mysql", "MySQL database")
				));
           
           public List<Topic> getAllTopics() {
        	   return topics;
           }

		public Topic getTopic(String id) {
			
		  return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		}

		public void addTopic(Topic topic) {
			topics.add(topic);
		}

		public void updateTopic(String id, Topic topic) {
			for(int i=0;i<topics.size();i++) {
				Topic t = topics.get(i);
				if(id.equals(t.getId())) {
					topics.set(i, topic);
				}
			}
			
		}

		public void deleteTopic(String id) {
			topics.removeIf(t->t.getId().equals(id));
			
		}

}
