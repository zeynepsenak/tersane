package tershane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;

public class excelwrite {
    //String[][] data,
    public void write(String[][] data, String[][] data2, String firm, String proje, String stando, String instndrt, String austndrt, String inver, String inumfang, String znr, String zober, String pstand, String seite, String bnummer, String bdatum, String aunr, String annr, String polabst, String gerat, String Mp, String MagTech, String Uv, String entlicht, String untber, String strom, String lmet, String tmed, String entmeg, String wbehandlung, String obertemp, String gauss, String zoberfl, String idlicht, String beltestdatnr, String sscw, String fscw, String sabw, String inter, String anhange) throws Exception{
        String fna =  "C:\\Users\\zsena\\Desktop\\" + firm + "_" + proje + ".xls";
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Inspektionsbericht für magnetische Partikel");
        
        //create pink cell style
        CellStyle headerCellStyle = workbook.createCellStyle();
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
        cell.setCellValue("Manyetik Parçacık Muayene Raporu");
        cell.setCellStyle(headerCellStyle);
        

        //create info rows - general info & gerat info
        createInfoRows(workbook, sheet, "Müşteri", "Muayne Prosedürü", "Sayfa No", firm, inver, seite, 2, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Proje Adı", "Muayne Kapsamı", "Rapor No", proje, inumfang, bnummer, 3, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Test Yeri", "Resim No", "Rapor Tarihi", stando, znr, bdatum, 4, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Muayne Standardı", "Yüzey Durumu", "İş Emri No", instndrt,zober, aunr, 5, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Değerlen. Standardı", "Muayne Aşaması", "Teklif No", austndrt, pstand, annr, 6, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        
        sheet.addMergedRegion(new CellRangeAddress(7,7,0,27));
        row = sheet.createRow(7);
        cell = row.createCell(0);
        cell.setCellValue("Ekimpan Bilgileri");
        cell.setCellStyle(headerCellStyle);
        
        createInfoRows(workbook, sheet, "Polabstand", "Untersuchungsbereich", "Oberflächentemperature", polabst, untber, obertemp, 8, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "Gerät", "Strom Art", "Gauss-Feldstärke", gerat, strom, gauss, 9, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "MP Trägermedium", "Luxmetre", "Zustand der Oberfläche", Mp, lmet, zoberfl, 10, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "Magnetisierungstechnik", "Testmedium", "Identifizierung von Lichtgeräten", MagTech, tmed, idlicht, 11, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "UV-Lichtintensität", "Entmagnetierung", "Beleuctungstest Datum/Nummer", Uv, entmeg, beltestdatnr, 12, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "Entfernung des Lichts", "Wärmebehandlung", " ", entlicht, wbehandlung, " ", 13, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        
        
        int pictureIdx;
        String x = "";
        if(sscw.equals("+") && fscw.equals("+")){
            x = "C:/dolu.jpeg";
        }else if(sscw.equals("+") && fscw.equals("-")){
            x = "C:/bir.jpeg" ;
        }else if(sscw.equals("-") && fscw.equals("+")){
            x = "C:/iki.jpeg";
        }else if(sscw.equals("-") && fscw.equals("-")){
            x = "C:/bos.jpeg";
        }
        try ( //resimler
            InputStream inputStream = new FileInputStream(x)) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            inputStream.close();
        
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0); 
            anchor.setRow1(14); 
            anchor.setCol2(15); 
            anchor.setRow2(19);

            Picture pict = drawing.createPicture(anchor, pictureIdx);
           // pict.resize();
        }
        
       
        
        sheet.addMergedRegion(new CellRangeAddress(14,14,16,27));
        row = sheet.createRow(14);
        cell = row.createCell(16);
        cell.setCellValue("Orte der Diskontinuität ");
        cell.setCellStyle(headerCellStyle);
        
        createDiscRows(workbook, sheet, 15, "BM", "UNENDLESS METALL", 16, 17, 18, 27);
        createDiscRows(workbook, sheet, 16, "HAZ", "WÄRMEBETROFFENE ZONE", 16, 17, 18, 27);
        createDiscRows(workbook, sheet, 17, "W", "SCHWEIßUNG", 16, 17, 18, 27);
        createDiscRows(workbook, sheet, 18, "B", "FASE", 16, 17, 18, 27);   
        
        sheet.addMergedRegion(new CellRangeAddress(19,19,0,6));
        row = sheet.createRow(19);
        cell = row.createCell(0);
        cell.setCellValue("Standardabweichungen");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(19,19,7,27));
        cell = row.createCell(7);
        cell.setCellValue(sabw);
        
