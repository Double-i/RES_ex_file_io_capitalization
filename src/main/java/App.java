import java.io.*;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        InputStream src = null;
        File dstFile = new File("output.txt");
        BufferedWriter writer = null;
        BufferedReader reader = null;
        FileOutputStream dst = null;
        try{
            src = App.class.getClassLoader().getResourceAsStream("test.txt");
            reader = new BufferedReader(new InputStreamReader(src));

            if (!dstFile.exists()) {
                dstFile.createNewFile();
            }
            dst = new FileOutputStream(dstFile);
            writer = new BufferedWriter(new CapitalizerDecorator(new OutputStreamWriter(dst)));

            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line + System.lineSeparator());
            }
            //writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // ATTENTION:   la fermeture doivent se faire en First In Last Out pour ne pas fermer une resource
            //              qui serait utiliser dans un BufferedReader par exemple
            try{
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(src!= null)
                    src.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(dst!= null)
                    dst.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
