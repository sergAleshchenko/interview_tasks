package enum_wrong_examples;

public class VoucherCreator {
    public static Voucher createVoucher(String inputData) {
        String[] params = inputData.split(":");
        String dataType = params[0].toUpperCase().trim().replaceAll(" ", "_");

        return new Voucher(VoucherType.valueOf(dataType));
    }
}
