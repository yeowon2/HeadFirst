package com.example.test.chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceServer {
    final private String[] adviceList = {
        "조금씩 드세요.",
        "꼭 맞는 청바지를 입어보세요. 정말 잘 어울릴 거예요!",
        "한 마디만 하겠습니다: 그건 좋지 않아요.",
        "오늘 하루만 솔직해집시다. 윗사람에게 용감하게 의견을 말해보세요.",
        "그 머리 스타일 말고 다른 헤어 스타일은 어떨까요?"
    };
    private final Random random = new Random();

    public void go() {
        // ServerSocketChannel을 통해 이 서버 애플리케이션이 바인딩된 포트로 들어오는 클라이언트 요청을 감시하게 됨
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            // ServerSocketChannel을 이 애플리케이션을 실행시키고자 하는 포트로 바인딩해야 함
            serverChannel.bind(new InetSocketAddress(5000));

            // 서버에서는 무한 루프를 돌면서 클라이언트 요청이 들어오길 기다림
            while(serverChannel.isOpen()) {
                // accept() 메서드는 요청이 들어올 때까지 기다리다 요청이 들어오면 클라이언트와의 통신을 위한 SocketChannel을 리턴함
                SocketChannel clientChannel = serverChannel.accept();
                // 클라이언트의 채널에 대해 출력 스트림을 생성하고 PrintWriter로 감쌈
                // 여기에 newOutputStream이나 new Writer를 사용할 수 있음
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));

                String advice = getAdvice();
                writer.println(advice);
                // wirter를 닫는데 이 때 SocketChannel도 함께 닫힘
                writer.close();
                System.out.println(advice);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int nextAdvice = random.nextInt(adviceList.length);
        return adviceList[nextAdvice];
    }

    public static void main(String[] args) {
        new DailyAdviceServer().go();
    }
}
