package com.example.test.chapter17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient {
    public void go() {
        InetSocketAddress serverAddr = new InetSocketAddress("127.0.0.1", 5000);
        // TWR 구문을 이용하여 코드가 완료되면 SocketChannel이 자동으로 닫히도록 함
        try (SocketChannel socketChannel = SocketChannel.open(serverAddr)) {

            // SocketChannel로부터 읽어들이는 Reader 생성
            Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
            // socketChannel로부터 가져온 Reader에 BufferedReader를 연쇄시킴
            BufferedReader reader = new BufferedReader(channelReader);

            // 이 readLine()은 파일에 연쇄된 BufferedReader를 쓸 때 사용한 readLine()과 완전히 같음
            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);

            // channelReader과 BufferedReader이 모두 닫히도록 함
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DailyAdviceClient().go();
    }
}
