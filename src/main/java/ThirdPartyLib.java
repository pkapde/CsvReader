import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ThirdPartyLib {
    static final String FILE_NAME = "C:\\Users\\HP\\IdeaProjects\\ThirdPartyLib\\src\\main\\resources\\user.csv";
    public static void CsvParse() throws IOException {
        Reader bufferedReader = Files.newBufferedReader(Paths.get(FILE_NAME));
        CsvToBean<User> csvToBean = new CsvToBeanBuilder(bufferedReader).withType(User.class).withIgnoreLeadingWhiteSpace(true).build();
        List<User> iterator = csvToBean.parse();
        System.out.println(iterator);
        /*while(iterator.hasNext()) {
            User user = iterator.next();
            System.out.println(user);
        }*/

    }
}
