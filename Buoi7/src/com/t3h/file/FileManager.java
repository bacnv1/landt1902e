package com.t3h.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {

    public void manager() {
        try {
            String path = "D:/T3h/Android/Java/1902.txt";
            File f = new File(path);
            boolean exists = f.exists();
            System.out.println(exists);
            if (exists == false) {
                // D:/T3h/Android/Java
                File parent = f.getParentFile();
                parent.mkdirs();
                f.createNewFile();
                System.out.println("Tao file thanh cong");
            } else {
                f.delete();
                System.out.println("Xoa file thanh cong");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAllFile() {
        File f = new File("D:/");
        readFileInfo(f);
    }

    private void readFileInfo(File f) {
        try {
            for (File file : f.listFiles()) {
                if (file.isFile()) {
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    System.out.print("Name: " + file.getName());
                    String time = format.format(new Date(file.lastModified()));
                    System.out.println("\tTime: " + time);
                    System.out.println();
                } else {
                    readFileInfo(file);
                }
            }
        } catch (Exception ex) {

        }
    }

    public void write(){
        try{
            // tro file
            File f = new File("D:/T3H/Android/Java/1902E.txt");
            if (f.exists() == false){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }
            // mo luong
            FileOutputStream out = new FileOutputStream(f, true);
            // ghi file
            String str = "Hello world\n";
            out.write(str.getBytes());
            // dong luong
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void readFile(){
        try {
            File f = new File("D:/T3H/Android/Java/1902E.txt");
            if (f.exists() == false){
                System.out.println("File chua ton tai");
                return;
            }
            // mo luong
            FileInputStream in = new FileInputStream(f);
            // doc file
            byte[] b = new byte[1024];
            int count = in.read(b);
            String s = "";
            while (count != -1){
                s += new String(b, 0, count);
                count = in.read(b);
            }
            System.out.println(s);
            // dong luong
            in.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
