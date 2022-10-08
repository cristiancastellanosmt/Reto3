/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.servicio;

import com.example.demo.Modelo.Message;
import com.example.demo.Repositorio.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CRISTIAN CASTELLANOS
 */
@Service
public class MessageService {
   @Autowired
    private MessageRepository MessageRepository;
    
    public List<Message> getAll(){
        return MessageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return MessageRepository.getMessage(id);
    }
    
    public Message save (Message message){
        if (message.getIdMessage()==null){
            return MessageRepository.save(message);
        
        }else{
            Optional<Message>message1=MessageRepository.getMessage(message.getIdMessage());
            if(message1.isEmpty()){
               return MessageRepository.save(message);
            }else{
                return message;
            }
        }
    } 
}
