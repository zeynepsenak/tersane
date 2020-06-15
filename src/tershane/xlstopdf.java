package tershane;

import com.aspose.cells.FileFormatType;
import com.aspose.cells.Workbook;


public class xlstopdf {
    
    public void pdf(String fna, String pdf) throws Exception{
        
        Workbook w = new Workbook(fna);
        w.save(pdf, FileFormatType.PDF);
        
    }
    
}
