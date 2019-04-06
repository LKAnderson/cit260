package officehours.navdb;

public class Communication {

    
    private CommunicationType type;
    private int frequency;
    private String qualifier;
    
    /**
     * Default constructor
     */
    public Communication() {
        
    }
    
    /**
     * @param type
     * @param frequency
     * @param qualifier
     */
    public Communication(CommunicationType type, int frequency, String qualifier) {
        super();
        this.type = type;
        this.frequency = frequency;
        this.qualifier = qualifier;
    }
    
    /**
     * @return the type
     */
    public CommunicationType getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(CommunicationType type) {
        this.type = type;
    }
    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }
    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    /**
     * @return the qualifier
     */
    public String getQualifier() {
        return qualifier;
    }
    /**
     * @param qualifier the qualifier to set
     */
    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    
}