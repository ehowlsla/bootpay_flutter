package jaceshim.bootpay_flutter;

/**
 * constans for bootpay flutter
 * @author jaceshim
 */
public class Constans {
    /**
     * 결제처리시 결과처리 onActivityResult에서 결제처리를 구분하기 위한 용도로 사용함.
     */
    public static final int PAY_ACTIVITY_REQ_CODE = 90;
    /**
     * {@link BootpayActivity} 호출시 req를 구분짖기 위해 {@link android.content.Intent}로 전달될 파라미터값의 key
     */
    public static final String REQ_CODE_KEY = "reqCode";
    /**
     * {@link BootpayFlutterPlugin}에서 {@link BootpayActivity}호출시 {@link android.content.Intent} 로 전달될 파라미터값의 key
     */
    public static final String PAY_PARAM_KEY = "payParams";

    /**
     * {@link BootpayActivity}에서 결제관련 처리 이후 {@link android.content.Intent} 로 전달될 결과값의 key
     */
    public static final String PAY_RESULT_DATA_KEY = "payResultData";


    /**
     * Payment Request Code
     * 본 enum은 {@link BootpayFlutterPlugin}와 {@link BootpayActivity}간 결제,취소 요청을 구분하기 위해 사용함.
     */
    enum PaymentReqCode {
        PAY(10), CANCEL(20);
        int code;
        PaymentReqCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }
    /**
     * Payment Result Code
     * 본 enum은 {@link BootpayFlutterPlugin}와 {@link BootpayActivity}간 처리후 결과를 구분하기 위해 사용함.
     */
    enum PaymentResultCode {
        SUCCESS(100), CANCEL(200), ERROR(300);
        int code;

        PaymentResultCode(int code) {
            this.code = code;
        }
        public int getCode() {
            return this.code;
        }

        static PaymentResultCode of(int code) {
            for (PaymentResultCode paymentResultCode : PaymentResultCode.values()) {
                if (paymentResultCode.getCode() == code) {
                    return paymentResultCode;
                }
            }
            throw new IllegalStateException("PaymentResultCode not found : " + code);
        }
    }
}
