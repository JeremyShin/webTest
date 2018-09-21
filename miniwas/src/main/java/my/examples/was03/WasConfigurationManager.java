package my.examples.was03;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class WasConfigurationManager {
    // 1. ObjectMapper를 불러온다.
    private ObjectMapper objectMapper;

    // 3. 자기 자신을 참조하는 private static 변수를 선언한다.
    //     static 한 변수는 딱 한번 초기화되고, 메모리에 딱 한번만 올라간다.
    private static WasConfigurationManager instance = new WasConfigurationManager();

    // 2. 생성자를 만든다.
    private WasConfigurationManager() {
        objectMapper = new ObjectMapper();
    } // WasConfigurationManager()

    // 4. public static 한 메소드를 만든다. instance를 리턴하는
    public static WasConfigurationManager getInstance(){
        return instance;
    } //WasConfigurationManager()

    // 5. WAS 환경설정 저장
    public void saveMiniWasConfiguration(MiniWasConfiguration miniWasConfiguration, String fileName)
        throws RuntimeException {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File(fileName), miniWasConfiguration);
            } catch (Exception ex) {
                throw new RuntimeException("파일 저장이 안됩니다.");
            }
        }
        public MiniWasConfiguration getMiniWasConfiguration(String fileName){
            try {
                MiniWasConfiguration readObj =
                        objectMapper.readValue(new File(fileName), MiniWasConfiguration.class);
                return readObj;
            }catch (Exception ex) {
                return null;
            }
        }

} //class()
