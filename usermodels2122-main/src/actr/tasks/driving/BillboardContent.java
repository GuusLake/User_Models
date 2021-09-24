package actr.tasks.driving;

public class BillboardContent {
    static String[] text = {"This hardly fits", "anything"};

    public static String getBillboardText(int billboardNumber) {
        return text[billboardNumber];
    }
}
