package com.example.producer.Entity;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.tomcat.util.buf.ByteBufferUtils;

import java.nio.ByteBuffer;

@Data
@Builder
@AllArgsConstructor
public class SendMsg {
    private String name;
    private String msg;
    public byte[] getByte(){
        ByteArrayBuilder byteArrayBuilder=new ByteArrayBuilder();
        byte[] bytes = this.name.getBytes();
        byte[] bytes1 = this.msg.getBytes();
        byteArrayBuilder.write(bytes);
        byteArrayBuilder.write(bytes1);
        System.out.println(byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }
}
