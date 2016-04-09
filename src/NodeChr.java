
public class NodeChr {
	private int[] chr;
	private int lengthOfChr=8;
	private int adapter;
	
	public NodeChr()
	{
		chr=new int[8];
		adapter=0;
	}
	public void setChr(int[] input)
	{
		lengthOfChr=chr.length;
		chr=new int[lengthOfChr];
		int i=0;
		for(int e:input)
		{
			chr[i]=e;
			i++;
		}
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
