import java.util.Objects;

final class IvrConfigurations {
    private String VoiceUrl;
    private String dbURL;
    private String username;
    private String password;
    private int WaitTimeOut;

    @Override
    public String toString() {
        return "IvrConfigurations{" +
                "VoiceUrl='" + VoiceUrl + '\'' +
                ", dbURL='" + dbURL + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", WaitTimeOut=" + WaitTimeOut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IvrConfigurations that = (IvrConfigurations) o;
        return WaitTimeOut == that.WaitTimeOut &&
                Objects.equals(VoiceUrl, that.VoiceUrl) &&
                Objects.equals(dbURL, that.dbURL) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(VoiceUrl, dbURL, username, password, WaitTimeOut);
    }

    public String getVoiceUrl() {
        return VoiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        VoiceUrl = voiceUrl;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWaitTimeOut() {
        return WaitTimeOut;
    }

    public void setWaitTimeOut(int waitTimeOut) {
        WaitTimeOut = waitTimeOut;
    }
}
