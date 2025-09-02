package com.example.test.chapter17;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClientA {
    private JTextField outgoing;
    private PrintWriter writer;

    public void go() {
        // 서버에 접속하기 위한 메서드 호출
        setUpNetworking();

        outgoing = new JTextField(20);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        JPanel mainPanel = new JPanel();
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
