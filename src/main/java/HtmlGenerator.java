public class HtmlGenerator {
    public static String generateProfileHtml(String name, String studentId, String bio) {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><meta charset=\"UTF-8\">");

        // CSS Biçimlendirmeleri (Renk, font, hizalama vb.)
        html.append("<style>");
        html.append("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f8f9fa; color: #343a40; margin: 50px; text-align: center; }");
        html.append("h1 { color: #2c3e50; font-size: 2.5em; border-bottom: 2px solid #3498db; display: inline-block; padding-bottom: 10px; }");
        html.append("h2 { color: #7f8c8d; font-weight: 300; margin-top: 10px; }");
        html.append("p { font-size: 1.1em; line-height: 1.8; margin-top: 30px; padding: 20px; background: #ffffff; border-radius: 10px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); display: inline-block; max-width: 600px; text-align: left; }");
        html.append("</style></head><body>");

        // Ödev İsterleri: H1 Ad Soyad, H2 Öğrenci No ve Biyografi
        html.append("<h1>").append(name).append("</h1><br>");
        html.append("<h2>Öğrenci No: ").append(studentId).append("</h2><br>");
        html.append("<p>").append(bio).append("</p>");

        html.append("</body></html>");
        return html.toString();
    }
}