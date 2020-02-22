package me.kay;

public class KayService {
    private KayProperties kayProperties;

    public KayProperties getKayProperties() {
        return kayProperties;
    }

    public void setKayProperties(KayProperties kayProperties) {
        this.kayProperties = kayProperties;
    }

    public String sayKay(String name) {
        return "Prefix: " + kayProperties.getPrefix() + ", --- " + name + " --- , Suffix: " + kayProperties.getSuffix();
    }
}
