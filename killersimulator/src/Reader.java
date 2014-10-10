import sun.misc.Regexp;

import java.io.*;

/**
 * Created by konstantindovzikov on 20.09.14.
 */
public class Reader {

    private BufferedReader reader;

    public Reader(InputStream input) {

        this.reader = new BufferedReader(new InputStreamReader(input));
    }

    public boolean readAnswer() {
        try {
            String res = "";
            while (!res.matches("^[y|n]$")) {
                res = reader.readLine();
            }
            return res.equals("y") & !res.equals("n");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
