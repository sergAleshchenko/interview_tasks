package inners;

public class DumbOwner {
    private int id;
    private static int coeff;

    public class DumberInner {
        private int id;

        public void setId(int id) {
            DumberInner.this.id = id + DumbOwner.this.id * DumbOwner.coeff;
        }
    }

}
