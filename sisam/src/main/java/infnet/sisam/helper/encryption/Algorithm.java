package infnet.sisam.helper.encryption;

public abstract interface Algorithm
{
  public abstract int createKey();
  
  public abstract String toBase(Integer paramInteger);
  
  public abstract String inverter(String paramString);
  
  public abstract String encrypt(String paramString);
  
  public abstract String decrypt(String paramString);
}
