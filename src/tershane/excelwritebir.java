package tershane;
import com.itextpdf.text.DocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;

public class excelwritebir {
    xlstopdf xp = new xlstopdf();
    public void write(String inp, String[][] data, String[][] data2, String firm, String proje, String stando, String instndrt, String austndrt, String inver, String znr, String zober, String pstand, String seite, String bnummer, String bdatum, String aunr, String annr, String ekipman_adı, String cihaz, String cenerji, String odak, String pozs, String fodakuz, String kursunek, String filtre, String fmark, String filmtip, String IQI, String ışıntaraf, String filmtaraf, String fişlemetek, String sıc, String geoygöl, String ısılişlem, String ononiki, String ononaltı, String onyirmidört, String onotuzaltı, String onkırksekiz, String otuzkırk, String gfilm, String rfilm, String bir, String iki, String üç, String dört, String beş, String altı, String mtarih, String ek) throws IOException, DocumentException, Exception{
        String fna =  "C:\\Users\\zsena\\Desktop\\" + firm + "_" + proje + ".xls";
        String pdf =  "C:\\Users\\zsena\\Desktop\\" + firm + "_" + proje + ".pdf";
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inspektionsbericht für magnetische Partikel");
        
        
        //create vertical pink cell style
        CellStyle styleVertical = workbook.createCellStyle();
        styleVertical.setRotation((short)90);
        styleVertical.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        styleVertical.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        
        //create pink cell style
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setWrapText(true);
        headerCellStyle.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        sheet.addMergedRegion(new CellRangeAddress(0,1,0,6));
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(" ");
        
        sheet.addMergedRegion(new CellRangeAddress(0,0,7,27));
        cell = row.createCell(7);
        cell.setCellValue("Gözetim Muayne ve Eğitim Hizmetleri");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(1,1,7,27));
        row = sheet.createRow(1);
        cell = row.createCell(7);
        cell.setCellValue("Radyografik Muayene Raporu");
        cell.setCellStyle(headerCellStyle);
        
