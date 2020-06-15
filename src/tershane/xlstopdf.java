package tershane;

import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class xlstopdf {
    
    public void pdf(Workbook workbook, String fna, String pdf) throws DocumentException, IOException{
        //First we read the Excel file in binary format into FileInputStream
                FileInputStream input_document = null;
        try {
            input_document = new FileInputStream(new File(fna));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(xlstopdf.class.getName()).log(Level.SEVERE, null, ex);
        }
                // Read workbook into HSSFWorkbook
                HSSFWorkbook my_xls_workbook = null; 
        try {
            my_xls_workbook = new HSSFWorkbook(input_document);
        } catch (IOException ex) {
            Logger.getLogger(xlstopdf.class.getName()).log(Level.SEVERE, null, ex);
        }
                // Read worksheet into HSSFSheet
                HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
                // To iterate over the rows
                Iterator<Row> rowIterator = my_worksheet.iterator();
                //We will create output PDF document objects at this point
                Document iText_xls_2_pdf = new Document();
        try {
            PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream(pdf));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(xlstopdf.class.getName()).log(Level.SEVERE, null, ex);
        }
                iText_xls_2_pdf.open();
                //we have two columns in the Excel sheet, so we create a PDF table with two columns
                //Note: There are ways to make this dynamic in nature, if you want to.
                PdfPTable my_table = new PdfPTable(2);
                //We will use the object below to dynamically add new data to the table
                PdfPCell table_cell;
                //Loop through rows.
                while(rowIterator.hasNext()) {
                        Row row = rowIterator.next(); 
                        Iterator<Cell> cellIterator = row.cellIterator();
                                while(cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next(); //Fetch CELL
                                        switch(cell.getCellType()) { //Identify CELL type
                                                //you need to add more code here based on
                                                //your requirement / transformations
                                        case STRING:
                                            
                                                //Push the data from Excel to PDF Cell
                                                 table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
                                                 //feel free to move the code below to suit to your needs
                                                 my_table.addCell(table_cell);
                                                break;
                                        }
                                        //next line
                                }
                
                }
                //Finally add the table to PDF document
                iText_xls_2_pdf.add(my_table);                       
                iText_xls_2_pdf.close();                
                //we created our pdf file..
                input_document.close(); //close xls
        
    }
    
}
