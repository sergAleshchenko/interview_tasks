package others;

import java.io.IOException;

class AutoClosableClass implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new IOException("IOEx");
    }

}

public class ExMain {
    int meth(int x) {
        int count=0;
        try {
            count += x;
            count += mexcept(count);
            count++;
        }catch(Exception e) {
            --count;
            return count;
        }
        finally {
            count += 3;
            return count;
        }
    }

    private int mexcept(int count) {
        throw new ArithmeticException("ArEx");
    }

    public int meth2(int x) {
        int y = 010; //1
        try {
            y += x; //2
            if (x <= 5)
                throw new Exception(); //3
            y++;
        } //4
        catch (Exception e) {
            y--;
        } //5
        return y;
    }

        public static void main(String[] args) {
//        try (others.AutoClosableClass myAutoClosable = new others.AutoClosableClass()) {
//            throw new RuntimeException("Runtime ex");
//        } catch (IOException e) {
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        ExMain exMain = new ExMain();
        System.out.println(exMain.meth(12));
    }
}
