package enum_wrong_examples;

public class EnumDemo {
    public static void main(String[] args) {
        String data = "CAMPING:somedata:somedata1";
        Voucher voucher = VoucherCreator.createVoucher(data);

        System.out.println(voucher);

        System.out.println(PlaneProducer.BOEING.name());
    }
}
