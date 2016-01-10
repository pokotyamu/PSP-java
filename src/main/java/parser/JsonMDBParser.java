/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokotyamu
 */
public class JsonMDBParser {

    public static File create(String uri) throws IOException {
        try {
            URL url = new URL(uri);
            // URLからInputStreamオブジェクトを取得（入力）
            InputStream in = url.openStream();
            File f = new File("mdb.mdb");
            // 出力先ファイル　OutputStream（出力）
            OutputStream out = new FileOutputStream(f);
            
            byte[] buf = new byte[1024];
            int len = 0;
            // 終わるまで書き込み
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.flush();
            return f;
        } catch (MalformedURLException ex) {
            Logger.getLogger(JsonMDBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
