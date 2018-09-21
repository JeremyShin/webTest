package my.examples.was04;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class WasConfigurationManager {
    private ObjectMapper objectMapper;

    private static WasConfigurationManager instance = new WasConfigurationManager();

    private WasConfigurationManager() {
        objectMapper = new ObjectMapper();
    }

    public static WasConfigurationManager getInstance() {
        return instance;
    }

    public void saveMiniWasConfiguration(MiniWasConfiguration miniWasConfiguration, String fileName)
        throws RuntimeException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), miniWasConfiguration);

        }catch (Exception ex) {
            throw new RuntimeException("파일 저장이 안됩니다!");
        }
    }
    public MiniWasConfiguration getMiniWasConfiguration(String fileName) {
        try {
            MiniWasConfiguration readObj =
                    objectMapper.readValue(new File(fileName), MiniWasConfiguration.class);
            return readObj;
        }catch (Exception ex) {
            return null;
        }
    }

}
