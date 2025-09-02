package com.example.test.chapter17;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClient {
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;

    public void go() {
        // 서버에 접속하기 위한 메서드 호출
        setUpNetworking();
        
        JScrollPane scroller = createScrollableTextArea();

        outgoing = new JTextField(20);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(scroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new IncomingReader());

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JScrollPane createScrollableTextArea() {
        incoming = new JTextArea(15, 30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller   = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        return scroller;
    }

    private void sendMessage() {
        writer.println(outgoing.getText());
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    private void setUpNetworking() {
        try {
            // 클라이언트와 서버를 한 시스템에서 테스트할 수 있도록 localhost 사용
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);

            // 서버에 연결할 SocketChannel 엶
            SocketChannel socketChannel = SocketChannel.open(serverAddress);
            // SocketChannel에 쓰는 writer로부터 PrintWriter를 만드는 부분
            writer = new PrintWriter(Channels.newWriter(socketChannel, UTF_8));
            System.out.println("Networking established");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 스레드가 하는 일
    // run 메서드에서 반복문을 돌리면서 받아온 메세지를 한 줄씩 읽어 각 줄을 스크롤링 텍스트 영역에 추가함
    public class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;

            try {
                while((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
}
