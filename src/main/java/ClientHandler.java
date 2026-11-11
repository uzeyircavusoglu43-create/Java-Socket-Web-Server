import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (OutputStream out = clientSocket.getOutputStream();
             PrintWriter writer = new PrintWriter(out, true, StandardCharsets.UTF_8)) {

            // Kişisel bilgilerini buraya giriyorsun
            String htmlContent = HtmlGenerator.generateProfileHtml(
                    "Üzeyir Çavuşoğlu",
                    "1250505026",
                    "Yazılım mühendisliği alanında stajlara hazırlanan, Java ve nesne yönelimli programlama (OOP) üzerine derinlemesine çalışmalar yapan bir mühendis adayıyım. Özellikle temiz kod (Clean Code) mimarileri, SOLID tasarım prensipleri ve güncel web teknolojileri ilgi alanlarım arasındadır. Kariyerimde sağlam temeller atmak adına algoritmik problem çözme yeteneğimi sürekli geliştirmekteyim."
            );

            // HTTP 1.1 Standart Yanıt Başlıkları
            String httpResponse = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length: " + htmlContent.getBytes(StandardCharsets.UTF_8).length + "\r\n" +
                    "Connection: close\r\n\r\n" +
                    htmlContent;

            writer.print(httpResponse);
            writer.flush();

        } catch (Exception e) {
            System.err.println("İstemciye yanıt verilirken hata oluştu: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                System.err.println("Soket kapatılamadı: " + e.getMessage());
            }
        }
    }
}