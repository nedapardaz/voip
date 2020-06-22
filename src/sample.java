public class sample {
    public static void main(String[] args) {
        InitializeIVR initializeIVR = new InitializeIVR();

        System.out.println(initializeIVR.ivrConfigurations.getDbURL());
        System.out.println(initializeIVR.ivrConfigurations.getPassword());
    }
}
