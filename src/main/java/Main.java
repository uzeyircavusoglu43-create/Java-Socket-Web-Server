import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int PORT = 1989;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("✅ Web sunucusu başlatıldı.");
            System.out.println("🌐 Tarayıcınızdan şu adrese gidin: http://localhost:" + PORT);

            // Sunucu sürekli açık kalarak bağlantıları dinler
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Yeni bağlantı: " + clientSocket.getInetAddress());

                // SOLID prensiplerine uygun olarak işi ayrı bir Thread'de ClientHandler'a devrediyoruz
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Sunucu başlatılamadı (Port kullanımda olabilir): " + e.getMessage());
        }
    }
}