        sheet.addMergedRegion(new CellRangeAddress(20,20,0,6));
        row = sheet.createRow(20);
        cell = row.createCell(0);
        cell.setCellValue("Inspektionstermine");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(20,20,7,27));
        cell = row.createCell(7);
        cell.setCellValue(inter);
        
        sheet.addMergedRegion(new CellRangeAddress(21,21,0,6));
        row = sheet.createRow(21);
        cell = row.createCell(0);
        cell.setCellValue("Beschreibungen und Anhänge");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(21,21,7,27));
        cell = row.createCell(7);
        cell.setCellValue(anhange);
        
        sheet.addMergedRegion(new CellRangeAddress(22,22,0,27));
        row = sheet.createRow(22);
        cell = row.createCell(0);
        cell.setCellValue("Inspektionsergebnisse");
        cell.setCellStyle(headerCellStyle);
        
        row = sheet.createRow(23);
        cell = row.createCell(0);
        cell.setCellValue("Sıra No");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(23,23,1,7));
        cell = row.createCell(1);
        cell.setCellValue("Kaynak/Parça No");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(23,23,8,10));
        cell = row.createCell(8);
        cell.setCellValue("Kontrol Uzun.");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(23,23,11,16));
        cell = row.createCell(11);
        cell.setCellValue("Kaynal Yön.");
        cell.setCellStyle(headerCellStyle);
        
        cell = row.createCell(17);
        cell.setCellValue("Kalınlık(mm)");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(23,23,18,21));
        cell = row.createCell(18);
        cell.setCellValue("Çap(mm)");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(23,23,22,23));
        cell = row.createCell(22);
        cell.setCellValue("Hata Tipi");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(23,23,24,26));
        cell = row.createCell(24);
        cell.setCellValue("Hatanın Yeri");
        cell.setCellStyle(headerCellStyle);
        
        cell = row.createCell(27);
        cell.setCellValue("Sonuç");
        cell.setCellStyle(headerCellStyle);
        
        int count=24;
        for(int r=0; r<15; r++ ){
            row = sheet.createRow(count);
            
            cell = row.createCell(0);
            cell.setCellValue(data[r][0]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,1,7));
            cell = row.createCell(1);
            cell.setCellValue(data[r][1]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,8,10));
            cell = row.createCell(8);
            cell.setCellValue(data[r][2]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,11,16));
            cell = row.createCell(11);
            cell.setCellValue(data[r][3]);

            cell = row.createCell(17);
            cell.setCellValue(data[r][4]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,18,21));
            cell = row.createCell(18);
            cell.setCellValue(data[r][5]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,22,23));
            cell = row.createCell(22);
            cell.setCellValue(data[r][6]);

            sheet.addMergedRegion(new CellRangeAddress(count,count,24,26));
            cell = row.createCell(24);
            cell.setCellValue(data[r][7]);

            cell = row.createCell(27);
            cell.setCellValue(data[r][8]);
            
            count = count + 1;
        }
        
        row = sheet.createRow(39);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,0,4));
        cell = row.createCell(0);
        cell.setCellValue("Personel Bilgileri");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,5,14));
        cell = row.createCell(5);
        cell.setCellValue("Operatör");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,15,19));
        cell = row.createCell(15);
        cell.setCellValue("Değerlendiren");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,20,24));
        cell = row.createCell(20);
        cell.setCellValue("Onay");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(39,39,25,26));
        cell = row.createCell(25);
        cell.setCellValue("Müşteri");
        cell.setCellStyle(headerCellStyle);
        
        count = 40;
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

            sheet.addMergedRegion(new CellRangeAddress(count,count,25,26));
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
        widthExcel = 5.90f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(15, width256);
        widthExcel = 1.20f;
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
        widthExcel = 1.50f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(20, width256);
        widthExcel = 0.11f;
        width256 = (int)Math.floor((widthExcel * Units.DEFAULT_CHARACTER_WIDTH + 5) / Units.DEFAULT_CHARACTER_WIDTH * 256);
        sheet.setColumnWidth(21, width256);
        widthExcel = 6.00f;
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
    
    private void createDiscRows(Workbook workbook, Sheet sheet, int r, String a, String b, int c1, int c2, int c21, int c22){
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
       
        sheet.addMergedRegion(new CellRangeAddress(r,r,c1,c2));
        
        Row row = sheet.createRow(r);
        
        Cell cell = row.createCell(c1);
        cell.setCellValue(a);
        cell.setCellStyle(style);
        
        sheet.addMergedRegion(new CellRangeAddress(r,r,c21,c22));
        cell = row.createCell(c21);
        cell.setCellValue(b);
        cell.setCellStyle(style);
    }
    
    
   
    
}
