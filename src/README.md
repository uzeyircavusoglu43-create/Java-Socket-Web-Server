# Java Socket Web Server - Profil Sayfası 🚀

Bu proje, 3. parti hiçbir web kütüphanesi (Spring, Tomcat vb.) kullanılmadan, sadece **Java Core kütüphaneleri (java.net.Socket)** kullanılarak geliştirilmiş sıfırdan bir HTTP Web Sunucusu uygulamasıdır. 

Uygulama, `1989` portu üzerinden dinleme yapar ve bağlanan web tarayıcısına özelleştirilmiş, HTML/CSS ile biçimlendirilmiş bir profil sayfası yanıtı döner. Proje mimarisi **SOLID prensipleri** göz önünde bulundurularak tasarlanmıştır.

## 🛠️ Kullanılan Teknolojiler
* Java 11+
* Java Core Networking (`java.net.ServerSocket`, `java.net.Socket`)
* Çok İş Parçacıklı Programlama (Multi-threading via `Runnable`)
* HTML5 & CSS3 (Satır içi stil biçimlendirmesi)

## ⚙️ Kurulum ve Çalıştırma
1. Projenin başlangıç noktası (main metodu) `src` dizinindeki **`Main.java`** dosyasıdır.
2. Projeyi IDE'nizde açtıktan sonra `Main.java` dosyasını çalıştırın.
3. Konsolda sunucunun başlatıldığını gördükten sonra web tarayıcınızın adres çubuğuna şunu yazın:
   ```text
   http://localhost:1989
🏗️ Mimari ve SOLID Prensipleri
Spaghetti Code yaklaşımından kaçınılmış, sorumluluklar modüllere ayrılmıştır:

Single Responsibility (Tek Sorumluluk): Main portu dinlemekten, ClientHandler gelen HTTP isteklerini yönetmekten, HtmlGenerator ise HTML string üretiminden sorumludur.

Open/Closed (Açık/Kapalı): İleride HTML yerine JSON yanıt dönmek istenirse, mevcut sınıfları bozmadan yeni bir Generator sınıfı eklenebilir.
