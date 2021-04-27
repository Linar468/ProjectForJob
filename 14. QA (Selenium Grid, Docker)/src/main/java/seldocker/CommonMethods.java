package seldocker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommonMethods {
    public static void runTerminalCommand(String command, String logText) {
        try {
            String path = System.getProperty("user.dir");
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"" + path + "\" && " + command);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line.contains(logText)) {
                    Thread.sleep(5000);
                    System.out.println(line);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
