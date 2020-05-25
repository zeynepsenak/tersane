package tershane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

public class excelwrite {
    
    public void write(String firm, String proje, String stando, String instndrt, String austndrt, String inver, String inumfang, String znr, String zober, String pstand, String seite, String bnummer, String bdatum, String aunr, String annr, String polabst, String gerat, String Mp, String MagTech, String Uv, String entlicht, String untber, String strom, String lmet, String tmed, String entmeg, String wbehandlung, String obertemp, String gauss, String zoberfl, String idlicht, String beltestdatnr, String sscw, String fscw, String sabw, String inter, String anhange) throws Exception{
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
        cell.setCellValue("Inspektionsbericht für magnetische Partikel");
        cell.setCellStyle(headerCellStyle);
        

        //create info rows - general info & gerat info
        createInfoRows(workbook, sheet, "Kunde", "Inspektionsverfahren", "Seite", firm, inver, seite, 2, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Projectname", "Inspektionsumfang", "Bericht Nr", proje, inumfang, bnummer, 3, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Inspektionsstandort", "Zeichnung Nr", "Bericht Datum", stando, znr, bdatum, 4, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Inspektionsstandard", "Zustand der Oberfläche", "Auftragsnr", instndrt,zober, aunr, 5, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        createInfoRows(workbook, sheet, "Auswertungsstandard", "Prüfungsstand", "Angebot Nr", austndrt, pstand, annr, 6, 0, 2, 3, 15, 16, 18, 19, 22, 23, 25, 26, 27 );
        
        sheet.addMergedRegion(new CellRangeAddress(7,7,0,27));
        row = sheet.createRow(7);
        cell = row.createCell(0);
        cell.setCellValue("Gerätsinformationen");
        cell.setCellStyle(headerCellStyle);
        
        createInfoRows(workbook, sheet, "Polabstand", "Untersuchungsbereich", "Oberflächentemperature", polabst, untber, obertemp, 8, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "Gerät", "Strom Art", "Gauss-Feldstärke", gerat, strom, gauss, 9, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "MP Trägermedium", "Luxmetre", "Zustand der Oberfläche", Mp, lmet, zoberfl, 10, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "Magnetisierungstechnik", "Testmedium", "Identifizierung von Lichtgeräten", MagTech, tmed, idlicht, 11, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "UV-Lichtintensität", "Entmagnetierung", "Beleuctungstest Datum/Nummer", Uv, entmeg, beltestdatnr, 12, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        createInfoRows(workbook, sheet, "Entfernung des Lichts", "Wärmebehandlung", " ", entlicht, wbehandlung, " ", 13, 0, 2, 3, 9, 10, 15, 16, 21, 22,  24, 25, 27);
        
        
        int pictureIdx;
        try ( //resimler
            InputStream inputStream = new FileInputStream("C:/2.1.jpeg")) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            inputStream.close();
        
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0); 
            anchor.setRow1(14); 
            anchor.setCol2(6); 
            anchor.setRow2(19);

            Picture pict = drawing.createPicture(anchor, pictureIdx);
           // pict.resize();
        }
        try(
            InputStream inputStream = new FileInputStream("C:/2.2.jpeg")) {
            byte[] bytes = IOUtils.toByteArray(inputStream);
            pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            inputStream.close();
        
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(6); 
            anchor.setRow1(14);
            anchor.setCol2(15);
            anchor.setRow2(20);

            Picture pic = drawing.createPicture(anchor, pictureIdx);
           // pic.resize();
        
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
        row = sheet.createRow(19);
        cell = row.createCell(7);
        cell.setCellValue(sabw);
        
        sheet.addMergedRegion(new CellRangeAddress(20,20,0,6));
        row = sheet.createRow(20);
        cell = row.createCell(0);
        cell.setCellValue("Inspektionstermine");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(20,20,7,27));
        row = sheet.createRow(20);
        cell = row.createCell(7);
        cell.setCellValue(inter);
        
        sheet.addMergedRegion(new CellRangeAddress(21,21,0,6));
        row = sheet.createRow(21);
        cell = row.createCell(0);
        cell.setCellValue("Beschreibungen und Anhänge");
        cell.setCellStyle(headerCellStyle);
        
        sheet.addMergedRegion(new CellRangeAddress(21,21,7,27));
        row = sheet.createRow(21);
        cell = row.createCell(7);
        cell.setCellValue(anhange);
        
        sheet.addMergedRegion(new CellRangeAddress(22,22,0,27));
        row = sheet.createRow(22);
        cell = row.createCell(0);
        cell.setCellValue("Inspektionsergebnisse");
        cell.setCellStyle(headerCellStyle);
        
        
        
        
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
        sheet.autoSizeColumn(7);
        sheet.autoSizeColumn(8);
        sheet.autoSizeColumn(9);
        sheet.autoSizeColumn(10);
        sheet.autoSizeColumn(11);
        sheet.autoSizeColumn(12);
        sheet.autoSizeColumn(13);
        sheet.autoSizeColumn(14);
        sheet.autoSizeColumn(15);
        sheet.autoSizeColumn(16);
        sheet.autoSizeColumn(17);
        sheet.autoSizeColumn(18);
        sheet.autoSizeColumn(19);
        sheet.autoSizeColumn(20);
        sheet.autoSizeColumn(21);
        sheet.autoSizeColumn(22);
        sheet.autoSizeColumn(23);
        sheet.autoSizeColumn(24);
        sheet.autoSizeColumn(25);
        sheet.autoSizeColumn(26);
        sheet.autoSizeColumn(27);
        sheet.autoSizeColumn(28);
        
        
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
