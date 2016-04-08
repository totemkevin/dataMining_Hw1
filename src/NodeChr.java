
public class NodeChr {
	private int[] chr;
	private int lengthOfChr=8;
	private int adapter;
	
	public void setChr(int[] input)
	{
		lengthOfChr=chr.length;
		chr=new int[lengthOfChr];
		chr=input;
	}
	public void setAdapter()
	{
		this.adapter=adapter;
	}
	
	
	public int[] getChr()
	{
		return chr;
	}
	public int getLength()
	{
		return lengthOfChr;
	}
	public int getAdapter()
	{
		return adapter;
	}
	
	public String toString()
	{
		String tmp="[";
		for(int i=0;i<lengthOfChr;i++)
		{
			tmp+=chr[i]+",";
		}
		tmp+="]";
		return tmp;
	}
	
}