        //create info rows - general info & gerat info
        createInfoRows(workbook, sheet, "Müşteri", "Muayne Prosedürü", "Sayfa No", firm, inp, seite, 2, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Proje Adı", "Muayne Kapsamı", "Rapor No", proje, inver, bnummer, 3, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Test Yeri", "Resim No", "Rapor Tarihi", stando, znr, bdatum, 4, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Muayne Standardı", "Yüzey Durumu", "İş Emri No", instndrt,zober, aunr, 5, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Değerlen. Standardı", "Muayne Aşaması", "Teklif No", austndrt, pstand, annr, 6, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        
        sheet.addMergedRegion(new CellRangeAddress(7,7,0,27));
        row = sheet.createRow(7);
        cell = row.createCell(0);
        cell.setCellValue("Ekimpan Bilgileri");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(8);
        sheet.addMergedRegion(new CellRangeAddress(8,9,0,1));
        cell = row.createCell(0);
        cell.setCellValue("Ekipman Adı/No");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,9,2,8));
        cell = row.createCell(2);
        cell.setCellValue("Kullanılan Cihaz");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,8,9,15));
        cell = row.createCell(9);
        cell.setCellValue("Cihazın Enerjisi");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,9,16,19));
        cell = row.createCell(16);
        cell.setCellValue("Odak Boyutu");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,9,20,21));
        cell = row.createCell(20);
        cell.setCellValue("Poz Süresi");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,9,22,24));
        cell = row.createCell(22);
        cell.setCellValue("Çekim Mesafesi");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,9,25,26));
        cell = row.createCell(25);
        cell.setCellValue("Kurşun Ekranlar");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(8,9,27,27));
        cell = row.createCell(27);
        cell.setCellValue("Filtreler");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(9);
        sheet.addMergedRegion(new CellRangeAddress(9,9,9,10));
        cell = row.createCell(9);
        cell.setCellValue("lr-192");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(9,9,11,12));
        cell = row.createCell(11);
        cell.setCellValue("Se-75");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(9,9,13,15));
        cell = row.createCell(13);
        cell.setCellValue("X-Ray Kv/mA");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(10);
        sheet.addMergedRegion(new CellRangeAddress(10,10,0,1));
        cell = row.createCell(0);
        cell.setCellValue(ekipman_adı);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,2,8));
        cell = row.createCell(2);
        cell.setCellValue(cihaz);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,9,10));
        cell = row.createCell(9);
        cell.setCellValue("-");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,11,12));
        cell = row.createCell(11);
        cell.setCellValue("-");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,13,14));
        cell = row.createCell(13);
        cell.setCellValue("-");
        cell.setCellStyle(headerCellStyle);
        
        cell = row.createCell(15);
        cell.setCellValue("-");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,16,19));
        cell = row.createCell(16);
        cell.setCellValue(odak);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,20,21));
        cell = row.createCell(20);
        cell.setCellValue(pozs);
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,22,24));
        cell = row.createCell(22);
        cell.setCellValue(fodakuz);
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(10,10,25,26));
        cell = row.createCell(25);
        cell.setCellValue(kursunek);
        cell.setCellStyle(headerCellStyle);
        
        cell = row.createCell(27);
        cell.setCellValue(filtre);
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(11);
        sheet.addMergedRegion(new CellRangeAddress(11,12,0,1));
        cell = row.createCell(0);
        cell.setCellValue("Isıl İşlem");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(11,12,2,6));
        cell = row.createCell(2);
        cell.setCellValue("Geometrik Yarı Gölge");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(11,11,7,16));
        cell = row.createCell(7);
        cell.setCellValue("Film Bilgileri");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(11,11,17,23));
        cell = row.createCell(17);
        cell.setCellValue("IQI Tekniği");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(11,11,24,27));
        cell = row.createCell(24);
        cell.setCellValue("Banyo İşlemleri");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(12);
        sheet.addMergedRegion(new CellRangeAddress(12,13,7,9));
        cell = row.createCell(7);
        cell.setCellValue("Film Markası");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(12,12,10,16));
        cell = row.createCell(9);
        cell.setCellValue("Film Tipi");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(12,12,17,23));
        cell = row.createCell(17);
        cell.setCellValue(IQI);
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(12,13,24,24));
        cell = row.createCell(24);
        cell.setCellValue("Otomatik");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(12,13,25,25));
        cell = row.createCell(25);
        cell.setCellValue("El ile");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(12,13,26,27));
        cell = row.createCell(26);
        cell.setCellValue("Sıcaklık");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(13);
        sheet.addMergedRegion(new CellRangeAddress(13,14,0,1));
        cell = row.createCell(0);
        cell.setCellValue(ısılişlem);
        
        sheet.addMergedRegion(new CellRangeAddress(13,14,2,6));
        cell = row.createCell(2);
        cell.setCellValue(geoygöl);
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(13,13,10,11));
        cell = row.createCell(10);
        cell.setCellValue("D4(MX-125)");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(13,13,12,14));
        cell = row.createCell(12);
        cell.setCellValue("D5(T200)");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(13,13,15,16));
        cell = row.createCell(15);
        cell.setCellValue("D7(AA400)");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(13,13,17,20));
        cell = row.createCell(17);
        cell.setCellValue("Işın Tarafı");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(13,13,21,23));
        cell = row.createCell(21);
        cell.setCellValue("Film Tarafı");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(14);
        sheet.addMergedRegion(new CellRangeAddress(14,14,7,9));
        cell = row.createCell(7);
        cell.setCellValue(fmark);
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,10,11));
        cell = row.createCell(10);
        cell.setCellValue("");/////////////////////////////////////////////////////////if film tipi ==
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,12,14));
        cell = row.createCell(12);
        cell.setCellValue("");/////////////////////////////////////////////////////////if film tipi ==
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,15,16));
        cell = row.createCell(15);
        cell.setCellValue("");/////////////////////////////////////////////////////////if film tipi ==
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,17,20));
        cell = row.createCell(17);
        cell.setCellValue(ışıntaraf);
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,21,23));
        cell = row.createCell(21);
        cell.setCellValue(filmtaraf);
        
        
        cell = row.createCell(24);
        cell.setCellValue(""); ///////////////////////////////////////////////////////////if otomatik
        
        
        cell = row.createCell(25);
        cell.setCellValue("");/////////////////////////////////////////////////////////if el ile
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,26,27));
        cell = row.createCell(26);
        cell.setCellValue(sıc); 
        
        sheet.addMergedRegion(new CellRangeAddress(15,15,0,27));
        row = sheet.createRow(15);
        cell = row.createCell(0);
        cell.setCellValue("Film Çekim Sonuç Bilgileri");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(16);
        sheet.addMergedRegion(new CellRangeAddress(16,16,0,1));
        cell = row.createCell(0);
        cell.setCellValue("Film Ebadı");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,2,6));
        cell = row.createCell(2);
        cell.setCellValue("10x12");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,7,10));
        cell = row.createCell(7);
        cell.setCellValue("10x16");
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,11,14));
        cell = row.createCell(11);
        cell.setCellValue("10x24");
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,15,17));
        cell = row.createCell(15);
        cell.setCellValue("10x36");
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,18,20));
        cell = row.createCell(18);
        cell.setCellValue("10x48");
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,21,22));
        cell = row.createCell(21);
        cell.setCellValue("30x40");
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,23,25));
        cell = row.createCell(23);
        cell.setCellValue("Uygun Film");
        
        sheet.addMergedRegion(new CellRangeAddress(16,16,26,27));
        cell = row.createCell(26);
        cell.setCellValue("Tamir Filmi");
        
        row = sheet.createRow(17);
        sheet.addMergedRegion(new CellRangeAddress(17,17,0,1));
        cell = row.createCell(0);
        cell.setCellValue("Film Sayısı");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,2,6));
        cell = row.createCell(2);
        cell.setCellValue(ononiki);
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,7,10));
        cell = row.createCell(7);
        cell.setCellValue(ononaltı);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,11,14));
        cell = row.createCell(11);
        cell.setCellValue(onyirmidört);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,15,17));
        cell = row.createCell(15);
        cell.setCellValue(onotuzaltı);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,18,20));
        cell = row.createCell(18);
        cell.setCellValue(onkırksekiz);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,21,22));
        cell = row.createCell(21);
        cell.setCellValue(otuzkırk);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,23,25));
        cell = row.createCell(23);
        cell.setCellValue(gfilm);
        
        sheet.addMergedRegion(new CellRangeAddress(17,17,26,27));
        cell = row.createCell(26);
        cell.setCellValue(rfilm);
        
        row = sheet.createRow(18);
        sheet.addMergedRegion(new CellRangeAddress(18,18,0,4));
        cell = row.createCell(0);
        cell.setCellValue("Değerlendirme Sembolleri");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(18,18,5,10));
        cell = row.createCell(6);
        cell.setCellValue("KABUL OK");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(18,18,11,12));
        cell = row.createCell(11);
        cell.setCellValue("TAMİR R");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(18,18,13,17));
        cell = row.createCell(13);
        cell.setCellValue("KES  C/O");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(18,18,18,23));
        cell = row.createCell(18);
        cell.setCellValue("FİLM TEKRARI RS");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(18,18,24,27));
        cell = row.createCell(24);
        cell.setCellValue("EKSTRA FİLM  EF");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(19);
        sheet.addMergedRegion(new CellRangeAddress(19,24,0,1));
        cell = row.createCell(0);
        cell.setCellValue("Çekim Düzenlemesi");
        cell.setCellStyle(styleVertical);
        
        int pictureIdx;
        try ( //resimler
            InputStream inputStream = new FileInputStream("C:/xx.jpeg")) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            inputStream.close();
        
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(2); 
            anchor.setRow1(19); 
            anchor.setCol2(27); 
            anchor.setRow2(23);

            Picture pict = drawing.createPicture(anchor, pictureIdx);
           // pict.resize();
        }
        
        row = sheet.createRow(24);
        sheet.addMergedRegion(new CellRangeAddress(24,24,2,4));
        cell = row.createCell(2);
        cell.setCellValue(bir);
        
        sheet.addMergedRegion(new CellRangeAddress(24,24,5,10));
        cell = row.createCell(5);
        cell.setCellValue(iki);
        
        sheet.addMergedRegion(new CellRangeAddress(24,24,11,14));
        cell = row.createCell(11);
        cell.setCellValue(üç);
        
        sheet.addMergedRegion(new CellRangeAddress(24,24,15,19));
        cell = row.createCell(15);
        cell.setCellValue(dört);
        
        sheet.addMergedRegion(new CellRangeAddress(24,24,20,24));
        cell = row.createCell(20);
        cell.setCellValue(beş);
        
        sheet.addMergedRegion(new CellRangeAddress(24,24,25,27));
        cell = row.createCell(25);
        cell.setCellValue(altı);
        
        createhatabaslık(workbook, sheet, 25);
        createhata(workbook, sheet, 27, "Aa", "2011", "Prository/Gözenek", "Db", "515", "Root Suck Back/Kökte Geri Çekilme-Konkavite");
        createhata(workbook, sheet, 28, "Ab", "2016", "Worm Holes/Gaz Kanalları", "Dc", "504", "Exessive Penetration/Aşırı Nüfuziyet-Konvexite");
        createhata(workbook, sheet, 29, "Ac", "2014", "Aligned Porosity/Sıral Gözenekler", "Ea", "1011", "Longitudinal Crack/Boyuna Çatlak");
        createhata(workbook, sheet, 30, "Ad", "2013", "Prosity Group/Gözenek Grubu", "Eb", "10211023,1", "Transverse Crack/Enine Çatlak");
        createhata(workbook, sheet, 31, "Ba", "3012", "Slag Inclusion/Clüf Kalıntısı", "Ec", "1046,1047,1054", "Crater Cracks/Krater Çatlakları");
        createhata(workbook, sheet, 32, "Bb", "3011", "Slag Line/Sıralı Cüruf Hattı", "Fb", "517,5091", "Bad Weld Surface/Kötü Kaynak Yüzeyi");
        createhata(workbook, sheet, 33, "Bc", "3013", "Slag Group (Clustered)/Kümelenmiş Cüruf Kalıntısı", "Fc", "5011,5012,5013", "Undercut/Yanma Oluğu");
        createhata(workbook, sheet, 34, "C", "4011", "Lack Of Fusion/Yapışma Noksanlığı", "ff", "-", "Film Failure/Film Çekim veya Banyo Hataları");
        createhata(workbook, sheet, 35, "D", "402,4021,4013", "Incomplete Penetration/Nüfüziyet Eksikliği", "W", "3041", "Tungsten Inclusion/Tungsten Kalıntısı");
        
        row = sheet.createRow(36);
        sheet.addMergedRegion(new CellRangeAddress(36,36,0,15));
        cell = row.createCell(0);
        cell.setCellValue("Muayene Tarihleri");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(36,36,16,27));
        cell = row.createCell(16);
        cell.setCellValue(bdatum);
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(37);
        sheet.addMergedRegion(new CellRangeAddress(37,37,0,15));
        cell = row.createCell(0);
        cell.setCellValue("Açıklamalar ve Ekler");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(37,37,16,27));
        cell = row.createCell(16);
        cell.setCellValue(" ");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(38,38,0,27));
        row = sheet.createRow(38);
        cell = row.createCell(0);
        cell.setCellValue("Muayene Sonuçları");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(39);
        cell = row.createCell(0);
        cell.setCellValue("Sıra No");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,1,4));
        cell = row.createCell(1);
        cell.setCellValue("Çekim Bölgesi");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,5,7));
        cell = row.createCell(5);
        cell.setCellValue("Film Numarası");
        cell.setCellStyle(headerCellStyle);
        
        cell = row.createCell(8);
        cell.setCellValue("Malzeme Cinsi");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(9);
        cell.setCellValue("Kaynak Yönt.");
        cell.setCellStyle(styleVertical);
       
        cell = row.createCell(10);
        cell.setCellValue("Kaynakçı No");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(11);
        cell.setCellValue("POZİSYON");
        cell.setCellStyle(styleVertical);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,12,14));
        cell = row.createCell(12);
        cell.setCellValue("Kalınlık(mm)");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(15);
        cell.setCellValue("Penetremetre");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(16);
        cell.setCellValue("Görünen Tel");
        cell.setCellStyle(styleVertical);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,17,18));
        cell = row.createCell(17);
        cell.setCellValue("Yoğunluk");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(19);
        cell.setCellValue("10x12");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(20);
        cell.setCellValue("10x16");
        cell.setCellStyle(styleVertical);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,20,21));
        cell = row.createCell(20);
        cell.setCellValue("10x24");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(21);
        cell.setCellValue("10x36");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(22);
        cell.setCellValue("10x48");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(23);
        cell.setCellValue("30x40");
        cell.setCellStyle(styleVertical);
       
        cell = row.createCell(24);
        cell.setCellValue("Hata Bölgesi");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(25);
        cell.setCellValue("Hata Tipi");
        cell.setCellStyle(styleVertical);
        
        cell = row.createCell(26);
        cell.setCellValue("ön Değerlen.");
        cell.setCellStyle(headerCellStyle);
        
        cell = row.createCell(27);
        cell.setCellValue("Kesin Değerlen.");
        cell.setCellStyle(headerCellStyle);
        
        
        int count=40;
        for(int r=0; r<2; r++ ){
            row = sheet.createRow(count);
            cell = row.createCell(0);
        cell.setCellValue(data[r][0]);
        
        sheet.addMergedRegion(new CellRangeAddress(count,count,1,4));
        cell = row.createCell(1);
        cell.setCellValue(data[r][1]);
        
        sheet.addMergedRegion(new CellRangeAddress(count,count,5,7));
        cell = row.createCell(5);
        cell.setCellValue(data[r][2]);
        
        cell = row.createCell(8);
        cell.setCellValue(data[r][3]);
        
        cell = row.createCell(9);
        cell.setCellValue(data[r][4]);
       
        cell = row.createCell(10);
        cell.setCellValue(data[r][5]);
        
        cell = row.createCell(11);
        cell.setCellValue(data[r][6]);
        
        sheet.addMergedRegion(new CellRangeAddress(count,count,12,14));
        cell = row.createCell(12);
        cell.setCellValue(data[r][7]);
        
        cell = row.createCell(15);
        cell.setCellValue(data[r][8]);
        
        cell = row.createCell(16);
        cell.setCellValue(data[r][9]);
        
        sheet.addMergedRegion(new CellRangeAddress(count,count,17,18));
        cell = row.createCell(17);
        cell.setCellValue(data[r][10]);
        
        cell = row.createCell(19);
        cell.setCellValue(data[r][11]);
        
        cell = row.createCell(20);
        cell.setCellValue(data[r][12]);
        
        sheet.addMergedRegion(new CellRangeAddress(count,count,20,21));
        cell = row.createCell(20);
        cell.setCellValue(data[r][13]);
        
        cell = row.createCell(21);
        cell.setCellValue(data[r][14]);
        
        cell = row.createCell(22);
        cell.setCellValue(data[r][15]);
        
        cell = row.createCell(23);
        cell.setCellValue(data[r][16]);
       
        cell = row.createCell(24);
        cell.setCellValue(data[r][17]);
        
        cell = row.createCell(25);
        cell.setCellValue(data[r][18]);
        
        cell = row.createCell(26);
        cell.setCellValue(data[r][19]);
        
        cell = row.createCell(27);
        cell.setCellValue(data[r][20]);
            
            count = count + 1;
        }
        
        row = sheet.createRow(43);
        
        sheet.addMergedRegion(new CellRangeAddress(43,43,0,4));
        cell = row.createCell(0);
        cell.setCellValue("Personel Bilgileri");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(43,43,5,14));
        cell = row.createCell(5);
        cell.setCellValue("Filmi Çeken");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(43,43,15,19));
        cell = row.createCell(15);
        cell.setCellValue("Değerlendiren");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(43,43,20,24));
        cell = row.createCell(20);
        cell.setCellValue("Onay");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(43,43,25,27));
        cell = row.createCell(25);
        cell.setCellValue("Müşteri");
        cell.setCellStyle(headerCellStyle);
        
        count = 44;
        for(int y=0; y<4; y++){
            row = sheet.createRow(count);
        
            sheet.addMergedRegion(new CellRangeAddress(count,count,0,4));
            cell = row.createCell(0);
            cell.setCellValue(data2[y][0]);
            cell.setCellStyle(headerCellStyle);

            sheet.addMergedRegion(new CellRangeAddress(count,count,5,14));
            cell = row.createCell(5);
            cell.setCellValue(data2[y][1]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,15,19));
            cell = row.createCell(15);
            cell.setCellValue(data2[y][2]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,20,24));
            cell = row.createCell(20);
            cell.setCellValue(data2[y][3]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,25,27));
            cell = row.createCell(25);
            cell.setCellValue(data2[y][4]);
            
            count = count + 1;
        }
            
        float widthExcel = 5.11f;
        int width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(0, width256);
        widthExcel = 3.11f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(1, width256);
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(2, width256);
        widthExcel = 0.80f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(3, width256);
        widthExcel = 1.50f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(4, width256);
        widthExcel = 0.70f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(5, width256);
        widthExcel = 2.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(6, width256);
        widthExcel = 1.20f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(7, width256);
        widthExcel = 3.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(8, width256);
        widthExcel = 1.20f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(9, width256);
        widthExcel = 3.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(10, width256);
        widthExcel = 2.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(11, width256);
        widthExcel = 0.11f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(12, width256);
        widthExcel = 0.11f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(13, width256);
        widthExcel = 0.11f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(14, width256);
        widthExcel = 4.20f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(15, width256);
        widthExcel = 2.20f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(16, width256);
        widthExcel = 6.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(17, width256);
        widthExcel = 2.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(18, width256);
        widthExcel = 1.90f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(19, width256);
        widthExcel = 2.50f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(20, width256);
        widthExcel = 0.11f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(21, width256);
        widthExcel = 4.30f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(22, width256);
        widthExcel = 1.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(23, width256);
        widthExcel = 3.30f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(24, width256);
        widthExcel = 3.00f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(25, width256);
        widthExcel = 4.20f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(26, width256);
        
        
        
        try(FileOutputStream outputStream = new FileOutputStream(fna)) {
            workbook.write(outputStream);
            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        xp.pdf(fna, pdf);
        
        
    }
    
    private void createInfoRows(Workbook workbook, Sheet sheet, String l1, String l2, String l3, String a1, String a2, String a3, int r, int c1, int c2, int c21, int c22, int c31, int c32,int c41, int c42,int c51, int c52, int c61, int c62){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c1,c2));
        
        Row row = sheet.createRow(r);
        
        Cell pCell1 = row.createCell(c1);
        pCell1.setCellValue(l1);
        pCell1.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c21,c22));
        Cell pCel1 = row.createCell(c21);
        pCel1.setCellValue(a1);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c31,c32));
        Cell pCell2 = row.createCell(c31);
        pCell2.setCellValue(l2);
        pCell2.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c41,c42));
        Cell pCel2 = row.createCell(c41);
        pCel2.setCellValue(a2);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c51,c52));
        Cell pCell3 = row.createCell(c51);
        pCell3.setCellValue(l3);
        pCell3.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c61,c62));
        Cell pCel3 = row.createCell(c61);
        pCel3.setCellValue(a3);
        
       
    }
    
    private void createhatabaslık(Workbook workbook, Sheet sheet, int r){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        Row row = sheet.createRow(r);
        sheet.addMergedRegion(new CellRangeAddress(r,r,0,2));
        Cell c = row.createCell(0);
        c.setCellValue("According to");
        c.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r+1,3,15));
        c = row.createCell(3);
        c.setCellValue("Hata Tipleri");
        c.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,16,18));
        c = row.createCell(16);
        c.setCellValue("According to");
        c.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r+1,19,27));
        c = row.createCell(19);
        c.setCellValue("Hata Tipleri");
        c.setCellStyle(style);
        
        row = sheet.createRow(r+1);
        Cell ce = row.createCell(0);
        ce.setCellValue("IIW");
        ce.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r+1,r+1,1,2));
        ce = row.createCell(1);
        ce.setCellValue("6520-1");
        ce.setCellStyle(style);
        
        ce = row.createCell(16);
        ce.setCellValue("IIW");
        ce.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r+1,r+1,17,18));
        ce = row.createCell(17);
        ce.setCellValue("6520-1");
        ce.setCellStyle(style);
        
        
    }
    
    private void createhata(Workbook workbook, Sheet sheet, int r, String a, String aa, String b, String c, String cc, String d){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        Row row = sheet.createRow(r);
        Cell ce = row.createCell(0);
        ce.setCellValue(a);
        ce.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,1,2));
        ce = row.createCell(1);
        ce.setCellValue(aa);
        ce.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,3,15));
        ce = row.createCell(3);
        ce.setCellValue(b);
        ce.setCellStyle(style);
        
        ce = row.createCell(16);
        ce.setCellValue(c);
        ce.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,17,18));
        ce = row.createCell(17);
        ce.setCellValue(cc);
        ce.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,19,27));
        ce = row.createCell(19);
        ce.setCellValue(d);
        ce.setCellStyle(style);
    }
    
}
