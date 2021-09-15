package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class DDTManage extends CommonOps{
    @DataProvider(name="data-provider-users")
    public Object[][] getDataObject(){
        return getCSVData(getData("fileDDT"));
    }

    /*####################################################################################
       Method Name: csvRead
       Method Description: The method reads data from CSV file's lines
       Method Parameters: String
       Method Returns: List<String>
   ####################################################################################*/
    public static List<String> csvRead(String csvFile){
        List<String> lines= null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /*####################################################################################
           Method Name: getCSVData
           Method Description: The method gets data from CSV using csvRead method and forms an object with this data
           Method Parameters: String
           Method Returns: Object
       ####################################################################################*/
    public static Object[][] getCSVData(String filePath){
        Object[][] data = new Object[3][2];
        List<String> dataCSV =  csvRead(filePath);
        for(int i =0; i<dataCSV.size(); i++){
            data[i][0]=dataCSV.get(i).split(",")[0];
            data[i][1]=dataCSV.get(i).split(",")[1];
        }
        return data;
    }
}
