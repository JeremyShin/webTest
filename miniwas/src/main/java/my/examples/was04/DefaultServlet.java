package my.examples.was04;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultServlet {
    public void service(Request request, Response response) {
        // 응답하기
        String webpath = request.getPath();
        if("/".equals(webpath)) {
            webpath += webpath + "index.html";
        }

        WasConfigurationManager wcm = WasConfigurationManager.getInstance();
        MiniWasConfiguration miniWasConfiguration = wcm.getMiniWasConfiguration("C://java//");
        String path = miniWasConfiguration.getStaticDir() + webpath;
        File file = new File(path);

        OutputStream out = response.getOut();
        PrintWriter pw = response.getPw();



    }
}
