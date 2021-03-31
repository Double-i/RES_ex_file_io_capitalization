import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class CapitalizerDecorator extends FilterWriter  {

        protected CapitalizerDecorator(Writer out) {
            super(out);
        }

        @Override
        public void write(int c) throws IOException {
            c = Character.toUpperCase(c);
            super.write(c);
        }

        @Override
        public void write(char[] cbuf) throws IOException {
            for(char c:cbuf){
                write(c);
            }
        }

        @Override
        public void write(String str) throws IOException {
            char[] cbuf = str.toCharArray();
            write(cbuf);
        }

        @Override
        public void write(String str, int off, int len) throws IOException {
            super.write(str,off,len);
            char[] cbuf = (str.substring(off, off+len)).toCharArray();
            write(cbuf);
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            char[] buf = Arrays.copyOfRange(cbuf, off,len);
            write(buf);

        }
}

