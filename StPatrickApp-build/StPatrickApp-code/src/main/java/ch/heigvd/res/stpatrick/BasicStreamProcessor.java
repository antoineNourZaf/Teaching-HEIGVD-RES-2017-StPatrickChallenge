package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * The responsibility of this class is to read characters from an input reader,
 * to process them, and to write them to an output writer.
 *
 * It is called "basic" stream processor, because it does nothing with the
 * characters: it writes them without transforming them.
 *
 * Note: clients do not instantiate this class directly. They obtain instances
 * of this class via the StreamProcessorsFactory.
 *
 * @author Olivier Liechti
 */
class BasicStreamProcessor implements IStreamProcessor {

   public String name;

   public BasicStreamProcessor(String name) {
      this.name = name;
   }

   public BasicStreamProcessor() {
   }

   @Override
   public void process(Reader in, Writer out) throws IOException {
      BufferedReader br = new BufferedReader(in);
      BufferedWriter bw = new BufferedWriter(out);
      int c = br.read();
      while (c != -1) {

         c = br.read();
         if (name.equals("e-remover")) {
            if (c != 'E' && c != 'e') {

               out.write(c);
               bw.write(c);
            }
         }
         else {
            out.write(c);
            bw.write(c);
         }
      }

      bw.flush();
   }

}
