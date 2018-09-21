package my.examples.was03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JacksonExam {
    public static void main(String[] args) throws Exception {
        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setClassPath(".");
        miniWasConfiguration.setStaticDir("/tmp/www");

        // 객체를 json 메시지로 변환한다.(직렬화한다.)

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonConfiguration = objectMapper.writeValueAsString(miniWasConfiguration);
        System.out.println(jsonConfiguration);

        // 역직렬화
        String jsonData = "{\"staticDir\":\"/tmp/www\",\"classPath\":\".\"}";
        MiniWasConfiguration readObj =
                objectMapper.readValue(jsonData, MiniWasConfiguration.class);

        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
        System.out.println("---------");
        // 파일에서 읽어오기
        File file = new File("C://java//test.txt");

        MiniWasConfiguration readFromFile =
        objectMapper.readValue(file, MiniWasConfiguration.class);
        System.out.println(readFromFile.getStaticDir());
        System.out.println(readFromFile.getClassPath());
        System.out.println("------------");

        //파일로 저장
        objectMapper.writeValue(new File("C://java//was.json"), miniWasConfiguration);


    }
}
