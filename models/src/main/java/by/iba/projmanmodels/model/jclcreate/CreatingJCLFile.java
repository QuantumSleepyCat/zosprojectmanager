package by.iba.projmanmodels.model.jclcreate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingJCLFile {

    public File createJclFile(String jcl)
    {
        File jclFile = new File("jclpars.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jclFile));
            bufferedWriter.write(jcl);
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return jclFile;
    }

}
