package Training;

import org.junit.Test;
import utils.SpreadSheetReader;

import java.util.List;

//@RunWith(Parameterized.class)
public class SpreadSheetExample {

    @Test
    public void spreadSheet(){
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/Example_Spreadsheet.xlsx");
        List<String> row = sheetReader.readRow(1, "Input Data");


        for(String cell : row){
            System.out.println(cell);
        }


    }


}
