import java.io.*;

public class FileCapitalizer {

    public static void capitalize(InputStream is, OutputStream os){
        BufferedReader bf = new BufferedReader(new InputStreamReader(is));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        try{
            String line;
            while((line = bf.readLine() )!= null){
                line.toUpperCase();
                bw.write(line.toUpperCase());
            }
            bw.flush();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        File testFile = new File(String.valueOf(FileCapitalizer.class.getResourceAsStream("test.txt")));
        File dest = new File(String.valueOf(FileCapitalizer.getClass().getResourceAsStream(););

        try {
            if(!dest.exists()){

                boolean ok = dest.createNewFile();
                System.out.println("Fichier de destination créé ? "+ok);

            }
            FileInputStream src =new FileInputStream(testFile);
            FileOutputStream dst = new FileOutputStream(dest);
            FileCapitalizer.capitalize(src, dst);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
