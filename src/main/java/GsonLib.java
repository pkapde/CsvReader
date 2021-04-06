import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GsonLib {
    private static final String CSV_PATH = "C:\\Users\\HP\\IdeaProjects\\ThirdPartyLib\\src\\main\\resources\\user.csv";
    private static final String JSON_PATH = "C:\\Users\\HP\\IdeaProjects\\ThirdPartyLib\\src\\main\\resources\\user.json";

    public static void jsonExample() throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CsvToBeanBuilder<User> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(User.class).withIgnoreLeadingWhiteSpace(true);
            CsvToBean<User> csvToBean = csvToBeanBuilder.build();
            List<User> csvUserList = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUserList);
            FileWriter writer = new FileWriter(JSON_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
            User[] userObj = gson.fromJson(br,User[].class);
            List<User> csvUserList1 = Arrays.asList(userObj);
            System.out.println(csvUserList1.get(0));
        } finally {

        }
    }
}
