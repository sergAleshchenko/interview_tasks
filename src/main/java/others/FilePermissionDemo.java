package others;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class FilePermissionDemo {
    public static void main(String[] args) {
        String srg = "H:\\IDEA_PROJECTS\\Learning\\test.txt";

//        FilePermission file1 = new FilePermission("H:\\IDEA_PROJECTS\\Learning\\-", "read");
        FilePermission file1 = new FilePermission(srg, "read");
        PermissionCollection permCollection = file1.newPermissionCollection();
        permCollection.add(file1);

        FilePermission file2 = new FilePermission(srg, "write");
        permCollection.add(file2);

        if (permCollection.implies(new FilePermission(srg, "read,write"))) {
            System.out.println("Read, Write permission is granted for the path " + srg);
        } else {
            System.out.println("No Read, Write permission is granted for the path " + srg);
        }

    }
}
